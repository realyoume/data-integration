import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import "@/assets/css/normalize.css";
import "@/assets/css/base.css";
import "@/plugins/elementui";

import  FileSaver from 'file-saver';
import  XLSX from 'xlsx';

// 全局引入相关包
import * as echarts from "echarts";

// 开启echarts
Vue.prototype.$echarts = echarts;

Vue.prototype.$FileSaver = FileSaver; //设置全局
Vue.prototype.$XLSX= XLSX;//设置全局
Vue.config.productionTip = false;
Vue.prototype.$bus = new Vue(); //用于取代Vuex实现组件之间的消息传递


new Vue({
  router,
  render: h => h(App)
}).$mount("#app");
