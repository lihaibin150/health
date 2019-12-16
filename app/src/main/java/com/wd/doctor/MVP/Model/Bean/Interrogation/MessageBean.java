package com.wd.doctor.MVP.Model.Bean.Interrogation;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Model.Bean.Interrogation
 * @ClassName: MessageBean
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:发送消息
 * @CreateDate: 2019/12/15 19:23
 * @UpdateDate: 2019/12/15 19:23
 * @Version: 3.5
 */


public class MessageBean {

    /**
     * message : 推送成功
     * status : 0000
     */

    private String message;
    private String status;

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
}
