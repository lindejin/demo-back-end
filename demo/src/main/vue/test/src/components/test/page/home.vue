<template>
    <div>
        <section class="data_section">
            <header class="section_title">数据统计</header>
            <el-row :gutter="20" style="margin-bottom: 10px;">
                <el-col :span="4">
                    <div class="data_list today_head"><span class="data_num head">当日数据：</span></div>
                </el-col>
                <el-col :span="4">
                    <div class="data_list"><span class="data_num">1</span> 新增用户</div>
                </el-col>
                <el-col :span="4">
                    <div class="data_list"><span class="data_num">2</span> 新增订单</div>
                </el-col>
                <el-col :span="4">
                    <div class="data_list"><span class="data_num">3</span> 新增水果</div>
                </el-col>
            </el-row>
            <el-row :gutter="20">
                <el-col :span="4">
                    <div class="data_list all_head"><span class="data_num head">总数据：</span></div>
                </el-col>
                <el-col :span="4">
                    <div class="data_list"><span class="data_num">4</span> 注册用户</div>
                </el-col>
                <el-col :span="4">
                    <div class="data_list"><span class="data_num">5</span> 订单</div>
                </el-col>
                <el-col :span="4">
                    <div class="data_list"><span class="data_num">6</span> 水果</div>
                </el-col>
            </el-row>
        </section>
        <tendency :sevenDate='sevenDate' :sevenDay='sevenDay'></tendency>
    </div>
</template>
<script>
import tendency from '../ecview/tendency'
import dtime from 'time-formater'
// 这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
// 例如：import 《组件名称》 from '《组件路径》';
export default {
  components: {tendency}, // import引入的组件需要注入到components中才能使用
  data () {
    return {
      sevenDay: [],
      sevenDate: [[], [], []]
    }
  },
  mounted () {
    this.initData()
    for (let i = 6; i > -1; i--) {
      const date = dtime(new Date().getTime() - 86400000 * i).format('YYYY-MM-DD')
      this.sevenDay.push(date)
    }
    this.getSevenData()
  },
  methods: {
    async initData () {
      const today = dtime().format('YYYY-MM-DD')
      Promise.all([new Date(today), new Date(today), new Date(today), new Date(), new Date(), new Date()])
        .then(res => {
          this.userCount = res[0].count
          this.orderCount = res[1].count
          this.adminCount = res[2].count
          this.allUserCount = res[3].count
          this.allOrderCount = res[4].count
          this.allAdminCount = res[5].count
        }).catch(err => {
          console.log(err)
        })
    },
    async getSevenData () {
      const apiArr = [[], [], []]
      this.sevenDay.forEach(item => {
        // apiArr[0].push([1, 2, 3, 4, 5, 6, 7](item))
        // apiArr[1].push([1, 2, 3, 4, 5, 6, 7](item))
        // apiArr[2].push([1, 2, 3, 4, 5, 6, 7](item))
      })
      const promiseArr = [...apiArr[0], ...apiArr[1], ...apiArr[2]]
      Promise.all(promiseArr).then(res => {
        const resArr = [[], [], []]
        res.forEach((item, index) => {
          if (item.status === 1) {
            resArr[Math.floor(index / 7)].push(item.count)
          }
        })
        this.sevenDate = resArr
      }).catch(err => {
        console.log(err)
      })
    }
  },
  // 监听属性 类似于data概念
  computed: {},
  // 监控data中的数据变化
  watch: {},
  // 方法集合
  // methods: {},
  created () { }, // 生命周期 - 创建完成（可以访问当前this实例）
  // mounted () { }, // 生命周期 - 挂载完成（可以访问DOM元素）
  beforeCreate () { }, // 生命周期 - 创建之前
  beforeMount () { }, // 生命周期 - 挂载之前
  beforeUpdate () { }, // 生命周期 - 更新之前
  updated () { }, // 生命周期 - 更新之后
  beforeDestroy () { }, // 生命周期 - 销毁之前
  destroyed () { }, // 生命周期 - 销毁完成
  activated () { } // 如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style lang="less">
@import "../../style/mixin";
.data_section {
    padding: 20px;
    margin-bottom: 40px;
    .section_title {
        text-align: center;
        font-size: 30px;
        margin-bottom: 10px;
    }
    .data_list {
        text-align: center;
        font-size: 14px;
        color: #666;
        border-radius: 6px;
        background: #e5e9f2;
        .data_num {
            color: #333;
            font-size: 26px;
        }
        .head {
            border-radius: 6px;
            font-size: 22px;
            padding: 4px 0;
            color: #fff;
            display: inline-block;
        }
    }
    .today_head {
        background: #ff9800;
    }
    .all_head {
        background: #20a0ff;
    }
}
.wan {
    .sc(16px, #333);
}
</style>
