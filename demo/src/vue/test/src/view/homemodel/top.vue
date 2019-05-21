<template>
  <div >
    <div>
      <!--顶部导航条 -->
      <div class="am-container header">
        <ul class="message-l">
          <div class="topMessage">
            <div v-show="tmp" class="menu-hd">
              <a @click="login" target="_top" class="h">亲，请登录</a>
              <a @click="register" target="_top">免费注册</a>
            </div>
            <div v-show="!tmp" class="menu-hd">
              <a @click="index" target="_top" class="h">欢迎登录，{{user}}</a>
              <a @click="unlogin" target="_top">退出登录</a>
            </div>
          </div>
        </ul>
        <ul class="message-r">
          <div class="topMessage home">
            <div class="menu-hd"><a @click="home" target="_top" class="h">商城首页</a></div>
          </div>
          <div class="topMessage my-shangcheng">
            <div class="menu-hd MyShangcheng"><a @click="index" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
          </div>
          <div class="topMessage mini-cart">
            <div class="menu-hd"><a id="mc-menu-hd" @click="shopcart" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
              id="J_MiniCartNum" class="h">0</strong></a></div>
          </div>
          <div class="topMessage favorite">
          </div>
        </ul>
      </div>
      <div class="clear"></div>
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
      name: '',
      tmp: this.temp(),
      user: localStorage.getItem('Flag01')
    }
  },
  // 监听属性 类似于data概念
  computed: {},
  // 监控data中的数据变化
  watch: {
    '$route' (to, from) {
      console.log()
    }
  },
  // 方法集合
  methods: {
    temp () {
      if (localStorage.getItem('Flag01')) {
        return false
      } else {
        return true
      }
    },
    login () {
      this.tmp = false
      console.log('登录')
      this.$router.push({
        path: '/login'
      })
    },
    unlogin () {
      this.tmp = true
      localStorage.removeItem('Flag01')
      console.log('退出登录')
      this.$router.go(0)
    },
    register () {
      console.log('注册')
      this.$router.push({
        path: '/register',
        query: {
          id: ''
        }
      })
    },
    index () {
      console.log('个人中心')
      if (localStorage.getItem('Flag01')) {
        this.$router.push({
          path: '/index',
          query: {
            id: ''
          }
        })
      } else {
        this.$router.push({
          path: '/login',
          query: {
            id: ''
          }
        })
      }
    },
    shopcart () {
      if (localStorage.getItem('Flag01')) {
        this.$router.push({
          path: '/myShoppingCart',
          query: {
            id: ''
          }
        })
      } else {
        this.$router.push({
          path: '/login',
          query: {
            id: ''
          }
        })
      }
    },
    home () {
      console.log('首页')
      this.$router.push({
        path: '/home1'
      })
    }
  },
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
