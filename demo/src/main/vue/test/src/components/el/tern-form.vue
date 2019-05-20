<template>
    <div class="tern-form">
        <slot></slot>
    </div>
</template>

<script>
export default {
  props: {
    url: {
      default: '',
      type: String
    },
    submitFlag: {
      default: null,
      type: String
    }

  },
  name: 'tern-form',
  data () {
    return {}
  },
  methods: {
    update (form) {
      return this.axios.put(this.url, form)
    },
    insert (form) {
      return this.axios.post(this.url, form)
    }
  },
  created () {
  }
}
</script>

<style scoped="">
    .tern-form .el-form-item {
        margin-bottom: 6px;
    }

    .el-input__inner {
        height: 32px;
    }

</style>
