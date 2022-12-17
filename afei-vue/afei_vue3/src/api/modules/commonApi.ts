import service from "../api"

export default {
  getTopAndFeaturedArticles: () => {
    return service.get('/api/articles/topAndFeatured')
  },
  getArticles: (params: any) => {
    return service.get('/api/articles/all', { params: params })
  },
  getArticlesByCategoryId: (params: any) => {
    return service.get('/api/articles/categoryId', { params: params })
  },
  getArticeById: (articleId: any) => {
    return service.get('/api/articles/' + articleId)
  },
  getAllCategories: () => {
    return service.get('/api/categories/all')
  },
  getAllTags: () => {
    return service.get('/api/tags/all')
  },
  getTopTenTags: () => {
    return service.get('/api/tags/topTen')
  },
  getArticlesByTagId: (params: any) => {
    return service.get('/api/articles/tagId', { params: params })
  },
  getAllArchives: (params: any) => {
    return service.get('/api/archives/all', { params: params })
  },
  login: (params: any) => {
    return service.post('/api/users/login', params)
  },
  saveComment: (params: any) => {
    return service.post('/api/comments/save', params)
  },
  getComments: (params: any) => {
    return service.get('/api/comments', { params: params })
  },
  getTopSixComments: () => {
    return service.get('/api/comments/topSix')
  },
  getAbout: () => {
    return service.get('/api/about')
  },
  getFriendLink: () => {
    return service.get('/api/links')
  },
  submitUserInfo: (params: any) => {
    return service.put('/api/users/info', params)
  },
  getUserInfoById: (id: any) => {
    return service.get('/api/users/info/' + id)
  },
  updateUserSubscribe: (params: any) => {
    return service.put('/api/users/subscribe', params)
  },
  sendValidationCode: (username: any) => {
    return service.get('/api/users/code', {
      params: {
        username: username
      }
    })
  },
  bindingEmail: (params: any) => {
    return service.put('/api/users/email', params)
  },
  register: (params: any) => {
    return service.post('/api/users/register', params)
  },
  searchArticles: (params: any) => {
    return service.get('/api/articles/search', {
      params: params
    })
  },
  getAlbums: () => {
    return service.get('/api/photos/albums')
  },
  getPhotosBuAlbumId: (albumId: any, params: any) => {
    return service.get('/api/albums/' + albumId + '/photos', {
      params: params
    })
  },
  getWebsiteConfig: () => {
    return service.get('/api')
  },
  qqLogin: (params: any) => {
    return service.post('/api/users/oauth/qq', params)
  },
  report: () => {
    service.post('/api/report')
  },
  getTalks: (params: any) => {
    return service.get('/api/talks', {
      params: params
    })
  },
  getTalkById: (id: any) => {
    return service.get('/api/talks/' + id)
  },
  logout: () => {
    return service.post('/api/users/logout')
  },
  getRepliesByCommentId: (commentId: any) => {
    return service.get(`/api/comments/${commentId}/replies`)
  },
  updatePassword: (params: any) => {
    return service.put('/api/users/password', params)
  },
  accessArticle: (params: any) => {
    return service.post('/api/articles/access', params)
  }
}
