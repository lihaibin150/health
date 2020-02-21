package com.wd.doctor.MVP.Model.Bean.Doctor;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Model.Bean.Doctor
 * @ClassName: UserPwdBean
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:重置用户密码（忘记密码用）
 * @CreateDate: 2019/12/14 10:00
 * @UpdateDate: 2019/12/14 10:00
 * @Version: 3.5
 */


public class UserPwdBean {

    /**
     * message : 密码重置成功
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
