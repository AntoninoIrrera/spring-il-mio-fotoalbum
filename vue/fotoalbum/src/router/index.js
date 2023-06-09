import { createRouter, createWebHistory } from 'vue-router'
// import HomeView from '../views/HomeView.vue'
import FotoIndex from '../views/FotoIndex.vue'
import MexApp from '../views/MexApp.vue'
import FotoShow from '../views/FotoShow.vue'
import HomePage from '../views/HomePage.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/home',
      name: 'home',
      component: HomePage
    },
    {
      path: '/foto',
      name: 'foto',
      component: FotoIndex
    },
    {
      path: '/messaggio',
      name: 'messaggio',
      component: MexApp
    },
    {
      path: '/:id',
      name: 'fotoShow',
      component: FotoShow
    }
    // {
    //   path: '/',
    //   name: 'home',
    //   component: HomeView
    // },
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
  ]
})

export default router
