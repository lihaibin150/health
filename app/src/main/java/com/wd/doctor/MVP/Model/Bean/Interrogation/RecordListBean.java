package com.wd.doctor.MVP.Model.Bean.Interrogation;

import java.util.List;

/**
 * @ProjectName: M01
 * @Package: com.wd.m01
 * @ClassName: RecordListBean
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:查询医生的问诊记录列表
 * @CreateDate: 2019/12/11 14:30
 * @UpdateDate: 2019/12/11 14:30
 * @Version: 3.5
 */

//查询医生的问诊记录列表
public class RecordListBean {


    /**
     * result : [{"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","inquiryTime":1577159686000,"jiGuangPwd":"R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=","lastContent":"文本","nickName":"fo_WKVWJ","recordId":3843,"status":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_6.jpg","userId":456,"userName":"IStXNe896745795"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * doctorHeadPic : http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg
         * inquiryTime : 1577159686000
         * jiGuangPwd : R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=
         * lastContent : 文本
         * nickName : fo_WKVWJ
         * recordId : 3843
         * status : 1
         * userHeadPic : http://172.17.8.100/images/health/user/head_pic/default/default_head_6.jpg
         * userId : 456
         * userName : IStXNe896745795
         */

        private String doctorHeadPic;
        private long inquiryTime;
        private String jiGuangPwd;
        private String lastContent;
        private String nickName;
        private int recordId;
        private int status;
        private String userHeadPic;
        private int userId;
        private String userName;

        public String getDoctorHeadPic() {
            return doctorHeadPic;
        }

        public void setDoctorHeadPic(String doctorHeadPic) {
            this.doctorHeadPic = doctorHeadPic;
        }

        public long getInquiryTime() {
            return inquiryTime;
        }

        public void setInquiryTime(long inquiryTime) {
            this.inquiryTime = inquiryTime;
        }

        public String getJiGuangPwd() {
            return jiGuangPwd;
        }

        public void setJiGuangPwd(String jiGuangPwd) {
            this.jiGuangPwd = jiGuangPwd;
        }

        public String getLastContent() {
            return lastContent;
        }

        public void setLastContent(String lastContent) {
            this.lastContent = lastContent;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getRecordId() {
            return recordId;
        }

        public void setRecordId(int recordId) {
            this.recordId = recordId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
