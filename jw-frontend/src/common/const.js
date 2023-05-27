// 部署url
export const REQUEST_BASE_URL_PROD = "http://ismzl.com/";
// 开发url （mock的地址
export const REQUEST_BASE_URL_DEV = "http://localhost:8080";

export const ROLE = {
  INVENTORY_MANAGER: "INVENTORY_MANAGER", //库存管理人员
  SALE_STAFF: "SALE_STAFF", // 进货销售人员
  SALE_MANAGER: "SALE_MANAGER", //销售经理
  FINANCIAL_STAFF: "FINANCIAL_STAFF", // 财务人员
  HR: "HR", // 人力资源人员
  GM: "GM", // 总经理
  ADMIN: "ADMIN", // 最高权限
  STUDENT: "STUDENT"
};


export const PATH = {
  // STUDENT
  MY_COURSE: {
    path: '/myCourse',
    requiresAuth: [ROLE.STUDENT]
  },

  ALL_COURSE: {
    path: '/allCourse',
    requiresAuth: [ROLE.STUDENT]
  },

  OTHER_COURSE: {
    path: '/otherCourse',
    requiresAuth: [ROLE.STUDENT]
  },

  STUDENT_MANAGEMENT: {
    path: '/studentManagement',
    requiresAuth: [ROLE.ADMIN]
  },

  COURSE_MANAGEMENT: {
    path: '/courseManagement',
    requiresAuth: [ROLE.ADMIN]
  },

  STUDENT_SCORE: {
    path: '/studentScore',
    requiresAuth: [ROLE.ADMIN]
  },



}
