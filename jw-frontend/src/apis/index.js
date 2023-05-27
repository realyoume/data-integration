
//TEST
const TEST_GET = "/api/test/get";
const TEST_POST = "/api/test/post";

const AUTH = "/api/user/auth"
const LOGIN = "/api/user/login"
const REGISTER = '/api/user/register'

// 商品分类管理
const COMMODITY_CLASSIFICATION_ALL = '/api/category/queryAll'
const COMMODITY_CLASSIFICATION_CREATE = '/api/category/create'
const COMMODITY_CLASSIFICATION_UPDATE = '/api/category/update'
const COMMODITY_CLASSIFICATION_DELETE = '/api/category/delete'

// 商品管理
const COMMODITY_ALL = '/api/product/queryAll';
const COMMODITY_CREATE = '/api/product/create';
const COMMODITY_UPDATE = '/api/product/update';
const COMMODITY_DELETE = '/api/product/delete';


const WAREHOUSE_INPUT = '/api/warehouse/input';
const WAREHOUSE_OUTPUT_PRE = '/api/warehouse/product/count';
const WAREHOUSE_OUTPUT = '/api/warehouse/output';
const WAREHOUSE_GET_INPUTSHEET = '/api/warehouse/inputSheet/state';
const WAREHOUSE_GET_OUTPUTSHEET = '/api/warehouse/outputSheet/state';
const WAREHOUSE_IO_DEATIL_BY_TIME = '/api/warehouse/sheetContent/time';
const WAREHOUSE_IPQ_BY_TIME = '/api/warehouse/inputSheet/time/quantity';
const WAREHOUSE_OPQ_BY_TIME = '/api/warehouse/outputSheet/time/quantity';
const WAREHOUSE_OUTPUTSHEET_APPROVE = '/api/warehouse/outputSheet/approve';
const WAREHOUSE_INPUTSHEET_APPROVE = '/api/warehouse/inputSheet/approve';
const WAREHOUSE_DAILY_COUNT = '/api/warehouse/warehouse/counting';

const WAREHOUSE_EXCEL_CREATE = '/api/warehouse/counting/excel';

// 销售管理
// 进货管理
const PURCHASE_ALL = '/api/purchase/sheet-show';
const PURCHASE_FIND_SHEET_BY_ID = '/api/purchase/find-sheet';
const PURCHASE_CREATE = '/api/purchase/sheet-make';
const PURCHASE_FIRST_APPROVAL = '/api/purchase/first-approval';
const PURCHASE_SECOND_APPROVAL = '/api/purchase/second-approval';
// 进货退货管理
const PURCHASE_RETURN_ALL = '/api/purchase-returns/sheet-show';
const PURCHASE_RETURN_CREATE = '/api/purchase-returns/sheet-make';
const PURCHASE_RETURN_FIRST_APPROVAL = '/api/purchase-returns/first-approval';
const PURCHASE_RETURN_SECOND_APPROVAL = '/api/purchase-returns/second-approval';
// 销售管理
const SALE_ALL = '/api/sale/sheet-show';
const SALE_CREATE = '/api/sale/sheet-make';
const SALE_FIRST_APPROVAL = '/api/sale/first-approval';
const SALE_SECOND_APPROVAL = '/api/sale/second-approval';
const SALE_FIND_SHEET_BY_ID = '/api/sale/find-sheet';


//销售退货管理//
const SALE_RETURN_ALL = '/api/sale-returns/sheet-show';//
const SALE_RETURN_CREATE = '/api/sale-returns/sheet-make';//
const SALE_RETURN_FIRST_APPROVAL = '/api/sale-returns/first-approval';//
const SALE_RETURN_SECOND_APPROVAL = '/api/sale-returns/second-approval';//

// 客户管理
const CUSTOMER_QUERY = '/api/customer/findByType';
const SALE_PURCHASE_ALL = '/api/purchase/sheet-show';
const SALE_PURCHASE_CREATE = '/api/purchase/sheet-make';
const SALE_CUSTOMER_QUERY = '/api/customer/findByType';
const SALE_CUSTOMER_MAX = '/api/sale/maxAmountCustomer';

const CUSTOMER_EDIT = '/api/customer/edit';
const CUSTOMER_CREATE = '/api/customer/create';


//员工管理
const WORKER_CREATE = '/api/workManagement/worker/add';//;
const WORKER_ALL = '/api/workManagement/query-all';//;
const WORKER_CHECK_IN = 'api/user/checkIn'

//财务管理
const ACCOUNT_ALL = '/api/account/query-all';
const ACCOUNT_CREATE = '/api/account/create';
const ACCOUNT_UPDATE = '/api/account/update';
const ACCOUNT_DELETE = '/api/account/delete';

const RECEIPT_ALL = '/api/receipt/query-all';
const RECEIPT_CREATE = '/api/receipt/sheet-make';
const RECEIPT_APPROVAL = '/api/receipt/approval';

const PAYMENT_ALL = '/api/payment-order/query-all';
//const PAYMENT_CREATE = '/api/finance/payment/create';
const PAYMENT_CREATE = '/api/payment-order/sheet/make';
const PAYMENT_APPROVAL = '/api/payment-order/approval';

const SALE_SHEET_ALL = '/api/finance/saleSheet/queryAll';
const SALE_RETURN_SHEET_ALL = '/api/finance/saleReturnSheet/queryAll';

const SALARY_CREATE = '/api/salary-sheet/sheet-make';//;


const SALE_DETAIL_ALL = '/api/sheetDetail/query-all';


const GIFT_ST = '/api/promotion/create/gifts-by-amount'


// 课程管理
const COURSE_ALL = '/api/courses/';
const STUDENT_ALL = '/api/students/';
const COURSE_PERSON = '/api/courses/person';
const COURSE_CHOOSE = '/api/courses/choose/';
const COURSE_CHOOSE_OTHER = '/api/courses/choose/other/';
const COURSE_UNCHOOSE = '/api/courses/unchoose/';
const COURSE_OTHERS = '/api/courses/others';

const PERSON_SCORES = '/api/scores/'
const UPDATE_SCORE = '/api/scores/'
const SCORE_PERCENT = 'api/scores/percent/'

module.exports = {
  TEST_GET,
  TEST_POST,


  // 课程

  COURSE_ALL,
  STUDENT_ALL,
  COURSE_PERSON,
  COURSE_CHOOSE,
  COURSE_UNCHOOSE,
  COURSE_CHOOSE_OTHER,
  COURSE_OTHERS,

  PERSON_SCORES,
  UPDATE_SCORE,
  SCORE_PERCENT,

  AUTH,
  LOGIN,
  REGISTER,
  COMMODITY_CLASSIFICATION_ALL,
  COMMODITY_CLASSIFICATION_CREATE,
  COMMODITY_CLASSIFICATION_UPDATE,
  COMMODITY_CLASSIFICATION_DELETE,

  COMMODITY_ALL,
  COMMODITY_CREATE,
  COMMODITY_UPDATE,
  COMMODITY_DELETE,

  WAREHOUSE_INPUT,
  WAREHOUSE_OUTPUT_PRE,
  WAREHOUSE_OUTPUT,
  WAREHOUSE_GET_INPUTSHEET,
  WAREHOUSE_GET_OUTPUTSHEET,
  WAREHOUSE_IO_DEATIL_BY_TIME,
  WAREHOUSE_IPQ_BY_TIME,
  WAREHOUSE_OPQ_BY_TIME,
  WAREHOUSE_OUTPUTSHEET_APPROVE,
  WAREHOUSE_INPUTSHEET_APPROVE,
  WAREHOUSE_DAILY_COUNT,

  WAREHOUSE_EXCEL_CREATE,

  PURCHASE_ALL,
  PURCHASE_CREATE,
  PURCHASE_FIRST_APPROVAL,
  PURCHASE_SECOND_APPROVAL,
  PURCHASE_RETURN_ALL,
  PURCHASE_RETURN_CREATE,
  PURCHASE_RETURN_FIRST_APPROVAL,
  PURCHASE_RETURN_SECOND_APPROVAL,
  PURCHASE_FIND_SHEET_BY_ID,

  SALE_ALL,
  SALE_CREATE,
  SALE_FIRST_APPROVAL,
  SALE_SECOND_APPROVAL,
  SALE_CUSTOMER_QUERY,
  SALE_CUSTOMER_MAX,
  SALE_FIND_SHEET_BY_ID,
  CUSTOMER_QUERY,
  SALE_PURCHASE_CREATE,

  //change
  CUSTOMER_EDIT,
  CUSTOMER_CREATE,
  SALE_RETURN_ALL,
  SALE_RETURN_CREATE,
  SALE_RETURN_FIRST_APPROVAL,
  SALE_RETURN_SECOND_APPROVAL,

  WORKER_CREATE,
  WORKER_ALL,
  WORKER_CHECK_IN,

  //FINANCE
  ACCOUNT_ALL,
  ACCOUNT_UPDATE,
  ACCOUNT_CREATE,
  ACCOUNT_DELETE,

  RECEIPT_ALL,
  RECEIPT_CREATE,
  RECEIPT_APPROVAL,

  PAYMENT_ALL,
  PAYMENT_CREATE,
  PAYMENT_APPROVAL,

  SALE_SHEET_ALL,
  SALE_RETURN_SHEET_ALL,

  SALE_DETAIL_ALL,

  SALARY_CREATE,

  GIFT_ST
};
