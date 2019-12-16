package com.wd.doctor.MVP.Model;

import com.wd.doctor.MVP.Contracter.InterrogationContracter;
import com.wd.doctor.MVP.Http.Utils.CommonObserver;
import com.wd.doctor.MVP.Http.Utils.CommonSchedulers;
import com.wd.doctor.MVP.Http.Utils.RequestNet;
import com.wd.doctor.MVP.Model.Bean.Interrogation.DetailsListBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.EvaluateBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.InquiryBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.MessageBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.RecordBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.RecordListBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.UsrInfoBean;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Model
 * @ClassName: InterrogationMode
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:问诊
 * @CreateDate: 2019/12/15 19:35
 * @UpdateDate: 2019/12/15 19:35
 * @Version: 3.5
 */

public class InterrogationMode implements InterrogationContracter.IModel {
    //查询医生的问诊记录列表
    @Override
    public void getRecordListModel(String doctorId, String sessionId, IModelCallback callback) {
        RequestNet.getInstance().create()
                .RECORD_LIST(doctorId, sessionId)
                .compose(CommonSchedulers.<RecordListBean>io2main())
                .subscribe(new CommonObserver<RecordListBean>() {
                    @Override
                    public void onNext(RecordListBean recordBean) {
                        callback.onSuccess(recordBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }

    //查询用户详细信息
    @Override
    public void getUserInfoModel(String doctorId, String sessionId, Integer userId, IModelCallback callback) {
        RequestNet.getInstance().create()
                .USR_INFO(doctorId, sessionId,userId)
                .compose(CommonSchedulers.<UsrInfoBean>io2main())
                .subscribe(new CommonObserver<UsrInfoBean>() {
                    @Override
                    public void onNext(UsrInfoBean usrInfoBean) {
                        callback.onSuccess(userId);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }

    //结束问诊
    @Override
    public void getInquiryModel(String doctorId, String sessionId, Integer recordId, IModelCallback callback) {
        RequestNet.getInstance().create()
                .INQUIRY(doctorId, sessionId, recordId)
                .compose(CommonSchedulers.<InquiryBean>io2main())
                .subscribe(new CommonObserver<InquiryBean>() {
                    @Override
                    public void onNext(InquiryBean inquiryBean) {
                        callback.onDetailsListSuccess(inquiryBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onDetailsListFailure(e);
                    }
                });
    }

    //查询问诊聊天记录
    @Override
    public void getDetailsListModel(String doctorId, String sessionId, Integer recordId, IModelCallback callback) {
        RequestNet.getInstance().create()
                .DETAILS_LIST(doctorId, sessionId, recordId)
                .compose(CommonSchedulers.<DetailsListBean>io2main())
                .subscribe(new CommonObserver<DetailsListBean>() {
                    @Override
                    public void onNext(DetailsListBean detailsListBean) {
                        callback.onSuccess(detailsListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }

    //发送消息(推送)
    @Override
    public void getMessageModel(String doctorId, String sessionId, Integer recordId, IModelCallback callback) {
        RequestNet.getInstance().create()
                .MESSAGE(doctorId, sessionId, recordId)
                .compose(CommonSchedulers.<MessageBean>io2main())
                .subscribe(new CommonObserver<MessageBean>() {
                    @Override
                    public void onNext(MessageBean messageBean) {
                        callback.onSuccess(messageBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }

    //查询医生历史问诊记录列表
    @Override
    public void getRecordModel(String doctorId, String sessionId, Integer page, Integer count, IModelCallback callback) {
        RequestNet.getInstance().create()
                .RECORD(doctorId, sessionId, page, count)
                .compose(CommonSchedulers.<RecordBean>io2main())
                .subscribe(new CommonObserver<RecordBean>() {
                    @Override
                    public void onNext(RecordBean recordBean) {
                        callback.onSuccess(recordBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }

    //查询问诊评价详情
    @Override
    public void getEvaluateModel(String doctorId, String sessionId, Integer recordId, IModelCallback callback) {
        RequestNet.getInstance().create()
                .EVALUATE(doctorId, sessionId, recordId)
                .compose(CommonSchedulers.<EvaluateBean>io2main())
                .subscribe(new CommonObserver<EvaluateBean>() {
                    @Override
                    public void onNext(EvaluateBean evaluateBean) {
                        callback.onSuccess(evaluateBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }
}
