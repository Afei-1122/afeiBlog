import axios from "axios"

axios.interceptors.request.use((config) => {
    config.headers['Authorization'] = 'Bearer ' + sessionStorage.getItem('token')
    return config
  })
  
  axios.interceptors.response.use(
    (response) => {
      switch (response.data.code) {
        case 40001:
          Vue.prototype.$message({
            type: 'error',
            message: response.data.message
          })
          router.push({ path: '/login' })
          break
        case 50000:
          Vue.prototype.$message({
            type: 'error',
            message: response.data.message
          })
          break
      }
      return response
    },
    (error) => {
      return Promise.reject(error)
    }
  )

export default axios