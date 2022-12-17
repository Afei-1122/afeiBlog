<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
import { getRouterList } from '@/assets/js/menu'
export default {
  created() {
    if (this.$store.state.userInfo != null) {
      getRouterList()
    }
    this.axios.post('/api/report')
  }
}
</script>
