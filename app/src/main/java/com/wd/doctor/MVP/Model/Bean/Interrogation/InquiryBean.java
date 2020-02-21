package com.wd.doctor.MVP.Model.Bean.Interrogation;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Model.Bean.Interrogation
 * @ClassName: InquiryBean
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:结束问诊
 * @CreateDate: 2019/12/15 19:22
 * @UpdateDate: 2019/12/15 19:22
 * @Version: 3.5
 */


public class InquiryBean {

    /**
     * message : 该问诊已结束,不能重复操作
     * status : 8002
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
