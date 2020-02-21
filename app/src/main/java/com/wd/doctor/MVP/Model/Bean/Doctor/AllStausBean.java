package com.wd.doctor.MVP.Model.Bean.Doctor;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Model.Bean.Doctor
 * @ClassName: AllStausBean
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:修改消息状态为全部已读
 * @CreateDate: 2019/12/17 13:53
 * @UpdateDate: 2019/12/17 13:53
 * @Version: 3.5
 */


public class AllStausBean {

    /**
     * message : 修改成功
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
