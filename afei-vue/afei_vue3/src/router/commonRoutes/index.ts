import { RouteRecordRaw } from 'vue-router'

// 自定义新增类型
export type AppRouteRecordRaw = RouteRecordRaw & {
     hidden?:boolean
}
const commonRoutes: Array<AppRouteRecordRaw>  = [
  {
    path: '/',
    name: 'Home',
    component: () => import('@/views/Home.vue')
  },
  {
    path: '/articles/:articleId',
    name: 'Articles',
    component: () => import('@/views/Article.vue')
  },
  {
    path: '/talks',
    name: 'talkList',
    component: () => import('@/views/TalkList.vue')
  },
  {
    path: '/talks/:talkId',
    name: 'talks',
    component: () => import('@/views/Talk.vue')
  },
  {
    path: '/archives',
    name: 'Archives',
    component: () => import('@/views/Archives.vue')
  },
  {
    path: '/article-list/:tagId',
    name: 'ArticleList',
    component: () => import('@/views/ArticleList.vue')
  },
  {
    path: '/tags',
    name: 'Tags',
    component: () => import('@/views/Tags.vue')
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('@/views/About.vue')
  },
  {
    path: '/message',
    name: 'Message',
    component: () => import('@/views/Message.vue')
  },
  {
    path: '/friends',
    name: 'Friends',
    component: () => import('@/views/FriendLink.vue')
  },
  {
    path: '/photos/:albumId',
    name: 'Photos',
    component: () => import('@/views/Photos.vue')
  },

  {
    path: '/oauth/login/qq',
    name: 'qqLogin',
    component: () => import('@/components/OauthLogin.vue')
  },
 
]


export default commonRoutes
