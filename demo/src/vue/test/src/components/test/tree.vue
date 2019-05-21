<template>
    <div class="manage_page fillcontain">
        <el-row style="height: 100%;">
            <el-col :span="4" style="min-height: 100%; background-color: #324057;">
                <el-menu :default-active="defaultActive" style="min-height: 100%;" background-color="#324057"
                    text-color="#fff" active-text-color="#ffd04b" router>
                    <el-menu-item index="/"><i class="el-icon-menu"></i>首页</el-menu-item>
                    <el-submenu index="2">
                        <template slot="title"><i class="el-icon-document"></i>列表管理</template>
                        <el-menu-item index="/user">用户列表</el-menu-item>
                        <el-menu-item index="/fruit">水果列表</el-menu-item>
                        <el-menu-item index="/order">订单列表</el-menu-item>
<!--                        <el-menu-item index="/admin">管理员列表</el-menu-item>-->
                    </el-submenu>
<!--                    <el-submenu index="3">-->
<!--                        <template slot="title"><i class="el-icon-plus"></i>进货管理</template>-->
<!--                        <el-menu-item index="/fruit">水果进货</el-menu-item>-->
<!--                    </el-submenu>-->
<!--                    <el-submenu index="4">-->
<!--                        <template slot="title"><i class="el-icon-sold-out"></i>订单管理</template>-->
<!--                        <el-menu-item index="/order">订单管理</el-menu-item>-->
<!--                        &lt;!&ndash; <el-menu-item index="newMember">用户数据</el-menu-item> &ndash;&gt;-->
<!--                    </el-submenu>-->
<!--                    <el-submenu index="5">-->
<!--                        <template slot="title"><i class="el-icon-edit"></i>编辑</template>-->
<!--                        &lt;!&ndash; <el-menu-item index="uploadImg">上传图片</el-menu-item> &ndash;&gt;-->
<!--                        <el-menu-item index="vueEdit">文本编辑</el-menu-item>-->
<!--                    </el-submenu>-->
                    <el-submenu index="6">
                        <template slot="title"><i class="el-icon-setting"></i>退出</template>
                        <el-menu-item index="/unlogin">退出登录</el-menu-item>
                        <!-- <el-menu-item index="sendMessage">发送通知</el-menu-item> -->
                    </el-submenu>
<!--                    <el-submenu index="7">-->
<!--                        <template slot="title"><i class="el-icon-warning"></i>说明</template>-->
<!--                        <el-menu-item index="explain">说明</el-menu-item>-->
<!--                    </el-submenu>-->
                </el-menu>
            </el-col>
            <el-col :span="20" style="height: 100%;overflow: auto;" >
                <headTop></headTop>
                <transition name="fade-transform" mode="out-in">
                <keep-alive>
                    <router-view class="main-content"></router-view>
                </keep-alive>
                </transition>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import headTop from './head'
export default {
  components: {
    headTop
  },
  computed: {
    defaultActive: function () {
      // console.log(this.$route.path)
      return this.$route.path.replace('/', '')
    }
  }
}
</script>

<style lang="less" scoped>
@import "../style/mixin";
/* eslint-disable */
.manage_page {
    width: 100%;
}
   /*fade-transform*/
.fade-transform-leave-active,
.fade-transform-enter-active {
  transition: all .5s;
}

.fade-transform-enter {
  opacity: 0;
  transform: translateX(-30px);
}

.fade-transform-leave-to {
  opacity: 0;
  transform: translateX(30px);
}
.main-content { width: calc(100% - 150px); }
.el-menu-item {
  height: 50px;
  line-height: 50px;
  padding: 0 45px;
  min-width: 0px;
}
</style>
