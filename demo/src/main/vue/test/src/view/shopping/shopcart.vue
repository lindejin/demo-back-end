<template>
  <div>
    <div class="goods-list-container">
      <Alert show-icon class="tips-box">
        小提示
        <Icon type="ios-lightbulb-outline" slot="icon"></Icon>
        <template slot="desc">请点击商品前的选择框，选择购物车中的商品，点击付款即可。</template>
      </Alert>
      <Table border ref="selection" :columns="columns" :data="CartList" size="large" @on-selection-change="select02" no-data-text="您的购物车没有商品，请先添加商品到购物车再点击购买">
      </Table>
      <div class="goods-page">
        <Page :total="fruitList.pageTotal" :current="fruitList.pageNum" :page-size="fruitList.pageSize" show-total
              @on-change="handlePage" @on-page-size-change='handlePageSize' ></Page>
      </div>
      <div class="address-container">
        <h3>收货人信息</h3>
        <div class="address-box">
          <div class="address-check">
            <div class="address-check-name">
              <span><Icon type="ios-checkmark-outline"></Icon> {{checkAddress.receiveName}}</span>
            </div>
            <div class="address-detail">
              <p>{{checkAddress.address}}</p>
            </div>
          </div>
          <Collapse>
            <Panel>
                选择地址
                <p slot="content">
                  <RadioGroup vertical size="large" @on-change="changeAddress">
                    <Radio :label="item.addressId" v-for="(item, index) in address" :key="index">
                      <span>{{item.receiveName}} {{item.receiveProvince}} {{item.receiveCity}} {{item.receiveDetailAddress}} {{item.receivePhone}}</span>
                    </Radio>
                  </RadioGroup>
                </p>
            </Panel>
          </Collapse>
        </div>
      </div>
<!--      <div class="remarks-container">-->
<!--        <h3>备注</h3>-->
<!--        <i-input v-model="remarks" size="large" placeholder="在这里填写备注信息" class="remarks-input"></i-input>-->
<!--      </div>-->
      <div class="invoices-container">
        <h3>发票信息</h3>
        <p>该商品不支持开发票</p>
      </div>
      <div class="pay-container">
        <div class="pay-box">
          <p><span>提交订单应付总额：</span> <span class="money"><Icon type="social-yen"></Icon> {{totalPrice.toFixed(2)}}</span></p>
          <div class="pay-btn">
            <Button type="error" size="large" @click="pay">支付订单</Button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'Order',
  beforeRouteEnter (to, from, next) {
    window.scrollTo(0, 0)
    next()
  },
  data () {
    return {
      chackOrder: '',
      address: '',
      address01: '',
      fruitList: {
        num: null,
        pageTotal: 0,
        pageNum: 1,
        pageSize: 5,
        list: []
      },
      params: {},
      CartList: [],
      goodsCheckList: [],
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
      ],
      checkAddress: {
        receiveName: '未选择',
        address: '请选择地址'
      },
      remarks: ''
    }
  },
  computed: {
    totalPrice () {
      let price = 0
      this.goodsCheckList.forEach(item => {
        price += item.price * item.count
      })
      return price
    }
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
    select02 (selection, row) {
      // console.log(selection)
      this.chackOrder = selection
      // this.goodsCheckList = selection
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
        // console.table(res.data.list)
      }).catch(() => {
        // 遇到异常则关闭加载
      })
    },
    searchAddress () {
      Object.assign(this.params, {
        pageSize: 1,
        pageNumber: 100,
        id: localStorage.getItem('Flag01')
      }, this.address01)
      this.axios.get('/address/select', {
        params: this.params
      }).then(res => {
        // this.fruitList.pageTotal = res.data.total
        this.address = res.data.list
        // console.log(this.record.list)
        // console.table(res.data.list)
      }).catch(() => {
        // 遇到异常则关闭加载
      })
    },
    changeAddress (data) {
      const father = this
      this.address.forEach(item => {
        if (item.addressId === data) {
          father.checkAddress.receiveName = item.receiveName
          father.checkAddress.address = `${item.receiveName} ${item.receiveProvince} ${item.receiveCity} ${item.receiveDetailAddress} ${item.receivePhone}`
        }
      })
    },
    pay () {
      // let newArr = this.chackOrder.filter((item, index, arr) => { return item.cart_id })
      if (localStorage.getItem('Flag01')) {
        let newArr = []
        for (let i of this.chackOrder) {
          // console.log(i.cart_id)
          newArr.push(i.order_id)
        }
        // console.log(newArr)
        this.axios.put('/cart/updata',
          newArr).then(res => {
          if (res.data > 0) {
            this.$message({
              type: 'success',
              message: '结算成功!'
            })
            this.search()
          } else {
            this.$message({
              type: 'error',
              message: '结算失败!'
            })
          }
        }).catch(() => {
          // 遇到异常则关闭加载
          this.$message({
            type: 'error',
            message: '结算异常!'
          })
        })
      }
    }
  },
  created () {
    this.search()
    this.searchAddress()
  },
  mounted () {
    setTimeout(() => {
      this.$refs.selection.selectAll(true)
    }, 500)
  },
  components: {
  }
}
</script>

<style scoped>
.goods-list-container {
  margin: 15px auto;
  width: 80%;
}
.tips-box {
  margin-bottom: 15px;
}
.address-container {
  margin-top: 15px;
}
.address-box {
  margin-top: 15px;
  padding: 15px;
  border: 1px #ccc dotted;
}
.address-check {
  margin: 15px 0px;
  height: 36px;
  display: flex;
  align-items: center;
}
.address-check-name {
  width: 120px;
  display: flex;
  justify-content: center;
  align-content: center;
  background-color: #ccc;
}
.address-check-name span {
  width: 120px;
  height: 36px;
  font-size: 14px;
  line-height: 36px;
  text-align: center;
  color: #fff;
  background-color: #f90013;
}
.address-detail {
  padding-left: 15px;
  font-size: 14px;
  color: #999999;
}
.remarks-container {
  margin: 15px 0px;
}
.remarks-input {
  margin-top: 15px;
}
.invoices-container p{
  font-size: 12px;
  line-height: 30px;
  color: #999;
}
.pay-container {
  margin: 15px;
  display: flex;
  justify-content: flex-end;
}
.pay-box {
  font-size: 18px;
  font-weight: bolder;
  color: #495060;
}
.money {
  font-size: 26px;
  color: #f90013;
}
.pay-btn {
  margin: 15px 0px;
  display: flex;
  justify-content: flex-end;
}
</style>
