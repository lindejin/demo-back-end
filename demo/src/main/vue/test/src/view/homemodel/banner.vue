<template>
    <div class=''>
        <div class="banner">
            <div class="am-slider am-slider-default scoll" data-am-flexslider id="demo-slider-0">
                <ul class="am-slides">
                    <el-carousel :interval="4000" type="card" height="400px">
                        <!-- <el-carousel-item v-for="item in 4" :key="item">
                            <h3>{{ item }}</h3>
                        </el-carousel-item> -->
                        <el-carousel-item v-for="(img,index) in imglist" :key="index">
                            <img :src="img.rul" class="image">
                        </el-carousel-item>
                    </el-carousel>
                    <!-- <li class="banner1"><a href="introduction.html"><img :src="require('../../../static/style/images/ad1.jpg')" /></a></li>
                    <li class="banner2"><a><img :src="require('../../../static/style/images/ad2.jpg')" /></a></li>
                    <li class="banner3"><a><img :src="require('../../../static/style/images/ad3.jpg')" /></a></li>
                    <li class="banner4"><a><img :src="require('../../../static/style/images/ad4.jpg')" /></a></li> -->

                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="shopNav">
            <div class="slideall">

                <div class="long-title"><span class="all-goods">水果商城欢迎您</span></div>
                <div class="nav-cont">
                    <ul>
                        <li class="index"><a href="#">首页</a></li>
                        <li class="qc"><a href="#">闪购</a></li>
                        <li class="qc"><a href="#">限时抢</a></li>
                        <li class="qc"><a href="#">团购</a></li>
                        <li class="qc last"><a href="#">大包装</a></li>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
</template>
<script>
// 这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
// 例如：import 《组件名称》 from '《组件路径》';
export default {
  components: {}, // import引入的组件需要注入到components中才能使用
  data () {
    return {
      imglist: [
        { rul: require('../../../static/style/images/ad1.jpg') },
        { rul: require('../../../static/style/images/ad2.jpg') },
        { rul: require('../../../static/style/images/ad3.jpg') },
        { rul: require('../../../static/style/images/ad4.jpg') }
      ]
    }
  },
  // 监听属性 类似于data概念
  computed: {},
  // 监控data中的数据变化
  watch: {},
  // 方法集合
  methods: {},
  created () { }, // 生命周期 - 创建完成（可以访问当前this实例）
  mounted () {
    console.log(this.imglist)
  }, // 生命周期 - 挂载完成（可以访问DOM元素）
  beforeCreate () { }, // 生命周期 - 创建之前
  beforeMount () { }, // 生命周期 - 挂载之前
  beforeUpdate () { }, // 生命周期 - 更新之前
  updated () { }, // 生命周期 - 更新之后
  beforeDestroy () { }, // 生命周期 - 销毁之前
  destroyed () { }, // 生命周期 - 销毁完成
  activated () { } // 如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style  scoped>
/*@import "../../../static/style/AmazeUI-2.4.2/assets/css/amazeui.css";*/
/*@import "../../../static/style/AmazeUI-2.4.2/assets/css/admin.css";*/
/*@import "../../../static/style/basic/css/demo.css";*/
/*@import "../../../static/style/css/hmstyle.css";*/
/*@import "../../../static/style/css/skin.css";*/
</style>
