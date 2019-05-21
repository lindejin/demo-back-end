<template>
    <div class=''>
        <!--引导 -->
        <div class="navCir">
            <li class="active"><a href="home.html"><i class="am-icon-home "></i>首页</a></li>
            <li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
            <li><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>
            <li><a href="../person/index.html"><i class="am-icon-user"></i>我的</a></li>
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
    }
  },
  // 监听属性 类似于data概念
  computed: {},
  // 监控data中的数据变化
  watch: {},
  // 方法集合
  methods: {},
  created () { }, // 生命周期 - 创建完成（可以访问当前this实例）
  mounted () { }, // 生命周期 - 挂载完成（可以访问DOM元素）
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
@import "../../../static/style/AmazeUI-2.4.2/assets/css/amazeui.css";
@import "../../../static/style/AmazeUI-2.4.2/assets/css/admin.css";
@import "../../../static/style/basic/css/demo.css";
@import "../../../static/style/css/hmstyle.css";
@import "../../../static/style/css/skin.css";
</style>
