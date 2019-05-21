<template>
  <div class="header_container">
    <el-button  @click="unlogin()">退出</el-button>
  </div>
</template>
<script>
import icon from './icon.gif'
// 这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
// 例如：import 《组件名称》 from '《组件路径》';
export default {
  components: {
  }, // import引入的组件需要注入到components中才能使用
  data () {
    return {
      icon,
      levelList: null
    }
  },
  watch: {
    $route () {
      this.getBreadcrumb()
    }
  },
  created () {
    this.getBreadcrumb()
    // this.unlogin()
  },
  methods: {
    unlogin () {
      this.tmp = true
      localStorage.removeItem('Flag02')
      console.log('退出登录')
      this.$router.go(0)
    },
    getBreadcrumb () {
      let matched = this.$route.matched.filter(item => item.name)// $route.matched 将会是一个包含从上到下的所有对象 (副本)。
      // console.log(this.$route.matched)
      // console.log(matched)
      const first = matched[0]
      if (first && first.name !== '首页') { // $route.name当前路由名称  ；$route.redirectedFrom重定向来源的路由的名字
        matched = [{ path: '/home', meta: { title: '首页' } }].concat(matched)
      }
      this.levelList = matched
      // console.log(this.levelList)
    }
  },
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
<style lang="less">
  @import "../style/mixin";
  .header_container {
    background-color: #eff2f7;
    height: 60px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding-left: 20px;
  }
  .avator {
    .wh(36px, 36px);
    border-radius: 50%;
    margin-right: 37px;
  }
  .el-dropdown-menu__item {
    text-align: center;
  }
  .list-item {
    display: inline-block;
    margin-right: 10px;
  }
  .list-move,
  .list-enter-active,
  .list-leave-active {
    transition: 1s;
  }
  .list-leave-active {
    position: absolute;
  }
  .list-enter,
  .list-leave-to {
    opacity: 0;
    transform: translateY(30px);
  }
  /*breadcrumb transition*/
  .breadcrumb-enter-active,
  .breadcrumb-leave-active {
    transition: all .5s;
  }

  .breadcrumb-enter,
  .breadcrumb-leave-active {
    opacity: 0;
    transform: translateX(20px);
  }

  .breadcrumb-move {
    transition: all .5s;
  }

  .breadcrumb-leave-active {
    position: absolute;
  }
  .app-breadcrumb.el-breadcrumb {
    display: inline-block;
    font-size: 14px;
    line-height: 50px;
    margin-left: 8px;
    .no-redirect {
      color: #97a8be;
      cursor: text;
    }
  }

</style>
