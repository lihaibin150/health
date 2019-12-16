package com.wd.doctor.MVP.Model.Bean.Doctor;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Model.Bean.Doctor
 * @ClassName: DoctorInquiryNoticeListBean
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:查询问诊通知消息
 * @CreateDate: 2019/12/14 8:50
 * @UpdateDate: 2019/12/14 8:50
 * @Version: 3.5
 */


public class DoctorInquiryNoticeListBean {
    public String status;
    public String message;
    public ResultBean result;

    public static class ResultBean {
        public int id;
        public String content;
        public long createTime;
    }
}
