<template>
    <div class=''>
        <div class="login-boxtitle">
            <a href="home.html"><image alt="logo" src="../images/logobig.png" /></a>
        </div>

        <div class="login-banner">
            <div class="login-main">
                <div class="login-banner-bg"><span></span><image :src="'./style/images/big.jpg'" /></div>
                <div class="login-box">

                    <h3 class="title">登录商城</h3>

                    <div class="clear"></div>

                    <div class="login-form">
                        <form>
                            <div class="user-name">
                                <label ><i class="am-icon-user"></i></label>
                                <input type="text" v-model="login.userName" placeholder="邮箱/手机/用户名">
                            </div>
                            <div class="user-pass">
                                <label ><i class="am-icon-lock"></i></label>
                                <input type="password" v-model="login.userPass" placeholder="请输入密码">
                            </div>
                        </form>
                    </div>

                    <div class="login-links">
                        <label for="remember-me"><input id="remember-me" type="checkbox">记住密码</label>
                        <a href="#" class="am-fr">忘记密码</a>
                        <a href="register.html" class="zcnext am-fr am-btn-default">注册</a>
                        <br />
                    </div>
                    <div class="am-cf">
                        <input type="submit" name="" value="登 录" @click="login01" class="am-btn am-btn-primary am-btn-sm">
                    </div>
                </div>
            </div>
        </div>

        <div class="footer ">
            <div class="footer-hd ">
                <p>
                    <a href="# ">工程科技</a>
                    <b>|</b>
                    <a href="# ">商城首页</a>
                    <b>|</b>
                    <a href="# ">支付宝</a>
                    <b>|</b>
                    <a href="# ">物流</a>
                </p>
            </div>
            <div class="footer-bd ">
                <p>
                    <a href="# ">关于工程</a>
                    <a href="# ">合作伙伴</a>
                    <a href="# ">联系我们</a>
                    <a href="# ">网站地图</a>
                    <em>© 2019-2025 dd.com 版权所有 <a href="http://www.baidu.com/" target="_blank" title="dd">dd</a>
                        - Collect from <a href="http://www.baidu.com/" title="dd" target="_blank">dd</a></em>
                </p>
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
      login: {
        userName: '',
        userPass: ''
      }
    }
  },
  // 监听属性 类似于data概念
  computed: {},
  // 监控data中的数据变化
  watch: {},
  // 方法集合
  methods: {
    login01 () {
      if (this.login.userName === '') {
        this.$message({
          type: 'error',
          message: '请输入账号'
        })
        return false
      }
      if (this.login.userPass === '') {
        this.$message({
          type: 'error',
          message: '请输入密码'
        })
        return false
      }
      console.log(this.login)
      this.axios.get('/user/login', {params: this.login}).then(res => {
        console.log(res.data)
        let tmp = res.data
        if (tmp) {
          localStorage.setItem('Flag01', res.data.userid)
          localStorage.setItem('token', res.data.token)
          let redirect = decodeURIComponent(this.$route.query.redirect || '/') //  获取登录成功后要跳转的路由。
          this.$router.push({
            path: redirect
          })
        } else {
          return false
        }
        // localStorage.setItem('Flag01', res.data)
      }).catch(() => {
        // 遇到异常则关闭加载
        console.log('1111')
        return false
      })
      // this.$router.go(-1)
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
@import "../../static/style/AmazeUI-2.4.2/assets/css/amazeui.css";
@import "../../static/style/css/dlstyle.css";
</style>
