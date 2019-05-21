<template>
  <div>
    <Table border :columns="columns" :data="CartList" size="large" no-data-text="你还有订单，快点去购物吧"></Table>
    <div class="goods-page">
      <Page :total="fruitList.pageTotal" :current="fruitList.pageNum" :page-size="fruitList.pageSize" show-total
            @on-change="handlePage" @on-page-size-change='handlePageSize' ></Page>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MyOrder',
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
      order: [{
        order_id: 1529931938150,
        goods_id: 1529931938150,
        count: 1,
        img: 'static/style/images/browse1.jpg',
        package: '4.7英寸-深邃蓝',
        price: 28,
        title: '苹果8/7',
        createAt: '2018-06-06 20:06:08'
      }],
      columns: [
        {
          title: '订单号',
          key: 'order_no',
          width: 180,
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
          title: '价格',
          width: 68,
          key: 'fruit_total_price',
          align: 'center'
        },
        {
          title: '购买时间',
          width: 120,
          key: 'order_time02',
          render: (h, params) => {
            return h('div',
              this.formatDate(new Date(params.row.order_time02), 'yyyy-MM-dd hh:mm')
            )
          },
          align: 'center'
        }
      ]
    }
  },
  created () {
    // this.loadShoppingCart()
    this.search()
    console.log('111')
  },
  methods: {
    formatDate (date, fmt) {
      let o = {
        'M+': date.getMonth() + 1, // 月份
        'd+': date.getDate(), // 日
        'h+': date.getHours(), // 小时
        'm+': date.getMinutes(), // 分
        's+': date.getSeconds(), // 秒
        'S': date.getMilliseconds() // 毫秒
      }
      if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length))
      }
      for (var k in o) {
        if (new RegExp('(' + k + ')').test(fmt)) {
          fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (('00' + o[k]).substr(('' + o[k]).length)))
        }
      }
      return fmt
    },
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
      this.axios.get('/cart/select02', {
        params: this.params
      }).then(res => {
        this.fruitList.pageTotal = res.data.total
        this.CartList = res.data.list
        // console.log(this.record.list)
        console.table(res.data.list)
      }).catch(() => {
        // 遇到异常则关闭加载
      })
    }
  }
}
</script>

<style scoped>
.page-size {
  margin: 15px 0px;
  display: flex;
  justify-content: flex-end;
  align-items: center;
}
</style>
