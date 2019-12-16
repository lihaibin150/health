package com.wd.doctor.MVP.Contracter;

import com.bwei.example.mylibrary.Base.IBaseView;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Contracter
 * @ClassName: InterrogationContracter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:问诊
 * @CreateDate: 2019/12/11 17:35
 * @UpdateDate: 2019/12/11 17:35
 * @Version: 3.5
 */
//问诊契约类
public interface InterrogationContracter {
    //model层   命名必须是IModel
    interface IModel {
        //查询医生的问诊记录列表
        void getRecordListModel(String doctorId, String sessionId, InterrogationContracter.IModel.IModelCallback callback);

        //查询用户详细信息
        void getUserInfoModel(String doctorId, String sessionId, Integer userId, InterrogationContracter.IModel.IModelCallback callback);

        //结束问诊
        void getInquiryModel(String doctorId, String sessionId, Integer recordId, InterrogationContracter.IModel.IModelCallback callback);

        //查询问诊聊天记录
        void getDetailsListModel(String doctorId, String sessionId, Integer recordId, InterrogationContracter.IModel.IModelCallback callback);

        //发送消息(推送)
        void getMessageModel(String doctorId, String sessionId, Integer recordId, InterrogationContracter.IModel.IModelCallback callback);

        //查询医生历史问诊记录列表
        void getRecordModel(String doctorId, String sessionId, Integer page, Integer count, InterrogationContracter.IModel.IModelCallback callback);

        //查询问诊评价详情
        void getEvaluateModel(String doctorId, String sessionId, Integer recordId, InterrogationContracter.IModel.IModelCallback callback);

        //model层中的接口回调
        interface IModelCallback {
            void onSuccess(Object data);

            void onDetailsListSuccess(Object data);

            void onFailure(Throwable e);

            void onDetailsListFailure(Throwable e);
        }
    }

    //view层  命名必须是IView
    interface IView extends IBaseView {
        void onSuccess(Object data);

        void onDetailsListSuccess(Object data);

        void onFailure(Throwable e);

        void onDetailsListFailure(Throwable e);
    }

    //presenter层   命名必须是IPresenter
    interface IPresenter {
        //查询医生的问诊记录列表
        void getRecordListPresenter(String doctorId, String sessionId);

        //查询用户详细信息
        void getUserInfoPresenter(String doctorId, String sessionId, Integer userId);

        //结束问诊
        void getInquiryPresenter(String doctorId, String sessionId, Integer recordId);

        //查询问诊聊天记录
        void getDetailsListPresenter(String doctorId, String sessionId, Integer recordId);

        //发送消息(推送)
        void getMessagePresenter(String doctorId, String sessionId, Integer recordId);

        //查询医生历史问诊记录列表
        void getRecordPresenter(String doctorId, String sessionId, Integer page, Integer count);

        //查询问诊评价详情
        void getEvaluatePresenter(String doctorId, String sessionId, Integer recordId);

    }

}
