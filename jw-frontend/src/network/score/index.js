import request from "@/network/request";
const testAPI = require("@/apis")

export const getScoresById = config => request._get(testAPI.PERSON_SCORES + config.id, config);
export const updateScore = config => request._post(testAPI.UPDATE_SCORE , config);
export const getScorePercent = config => request._get(testAPI.SCORE_PERCENT + config.id, config);


// export const getAllCourse= config => request._get(testAPI.COURSE_ALL, config);
// export const getAllStudent= config => request._get(testAPI.STUDENT_ALL, config);
// export const getMyCourse = config => request._post(testAPI.COURSE_PERSON, config);
// export const chooseCourse = config => request._post(testAPI.COURSE_CHOOSE + config.courseId, config);
// export const unchooseCourse = config => request._post(testAPI.COURSE_UNCHOOSE + config.courseId, config);
// export const chooseOtherCourse = config => request._post(testAPI.COURSE_CHOOSE_OTHER + config.courseId, config);
//
//
// export const getOtherCourse = config =>  request._get(testAPI.COURSE_OTHERS, config);
