<template>
  <div>
    <div class="address-box" v-for="(item, index) in address" :key="index">
      <div class="address-header">
        <span>{{item.name}}</span>
        <div class="address-action">
          <span @click="edit(index)"><Icon type="edit"></Icon> 修改</span>
          <span @click="del(index)"><Icon type="trash-a"></Icon> 删除</span>
        </div>
      </div>
      <div class="address-content">
        <p><span class="address-content-title"> 收 货 人 :</span> {{item.receiveName}}</p>
        <p><span class="address-content-title">收货地区:</span> {{item.receiveProvince}} {{item.receiveCity}} {{item.receiveCounty}}</p>
        <p><span class="address-content-title">收货地址:</span> {{item.receiveDetailAddress}}</p>
        <p><span class="address-content-title">手机号码:</span> {{item.receivePhone}}</p>
      </div>
    </div>
    <div class="goods-page">
      <Page :total="fruitList.pageTotal" :current="fruitList.pageNum" :page-size="fruitList.pageSize" show-total
            @on-change="handlePage" @on-page-size-change='handlePageSize' ></Page>
    </div>
    <Modal v-model="modal" width="530">
        <p slot="header">
          <Icon type="edit"></Icon>
          <span>修改地址</span>
        </p>
        <div>
            <Form :model="formData" ref="addressForm" label-position="left" :label-width="100" :rules="ruleInline">
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
        <div slot="footer">
            <Button type="primary" size="large" long @click="editAction">修改</Button>
        </div>
    </Modal>
  </div>
</template>

<script>
import Distpicker from 'v-distpicker'
export default {
  name: 'MyAddress',
  data () {
    return {
      fruitList: {
        num: null,
        pageTotal: 0,
        pageNum: 1,
        pageSize: 5,
        list: []
      },
      params: {},
      // 改成数据库接收的数据
      address: [],
      modal: false,
      formData: {
        receiveName: '',
        receiveDetailAddress: '',
        receiveTel: '',
        receivePhone: '',
        receiveProvince: '福建省',
        receiveCity: '厦门市',
        receiveCounty: '海沧区',
        addressId: '',
        userId: '',
        addressState: '',
        createTime: '',
        updateTime: ''
      },
      url: '/address/select',
      pageNum: 1,
      pageSize: 100,
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
  created () {
  },
  computed: {
  },
  mounted () {
    this.search()
  },
  methods: {
    handlePage (page) {
      this.fruitList.pageNum = page
      this.search()
    },
    handlePageSize (val) {
      this.fruitList.pageSize = val
      this.pageCurrentChange(1)
      this.search()
    },
    // 搜索，条件排序
    search () {
      Object.assign(this.params, {
        pageSize: this.fruitList.pageNum || 1,
        pageNumber: this.fruitList.pageSize || 5,
        id: localStorage.getItem('Flag01')
      }, this.params)
      this.axios.get(this.url, {
        params: this.params
      }).then(res => {
        this.fruitList.pageTotal = res.data.total
        this.address = res.data.list
        // console.log(this.record.list)
        // console.table(res.data.list)
      }).catch(() => {
        // 遇到异常则关闭加载
      })
    },
    getProvince (data) {
      this.formData.receiveProvince = data.value
    },
    getCity (data) {
      this.formData.receiveCity = data.value
    },
    getArea (data) {
      this.formData.receiveCounty = data.value
    },
    edit (index) {
      this.modal = true
      this.formData.receiveProvince = this.address[index].receiveProvince
      this.formData.receiveCity = this.address[index].receiveCity
      this.formData.receiveCounty = this.address[index].receiveCounty
      this.formData.receiveDetailAddress = this.address[index].receiveDetailAddress
      this.formData.receiveName = this.address[index].receiveName
      this.formData.receivePhone = this.address[index].receivePhone
      this.formData = this.address[index]
    },
    editAction () {
      this.modal = false
      // 先表单验证，再更新数据库
      this.$refs.addressForm.validate(valid => {
        if (valid) {
          console.log(this.formData)
          this.axios.put('/address/updata', this.formData
          ).then(res => {
            if (res.data > 0) {
              this.$Message.success('修改成功')
              this.$message({
                type: 'success',
                message: '修改成功!'
              })
              this.search()
            } else {
              this.$message({
                type: 'error',
                message: '修改失败!'
              })
            }
          }).catch(() => {
            // 遇到异常则关闭加载
            this.$message({
              type: 'error',
              message: '修改异常!'
            })
          })
        }
      })
    },
    del (index) {
      this.formData.addressId = this.address[index].addressId
      console.log(this.address[index].addressId)
      // console.log(index)
      this.$Modal.confirm({
        title: '信息提醒',
        content: '你确定删除这个收货地址',
        onOk: () => {
          this.axios.put('/address/delete', this.formData
          ).then(res => {
            if (res.data > 0) {
              this.$Message.success('删除成功')
              this.$message({
                type: 'success',
                message: '删除成功!'
              })
              this.search()
            } else {
              this.$message({
                type: 'error',
                message: '删除失败!'
              })
            }
          }).catch(() => {
            // 遇到异常则关闭加载
            this.$message({
              type: 'error',
              message: '删除异常!'
            })
          })
        },
        onCancel: () => {
          this.$Message.info('取消删除')
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
.address-box {
  padding: 15px;
  margin: 15px;
  border-radius: 5px;
  box-shadow: 0px 0px 5px #ccc;
}
.address-header {
  height: 35px;
  display: flex;
  justify-content: space-between;
  color: #232323;
  font-size: 18px;
}
.address-content {
  font-size: 14px;
}
.address-content-title {
  color: #999;
}
.address-action span{
  margin-left: 15px;
  font-size: 14px;
  color: #2d8cf0;
  cursor: pointer;
}
</style>
