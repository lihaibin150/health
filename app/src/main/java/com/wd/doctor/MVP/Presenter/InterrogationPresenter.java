package com.wd.doctor.MVP.Presenter;

import com.bwei.example.mylibrary.Base.BasePresenter;
import com.wd.doctor.MVP.Contracter.API.Constant;
import com.wd.doctor.MVP.Contracter.InterrogationContracter;
import com.wd.doctor.MVP.Model.Bean.Interrogation.DetailsListBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.EvaluateBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.InquiryBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.MessageBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.RecordBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.UsrInfoBean;
import com.wd.doctor.MVP.Model.InterrogationMode;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Presenter
 * @ClassName: InterrogationPresenter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/15 19:46
 * @UpdateDate: 2019/12/15 19:46
 * @Version: 3.5
 */


public class InterrogationPresenter extends BasePresenter<InterrogationContracter.IView> implements InterrogationContracter.IPresenter {
    private InterrogationMode mInterrogationMode;

    @Override
    protected void initModel() {
        mInterrogationMode = new InterrogationMode();
    }

    //查询医生的问诊记录列表
    @Override
    public void getRecordListPresenter(String doctorId, String sessionId) {
        mInterrogationMode.getRecordListModel(doctorId, sessionId, new InterrogationContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                getView().onSuccess(data);
            }

            @Override
            public void onDetailsListSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onDetailsListFailure(Throwable e) {

            }
        });
    }

    //查询用户详细信息
    @Override
    public void getUserInfoPresenter(String doctorId, String sessionId, Integer userId) {
        mInterrogationMode.getUserInfoModel(doctorId, sessionId, userId, new InterrogationContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(UsrInfoBean.class)) {
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onDetailsListSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {
                if (ViewAttached()) {
                    getView().onFailure(e);
                }
            }

            @Override
            public void onDetailsListFailure(Throwable e) {

            }
        });
    }

    //结束问诊
    @Override
    public void getInquiryPresenter(String doctorId, String sessionId, Integer recordId) {
        mInterrogationMode.getInquiryModel(doctorId, sessionId, recordId, new InterrogationContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {

            }

            @Override
            public void onDetailsListSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onDetailsListSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(InquiryBean.class)) {
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }

            @Override
            public void onDetailsListFailure(Throwable e) {
                //4、失败回调
                if (ViewAttached()) {
                    getView().onDetailsListFailure(e);
                }
            }
        });
    }

    //查询问诊聊天记录(接收客户端发来的消息)
    @Override
    public void getDetailsListPresenter(String doctorId, String sessionId, Integer inquiryId, Integer page, Integer count) {
        mInterrogationMode.getDetailsListModel(doctorId, sessionId, inquiryId, page, count, new InterrogationContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(DetailsListBean.class)) {
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onDetailsListSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {
                //4、失败回调
                if (ViewAttached()) {
                    getView().onFailure(e);
                }
            }

            @Override
            public void onDetailsListFailure(Throwable e) {

            }
        });
    }

    //发送消息(发送消息到客户端)
    @Override
    public void getMessagePresenter(String doctorId, String sessionId, Integer inquiryId, String content, Integer type, Integer userId) {
        mInterrogationMode.getMessageModel(doctorId, sessionId, inquiryId, content, type, userId, new InterrogationContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(MessageBean.class)) {
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onDetailsListSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {
                //4、失败回调
                if (ViewAttached()) {
                    getView().onFailure(e);
                }
            }

            @Override
            public void onDetailsListFailure(Throwable e) {

            }
        });
    }

    //查询医生历史问诊记录列表
    @Override
    public void getRecordPresenter(String doctorId, String sessionId, Integer page, Integer count) {
        mInterrogationMode.getRecordModel(doctorId, sessionId, page, count, new InterrogationContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(RecordBean.class)) {
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onDetailsListSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {
                //4、失败回调
                if (ViewAttached()) {
                    getView().onFailure(e);
                }
            }

            @Override
            public void onDetailsListFailure(Throwable e) {

            }
        });
    }

    //查询问诊评价详情
    @Override
    public void getEvaluatePresenter(String doctorId, String sessionId, Integer recordId) {
        mInterrogationMode.getEvaluateModel(doctorId, sessionId, recordId, new InterrogationContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(EvaluateBean.class)) {
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onDetailsListSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {
                //4、失败回调
                if (ViewAttached()) {
                    getView().onFailure(e);
                }
            }

            @Override
            public void onDetailsListFailure(Throwable e) {

            }
        });
    }
}
