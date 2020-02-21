package com.wd.doctor.MVP.Model.Bean.Interrogation;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Model.Bean.Interrogation
 * @ClassName: UsrInfoBean
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:查询用户详细信息
 * @CreateDate: 2019/12/15 19:18
 * @UpdateDate: 2019/12/15 19:18
 * @Version: 3.5
 */


public class UsrInfoBean {

    /**
     * result : {"age":24,"diseaseBefore":"递四方速递","diseaseMain":"递四方速递","diseaseNow":"递四方速递","height":173,"nickName":"天涯","picture":"http://172.17.8.100/images/health/user/archives/2019-12-10/KJSEog20191210203408.jpg,http://172.17.8.100/images/health/user/archives/2019-12-10/emobVL20191210203408.jpg","sex":1,"treatmentEndTime":1554048000000,"treatmentHospitalRecent":"递四方速递","treatmentProcess":"递四方速递","treatmentStartTime":1554048000000,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-10/Sy3HNE20191210194352.jpg","userId":437,"weight":85}
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
         * age : 24
         * diseaseBefore : 递四方速递
         * diseaseMain : 递四方速递
         * diseaseNow : 递四方速递
         * height : 173
         * nickName : 天涯
         * picture : http://172.17.8.100/images/health/user/archives/2019-12-10/KJSEog20191210203408.jpg,http://172.17.8.100/images/health/user/archives/2019-12-10/emobVL20191210203408.jpg
         * sex : 1
         * treatmentEndTime : 1554048000000
         * treatmentHospitalRecent : 递四方速递
         * treatmentProcess : 递四方速递
         * treatmentStartTime : 1554048000000
         * userHeadPic : http://172.17.8.100/images/health/user/head_pic/2019-12-10/Sy3HNE20191210194352.jpg
         * userId : 437
         * weight : 85
         */

        private int age;
        private String diseaseBefore;
        private String diseaseMain;
        private String diseaseNow;
        private int height;
        private String nickName;
        private String picture;
        private int sex;
        private long treatmentEndTime;
        private String treatmentHospitalRecent;
        private String treatmentProcess;
        private long treatmentStartTime;
        private String userHeadPic;
        private int userId;
        private int weight;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getDiseaseBefore() {
            return diseaseBefore;
        }

        public void setDiseaseBefore(String diseaseBefore) {
            this.diseaseBefore = diseaseBefore;
        }

        public String getDiseaseMain() {
            return diseaseMain;
        }

        public void setDiseaseMain(String diseaseMain) {
            this.diseaseMain = diseaseMain;
        }

        public String getDiseaseNow() {
            return diseaseNow;
        }

        public void setDiseaseNow(String diseaseNow) {
            this.diseaseNow = diseaseNow;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public long getTreatmentEndTime() {
            return treatmentEndTime;
        }

        public void setTreatmentEndTime(long treatmentEndTime) {
            this.treatmentEndTime = treatmentEndTime;
        }

        public String getTreatmentHospitalRecent() {
            return treatmentHospitalRecent;
        }

        public void setTreatmentHospitalRecent(String treatmentHospitalRecent) {
            this.treatmentHospitalRecent = treatmentHospitalRecent;
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

        public String getUserHeadPic() {
            return userHeadPic;
        }

        public void setUserHeadPic(String userHeadPic) {
            this.userHeadPic = userHeadPic;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
