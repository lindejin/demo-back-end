<template>
  <div>
    <Table border ref="selection" :columns="columns" :data="CartList" size="large" no-data-text="您的购物车没有商品，请先添加商品到购物车再点击购买"></Table>
    <div class="go-to">
      <Button @click="goTo" type="primary">去付款</Button>
    </div>
    <div class="goods-page">
      <Page :total="fruitList.pageTotal" :current="fruitList.pageNum" :page-size="fruitList.pageSize" show-total
            @on-change="handlePage" @on-page-size-change='handlePageSize' ></Page>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MyShoppingCart',
  data () {
    return {
      fruitList: {
        num: null,
        pageTotal: 0,
        pageNum: 1,
        pageSize: 5,
        list: []
      },
      params: {},
      CartList: [],
      shoppingCart: [{'goods_id': 1529931938150, 'count': 1, 'img': 'static/style/images/browse1.jpg', 'package': '4.7英寸-深邃蓝', 'price': 28, 'title': '苹果8/7'}],
      columns: [
        {
          type: 'selection',
          width: 58,
          align: 'center'
        },
        {
          title: '图片',
          key: 'fruit_image',
          width: 86,
          render: (h, params) => {
            return h('div', [
              h('img', {
                style: {// 设置样式
                  width: '40px',
                  height: '40px'
                },
                attrs: {
                  src: params.row.fruit_image
                }
              })
            ])
          },
          align: 'center'
        },
        {
          title: '名称',
          key: 'fruit_name',
          align: 'center'
        },
        {
          title: '简介',
          width: 198,
          key: 'fruit_summery',
          align: 'center'
        },
        {
          title: '数量',
          key: 'fruit_number',
          width: 68,
          align: 'center'
        },
        {
          title: '总价',
          width: 68,
          key: 'fruit_total_price',
          align: 'center'
        }
      ]
    }
  },
  created () {
    // this.loadShoppingCart()
    this.search()
  },
  computed: {
  },
  methods: {
    handlePage (page) {
      this.fruitList.pageNum = page
      this.search()
    },
    handlePageSize (val) {
      this.fruitList.pageSize = val
      this.pageCurrentChange(1)
      this.search()
    },
    search () {
      Object.assign(this.params, {
        pageSize: this.fruitList.pageNum || 1,
        pageNumber: this.fruitList.pageSize || 5,
        id: localStorage.getItem('Flag01')
      }, this.params)
      this.axios.get('/cart/select', {
        params: this.params
      }).then(res => {
        this.fruitList.pageTotal = res.data.total
        this.CartList = res.data.list
        // console.log(this.record.list)
        console.table(res.data.list)
      }).catch(() => {
        // 遇到异常则关闭加载
      })
    },
    goTo () {
      this.$router.push('/shopcart')
    }
  }
}
</script>

<style scoped>
.go-to {
  margin: 15px;
  display: flex;
  justify-content: flex-end;
}
</style>
