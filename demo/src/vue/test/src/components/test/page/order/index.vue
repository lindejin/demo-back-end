<template>
  <div>
    <el-col :span="24">
      <div style="height: 520px;width: 100%">
        <el-row>
          <h1>订单列表</h1>
          <el-button size="mini"  title="增加" type="primary" plain @click="seach(1)">全部</el-button>
          <el-button size="mini"  title="增加" type="primary" plain @click="seach(2)">未发货</el-button>
          <tern-table ref="tables" :url="stdUrl" fit border highlight-current-row style="width: 100%">
            <el-table-column fixed type="selection" width="50"></el-table-column>
            <el-table-column type="index" label="序号" width="50"> </el-table-column>
            <el-table-column prop="order_no" label="订单号" width="100" show-overflow-tooltip></el-table-column>
            <el-table-column prop="user_name" label="用户" width="120" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="user_phone" label="联系电话" width="120" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="fruit_name" label="水果" width="120" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="fruit_number" label="数量" width="120" show-overflow-tooltip>
            </el-table-column>
<!--            <el-table-column prop="order_time01" label="购买时间" width="180" show-overflow-tooltip>-->
<!--            </el-table-column>-->
            <el-table-column label="操作" fixed="right" width="380px">
              <template slot-scope="scope">
                <el-button size="mini" icon="fa fa-eye fa-lg" title="详情" type="success" plain @click="detail(scope.row)"></el-button>
                <!--                                <el-button size="mini" icon="fa fa-edit fa-lg" title="修改" type="success" plain @click="edit(scope.row)"></el-button>-->
                <el-button size="mini" icon="fa fa-check" title="发货" type="success" plain @click="edit(scope.row)" v-show="!scope.row.send_time"></el-button>
<!--                <el-button size="mini" icon="fa fa-check" title="陈工" type="success" plain @click="edit(scope.row)"></el-button>-->
              </template>
            </el-table-column>
          </tern-table>
        </el-row>
        <Modal v-model="modal" width="530">
          <p slot="header">
            <Icon type="edit"></Icon>
            <span>详情</span>
          </p>
          <div>
            <Form :model="formData" ref="addressForm" label-position="left" :label-width="100">
              <FormItem label="订单号" >
                <i-input disabled v-model="formData.order_no" size="large"></i-input>
              </FormItem>
              <FormItem label="用户" >
                <i-input disabled v-model="formData.user_name" size="large"></i-input>
              </FormItem>
              <FormItem label="电话号码">
                <i-input disabled v-model="formData.user_phone" size="large"></i-input>
              </FormItem>
              <FormItem label="水果">
                <i-input disabled v-model="formData.fruit_name" size="large"></i-input>
              </FormItem>
              <FormItem label="数量">
                <i-input disabled v-model="formData.fruit_number" size="large"></i-input>
              </FormItem>
              <FormItem label="付款">
                <i-input disabled v-model="formData.fruit_price" size="large"></i-input>
              </FormItem>
            </Form>
          </div>
        </Modal>
      </div>
    </el-col>
    <add ref="tables" />
    <!--         <el-dialog v-loading="editForm" title="用户信息管理" :visible.sync="isFastCreate" width="70%" top="6%" :before-close="closeDialog">-->
    <!--            <add ref="tables" ></add>-->
    <!--            <div slot="footer" class="dialog-footer">-->
    <!--                <tern-button buttonCode="normal" @click="changeListVar">确定选中</tern-button>-->
    <!--                <tern-button buttonCode="normal" @click="closeDialog()">关闭</tern-button>-->
    <!--            </div>-->
    <!--        </el-dialog>-->
  </div>
</template>
<script>
import add from './add'
// 这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
// 例如：import 《组件名称》 from '《组件路径》';
export default {
  components: {
    add
  }, // import引入的组件需要注入到components中才能使用
  data () {
    return {
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
      editForm: [],
      isFastCreate: false,
      stdUrl: '/cart/select02'
    }
  },
  // 监听属性 类似于data概念
  computed: {},
  // 监控data中的数据变化
  watch: {},
  // 方法集合
  methods: {
    seach (val) {
      if (val === 1) {
        this.stdUrl = '/cart/select02'
        this.$refs.table.search()
      }
      if (val === 2) {
        this.stdUrl = '/cart/select03'
        this.$refs.table.search()
      }
    },
    detail (row) {
      this.modal = true
      this.formData = row
    },
    add () {
      this.$refs.tables.add()
    },
    edit (row) {
      this.formData = row
      this.axios.put('/order/updata', {
        orderId: row.order_id}
      ).then(res => {
        if (res.data > 0) {
          this.$message({
            type: 'success',
            message: '发货成功!'
          })
          this.lnitializationData()
          this.$nextTick(() => {
            this.$router.go(0)
          })
        } else {
          this.$message({
            type: 'error',
            message: '发货失败!'
          })
        }
        this.$router.go(0)
        // this.$nextTick(() => {
        //   this.dialogVisible = false
        // })
        // this.$refs.userInfo.clearValidate()
        // this.$refs.userInfo.resetField()
      }).catch(() => {
        // 遇到异常则关闭加载
        this.$nextTick(() => {
          this.dialogVisible = false
        })
      })
      this.$router.go(0)
    },
    del (row) {},
    closeDialog () {},
    changeListVar () {}
  },
  created () {}, // 生命周期 - 创建完成（可以访问当前this实例）
  mounted () {}, // 生命周期 - 挂载完成（可以访问DOM元素）
  beforeCreate () {}, // 生命周期 - 创建之前
  beforeMount () {}, // 生命周期 - 挂载之前
  beforeUpdate () {}, // 生命周期 - 更新之前
  updated () {}, // 生命周期 - 更新之后
  beforeDestroy () {}, // 生命周期 - 销毁之前
  destroyed () {}, // 生命周期 - 销毁完成
  activated () {} // 如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style  scoped>
.hr-line-dashed {
  border-top: 1px dashed #e7eaec;
  color: #ffffff;
  background-color: #ffffff;
  height: 1px;
  margin-bottom: 20px;
}

.hr-line-solid-blue {
  border-top: 1px solid crimson;
  color: #ffffff;
  background-color: #ffffff;
  height: 1px;
  margin-bottom: 20px;
}

.title_top_all {
  height: 22px;
  padding-left: 10px;
  font-size: 16px;
  color: #20a0ff;
  line-height: 22px;
  margin-bottom: 10px;
  border-left: 12px solid #20a0ff;
}
.hr-line-solid-blue {
  border-top: 1px solid #20a0ff;
  color: #ffffff;
  background-color: #ffffff;
  height: 1px;
  margin-bottom: 20px;
}

.title_top_all {
  height: 22px;
  padding-left: 10px;
  font-size: 16px;
  color: #20a0ff;
  line-height: 22px;
  margin-bottom: 10px;
  border-left: 12px solid #20a0ff;
}
.ownSelect {
  width: 220px;
  margin-right: 3px;
  height: 28px;
}
footer,
header,
nav,
section {
  display: block;
}
table {
  border-collapse: inherit;
}
</style>
