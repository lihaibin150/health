package com.wd.doctor.MVP.Model.Bean.Interrogation;

/**
 * @ProjectName: M01
 * @Package: com.wd.m01
 * @ClassName: RecordListBean
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:查询医生的问诊记录列表
 * @CreateDate: 2019/12/11 14:30
 * @UpdateDate: 2019/12/11 14:30
 * @Version: 3.5
 */

//查询医生的问诊记录列表
public class RecordListBean {

    /**
     * result : []
     * message : 查询成功
     * status : 0000
     */

    public String status;
    public String message;
    public ResultBean result;

    public static class ResultBean {
        public int recordId;
        public int userId;
        public String userHeadPic;
        public String doctorHeadPic;
        public String lastContent;
        public String nickName;
        public long inquiryTime;
        public int status;
    }


}
