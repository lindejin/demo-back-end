<template>
  <div>
    <searchTop/>
    <div class="item-detail-show">
      <div class="item-detail-left">
        <div class="item-detail-big-img">
          <img :src="fruit.fruitImage" alt="">
        </div>
<!--        <div class="item-detail-img-row">-->
<!--          <div class="item-detail-img-small" v-for="(item, index) in fruit" :key="index" @mouseover="showBigImg(index)">-->
<!--            <img :src="'static/style/images/ad1.png'" alt="">-->
<!--          </div>-->
<!--        </div>-->
      </div>
      <div class="item-detail-right">
        <div class="item-detail-title">
          <p>
            <span class="item-detail-express">校园配送</span> {{fruit.fruitName}}</p>
        </div>
        <div class="item-detail-tag">
          <p>
            <span>【满69-20元】</span>
            <span>【关注产品】</span>
            <span>【BIT配次日达】</span>
          </p>
        </div>
        <div class="item-detail-price-row">
          <div class="item-price-left">
            <div class="item-price-row">
              <p>
                <span class="item-price-title">B I T 价</span>
                <span class="item-price">￥{{fruit.primeCost}}</span>
              </p>
            </div>
            <div class="item-price-row">
              <p>
                <span class="item-price-title">优 惠 价</span>
                <span class="item-price-full-cut" >满148减10</span>
                <span class="item-price-full-cut" >满218减20</span>
                <span class="item-price-full-cut" >满288减30</span>
              </p>
            </div>
            <div class="item-price-row">
              <p>
                <span class="item-price-title">促&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销</span>
                <span class="item-price-full-cut">多买优惠</span>
                <span class="item-price-full-cut">跨店满减</span>
              </p>
            </div>
          </div>
          <div class="item-price-right">
            <div class="item-remarks-sum">
              <p>累计销量</p>
              <p>
                <span class="item-remarks-num">{{fruit.saleCount}}</span>
              </p>
            </div>
          </div>
        </div>
        <br>
<!--        <el-input-number v-model="count"  :min="1" :max="10" label="描述文字"></el-input-number>-->
        <div class="add-buy-car-box">
          <div class="add-buy-car">
            <InputNumber :min="1" v-model="count" size="large"></InputNumber>
            <Button type="error" size="large" @click="addShoppingCartBtn()">加入购物车</Button>
          </div>
        </div>
      </div>
    </div>
    <!-- 商品详细展示 -->
    <ShowGoodsDetail></ShowGoodsDetail>
  </div>
</template>

<script>
import searchTop from '../homemodel/searchTop'
import ShowGoodsDetail from './ShowGoodsDetail'
export default {
  components: {
    ShowGoodsDetail,
    searchTop
  },
  name: 'ShowGoods',
  data () {
    return {
      fruit: {
        createTime: '',
        fruitDetail: '',
        fruitHot: '',
        fruitId: '',
        fruitImage: '',
        fruitName: '',
        fruitSale: '',
        fruitStatus: '',
        fruitStock: '',
        fruitSummery: '',
        primeCost: '',
        saleCount: '',
        shelfStatus: '',
        updateTime: ''},
      order: {
        userId: '',
        fruitId: '',
        fruitName: '',
        fruitPrice: '',
        fruitNumber: '',
        fruitTotalPrice: ''
      },
      goodsInfo: {
        goodsImg: require('../../../static/style/images/ad1.png'),
        imglist: [
          { rul: require('../../../static/style/images/ad1.png') },
          { rul: require('../../../static/style/images/ad2.png') },
          { rul: require('../../../static/style/images/ad3.png') },
          { rul: require('../../../static/style/images/ad4.png') },
          { rul: require('../../../static/style/images/ad5.png') }
        ],
        title: 2,
        tags: 2,
        discount: 2,
        promotion: 2,
        remarksNumL: 2
      },
      price: 0,
      count: 1,
      selectBoxIndex: 0,
      imgIndex: 0
    }
  },
  computed: {
    hirePurchase () {
      const three = this.price * this.count / 3
      const sex = this.price * this.count / 6
      const twelve = this.price * this.count / 12 * 1.0025
      const twentyFour = this.price * this.count / 24 * 1.005
      return [
        {
          tooltip: '无手续费',
          type: '不分期'
        },
        {
          tooltip: '无手续费',
          type: `￥${three.toFixed(2)} x 3期`
        },
        {
          tooltip: '无手续费',
          type: `￥${sex.toFixed(2)} x 6期`
        },
        {
          tooltip: '含手续费：费率0.25%起，￥0.1起×12期',
          type: `￥${twelve.toFixed(2)} x 12期`
        },
        {
          tooltip: '含手续费：费率0.5%起，￥0.1起×12期',
          type: `￥${twentyFour.toFixed(2)} x 24期`
        }
      ]
    }
  },
  watch: {
    '$route' (to, from) {
      // 此处作查询方法
      // console.log(this.$route.query.name)
      this.fruit = JSON.parse(this.$route.query.fruit)
    }
  },
  methods: {
    select (index1, index2) {
      this.selectBoxIndex = index1 * 3 + index2
      this.price = this.goodsInfo.setMeal[index1][index2].price
    },
    showBigImg (index) {
      this.imgIndex = index
      // console.log(this.goodsInfo.imglist[index])
    },
    addShoppingCartBtn () {
      // 加入购物车
      this.order.fruitId = this.fruit.fruitId
      this.order.fruitName = this.fruit.fruitName
      this.order.fruitPrice = this.fruit.primeCost
      this.order.fruitNumber = this.count
      this.order.fruitTotalPrice = this.fruit.primeCost * this.count
      this.order.userId = localStorage.getItem('Flag01')
      console.log(this.order)
      if (localStorage.getItem('Flag01')) {
        this.$confirm('此操作将加入购物车, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.post('/cart/add', this.order
          ).then(res => {
            if (res.data > 0) {
              this.$message({
                type: 'success',
                message: '加入购物车成功!'
              })
            } else {
              this.$message({
                type: 'error',
                message: '加入购物车失败!'
              })
            }
          }).catch(() => {
            // 遇到异常则关闭加载
            this.$message({
              type: 'error',
              message: '加入购物车异常!'
            })
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消加入购物车'
          })
        })
      } else {
        this.$router.push({
          path: '/login'
        })
      }
    }
  },
  mounted () {
    console.log(JSON.parse(this.$route.query.fruit))
    this.fruit = JSON.parse(this.$route.query.fruit)
  }
}
</script>

<style scoped>
  /******************商品图片及购买详情开始******************/
  .item-detail-show {
    width: 80%;
    margin: 15px auto;
    display: flex;
    flex-direction: row;
    background-color: #fff;
  }
  .item-detail-left {
    width: 350px;
    margin-right: 30px;
  }
  .item-detail-big-img {
    width: 350px;
    height: 350px;
    box-shadow: 0px 0px 8px #ccc;
    cursor: pointer;
  }
  .item-detail-big-img img {
    width: 100%;
  }
  .item-detail-img-row {
    margin-top: 15px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }
  .item-detail-img-small {
    width: 68px;
    height: 68px;
    box-shadow: 0px 0px 8px #ccc;
    cursor: pointer;
  }
  .item-detail-img-small img {
    width: 100%;
  }
  /*商品选购详情*/
  .item-detail-right {
    display: flex;
    flex-direction: column;
  }
  .item-detail-title p {
    color: #666;
    font-size: 20px;
  }
  .item-detail-express {
    font-size: 14px;
    padding: 2px 3px;
    border-radius: 3px;
    background-color: #e4393c;
    color: #fff;
  }
  /*商品标签*/
  .item-detail-tag {
    font-size: 12px;
    color: #e4393c;
  }
  /*价格详情等*/
  .item-detail-price-row {
    padding: 5px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    background-color: #f3f3f3;
  }
  .item-price-left {
    display: flex;
    flex-direction: column;
  }
  .item-price-title {
    color: #999999;
    font-size: 14px;
    margin-right: 15px;
  }
  .item-price-row {
    margin: 5px 0px;
  }
  .item-price {
    color: #e4393c;
    font-size: 23px;
    cursor: pointer;
  }
  .item-price-full-cut {
    margin-right: 5px;
    padding: 3px;
    color: #e4393c;
    font-size: 12px;
    background-color: #ffdedf;
    border: 1px dotted #e4393c;
    cursor: pointer;
  }
  .item-remarks-sum {
    padding-left: 8px;
    border-left: 1px solid #ccc;
  }
  .item-remarks-sum p {
    color: #999999;
    font-size: 12px;
    line-height: 10px;
    text-align: center;
  }
  .item-remarks-num {
    line-height: 18px;
    color: #005eb7;
  }
  .item-select {
    display: flex;
    flex-direction: row;
    margin-top: 15px;
  }
  .item-select-title {
    color: #999999;
    font-size: 14px;
    margin-right: 15px;
  }
  .item-select-column {
    display: flex;
    flex-direction: column;
  }
  .item-select-row {
    display: flex;
    flex-direction: row;
    margin-bottom: 8px;
  }
  .item-select-box {
    display: flex;
    flex-direction: row;
    align-items: center;
  }
  .item-select-img {
    width: 36px;
  }
  .item-select-box {
    padding: 5px;
    margin-right: 8px;
    background-color: #f7f7f7;
    border: 0.5px solid #ccc;
    cursor: pointer;
  }
  .item-select-box:hover {
    border: 0.5px solid #e3393c;
  }
  .item-select-box-active {
    border: 0.5px solid #e3393c;
  }
  .item-select-img img {
    width: 100%;
  }
  .item-select-intro p {
    margin: 0px;
    padding: 5px;
  }
  .item-select-class {
    padding: 5px;
    margin-right: 8px;
    background-color: #f7f7f7;
    border: 0.5px solid #ccc;
    cursor: pointer;
  }
  .item-select-class:hover {
    border: 0.5px solid #e3393c;
  }
  .add-buy-car-box {
    width: 100%;
    margin-top: 15px;
    border-top: 1px dotted #ccc;
  }
  .add-buy-car {
    margin-top: 15px;
  }
  /******************商品图片及购买详情结束******************/
</style>
