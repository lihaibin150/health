package com.wd.doctor.MVP.Model.Bean.Interrogation;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Model.Bean.Interrogation
 * @ClassName: EvaluateBean
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:查询问诊评价详情
 * @CreateDate: 2019/12/15 19:26
 * @UpdateDate: 2019/12/15 19:26
 * @Version: 3.5
 */


public class EvaluateBean {

    /**
     * result : {"majorDegree":0,"satisfactionDegree":0}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * majorDegree : 0
         * satisfactionDegree : 0
         */

        private int majorDegree;
        private int satisfactionDegree;

        public int getMajorDegree() {
            return majorDegree;
        }

        public void setMajorDegree(int majorDegree) {
            this.majorDegree = majorDegree;
        }

        public int getSatisfactionDegree() {
            return satisfactionDegree;
        }

        public void setSatisfactionDegree(int satisfactionDegree) {
            this.satisfactionDegree = satisfactionDegree;
        }
    }
}
