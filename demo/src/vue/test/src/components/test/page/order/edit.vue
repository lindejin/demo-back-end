<template>
    <div>
      <el-dialog :title="title" :visible.sync="dialogVisible" :before-close="handleClose" width="70%">
        <el-row>
            <tern-form ref="investmentEditForm" :url="'/jrsfl/valuation/entrusted/save'" submitFlag="submitFlag">
                <el-form :model="editForm" ref="editForm" :rules="rules" label-position="right" label-width="120px">
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="用户ID：" prop="ACCT_NO">
                                <el-input v-model="editForm.userId" placeholder="请填写内部账号" :maxlength="32" :disabled="this.submitFlag=='view'" :readonly="true"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="账号：" prop="ACCT_NM">
                                <el-input v-model="editForm.userName" placeholder="请填写账号名称" :maxlength="128" :disabled="this.submitFlag=='view'"
                                    :readonly="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="密码：" prop="PROD_NM">
                                <el-input autocomplete="new-password" type="password" v-model="editForm.userPass" placeholder="请填写产品名称" :maxlength="32" :disabled="this.submitFlag=='view'"
                                    :readonly="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="电子邮箱：" prop="PROD_CD">
                                <el-input v-model="editForm.userEmail" placeholder="请填写产品代码" :maxlength="32" :disabled="this.submitFlag=='view'"
                                    :readonly="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="手机号码：" prop="PAY_INT_FREQ">
                                <el-input v-model="editForm.userPhone" placeholder="请填写产品名称" :maxlength="32"
                                    :disabled="this.submitFlag=='view'" :readonly="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="问题：" prop="PAY_INT_CONTENT">
                                <el-input v-model="editForm.userQuestion" placeholder="请填写产品代码" :maxlength="32"
                                    :disabled="this.submitFlag=='view'" :readonly="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>

                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="回答：" prop="VAL_DT">
                              <el-input v-model="editForm.userAnswer" placeholder="请填写产品代码" :maxlength="32"
                                        :disabled="this.submitFlag=='view'" :readonly="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="状态：" prop="DUE_DT">
                              <el-input v-model="editForm.userState" placeholder="请填写产品代码" :maxlength="32"
                                        :disabled="this.submitFlag=='view'" :readonly="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="类别：" prop="FNC_TYPE">
                                <el-input v-model="editForm.userRole" placeholder="请填写理财类型" :maxlength="32" :disabled="this.submitFlag=='view'"
                                    :readonly="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="创建时间：" prop="EXPTD_PFT_RATE" :rules="[{ validator: (rule, value, callback)=> {checkNum(rule, value, callback)},trigger: 'blur'}]">
                              <el-input v-model="editForm.createTime" placeholder="请填写交易对手" :maxlength="128"
                                        :disabled="this.submitFlag=='view'" :readonly="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="修改时间：" prop="COMPANY_NM">
                                <el-input v-model="editForm.updateTime" placeholder="请填写交易对手" :maxlength="128"
                                    :disabled="this.submitFlag=='view'" :readonly="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                        </el-col>
                    </el-row>
                </el-form>
            </tern-form>
        </el-row>
        <div slot="footer" class="dialog-footer">
<!--          <tern-button buttonCode="normal" @click="changeListVar">确定选中</tern-button>-->
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
      title: '',
      dialogVisible: false,
      submitFlag: 'view',
      editForm: {},
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
      rules: {}
    }
  },
  methods: {
    edit (data) {
      this.title = '维护'
      this.editForm = JSON.parse(JSON.stringify(data))
      this.submitFlag = 'update'
      this.dialogVisible = true
      // this.preUpdate()// 触发当前标志以修改
    },
    add () {
      this.title = '增加'
      this.$nextTick(() => {
        this.editForm = {}
      })
      // this.$refs.editForm.resetFields()
      this.submitFlag = 'add'
      this.dialogVisible = true
      // this.preUpdate()// 触发当前标志以修改
    },
    open (data) {
      this.title = '详情'
      this.editForm = JSON.parse(JSON.stringify(data))
      this.submitFlag = 'view'
      this.dialogVisible = true
      console.log(this.editForm)
    },
    handleClose () {
      this.$refs.editForm.resetFields()
      this.$nextTick(() => {
        this.$refs['editForm'].clearValidate()
      })
      this.$emit('search')
      this.dialogVisible = false
    },
    onSubmit () {
      var self = this
      self.submit('investmentEditForm', this.editForm, res => {
        if (res.code === 200) {
          self.successMsg(res.message)
          self.handleClose()
          self.$emit('search')
        } else {
          self.failMsg(res.message)
          self.handleClose()
          self.$emit('search')
        }
      })
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
