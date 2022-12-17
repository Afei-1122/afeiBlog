import axios from "@/api/index";

export function getAsyncRouterList(){
    // getRouterList
    return axios({
         url:'/api/admin/user/menus',
    })
}

export function loginAuthor(params){
    //  login
    return axios({
         url:'/api/users/login',
         method:"post",
         data:params
    })
}
