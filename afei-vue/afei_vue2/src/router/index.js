import Vue from 'vue'
import VueRouter from 'vue-router'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import store from '@/store/index'
const notFound = () => import('@/views/notFound/index.vue')
Vue.use(VueRouter)
const routes = [
  {
    path: '/login',
    name: '登录',
    hidden: true,
    component: () => import('../views/login/Login.vue')
  },
  // {
  //   path: '/404',
  //   component: notFound,
  //   hidden: true
  // },
  // { path: '*', redirect: '/404', hidden: true }
]
const createRouter = () =>
  new VueRouter({
    mode: 'history',
    routes: routes
  })
const router = createRouter()


export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher
}

// 进度条配置

NProgress.configure({
  easing: 'ease',
  speed: 500,
  showSpinner: false,
  trickleSpeed: 200,
  minimum: 0.3
})
router.beforeEach((to, from, next) => {
  NProgress.start()
  if (to.path == '/login') {
    next()
  } else if (!store.state.userInfo) {
    next({ path: '/login' })
  } else {
    next()
  }
})

router.afterEach(() => {
  NProgress.done()
})

export default router
