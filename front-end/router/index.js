import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from "../components/login/login";
import home from "../components/home/home";
import searchbook from "../components/book/searchbook";
import addbook from "../components/book/addbook";
import BookUpdate from "../components/book/BookUpdate";

import searchuser from "../components/user/searchuser";
import adduser from "../components/user/adduser";
import UserUpdate from "../components/user/UserUpdate";

import borrowbook from "../components/borrow/borrowbook";
import returnbook from "../components/borrow/returnbook";



Vue.use(VueRouter)

  const routes = [
    {
      path:'/',
      name:'login',
      component: Login
    },
    {
      path:'/home',
      name:'home',
      component: home,
      children:[
        {
          path:'/searchbook',
          name:'searchbook',
          component:searchbook
        },
        {
          path:'/addbook',
          name:'addbook',
          component:addbook
        },
        {
          path:'/BookUpdate',
          name:'BookUpdate',
          component:BookUpdate
        },
        {
          path:'/searchuser',
          name:'searchuser',
          component:searchuser
        },
        {
          path:'/adduser',
          name:'adduser',
          component:adduser
        },
        {
          path:'/UserUpdate',
          name:'UserUpdate',
          component:UserUpdate
        },
        {
          path:'/borrowbook',
          name:'borrowbook',
          component:borrowbook
        },
        {
          path:'/returnbook',
          name:'returnbook',
          component:returnbook
        },
      ]
    }
  /*{
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/!* webpackChunkName: "about" *!/ '../views/About.vue')
  }*/
]

const router = new VueRouter({
  routes
})

export default router
