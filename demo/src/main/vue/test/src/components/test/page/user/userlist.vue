<template>
    <div>
        <el-col :span="24">
            <div style="height: 520px;width: 100%">
                <el-row>
                    <h1>用户</h1>
                  <tern-form>
                    <el-form ref="formone" :inline="true" class="demo-form-inline">
                      <el-row>
                        <el-form-item label="用户名" prop="inputC" label-width="90px">
                          <el-input v-model="params.name" type="text" :maxlength="30"></el-input>
                        </el-form-item>
                        <el-form-item label="邮箱" prop="inputC" label-width="90px">
                          <el-input v-model="params.email" type="text" :maxlength="30"></el-input>
                        </el-form-item>
                        <el-form-item label="电话" prop="inputC" label-width="90px">
                        <el-input v-model="params.phone" type="text" :maxlength="30"></el-input>
                        </el-form-item>
                        <el-form-item >
                          <tern-button buttonCode="normal" @click="Search" type="primary" size="mini"><i
                            class="fa fa-search"></i>&nbsp;&nbsp;查询
                          </tern-button>
                        </el-form-item>
                      </el-row>
                      <el-row>
                        <el-form-item label="新增用户" label-width="90px">
                          <el-button size="mini" icon="fa fa-plus" title="增加" type="primary" plain @click="add()"></el-button>
                        </el-form-item>
                      </el-row>
                    </el-form>
                  </tern-form>
                    <!-- <el-button size="mini" icon="fa fa-plus" title="增加" type="primary" plain @click="detail(scope.row)"></el-button> -->
                    <tern-table ref="table" :url="stdUrl" fit border highlight-current-row style="width: 100%">
                        <el-table-column fixed type="selection" width="50"></el-table-column>
                        <el-table-column type="index" label="序号" width="50"> </el-table-column>
                        <el-table-column prop="userName" label="用户名" width="100" show-overflow-tooltip></el-table-column>
                        <el-table-column prop="userPhone" label="联系电话" width="120" show-overflow-tooltip>
                        </el-table-column>
                        <el-table-column prop="createTime" label="创建时间" width="180" show-overflow-tooltip>
                        </el-table-column>
                        <el-table-column prop="updateTime" label="修改时间" width="180" show-overflow-tooltip>
                        </el-table-column>
                        <el-table-column label="操作" fixed="right" width="380px">
                            <template slot-scope="scope">
                                <el-button size="mini" icon="fa fa-eye fa-lg" title="详情" type="success" plain @click="detail(scope.row)"></el-button>
<!--                                <el-button size="mini" icon="fa fa-edit fa-lg" title="修改" type="success" plain @click="edit(scope.row)"></el-button>-->
<!--                                <el-button size="mini" icon="fa fa-stop-circle" title="解冻" type="danger" plain @click="del(scope.row)" v-if="scope.row.userRole!=1"></el-button>-->
<!--                              <el-button size="mini" icon="fa fa-play-circle" title="冻结" type="success" plain @click="edit(scope.row)" v-else></el-button>-->
                            </template>
                        </el-table-column>
                    </tern-table>
                </el-row>
            </div>
        </el-col>
      <add ref="tables_add" />
      <edit ref="tables_edit" />
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
import edit from './edit'
// 这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
// 例如：import 《组件名称》 from '《组件路径》';
export default {
  components: {
    add,
    edit
  }, // import引入的组件需要注入到components中才能使用
  data () {
    return {
      editForm: [],
      params: {
        name: '',
        email: '',
        phone: ''
      },
      isFastCreate: false,
      stdUrl: '/user/select'
    }
  },
  // 监听属性 类似于data概念
  computed: {},
  // 监控data中的数据变化
  watch: {},
  // 方法集合
  methods: {
    Search () {
      this.$refs.table.search(this.params)
    },
    detail (row) {
      this.$refs.tables_edit.open(row)
    },
    add () { this.$refs.tables_add.add() },
    edit (row) {
      // this.$refs.tables.edit(row)
    },
    del (row) { },
    closeDialog () {
    },
    changeListVar () {}
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
table{border-collapse:inherit;}
</style>
