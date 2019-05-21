<template>
  <div class="login_page fillcontain">
    <transition name="form-fade" mode="in-out">
      <section class="form_contianer">
        <div class="manage_tip">
          <p>elm后台管理系统</p>
        </div>
        <el-form :model="loginForm" :rules="rules" ref="loginForm">
          <el-form-item prop="userName">
            <el-input v-model="loginForm.userName" placeholder="用户名"><span>dsfsf</span></el-input>
          </el-form-item>
          <el-form-item prop="userPass">
            <el-input type="password" placeholder="密码" v-model="loginForm.userPass"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('loginForm')" class="submit_btn">登陆</el-button>
          </el-form-item>
        </el-form>
        <p class="tip">温馨提示：</p>
<!--        <p class="tip">未登录过的新用户，自动注册</p>-->
<!--        <p class="tip">注册过的用户可凭账号密码登录</p>-->
      </section>
    </transition>
  </div>
</template>

<script>
export default {
  data () {
    return {
      loginForm: {
        userName: '',
        userPass: ''
      },
      rules: {
        userName: [
          { required: true, message: '请输入用户名', trigger: 'blur' }
        ],
        userPass: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ]
      },
      showLogin: false
    }
  },
  mounted () {
  },
  computed: {
  },
  methods: {
    submitForm (formName) {
      // console.log(this.loginForm)
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.axios.get('/user/login02', {params: this.loginForm}).then(res => {
            console.log('1')
            let tmp = res.data
            if (tmp) {
              localStorage.setItem('Flag02', res.data.userid)
              localStorage.setItem('token', res.data.token)
              let redirect = decodeURIComponent(this.$route.query.redirect || '/') //  获取登录成功后要跳转的路由。
              this.$router.push({
                path: redirect
              })
            } else {
              return false
            }
          }).catch(() => {
            // 遇到异常则关闭加载
            console.log('2')
          })
          // localStorage.setItem('Flag02', )
        } else {
        }
      })
      // console.log(localStorage.setItem('Flag02'))
      // console.log(localStorage.setItem('token'))  this.$router.go(-1)
    }
  },
  watch: {
    adminInfo: function (newValue) {
      if (localStorage.setItem('Flag02')) {
        this.$message({
          type: 'success',
          message: '检测到您之前登录过，将自动登录'
        })
        this.$router.push('/home')
      }
    }
  }
}
</script>

<style lang="less" scoped>
  @import '../../style/mixin';
  .login_page{
    background-color: #324057;
  }
  .manage_tip{
    position: absolute;
    width: 100%;
    top: -100px;
    left: 0;
    p{
      font-size: 34px;
      color: #fff;
    }
  }
  .form_contianer{
    .wh(320px, 210px);
    .ctp(320px, 210px);
    padding: 25px;
    border-radius: 5px;
    text-align: center;
    background-color: #fff;
    .submit_btn{
      width: 100%;
      font-size: 16px;
    }
  }
  .tip{
    font-size: 12px;
    color: red;
  }
  .form-fade-enter-active, .form-fade-leave-active {
    transition: all 1s;
  }
  .form-fade-enter, .form-fade-leave-active {
    transform: translate3d(0, -50px, 0);
    opacity: 0;
  }
</style>
