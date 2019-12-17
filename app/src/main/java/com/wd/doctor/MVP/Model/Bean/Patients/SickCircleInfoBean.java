package com.wd.doctor.MVP.Model.Bean.Patients;

/**
 * @Package: com.wd.doctor.MVP.Model.Bean.Patients
 * @describe(描述)：SickCircleInfoBean.java
 * @ClassName: SickCircleInfoBean
 * @data（日期）: 2019/12/13
 * @time（时间）: 9:02
 * @author（作者）: 李海斌
 * @UpdateRemark: 更新说明：Android
 * @Version: 3.5
 **/

//查询病友圈详情
public class SickCircleInfoBean {

    /**
     * result : {"amount":10,"authorName":"下雨吧","content":"发发发","departmentId":5,"departmentName":"小儿科","detail":"详情","disease":"病症描述","id":11,"title":"急寻：面神经炎的治疗方法","treatmentEndTime":1536681600000,"treatmentHospital":"治疗医院","treatmentProcess":"治疗过程描述","treatmentStartTime":1486051200000,"userId":1,"whetherContent":1}
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
         * amount : 10
         * authorName : 下雨吧
         * content : 发发发
         * departmentId : 5
         * departmentName : 小儿科
         * detail : 详情
         * disease : 病症描述
         * id : 11
         * title : 急寻：面神经炎的治疗方法
         * treatmentEndTime : 1536681600000
         * treatmentHospital : 治疗医院
         * treatmentProcess : 治疗过程描述
         * treatmentStartTime : 1486051200000
         * userId : 1
         * whetherContent : 1
         */

        private int amount;
        private String authorName;
        private String content;
        private int departmentId;
        private String departmentName;
        private String detail;
        private String disease;
        private int id;
        private String title;
        private long treatmentEndTime;
        private String treatmentHospital;
        private String treatmentProcess;
        private long treatmentStartTime;
        private int userId;
        private int whetherContent;

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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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
    }
}
