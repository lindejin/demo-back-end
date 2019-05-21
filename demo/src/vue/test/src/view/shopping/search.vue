<template>
  <div>
    <searchTop/>
    <div class="container">
      <!-- 商品展示容器 -->
      <div class="goods-box">
        <div class="as-box">
          <div class="item-as-title">
            <span>商品精选</span>
            <span>广告</span>
          </div>
          <div class="item-as" v-for="(item,index) in asItems" :key="index">
            <div class="item-as-img">
              <img style="height: 160px;width: 160px" :src="'static/style/images/browse1.jpg'" alt="">
            </div>
            <div class="item-as-price">
              <span>
                <Icon type="social-yen text-danger"></Icon>
                <span class="seckill-price text-danger">{{item.price}}</span>
              </span>
            </div>
            <div class="item-as-intro">
              <span>{{item.intro}}</span>
            </div>
            <div class="item-as-selled">
              已有<span>{{item.num}}</span>人评价
            </div>
          </div>
        </div>
        <div class="goods-list-box">
          <div class="goods-list-tool">
            <ul>
              <li v-for="(item,index) in goodsTool" :key="index" @click="orderBy(item.en, index)">
                <span :class="{ 'goods-list-tool-active': isAction[index]}">{{item.title}}<Icon :type="icon[index]">
                  </Icon>
                </span>
              </li>
            </ul>
          </div>
          <div class="goods-list">
            <div class="goods-show-info" v-for="(item, index) in fruitList.list" :key="index">
              <div class="goods-show-img">
                <img style="height: 228px;width: 228px" :src="item.fruitImage" @click="introduction(item)">
              </div>
              <div class="goods-show-price">
                <span>
                  <Icon type="social-yen text-danger"></Icon>
                  <span class="seckill-price text-danger">{{item.primeCost}}</span>
                </span>
              </div>
              <div class="goods-show-detail">
                <span>{{item.fruitName}}</span>
              </div>
              <div class="goods-show-num">
                销量<span>{{item.saleCount}}</span>
              </div>
<!--              <div class="goods-show-seller">-->
<!--                <span>{{item.shopName}}</span>-->
<!--              </div>-->
            </div>
          </div>
        </div>
      </div>
      <div class="goods-page">
        <Page :total="fruitList.pageTotal" :current="fruitList.pageNum" :page-size="fruitList.pageSize" show-total
              @on-change="handlePage" @on-page-size-change='handlePageSize' ></Page>
      </div>
    </div>
    <Footer></Footer>
    <Spin size="large" fix v-if="false"></Spin>
  </div>
</template>

<script>
import searchTop from '../homemodel/searchTop'
export default {
  components: {
    searchTop
  },
  name: 'GoodsList',
  data () {
    return {
      url: '/fruit/select02',
      name: '',
      // 广告
      asItems: [{'img': 'static/img/goodsList/item-as-img-1.jpg', 'price': 39.9, 'intro': 'SKSK 苹果7/7plus手机壳 iPhone 7 Plus保护套全包硬', 'num': 3140, 'sale': 9000}, {'img': 'static/img/goodsList/item-as-img-2.jpg', 'price': 36.6, 'intro': '狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外', 'num': 6160, 'sale': 8900}, {'img': 'static/img/goodsList/item-as-img-1.jpg', 'price': 38.6, 'intro': 'SKSK 苹果7/7plus手机壳 iPhone 7 Plus保护套全包硬', 'num': 9160, 'sale': 8800}, {'img': 'static/img/goodsList/item-as-img-2.jpg', 'price': 35.6, 'intro': '狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外', 'num': 6160, 'sale': 7990}, {'img': 'static/img/goodsList/item-as-img-1.jpg', 'price': 38.6, 'intro': 'SKSK 苹果7/7plus手机壳 iPhone 7 Plus保护套全包硬', 'num': 9160, 'sale': 7600}, {'img': 'static/img/goodsList/item-as-img-2.jpg', 'price': 35.6, 'intro': '狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外', 'num': 6160, 'sale': 6900}],
      sreachItem: '',
      // 搜索出来的水果
      fruitList: {
        num: null,
        pageTotal: 0,
        pageNum: 1,
        pageSize: 16,
        list: []
      },
      params: {},
      isAction: [ true, false, false ],
      icon: [ 'arrow-up-a', 'arrow-down-a', 'arrow-down-a' ],
      goodsTool: [
        {title: '综合', en: 'sale'},
        {title: '出货量', en: 'remarks'},
        {title: '价格', en: 'price'}
      ]
    }
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
    // 详情页
    introduction (item) {
      console.log('详情页')
      this.$router.push({
        path: '/introduction',
        query: {
          fruit: JSON.stringify(item)
        }
      })
    },
    // 搜索，条件排序
    search () {
      Object.assign(this.params, {
        pageSize: this.fruitList.pageNum || 1,
        pageNumber: this.fruitList.pageSize || 16,
        name: this.name,
        num: this.fruitList.num
      }, this.params)
      this.axios.get(this.url, {
        params: this.params
      }).then(res => {
        this.fruitList.pageTotal = res.data.total
        this.fruitList.list = res.data.list
        // console.log(this.record.list)
        // console.table(res.data.list)
      }).catch(() => {
        // 遇到异常则关闭加载
      })
    },
    orderBy (data, index) {
      // console.log(data)
      // console.log(index)
      this.fruitList.num = index
      console.log(this.fruitList)
      this.icon = [ 'arrow-down-a', 'arrow-down-a', 'arrow-down-a' ]
      this.isAction = [ false, false, false ]
      this.isAction[index] = true
      this.icon[index] = 'arrow-up-a'
      this.handlePage(1)
    }
  },
  created () {
  },
  mounted () {
    // this.name = this.$route.params.name
    // 初始化查询
    console.log(this.$route.query.name)
    this.name = this.$route.query.name
    this.handlePage(1)
    this.sreachItem = this.$route.query.sreachData
  },
  watch: {
    '$route' (to, from) {
      // 此处作查询方法
      // console.log(this.$route.query.name)
      this.name = this.$route.query.name
      this.handlePage(1)
    }
  }
}
</script>

<style scoped>
  .container {
    margin: 15px auto;
    width: 93%;
    min-width: 1000px;
  }
  .text-danger {
    color: #A94442;
  }
  .seckill-price{
    margin-right: 5px;
    font-size: 25px;
    font-weight: bold;
  }
  .goods-box {
    display: flex;
  }
  /* ---------------侧边广告栏开始------------------- */
  .as-box {
    width: 200px;
    border: 1px solid #ccc;
  }
  .item-as-title{
    width: 100%;
    height: 36px;
    color: #B1191A;
    line-height: 36px;
    font-size: 18px;
  }
  .item-as-title span:first-child{
    margin-left: 20px;
  }
  .item-as-title span:last-child{
    float: right;
    margin-right: 15px;
    font-size: 10px;
    color: #ccc;
  }
  .item-as{
    width: 160px;
    margin: 18px auto;
  }
  .item-as-img{
    width: 160px;
    height: 160px;
    margin: 0px auto;
  }
  .item-as-price span{
    font-size: 18px;
  }
  .item-as-intro{
    margin-top: 5px;
    font-size: 12px;
  }
  .item-as-selled{
    margin-top: 5px;
    font-size: 12px;
  }
  .item-as-selled span{
    color: #005AA0;
  }
  /* ---------------侧边广告栏结束------------------- */

  /* ---------------商品栏开始------------------- */
  .goods-list-box {
    margin-left: 15px;
    width: calc(100% - 215px);
  }
  .goods-list-tool{
    width: 100%;
    height: 38px;
    border: 1px solid #ccc;
    background-color: #F1F1F1;
  }
  .goods-list-tool ul{
    padding-left: 15px;
    list-style: none;
  }
  .goods-list-tool li{
    cursor: pointer;
    float: left;
  }
  .goods-list-tool span{
    padding: 5px 8px;
    border: 1px solid #ccc;
    border-left: none;
    line-height: 36px;
    background-color: #fff;
  }
  .goods-list-tool span:hover{
    border: 1px solid #E4393C;
  }
  .goods-list-tool i:hover{
    color: #E4393C;
  }
  .goods-list-tool-active {
    color: #fff;
    border-left: 1px solid #ccc;
    background-color: #E4393C !important;
  }

  .goods-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
  }
  .goods-show-info{
    width: 240px;
    padding: 10px;
    margin: 15px 0px;
    border: 1px solid #fff;
    cursor: pointer;
  }
  .goods-show-info:hover{
    border: 1px solid #ccc;
    box-shadow: 0px 0px 15px #ccc;
  }
  .goods-show-price{
    margin-top: 6px;
  }
  .goods-show-detail{
    font-size: 12px;
    margin: 6px 0px;
  }
  .goods-show-num{
    font-size: 12px;
    margin-bottom: 6px;
    color: #009688;
  }
  .goods-show-num span{
    color: #005AA0;
    font-weight: bold;
  }
  .goods-show-seller{
    font-size: 12px;
    color:#E4393C;
  }
  .goods-page {
    margin-top: 20px;
    display: flex;
    justify-content: flex-end;
  }
  /* ---------------商品栏结束------------------- */
</style>
