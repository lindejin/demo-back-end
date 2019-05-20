<template>
  <div>
    <div class="login-boxtitle">
      <a href="home.html"><image alt="logo" src="static/style/images/logobig.png" /></a>
    </div>
  <div class="res-banner">
    <div class="res-main">
      <div class="login-banner-bg"><span></span><img src="static/style/images/big.jpg" /></div>
      <div class="login-box">
          <div class="am-tabs-bd">
            <div class="am-tab-panel am-active">
              <el-form
                :model="ReginForm"
                ref="ReginForm"
                :rules="rule"
                class="regform"
                label-width="0">

                <h3>用户注册</h3>

                <el-form-item prop="userName">
                  <el-input
                    type="text"
                    v-model="ReginForm.userName"
                    placeholder="用户名">
                  </el-input>
                </el-form-item>

                <el-form-item prop="userPass">
                  <el-input
                    type="password"
                    v-model="ReginForm.userPass"
                    placeholder="密码">
                  </el-input>
                </el-form-item>

                <el-form-item prop="confirmpassword">
                  <el-input
                    type="password"
                    v-model="ReginForm.confirmpassword"
                    placeholder="确认密码">
                  </el-input>
                </el-form-item>

                <el-form-item prop="userEmail">
                  <el-input
                    type="email"
                    v-model="ReginForm.userEmail"
                    placeholder="电子邮件">
                  </el-input>
                </el-form-item>
                <el-form-item prop="smscode" class="code">
                  <el-input v-model="ReginForm.smscode" placeholder="验证码"></el-input>
                  <el-button type="primary" :disabled='isDisabled' @click="sendCode">发送</el-button>
                </el-form-item>
                <el-form-item prop="userPhone">
                  <el-input
                    type="text"
                    v-model.number="ReginForm.userPhone"
                    placeholder="电话号码">
                  </el-input>
                </el-form-item>

                <el-form-item prop="userQuestion">
                  <el-input
                    type="text"
                    v-model="ReginForm.userQuestion"
                    placeholder="找回问题">
                  </el-input>
                </el-form-item>
                <el-form-item prop="userAnswer">
                  <el-input
                    type="text"
                    v-model="ReginForm.userAnswer"
                    placeholder="答案">
                  </el-input>
                </el-form-item>

                <el-form-item >
                  <el-button
                    type="success"
                    class="submitBtn"
                    round
                    @click.native.prevent="submit"
                    :loading="logining">
                    注册
                  </el-button>
                  <el-button
                    type="primary"
                    class="resetBtn"
                    round
                    @click.native.prevent="reset">
                    重置
                  </el-button>
                  <hr>
                  <p>已经有账号，马上去<span class="to" @click="tologin">登录</span></p>
                </el-form-item>

              </el-form>
            </div>

<!--            <div class="am-tab-panel">-->
<!--              <form method="post">-->
<!--                <div class="user-phone">-->
<!--                  <label for="phone"><i class="am-icon-mobile-phone am-icon-md"></i></label>-->
<!--                  <input type="tel" name="" id="phone" placeholder="请输入手机号">-->
<!--                </div>-->
<!--                <div class="verification">-->
<!--                  <label for="code"><i class="am-icon-code-fork"></i></label>-->
<!--                  <input type="tel" name="" id="code" placeholder="请输入验证码">-->
<!--                  <a class="btn" href="javascript:void(0);" onclick="sendMobileCode();" id="sendMobileCode">-->
<!--                    <span id="dyMobileButton">获取</span></a>-->
<!--                </div>-->
<!--                <div class="user-pass">-->
<!--                  <label for="password"><i class="am-icon-lock"></i></label>-->
<!--                  <input type="password" name="" id="password" placeholder="设置密码">-->
<!--                </div>-->
<!--                <div class="user-pass">-->
<!--                  <label for="passwordRepeat"><i class="am-icon-lock"></i></label>-->
<!--                  <input type="password" name="" id="passwordRepeat" placeholder="确认密码">-->
<!--                </div>-->
<!--              </form>-->
<!--              <div class="login-links">-->
<!--                <label for="reader-me">-->
<!--                  <input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》-->
<!--                </label>-->
<!--              </div>-->
<!--              <div class="am-cf">-->
<!--                <input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">-->
<!--              </div>-->

<!--              <hr>-->
<!--            </div>-->

            <!-- <script>
              $(function() {
                $('#doc-my-tabs').tabs();
              })
            </script> -->

          </div>
        </div>
    </div>
      </div>
  </div>
</template>

<script>
export default {
  name: 'SignUp',
  data () {
    let smscodeCheck = (rule, value, callback) => {
      this.axios.get('/user/getCode'
      ).then(res => {
        if (res.data.toString() === value) {
          callback()
        } else {
          this.$message({
            type: 'error',
            message: '验证码与发送不一致!'
          })
          callback(new Error('验证码错误'))
        }
      }).catch(() => {
        // 遇到异常则关闭加载
        callback(new Error('表单验证异常'))
      })
    }
    let nameCheck = (rule, value, callback) => {
      this.axios.get('/user/select01', {params: {name: this.ReginForm.userName}}
      ).then(res => {
        if (res.data !== 0) {
          callback(new Error('用户已存在，请重输'))
        } else {
          callback()
        }
      }).catch(() => {
        // 遇到异常则关闭加载
        callback(new Error('表单验证异常'))
      })
    }
    let confirmpasswordCheck = (rule, value, callback) => {
      if (value === '') {
        return callback(new Error('密码是必须的'))
      } else if (value !== this.ReginForm.userPass) {
        return callback(new Error('两次输入的密码不一致'))
      } else {
        return callback()
      }
    }
    let telCheck = (rule, value, callback) => {
      if (value === '') {
        return callback(new Error('电话号码是必须的'))
      } else if (!Number.isInteger(value)) {
        return callback(new Error('电话号码必须是数字'))
      } else if (value.toString().length !== 11) {
        return callback(new Error('电话号码必须是11位数字'))
      } else {
        callback()
      }
    }
    return {
      isDisabled: false,
      ReginForm: {
        userName: '',
        userPass: '',
        confirmpassword: '',
        userPhone: '',
        userEmail: '',
        userQuestion: '',
        userAnswer: '',
        name: '',
        smscode: ''
      },
      logining: false,
      rule: {
        userName: [
          {
            required: true,
            validator: nameCheck,
            trigger: 'blur'
          }
        ],
        smscode: [
          {
            required: true,
            validator: smscodeCheck,
            trigger: 'blur'
          }
        ],
        userPass: [
          {
            required: true,
            message: '密码是必须的！',
            trigger: 'blur'
          }
        ],
        confirmpassword: [
          {
            required: true,
            validator: confirmpasswordCheck,
            trigger: 'blur'
          }
        ],
        userPhone: [
          {
            required: true,
            validator: telCheck,
            trigger: 'blur'
          }
        ],
        userEmail: [
          {
            required: true,
            type: 'email',
            message: '请输入正确的电子邮件格式(xxx@xxx.com)',
            trigger: 'blur'
          }
        ],
        userQuestion: [
          {
            required: true,
            max: 12,
            min: 2,
            message: '问题和答案是必须的，最好是汉字',
            trigger: 'blur'
          }
        ],
        userAnswer: [
          {
            required: true,
            max: 12,
            min: 2,
            message: '问题和答案是必须的，最好是汉字',
            trigger: 'blur'
          }
        ]
      }
    }
  },
  computed: {
  },
  methods: {
    sendCode () {
      // 发送验证码 806962181@qq.com
      this.axios.get('/user/mail', {params: {userEmail: this.ReginForm.userEmail}}
      ).then(res => {
        if (res.data === 0) {
          this.$message({
            type: 'success',
            message: '发送成功!'
          })
        } else {
          this.$message({
            type: 'error',
            message: '发送失败,请检查邮箱!'
          })
        }
      }).catch(() => {
        // 遇到异常
      })
    },
    submit () {
      this.$refs.ReginForm.validate(valid => {
        if (valid) {
          this.axios.post('/user/add', this.ReginForm
          ).then(res => {
            if (res.data > 0) {
              this.$message({
                type: 'success',
                message: '注册成功!'
              })
            } else {
              this.$message({
                type: 'error',
                message: '注册失败!'
              })
            }
          }).catch(() => {
            // 遇到异常则关闭加载
            this.$nextTick(() => {
              this.dialogVisible = false
            })
          })
        } else {
          console.log('submit err')
        }
      })
    },
    reset () {
      this.$refs.ReginForm.resetFields()
    },
    tologin () {
      this.$router.push('/login')
    }
  },
  mounted () {
  },
  components: {
  }
}
</script>

<style scoped>
  @import "../../../static/style/AmazeUI-2.4.2/assets/css/amazeui.css";@import "../../../static/style/AmazeUI-2.4.2/assets/css/amazeui.css";
  @import "../../../static/style/AmazeUI-2.4.2/assets/css/amazeui.css";@import "../../../static/style/css/dlstyle.css";
  .container {
  margin: 15px auto;
  height: 500px;
  overflow: hidden;
}
  .login-box{
    height: 560px;
  }
.signup-img-box {
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}
.signup-img-box>img {
  height: 80%;
}
.sign-up-title {
  width: 430px;
  margin: 15px auto;
  height: 80px;
}
.sing-up-step-box {
  margin: 15px auto;
  padding-left: 30px;
  padding-top: 30px;
  width: 430px;
  height: 380px;
  border: 1px solid #495060;
}
.sign-up-box {
  margin: 30px 25px;
  width: 350px;
  display: flex;
  align-items: center;
}
  .regform {
    margin: 0px auto;
    width: 310px;
    background: #fff;
    box-shadow: 0 0 10px #B4BCCC;
    padding: 30px 30px 0 30px;
    border-radius: 0px;
  }
  .submitBtn {
    width: 65%;
  }
  .to {
    color: #FA5555;
    cursor: pointer;
  }
  .code >>> .el-form-item__content {
    display: flex;
    align-items: center;
    justify-content: space-between;
  }
  .code button {
    margin-left: 20px;
    width: 140px;
    text-align: center;
  }
</style>
