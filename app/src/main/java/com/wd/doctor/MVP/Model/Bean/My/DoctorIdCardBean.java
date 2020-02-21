package com.wd.doctor.MVP.Model.Bean.My;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Model.Bean.My
 * @ClassName: DoctorIdCardBean
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:绑定身份证
 * @CreateDate: 2019/12/23 18:57
 * @UpdateDate: 2019/12/23 18:57
 * @Version: 3.5
 */

public class DoctorIdCardBean {

    /**
     * message : 绑定成功
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
