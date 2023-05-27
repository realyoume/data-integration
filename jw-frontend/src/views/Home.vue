<template>
  <div></div>
</template>

<script>
import {  PATH } from "../common/const";
  export default {
    beforeMount() {
      // 设置不同角色访问的首页
      // let role = sessionStorage.getItem("role");
      // console.log(role)
      // if(role === ROLE.ADMIN) {
      //   this.$router.push(PATH.COMMODITY_CLASSIFICATION.path);
      // } else if(role === ROLE.INVENTORY_MANAGER) {
      //   this.$router.push(PATH.COMMODITY_CLASSIFICATION.path);
      // } else if(role === ROLE.GM) {
      //   this.$router.push(PATH.GM_APPROVAL);
      // } else if (role === ROLE.SALE_STAFF || role === ROLE.SALE_MANAGER) {
      //   this.$router.push(PATH.PURCHASE_VIEW)
      // }else if ( role === ROLE.HR ){
      //   this.$router.push(PATH.WORKER_MANAGEMENT)
      // }else if ( role === ROLE.FINANCIAL_STAFF ){
      //   this.$router.push(PATH.SALARY_VIEW)
      // }
      // else {
      //   this.$router.push("/error");
      // }

      //设置不同角色访问的首页
      let role = sessionStorage.getItem("role");
      console.log(role)
      if(role === "ADMIN") {
        this.$router.push(PATH.STUDENT_MANAGEMENT.path);
      }else {
        this.$router.push(PATH.ALL_COURSE.path);
      }

    }
  }
</script>

<style scoped>
</style>
