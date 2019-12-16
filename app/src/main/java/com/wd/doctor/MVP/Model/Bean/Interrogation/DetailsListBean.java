package com.wd.doctor.MVP.Model.Bean.Interrogation;

import java.util.List;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Model.Bean.Interrogation
 * @ClassName: DetailsListBean
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:查询问诊聊天记录
 * @CreateDate: 2019/12/15 19:23
 * @UpdateDate: 2019/12/15 19:23
 * @Version: 3.5
 */


public class DetailsListBean {

    /**
     * result : [{"askTime":1576046971000,"content":"文本","direction":1,"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","msgType":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_3.jpg"}]
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
         * askTime : 1576046971000
         * content : 文本
         * direction : 1
         * doctorHeadPic : http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg
         * msgType : 1
         * userHeadPic : http://172.17.8.100/images/health/user/head_pic/default/default_head_3.jpg
         */

        private long askTime;
        private String content;
        private int direction;
        private String doctorHeadPic;
        private int msgType;
        private String userHeadPic;

        public long getAskTime() {
            return askTime;
        }

        public void setAskTime(long askTime) {
            this.askTime = askTime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }

        public String getDoctorHeadPic() {
            return doctorHeadPic;
        }

        public void setDoctorHeadPic(String doctorHeadPic) {
            this.doctorHeadPic = doctorHeadPic;
        }

        public int getMsgType() {
            return msgType;
        }

        public void setMsgType(int msgType) {
            this.msgType = msgType;
        }

        public String getUserHeadPic() {
            return userHeadPic;
        }

        public void setUserHeadPic(String userHeadPic) {
            this.userHeadPic = userHeadPic;
        }
    }
}
