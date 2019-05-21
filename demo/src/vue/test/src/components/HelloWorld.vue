<template>
  <div>
    <el-button @click="visible = true">Button</el-button>
    <el-dialog :visible.sync="visible" title="Hello world">
      <p>Try Element</p>
    </el-dialog>
    <router-link to="/Helloworld">测试</router-link>
    <h3>{{msg}}</h3>
  </div>
</template>

<script>
import Tree from './test/tree.vue'
export default {
  components: {Tree},
  name: 'HelloWorld',
  data () {
    return {
      msg: '你好世界',
      visible: false
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
</style>
