<template>
  <div id="main">
    <div class="main-box">
      <div :class="['container', 'container-register', { 'is-txl': isLogin }]">
        <form>
          <h2 class="title">Create Account</h2>
          <span class="text">or use email for registration</span>
          <input class="form__input" type="text" placeholder="Name" />
          <input class="form__input" type="text" placeholder="Email" />
          <input class="form__input" type="password" placeholder="Password" />
          <div class="primary-btn" @click="register">立即注册</div>
        </form>
      </div>
      <div :class="['container', 'container-login', { 'is-txl is-z200': isLogin }]">
        <form>
          <h2 class="title">Sign in to Blog</h2>
          <span class="text">or use email for registration</span>

          <input class="form__input" type="text" placeholder="userName" v-model="loginForm.username" />
          <input class="form__input" type="password" placeholder="Password" v-model="loginForm.password" />
          <div class="primary-btn" @click="login">立即登录</div>
        </form>
      </div>
      <div :class="['switch', { login: isLogin }]">
        <div class="switch__circle"></div>
        <div class="switch__circle switch__circle_top"></div>
        <div class="switch__container">
          <h2>{{ isLogin ? 'Hello Friend !' : 'Welcome Back !' }}</h2>
          <p>
            {{
                isLogin
                  ? 'Enter your personal details and start journey with us'
                  : 'To keep connected with us please login with your personal info'
            }}
          </p>
          <div class="primary-btn" @click="isLogin = !isLogin">
            {{ isLogin ? '立即注册' : '立即登录' }}
          </div>
        </div>
      </div>
    </div>
  </div>

</template>
  
<script>
import { getRouterList } from '@/assets/js/menu'
import { loginAuthor } from "@/api/moudle/reOverWrite"
export default {
  name: 'Login',
  data() {
    return {
      isLogin: false,
      loginForm: {
        username: '',
        password: ''
      },
    }
  },
  methods: {
    validataAsync() {
      if (this.loginForm.username == "") {
        this.$message.warning("用户名不能为空")
        return false
      }
      if (this.loginForm.password == "") {
        this.$message.warning("密码不能为空")
        return false
      }
      return true
    },
    async login() {
      if (this.validataAsync()) {
        const that = this
        var captcha = new TencentCaptcha(this.config.TENCENT_CAPTCHA, async function (res) {
          if (res.ret === 0) {
            let param = new URLSearchParams()
            param.append('username', that.loginForm.username)
            param.append('password', that.loginForm.password)
            const { data } = await loginAuthor(param)
            if (data.flag) {
              that.$store.commit('login', data.data)
              getRouterList()
              that.$message.success('登录成功')
              that.$router.replace({ path: '/' }).catch(err => { console.log(err) })
            } else {
              that.$message.error(data.message)
            }
          }
        })
        captcha.show()
      }

    },
    register() {
      this.$message('注册暂不对外开放')
    },
  }
}
</script>
  
<style lang="scss" scoped>
#main {
  width: 100vw;
  height: 100vh;
  background: #E0EAFC;
  /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #757F9A, #D7DDE8);
  /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #757F9A, #E0EAFC);
  /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  background-size: 400%;
  animation: backdiv 12s infinite;
}

@keyframes backdiv {
  0% {
    background-position: 0% 50%;
  }

  50% {
    background-position: 100% 50%;
  }

  100% {
    background-position: 0% 50%;
  }
}

.main-box {
  position: relative;
  top: 20px;
  left: 50%;
  transform: translateX(-50%);
  width: 1000px;
  min-width: 1000px;
  min-height: 600px;
  height: 600px;
  padding: 25px;
  background-color: #ecf0f3;
  border-radius: 12px;
  overflow: hidden;

  .container {
    display: flex;
    justify-content: center;
    align-items: center;
    position: absolute;
    top: 0;
    width: 600px;
    height: 100%;
    padding: 25px;
    background-color: #ecf0f3;
    transition: all 1.25s;

    form {
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
      width: 100%;
      height: 100%;
      color: #a0a5a8;

      .title {
        font-size: 34px;
        font-weight: 700;
        line-height: 3;
        color: #181818;
      }

      .text {
        margin-top: 12px;
        margin-bottom: 22px;
      }

      .form__input {
        width: 350px;
        height: 40px;
        margin: 4px 0;
        padding-left: 25px;
        font-size: 13px;
        letter-spacing: 0.15px;
        border: none;
        outline: none;
        // font-family: 'Montserrat', sans-serif;
        background-color: #ecf0f3;
        transition: 0.25s ease;
        border-radius: 8px;
        box-shadow: inset 2px 2px 4px #d1d9e6, inset -2px -2px 4px #f9f9f9;

        &::placeholder {
          color: #a0a5a8;
        }
      }
    }
  }

  .container-register {
    z-index: 100;
    left: calc(100% - 600px);
  }

  .container-login {
    left: calc(100% - 600px);
    z-index: 0;
  }

  .is-txl {
    left: 0;
    transition: 1.25s;
    transform-origin: right;
  }

  .is-z200 {
    z-index: 200;
    transition: 1.25s;
  }

  .switch {
    display: flex;
    justify-content: center;
    align-items: center;
    position: absolute;
    top: 0;
    left: 0;
    height: 100%;
    width: 400px;
    z-index: 200;
    transition: 1.25s;
    background-color: #ecf0f3;
    overflow: hidden;
    box-shadow: 4px 4px 10px #d1d9e6, -4px -4px 10px #f9f9f9;
    color: #a0a5a8;

    .switch__circle {
      position: absolute;
      width: 500px;
      height: 500px;
      border-radius: 50%;
      background-color: #ecf0f3;
      box-shadow: inset 8px 8px 12px #d1d9e6, inset -8px -8px 12px #f9f9f9;
      bottom: -60%;
      left: -60%;
      transition: 1.25s;
    }

    .switch__circle_top {
      top: -30%;
      left: 60%;
      width: 300px;
      height: 300px;
    }

    .switch__container {
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
      position: absolute;
      width: 400px;
      padding: 50px 55px;
      transition: 1.25s;

      h2 {
        font-size: 34px;
        font-weight: 700;
        line-height: 3;
        color: #181818;
      }

      p {
        font-size: 14px;
        letter-spacing: 0.25px;
        text-align: center;
        line-height: 1.6;
      }
    }
  }

  .login {
    left: calc(100% - 400px);

    .switch__circle {
      left: 0;
    }
  }

  .primary-btn {
    width: 180px;
    height: 50px;
    border-radius: 25px;
    margin-top: 50px;
    text-align: center;
    line-height: 50px;
    font-size: 14px;
    letter-spacing: 2px;
    background-color: #4b70e2;
    color: #f9f9f9;
    cursor: pointer;
    box-shadow: 8px 8px 16px #d1d9e6, -8px -8px 16px #f9f9f9;

    &:hover {
      box-shadow: 4px 4px 6px 0 rgb(255 255 255 / 50%),
        -4px -4px 6px 0 rgb(116 125 136 / 50%),
        inset -4px -4px 6px 0 rgb(255 255 255 / 20%),
        inset 4px 4px 6px 0 rgb(0 0 0 / 40%);
    }
  }
}

.login-container {
  position: absolute;
  top: 0;
  bottom: 0;
  right: 0;
  left: 0;
  background: url(https://static.linhaojun.top/photos/765664a8a75211296a9cd89671d6d660.png) center center / cover no-repeat;
}

.login-card {
  position: absolute;
  top: 0;
  bottom: 0;
  right: 0;
  background: #fff;
  padding: 170px 60px 180px;
  width: 350px;
}

.login-title {
  color: #303133;
  font-weight: bold;
  font-size: 1rem;
}

.login-form {
  margin-top: 1.2rem;
}

.login-card button {
  margin-top: 1rem;
  width: 100%;
}
</style>
  
  