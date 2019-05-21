<template>
    <div>
      <el-dialog :title="title" :visible.sync="dialogVisible" :before-close="handleClose" width="70%">
        <el-row>
            <tern-form ref="investmentFruitForm" :url="'/fruit/add'" submitFlag="submitFlag">
                <el-form :model="fruitInfo" ref="fruitForm" :rules="rules" label-position="right" label-width="120px">
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="水果名称：" prop="fruitName">
                                <el-input v-model="fruitInfo.fruitName" placeholder="请填写水果名称" :maxlength="32"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="水果简介：" prop="fruitSummery">
                                <el-input v-model="fruitInfo.fruitSummery" placeholder="请填写水果简介" :maxlength="128"
                                    ></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="水果原价：" prop="primeCost">
                                <el-input v-model="fruitInfo.primeCost" placeholder="请填写水果原价" :maxlength="32"
                                    ></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="促销价格：" prop="fruitSale">
                                <el-input v-model="fruitInfo.fruitSale" placeholder="请填写促销价格" :maxlength="32"
                                     ></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="水果销量：" prop="saleCount">
                                <el-input v-model="fruitInfo.saleCount" placeholder="请填写水果销量" :maxlength="32"
                                     ></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="水果库存：" prop="fruitStock">
                              <el-input v-model="fruitInfo.fruitStock" placeholder="请填写水果库存" :maxlength="32"
                                         ></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="上架状态：" prop="shelfStatus">
                              <el-input v-model="fruitInfo.shelfStatus" placeholder="请填写上架状态" :maxlength="32"
                                         ></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="热门状态：" prop="fruitHot">
                                <el-input v-model="fruitInfo.fruitHot" placeholder="请填写热门状态" :maxlength="32"
                                    ></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="水果详情：" prop="fruitDetail">
                                <el-input v-model="fruitInfo.fruitDetail" type="textarea" placeholder="请填写水果详情" :maxlength="1000"
                                      :rows="9"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
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
<!--                              <img v-if="dialogImageUrl" :src="dialogImageUrl" class="avatar">-->
<!--                              <i v-else class="el-icon-plus avatar-uploader-icon"></i>-->
                              <el-button v-show="!dialogImageUrl" size="small" type="success">点击上传</el-button>
                              <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                            </el-upload>
                          </el-form-item>
                        </el-col>
                    </el-row>
                </el-form>
            </tern-form>
        </el-row>
        <div slot="footer" class="dialog-footer">
          <tern-button buttonCode="normal" @click="onSubmit()">确定</tern-button>
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
      fruitInfo: {},
      fileList: [{name: 'et4.jip', url: require('D:/CCleaner/fruit/test/static/style/images/et4.png')}],
      addFruitInfo: {
        type: Object
      },
      startDateOptions: {
        // disabledDate: (time) => {
        //   return time && this.fruitInfo.DUE_DT &&
        //                     dateFormat(time, 'yyyy-MM-dd') > this.fruitInfo.DUE_DT.replace(/\-/g, '')
        // }
      },
      endDateOptions: {
        // disabledDate: (time) => {
        //   return time && this.fruitInfo.VAL_DT &&
        //                     dateFormat(time, 'yyyy-MM-dd') < this.fruitInfo.VAL_DT.replace(/\-/g, '')
        // }
      },
      dialogImageUrl: '', // 图片
      formData: new FormData(),
      rules: {
        file: [
          { required: true, message: '请上传图片' }
        ]
      }
    }
  },
  methods: {
    edit (data) {
      this.title = '维护'
      this.fruitInfo = JSON.parse(JSON.stringify(data))
      this.submitFlag = 'update'
      this.dialogVisible = true
      // this.preUpdate()// 触发当前标志以修改
    },
    add () {
      this.title = '增加'
      this.$nextTick(() => {
        this.fruitInfo = {}
      })
      // this.$refs.fruitInfo.resetFields()
      this.submitFlag = 'add'
      this.dialogVisible = true
      // this.preUpdate()// 触发当前标志以修改
    },
    open (data) {
      this.title = '详情'
      this.fruitInfo = JSON.parse(JSON.stringify(data))
      this.submitFlag = 'view'
      this.dialogVisible = true
      console.log(this.fruitInfo)
    },
    handleClose () {
      this.$refs.fruitForm.resetFields()
      this.$nextTick(() => {
        this.$refs['fruitForm'].clearValidate()
      })
      this.$emit('search')
      this.dialogVisible = false
    },
    onSubmit () {
      // 这里进行表单提交操作
      // 存图片
      let fileValue = document.querySelector('.el-upload .el-upload__input')
      this.formData.delete('file')
      this.formData.append('file', fileValue.files[0])
      this.formData.delete('fruitInfo')
      this.formData.append('fruitInfo', JSON.stringify(this.fruitInfo))
      this.$refs.fruitForm.validate((valid) => {
        if (valid) {
          // let headers = {headers: { 'Content-Type': 'multipart/form-data' }}
          this.axios.post('/fruit/add', this.formData
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
                message: '添加成功!'
              })
              this.$emit('fatherMethod')
            } else {
              this.$message({
                type: 'error',
                message: '添加失败!'
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
    changeListVar () {
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
      // console.log(this.formData.get('file'))
      this.dialogImageUrl = file.url
      // this.$refs.upload.clearFiles()
      // console.log(file.url)
      // this.addFruitInfo.file = file.url
      // this.doUpload = true
      // this.$refs.fruitForm.validateField('file')
    }
  }
}
</script>

<style scoped>
.inputStyle {
    width: 100%;
}
.myClass input.el-input__inner {
  width: 200px;
}
</style>
