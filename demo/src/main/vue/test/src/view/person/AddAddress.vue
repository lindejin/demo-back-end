<template>
  <div>
    <div class="add-container">
      <div class="add-title">
        <h1>添加收货地址</h1>
      </div>
      <div class="add-box">
        <Form ref="addressForm" :model="formData" label-position="left" :label-width="100" :rules="ruleInline">
          <FormItem label="收件人" prop="receiveName">
            <i-input v-model="formData.receiveName" size="large"></i-input>
          </FormItem>
          <FormItem label="收件地区" prop="receiveDetailAddress">
            <Distpicker :province="formData.receiveProvince" :city="formData.receiveCity" :area="formData.receiveCounty" @province="getProvince" @city="getCity" @area="getArea"></Distpicker>
          </FormItem>
          <FormItem label="详细地址" prop="receiveDetailAddress">
            <i-input v-model="formData.receiveDetailAddress" size="large"></i-input>
          </FormItem>
          <FormItem label="固定电话">
            <i-input v-model="formData.receiveTel" size="large"></i-input>
          </FormItem>
          <FormItem label="手机号码" prop="receivePhone">
            <i-input v-model="formData.receivePhone" size="large"></i-input>
          </FormItem>
        </Form>
      </div>
      <div class="add-submit">
        <Button type="primary" @click="address">添加地址</Button>
      </div>
    </div>
  </div>
</template>

<script>
import Distpicker from 'v-distpicker'
export default {
  name: 'AddAddress',
  data () {
    return {
      formData: {
        receiveName: '',
        receiveDetailAddress: '',
        receiveTel: '',
        receivePhone: '',
        receiveProvince: '广东省',
        receiveCity: '广州市',
        receiveCounty: '天河区'
      },
      ruleInline: {
        receiveName: [
          { required: true, message: '请输入姓名', trigger: 'blur' }
        ],
        receiveDetailAddress: [
          { required: true, message: '请输入地址', trigger: 'blur' }
        ],
        receivePhone: [
          { required: true, message: '手机号不能为空', trigger: 'blur' },
          { type: 'string', pattern: /^1[3|4|5|7|8][0-9]{9}$/, message: '手机号格式出错', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    getProvince (data) {
      this.formData.receiveProvince = data.value
    },
    getCity (data) {
      this.formData.receiveCity = data.value
    },
    getArea (data) {
      this.formData.receiveCounty = data.value
    },
    address () {
      let getFlag = localStorage.getItem('Flag01')
      Object.assign(this.formData, {
        userId: getFlag
      }, this.formData)
      // 先表单验证，再存进数据库
      this.$refs.addressForm.validate(valid => {
        if (valid) {
          console.log(this.formData)
          this.axios.post('/address/add', this.formData
          ).then(res => {
            if (res.data > 0) {
              this.$message({
                type: 'success',
                message: '添加成功!'
              })
            } else {
              this.$message({
                type: 'error',
                message: '添加失败!'
              })
            }
          }).catch(() => {
            // 遇到异常则关闭加载
            this.$message({
              type: 'error',
              message: '添加异常!'
            })
          })
        }
      })
    }
  },
  components: {
    Distpicker
  }
}
</script>

<style scoped>
.add-container {
  margin: 15px auto;
  width: 60%;
  min-width: 600px;
}
.add-title {
  margin-bottom: 15px;
  text-align: center;
}
.add-submit {
  display: flex;
  justify-content: center;
}
</style>
