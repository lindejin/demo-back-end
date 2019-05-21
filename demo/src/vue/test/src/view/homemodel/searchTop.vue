<template>
    <div >
        <div>
            <!--悬浮搜索框-->
            <div class="nav white">
                <div class="logo"><img :src="require('../../../static/style/images/logo.png')" /></div>
                <div class="logoBig">
                    <li><img :src="require('../../../static/style/images/logobig.png')" /></li>
                </div>

                <div class="search-bar pr">
                    <a name="index_none_header_sysc" href="#"></a>
                    <form>
                        <input id="searchInput" v-model="name"  type="text" placeholder="搜索" autocomplete="off">
                        <input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit" @click="search">
                    </form>
                </div>
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
      tmp: true,
      user: 'lin'
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
    login () {
      this.tmp = false
      console.log('登录')
    },
    register () {
      console.log('注册')
    },
    index () {
      console.log('个人中心')
    },
    home () {
      this.$router.push({
        path: '/home02'
      })
    },
    search () {
      this.$router.push({
        path: '/search',
        query: {
          name: this.name
        }
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
