package com.wd.doctor.MVP.Model.Bean.Doctor;
/**
 *@Package: com.wd.doctor.MVP.Model.Bean.Doctor
 *@describe(描述)：FindDoctorByIdBean.java
 *@ClassName: FindDoctorByIdBean
 *@data（日期）: 2019/12/11
 *@time（时间）: 15:48
 *@author（作者）: 李海斌
 *@UpdateRemark: 更新说明：Android
 *@Version: 3.5
 **/

//根据医生id查询医生信息
public class FindDoctorByIdBean {

    /**
     * result : {"departmentId":5,"departmentName":"小儿科","goodField":"小儿科,找我就对了","id":155,"inauguralHospital":"清华大学附属医院","jobTitle":"主任","name":"任二","personalProfile":"神医在世"}
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
         * departmentId : 5
         * departmentName : 小儿科
         * goodField : 小儿科,找我就对了
         * id : 155
         * inauguralHospital : 清华大学附属医院
         * jobTitle : 主任
         * name : 任二
         * personalProfile : 神医在世
         */

        private int departmentId;
        private String departmentName;
        private String goodField;
        private int id;
        private String inauguralHospital;
        private String jobTitle;
        private String name;
        private String personalProfile;

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

        public String getGoodField() {
            return goodField;
        }

        public void setGoodField(String goodField) {
            this.goodField = goodField;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getInauguralHospital() {
            return inauguralHospital;
        }

        public void setInauguralHospital(String inauguralHospital) {
            this.inauguralHospital = inauguralHospital;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPersonalProfile() {
            return personalProfile;
        }

        public void setPersonalProfile(String personalProfile) {
            this.personalProfile = personalProfile;
        }
    }
}
