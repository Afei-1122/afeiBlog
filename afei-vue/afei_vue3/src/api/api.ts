import axios from 'axios'
import { app } from '@/main'

const service = axios.create({
  baseURL: "", 
  timeout: 120 * 1000, 
})

service.interceptors.request.use((config: any) => {
  config.headers['Authorization'] = 'Bearer ' + sessionStorage.getItem('token')
  return config
})

service.interceptors.response.use(
  (response) => {
    switch (response.data.code) {
      case 50000:
        app.config.globalProperties.$notify({
          title: 'Error',
          message: '系统异常,请联系管理员',
          type: 'error'
        })
        break
      case 40001:
        app.config.globalProperties.$notify({
          title: 'Error',
          message: '用户未登录',
          type: 'error'
        })
        break
    }
    return response
  },
  (error) => {
    return Promise.reject(error)
  }
)

export default service
