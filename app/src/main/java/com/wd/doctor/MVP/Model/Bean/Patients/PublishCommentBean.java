package com.wd.doctor.MVP.Model.Bean.Patients;

/**
 *@Package: com.wd.doctor.MVP.Model.Bean.Patients
 *@describe(描述)：PublishCommentBean.java
 *@ClassName: PublishCommentBean
 *@data（日期）: 2019/12/13
 *@time（时间）: 9:01
 *@author（作者）: 李海斌
 *@UpdateRemark: 更新说明：Android
 *@Version: 3.5
 **/

//发表评论
public class PublishCommentBean {

    /**
     * message : 发表成功
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
