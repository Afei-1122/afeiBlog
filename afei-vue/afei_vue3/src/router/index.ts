import { createRouter, createWebHistory } from 'vue-router'
import commonRoutes from "@/router/commonRoutes/index"
import type {AppRouteRecordRaw} from "@/router/commonRoutes/index"
const defaultRoutes:Array<AppRouteRecordRaw> = [
  {
    path: '/:catchAll(.*)',
    redirect: '/404',
    hidden: true
  },
  {
    path: '/404',
    name: '404',
    component: () => import('@/views/notFound/404.vue')
  }
]
 

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes:[
    ...commonRoutes,
    ...defaultRoutes
  ] 
})

export default router
