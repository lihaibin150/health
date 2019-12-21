package com.wd.doctor.MVP.Model.Bean.Doctor;

import java.util.List;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Model.Bean.Doctor
 * @ClassName: MyAdoptedCommentListBean
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:查询我的被采纳的建议
 * @CreateDate: 2019/12/17 20:58
 * @UpdateDate: 2019/12/17 20:58
 * @Version: 3.5
 */


public class MyAdoptedCommentListBean {

    /**
     * result : []
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<?> result;

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

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }
}
