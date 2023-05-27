import Vue from "vue";
import VueRouter from "vue-router";
import { ROLE, PATH } from "../common/const";




const Error = () => import("../components/content/Error");
const Login = () => import("../views/auth/Login");
const Home = () => import("../views/Home");

// 课程管理
const MyCourse = () => import("../views/course/MyCourse");
const AllCourse = () => import("../views/course/AllCourse");
const OtherCourse = () => import("../views/course/OtherCourse");
const StudentManagement = () => import("../views/course/StudentManagement");
const CourseManagement = () => import("../views/course/CourseManagement");
const StudentScore = () => import("../views/course/StudentScore");



Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    component: Home
  },
  {
    path: "/error",
    component: Error
  },
  {
    path: "/login",
    component: Login
  },
  {
    path: "/register",
    component: () => import("@/views/auth/register.vue")
  },
  // 课程管理
  {
    path: PATH.MY_COURSE.path,
    component: MyCourse,
    meta: { requiresAuth: PATH.MY_COURSE.requiresAuth }
  },
  {
    path: PATH.ALL_COURSE.path,
    component: AllCourse,
    meta: { requiresAuth: PATH.ALL_COURSE.requiresAuth }
  },
  {
    path: PATH.OTHER_COURSE.path,
    component: OtherCourse,
    meta: { requiresAuth: PATH.OTHER_COURSE.requiresAuth }
  },
  {
    path: PATH.STUDENT_MANAGEMENT.path,
    component: StudentManagement,
    meta: { requiresAuth: PATH.STUDENT_MANAGEMENT.requiresAuth }
  },
  {
    path: PATH.COURSE_MANAGEMENT.path,
    component: CourseManagement,
    meta: { requiresAuth: PATH.COURSE_MANAGEMENT.requiresAuth }
  },
  {
    path: PATH.STUDENT_SCORE.path,
    component: StudentScore,
    meta: { requiresAuth: PATH.STUDENT_SCORE.requiresAuth }
  },

  // -----------------------未找到页面-----------------------------
  {
    path: "*",
    redirect: "/error"
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

router.beforeEach(async (to, from, next) => {
  // console.log(to.path);
  if (to.path === "/error" || to.path === "/login") {
    next();
  } else if (to.path === "/") {
    let token = sessionStorage.getItem("token");
    let role = sessionStorage.getItem("role");
    if (token == null || role == null) next("/login");
    else next();
  } else if (to.meta.requiresAuth) {
    if (
      to.meta.requiresAuth.some(
        role => role.toString() === sessionStorage.getItem("role")
      )
    ) {
      //有权限
      // console.log("获得访问权限");
      next()
    } else {
      // console.log("无权限访问");
      next("/"); //无权限,跳回主页
    }
  } else {
    // 非法路径, 直接next (跳转error)
    next();
  }
});

export default router;
