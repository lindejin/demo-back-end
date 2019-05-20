<template>
    <div>
      <el-dialog :title="title" :visible.sync="dialogVisible" :before-close="handleClose" width="70%">
        <el-row>
            <tern-form ref="investmentEditForm" :url="'/jrsfl/valuation/entrusted/save'" submitFlag="submitFlag">
                <el-form :model="editForm" ref="fruitForm" :rules="rules" label-position="right" label-width="120px">
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="水果ID：" prop="fruitId">
                                <el-input v-model="editForm.fruitId" placeholder="" :maxlength="32" :disabled="this.submitFlag=='view'" :readonly="true"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="水果名称：" prop="fruitName">
                                <el-input v-model="editForm.fruitName" placeholder="请填写水果名称" :maxlength="128" :disabled="this.submitFlag=='view'"
                                    :readonly="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="水果简介：" prop="fruitSummery">
                                <el-input v-model="editForm.fruitSummery" placeholder="请填写水果简介" :maxlength="32" :disabled="this.submitFlag=='view'"
                                    :readonly="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="水果原价：" prop="primeCost">
                                <el-input v-model="editForm.primeCost" placeholder="请填写产品代码" :maxlength="32" :disabled="this.submitFlag=='view'"
                                    :readonly="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="促销价格：" prop="fruitSale">
                                <el-input v-model="editForm.fruitSale" placeholder="请填写产品名称" :maxlength="32"
                                    :disabled="this.submitFlag=='view'" :readonly="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="销量：">
                                <el-input v-model="editForm.saleCount" placeholder="请填写产品代码" :maxlength="32"
                                    :disabled="this.submitFlag=='view'" :readonly="true"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>

                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="库存：" prop="fruitStock">
                              <el-input v-model="editForm.fruitStock" placeholder="请填写产品代码" :maxlength="32"
                                        :disabled="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="上架状态：" >
                              <el-input v-model="editForm.shelfStatus" placeholder="请填写产品代码" :maxlength="32"
                                        :disabled="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="热门状态：" prop="fruitHot">
                                <el-input v-model="editForm.fruitHot" placeholder="请填写理财类型" :maxlength="32" :disabled="this.submitFlag=='view'"
                                    :readonly="this.submitFlag=='view'"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="创建时间："  :rules="[{ validator: (rule, value, callback)=> {checkNum(rule, value, callback)},trigger: 'blur'}]">
                              <el-input v-model="editForm.createTime" placeholder="请填写交易对手" :maxlength="128"
                                        :disabled="this.submitFlag=='view'" :readonly="true"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="修改时间：" >
                                <el-input v-model="editForm.updateTime" placeholder="请填写交易对手" :maxlength="128"
                                    :disabled="this.submitFlag=='view'" :readonly="true"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                        </el-col>
                    </el-row>
                  <el-row>
                    <el-col :span="24">
                      <el-form-item label="水果图片:">
                        <el-upload
                          ref="upload"
                          class="upload-demo"
                          action="aaa"
                          :limit="1"
                          :auto-upload="false"
                          :on-change="handlePictureCardPreview"
                          :before-upload="beforeupload"
                          :file-list="fileList"
                          list-type="picture-card">
                          <el-button v-show="this.submitFlag!='view'" size="small" type="success">点击上传</el-button>
                          <div slot="tip" class="el-upload__tip">图片</div>
                        </el-upload>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </el-form>
            </tern-form>
        </el-row>
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
      title: '',
      dialogVisible: false,
      submitFlag: 'view',
      editForm: {},
      formData: new FormData(),
      fileList: [{name: '', url: ''}],
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
      console.log(this.editForm)
      this.submitFlag = 'update'
      this.dialogVisible = true
      this.fileList[0].url = this.editForm.fruitImage
      this.fileList[0].name = '图'
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
      this.fileList[0].url = this.editForm.fruitImage
      this.fileList[0].name = '图'
      this.dialogVisible = true
      console.log(this.editForm)
    },
    handleClose () {
      this.$refs.fruitForm.resetFields()
      this.$nextTick(() => {
        this.$refs['fruitForm'].clearValidate()
      })
      this.$emit('search')
      this.$emit('fatherMethod')
      this.dialogVisible = false
    },
    onSubmit () {
      // 这里进行表单提交操作
      // 存图片
      let fileValue = document.querySelector('.el-upload .el-upload__input')
      this.formData.delete('file')
      this.formData.append('file', fileValue.files[0])
      this.formData.delete('fruitInfo')
      this.formData.append('fruitInfo', JSON.stringify(this.editForm))
      this.$refs.fruitForm.validate((valid) => {
        if (valid) {
          // let headers = {headers: { 'Content-Type': 'multipart/form-data' }}
          this.axios.post('/fruit/updata', this.formData
          ).then(res => {
            this.$refs.fruitForm.clearValidate()
            this.$refs.fruitForm.resetField()
            console.log('1')
            this.$refs.upload.clearFiles()
            this.formData.delete('file')
            console.log(this.formData.get('fruitInfo'))
            this.dialogVisible = false
            if (res.data > 0) {
              this.$message({
                type: 'error',
                message: '修改成功!'
              })
              this.$emit('fatherMethod')
            } else {
              this.$message({
                type: 'error',
                message: '修改失败!'
              })
            }
          }).catch(() => {
            // 遇到异常则关闭加载
            this.$nextTick(() => {
              this.dialogVisible = false
            })
          })
          console.log('表单验证成功')
          this.dialogVisible = false
        } else {
          console.log('error 表单验证失败!!')
          return false
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
    },
    // 阻止upload的自己上传，进行再操作
    beforeupload (file) {
      console.log(5)
      // this.$refs.upload.clearFiles()
      return false
    },
    // 图片预览
    handlePictureCardPreview (file) {
      // console.log(this.$refs)
      // 存图片
      let fileValue = document.querySelector('.el-upload .el-upload__input')
      this.formData.delete('file')
      this.formData.append('file', fileValue.files[0])
    }
  }
}
</script>

<style scoped>
.inputStyle {
    width: 100%;
}
</style>
