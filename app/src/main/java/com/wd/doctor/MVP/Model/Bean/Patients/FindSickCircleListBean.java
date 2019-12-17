package com.wd.doctor.MVP.Model.Bean.Patients;

import java.util.List;

/**
 *@Package: com.wd.doctor.MVP.Model.Bean.Doctor
 *@describe(描述)：FindSickCircleListBean.java
 *@ClassName: FindSickCircleListBean
 *@data（日期）: 2019/12/13
 *@time（时间）: 8:58
 *@author（作者）: 李海斌
 *@UpdateRemark: 更新说明：Android
 *@Version: 3.5
 **/

//病友圈列表展示
public class FindSickCircleListBean {

    /**
     * result : [{"amount":0,"detail":"头疼的厉害","releaseTime":1576512000000,"sickCircleId":1742,"title":"骨科"},{"amount":0,"detail":"头疼的厉害","releaseTime":1576512000000,"sickCircleId":1740,"title":"骨科"},{"amount":0,"detail":"头疼的厉害","releaseTime":1576425600000,"sickCircleId":1736,"title":"骨科"},{"amount":0,"detail":"头疼的厉害","releaseTime":1576425600000,"sickCircleId":1732,"title":"骨科"},{"amount":0,"detail":"头疼的厉害","releaseTime":1576425600000,"sickCircleId":1731,"title":"骨科"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * amount : 0
         * detail : 头疼的厉害
         * releaseTime : 1576512000000
         * sickCircleId : 1742
         * title : 骨科
         */

        private int amount;
        private String detail;
        private long releaseTime;
        private int sickCircleId;
        private String title;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getSickCircleId() {
            return sickCircleId;
        }

        public void setSickCircleId(int sickCircleId) {
            this.sickCircleId = sickCircleId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
