<template>
    <div>
      <el-dialog :title="title" :visible.sync="dialogVisible" :before-close="handleClose" width="70%">
        <el-col>
            <tern-form  ref="addFrom" :url="'/user/add'" submitFlag="submitFlag">
                <el-form  action="'/user/add'" ref="userInfo" :model="userInfo"  :rules="rules" label-position="right" label-width="120px">
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="账号：" prop="userName">
                                <el-input v-model="userInfo.userName" placeholder="请填写账号名称" :maxlength="30"></el-input>
                            </el-form-item>
                        </el-col>
                      <el-col :span="12">
                        <el-form-item label="用户名：" prop="userName">
                          <el-input v-model="userInfo.userName" placeholder="请填写用户名" :maxlength="30"></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="密码：" prop="userPass">
                                <el-input autocomplete="new-password" type="password" v-model="userInfo.userPass" placeholder="请填写产品名称" :maxlength="32"></el-input>
                            </el-form-item>
                        </el-col>
                      <el-col :span="12">
                        <el-form-item label="确认：" prop="userPass">
                          <el-input autocomplete="new-password" type="password" v-model="userInfo.userPass" placeholder="请填写产品名称" :maxlength="32"></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="12">
                        <el-form-item label="电子邮箱：" prop="userEmail">
                          <el-input v-model="userInfo.userEmail" placeholder="请填写产品代码" :maxlength="32"></el-input>
                        </el-form-item>
                      </el-col>
                        <el-col :span="12">
                            <el-form-item label="手机号码：" prop="userPhone">
                                <el-input v-model="userInfo.userPhone" placeholder="请填写产品名称" :maxlength="32"
                                     ></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>

                    <el-row>
                      <el-col :span="12">
                        <el-form-item label="问题：" prop="userQuestion">
                          <el-input v-model="userInfo.userQuestion" placeholder="请填写产品代码" :maxlength="32"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                        <el-col :span="12">
                            <el-form-item label="回答：" prop="userAnswer">
                              <el-input v-model="userInfo.userAnswer" placeholder="请填写产品代码" :maxlength="32"
                                         ></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-form>
            </tern-form>
        </el-col>
        <div slot="footer" class="dialog-footer">
          <tern-button buttonCode="normal" @click="onSubmit">确定</tern-button>
          <tern-button buttonCode="normal" @click="handleClose ()">关闭</tern-button>
        </div>
      </el-dialog>
    </div>
</template>

<script>
// import {dateFormat} from '@/utils'
export default {
  data () {
    return {
      params: {
        name: '',
        email: '',
        phone: ''
      },
      title: '',
      dialogVisible: false,
      submitFlag: 'view',
      userInfo: {},
      addUser: {userInfo: {}},
      startDateOptions: {
        // disabledDate: (time) => {
        //   return time && this.editForm.DUE_DT &&
        //                     dateFormat(time, 'yyyy-MM-dd') > this.editForm.DUE_DT.replace(/\-/g, '')
        // }
      },
      endDateOptions: {
        // disabledDate: (time) => {
        //   return time && this.editForm.VAL_DT &&
        //                     dateFormat(time, 'yyyy-MM-dd') < this.editForm.VAL_DT.replace(/\-/g, '')
        // }
      },
      rules: {
        userName: [
          { required: true, message: '请输入账号', trigger: 'blur' }
        ],
        userPass: [
          { required: true, message: '请输入账号', trigger: 'blur' }
        ],
        userEmail: [
          { required: true, message: '请输入账号', trigger: 'blur' }
        ],
        userPhone: [
          { required: true, message: '请输入账号', trigger: 'blur' }
        ],
        userQuestion: [
          { required: true, message: '请输入账号', trigger: 'blur' }
        ],
        userAnswer: [
          { required: true, message: '请输入账号', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    add () {
      this.title = '增加'
      this.$nextTick(() => {
        this.userInfo = {}
      })
      // this.$refs.editForm.resetFields()
      this.submitFlag = 'add'
      this.dialogVisible = true
      // this.preUpdate()// 触发当前标志以修改
    },
    open (data) {
      this.title = '详情'
      this.userInfo = JSON.parse(JSON.stringify(data))
      this.submitFlag = 'view'
      this.dialogVisible = true
      console.log(this.userInfo)
    },
    handleClose () {
      this.$refs.userInfo.resetFields()
      this.$nextTick(() => {
        this.$refs['userInfo'].clearValidate()
      })
      this.$emit('search')
      this.dialogVisible = false
    },
    onSubmit () {
      this.$refs.userInfo.validate((valid) => {
        if (valid) {
          this.axios.post('/user/add', this.userInfo
          ).then(res => {
            this.$nextTick(() => {
              this.dialogVisible = false
            })
            this.$refs.userInfo.clearValidate()
            this.$refs.userInfo.resetField()
          }).catch(() => {
            // 遇到异常则关闭加载
            this.$nextTick(() => {
              this.dialogVisible = false
            })
          })
          this.$message({
            type: 'success',
            message: '添加成功'
          })
          this.dialogVisible = false
        } else {
          this.$message({
            type: 'success',
            message: '添加失败'
          })
          return false
        }
      })
      // this.$refs.editForm.validate((valid) => {
      //   if (valid) {
      //     alert('提交成功!')
      //     this.dialogVisible = false
      //   } else {
      //     console.log('error 提交失败!!')
      //     return false
      //   }
      // })
      // this.submit('editForm', this.form, res => {
      //   if (res.code === 1) {
      //     this.handleClose()
      //     this.successMsg(res.message)
      //     this.$emit('success')
      //   } else {
      //     this.warnMsg(res.message)
      //   }
      // })
    },
    checkNum (rule, value, callback) {
      if (value === undefined) {
        return
      }
      // eslint-disable-next-line no-irregular-whitespace
      var regu = '^([0-9])[0-9]*(\\.\\w*)?$'
      // eslint-disable-next-line no-irregular-whitespace
      var re = new RegExp(regu)
      if (!re.test(value)) {
        callback(new Error('请输入正确数值'))
      } else {
        callback()
      }
    }
  }
}
</script>

<style scoped>
.inputStyle {
    width: 100%;
}
</style>
