package com.wd.doctor.MVP.Model.Bean.Doctor;

/**
 *@Package: com.wd.doctor.MVP.Model.Bean.Doctor
 *@describe(描述)：UploadImagePicBean.java
 *@ClassName: UploadImagePicBean
 *@data（日期）: 2019/12/13
 *@time（时间）: 8:59
 *@author（作者）: 李海斌
 *@UpdateRemark: 更新说明：Android
 *@Version: 3.5
 **/

//上传形象照
public class UploadImagePicBean {

    /**
     * result : http://172.17.8.100/images/health/doctor/image_pic/2019-12-11/DeSQD720191211141537.png
     * message : 上传成功
     * status : 0000
     */

    private String result;
    private String message;
    private String status;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
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
}
