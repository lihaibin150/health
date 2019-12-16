package com.wd.doctor.MVP.Model.Bean.Patients;

/**
 *@Package: com.wd.doctor.MVP.Model.Bean.Patients
 *@describe(描述)：SickCircleInfoBean.java
 *@ClassName: SickCircleInfoBean
 *@data（日期）: 2019/12/13
 *@time（时间）: 9:02
 *@author（作者）: 李海斌
 *@UpdateRemark: 更新说明：Android
 *@Version: 3.5
 **/

//查询病友圈详情
public class SickCircleInfoBean {

    /**
     * result : {"amount":0,"authorName":"LQ_PTBPO","departmentId":2,"departmentName":"骨科","detail":"4too宏观经济","disease":"退行性关节病","id":1655,"title":"挂机了","treatmentEndTime":1575561600000,"treatmentHospital":"你看看","treatmentProcess":"哈哈","treatmentStartTime":1575561600000,"userId":410,"whetherContent":2}
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
         * amount : 0
         * authorName : LQ_PTBPO
         * departmentId : 2
         * departmentName : 骨科
         * detail : 4too宏观经济
         * disease : 退行性关节病
         * id : 1655
         * title : 挂机了
         * treatmentEndTime : 1575561600000
         * treatmentHospital : 你看看
         * treatmentProcess : 哈哈
         * treatmentStartTime : 1575561600000
         * userId : 410
         * whetherContent : 2
         */

        private int amount;
        private String authorName;
        private int departmentId;
        private String departmentName;
        private String detail;
        private String disease;
        private int id;
        private String title;
        private long treatmentEndTime;
        private String treatmentHospital;
        private String treatmentProcess;
        private String picture;
        private long treatmentStartTime;
        private int userId;
        private int whetherContent;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "amount=" + amount +
                    ", authorName='" + authorName + '\'' +
                    ", departmentId=" + departmentId +
                    ", departmentName='" + departmentName + '\'' +
                    ", detail='" + detail + '\'' +
                    ", disease='" + disease + '\'' +
                    ", id=" + id +
                    ", title='" + title + '\'' +
                    ", treatmentEndTime=" + treatmentEndTime +
                    ", treatmentHospital='" + treatmentHospital + '\'' +
                    ", treatmentProcess='" + treatmentProcess + '\'' +
                    ", picture='" + picture + '\'' +
                    ", treatmentStartTime=" + treatmentStartTime +
                    ", userId=" + userId +
                    ", whetherContent=" + whetherContent +
                    '}';
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getDisease() {
            return disease;
        }

        public void setDisease(String disease) {
            this.disease = disease;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getTreatmentEndTime() {
            return treatmentEndTime;
        }

        public void setTreatmentEndTime(long treatmentEndTime) {
            this.treatmentEndTime = treatmentEndTime;
        }

        public String getTreatmentHospital() {
            return treatmentHospital;
        }

        public void setTreatmentHospital(String treatmentHospital) {
            this.treatmentHospital = treatmentHospital;
        }

        public String getTreatmentProcess() {
            return treatmentProcess;
        }

        public void setTreatmentProcess(String treatmentProcess) {
            this.treatmentProcess = treatmentProcess;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public long getTreatmentStartTime() {
            return treatmentStartTime;
        }

        public void setTreatmentStartTime(long treatmentStartTime) {
            this.treatmentStartTime = treatmentStartTime;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWhetherContent() {
            return whetherContent;
        }

        public void setWhetherContent(int whetherContent) {
            this.whetherContent = whetherContent;
        }

        public ResultBean(int amount, String authorName, int departmentId, String departmentName, String detail, String disease, int id, String title, long treatmentEndTime, String treatmentHospital, String treatmentProcess, String picture, long treatmentStartTime, int userId, int whetherContent) {
            this.amount = amount;
            this.authorName = authorName;
            this.departmentId = departmentId;
            this.departmentName = departmentName;
            this.detail = detail;
            this.disease = disease;
            this.id = id;
            this.title = title;
            this.treatmentEndTime = treatmentEndTime;
            this.treatmentHospital = treatmentHospital;
            this.treatmentProcess = treatmentProcess;
            this.picture = picture;
            this.treatmentStartTime = treatmentStartTime;
            this.userId = userId;
            this.whetherContent = whetherContent;
        }
    }
}
