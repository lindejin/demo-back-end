<template>
  <div>
    <el-col :span="24">
      <div style="height: 520px;width: 100%">
        <el-row>
          <h1>水果列表</h1>
          <el-button size="mini" icon="fa fa-plus" title="增加" type="primary" plain @click="add()"></el-button>
          <!-- <el-button size="mini" icon="fa fa-plus" title="增加" type="primary" plain @click="detail(scope.row)"></el-button> -->
          <tern-table ref="tables" :url="stdUrl" fit border highlight-current-row style="width: 100%">
            <el-table-column fixed type="selection" width="50"></el-table-column>
            <el-table-column type="index" label="序号" width="50"> </el-table-column>
            <el-table-column prop="fruitName" label="水果名称" width="100" show-overflow-tooltip></el-table-column>
            <el-table-column prop="fruitSummery" label="简介" width="120" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="primeCost" label="原价" width="100" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="fruitSale" label="促销价格" width="100" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="createTime" label="创建时间" width="180" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="updateTime" label="更新时间" width="180" show-overflow-tooltip>
            </el-table-column>
            <el-table-column label="操作" fixed="right" width="380px">
              <template slot-scope="scope">
                <el-button size="mini" icon="fa fa-eye fa-lg" title="详情" type="success" plain @click="detail(scope.row)"></el-button>
                <el-button size="mini" icon="fa fa-edit fa-lg" title="修改" type="success" plain @click="edit(scope.row)"></el-button>
                <el-button size="mini" icon="fa fa-arrow-circle-down" title="下架" type="danger" plain @click="down(scope.row)" v-if="scope.row.shelfStatus==0"></el-button>
                <el-button size="mini" icon="fa fa-arrow-circle-up" title="上架" type="success" plain @click="up(scope.row)" v-else></el-button>
<!--                <el-button size="mini" icon="" title="清仓" type="success" plain @click="update(scope.row)"><i class="fa fa-spinner fa-spin fa-1x fa-fw"></i></el-button>-->
              </template>
            </el-table-column>
          </tern-table>
        </el-row>
      </div>
    </el-col>
    <add @fatherMethod="search" ref="tables_add" />
    <edit @fatherMethod="search" ref="tables_edit" />
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
      params: {
        name: '',
        email: '',
        phone: ''
      },
      FruitForm: {},
      isFastCreate: false,
      stdUrl: '/fruit/select'
    }
  },
  // 监听属性 类似于data概念
  computed: {},
  // 监控data中的数据变化
  watch: {},
  // 方法集合
  methods: {
    search () {
      this.$refs.tables.search(this.params)
    },
    detail (row) {
      this.$refs.tables_edit.open(row)
    },
    add () {
      this.$refs.tables_add.add()
    },
    edit (row) {
      this.$refs.tables_edit.edit(row)
    },
    del (row) {},
    down (row) { // 下架
      row.shelfStatus = 1
      this.axios.put('/fruit/updatadown', row
      ).then(res => {
        if (res.data > 0) {
          this.$message({
            type: 'success',
            message: '下架成功!'
          })
          this.lnitializationData()
          this.$nextTick(() => {
            this.$router.go(0)
          })
        } else {
          this.$message({
            type: 'error',
            message: '下架失败!'
          })
        }
      }).catch(() => {
        // 遇到异常则关闭加载
      })
      this.$router.go(0)
      this.$refs.tables.search(this.params)
    },
    up (row) { // 上架
      row.shelfStatus = 0
      this.axios.put('/fruit/updataup', row
      ).then(res => {
        this.lnitializationData()
        if (res.data > 0) {
          this.$message({
            type: 'success',
            message: '上架成功!'
          })
          this.$nextTick(() => {
            this.$router.go(0)
          })
        } else {
          this.$message({
            type: 'error',
            message: '上架失败!'
          })
        }
      }).catch(() => {
        // 遇到异常则关闭加载
      })
      this.$router.go(0)
    },
    update (row) { // 清仓
      console.log(row)
    },
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
