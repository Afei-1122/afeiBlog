import Vue from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/css/index.css'
import './assets/css/iconfont.css'
import config from './assets/js/config'
import axios from './api/index'
import VueAxios from 'vue-axios'
import ECharts from 'vue-echarts'
import 'echarts/lib/chart/line'
import 'echarts/lib/chart/pie'
import 'echarts/lib/chart/bar'
import 'echarts/lib/chart/map'
import 'echarts/lib/component/tooltip'
import 'echarts/lib/component/legend'
import 'echarts/lib/component/title'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import VueCalendarHeatmap from 'vue-calendar-heatmap'
import tagCloud from './components/tag-cloud'
import dayjs from 'dayjs'

Vue.config.productionTip = false
Vue.prototype.config = config
Vue.use(mavonEditor)
Vue.use(ElementUI)
Vue.use(tagCloud)
Vue.use(VueCalendarHeatmap)
Vue.use(VueAxios, axios)
Vue.component('v-chart', ECharts)
Vue.prototype.$moment = dayjs

Vue.filter('date', function (value, formatStr = 'YYYY-MM-DD') {
  return dayjs(value).format(formatStr)
})

Vue.filter('dateTime', function (value, formatStr = 'YYYY-MM-DD HH:mm:ss') {
  return dayjs(value).format(formatStr)
})

new Vue({
  router,
  store,
  render: (h) => h(App)
}).$mount('#app')
