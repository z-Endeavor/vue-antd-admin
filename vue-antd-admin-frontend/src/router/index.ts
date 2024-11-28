import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import HomeView from "../views/HomeView.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/user/login",
    name: "userLogin",
    component: HomeView,
  },
  {
    path: "/user/register",
    name: "userRegister",
    component: HomeView,
  },
  {
    path: "/admin/userManage",
    name: "adminUserManage",
    component: HomeView,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
