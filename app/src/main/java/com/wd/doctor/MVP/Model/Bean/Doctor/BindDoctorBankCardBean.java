package com.wd.doctor.MVP.Model.Bean.Doctor;

/**
 *@Package: com.wd.doctor.MVP.Model.Bean.Doctor
 *@describe(描述)：BindDoctorBankCardBean.java
 *@ClassName: BindDoctorBankCardBean
 *@data（日期）: 2019/12/11
 *@time（时间）: 15:47
 *@author（作者）: 李海斌
 *@UpdateRemark: 更新说明：Android
 *@Version: 3.5
 **/

//绑定银行卡
public class BindDoctorBankCardBean {

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
