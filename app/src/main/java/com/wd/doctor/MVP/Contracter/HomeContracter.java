package com.wd.doctor.MVP.Contracter;

import com.bwei.example.mylibrary.Base.IBaseView;

import okhttp3.MultipartBody;

/**
 * 契约类，方便统一管理相关接口
 * 声明规范：
 * 1、命名规范为 "I${业务模块}Contract" 格式，如：登录模块 Contract 命名为 "ILoginContract"
 * 2、内部接口命名规范为 IView 、IPresenter 、IModel、IModelCallback   ps：内部接口命名不加业务名字
 */

//我的契约类
public interface HomeContracter {
    //model层   命名必须是IModel
    interface IModel {
        //根据医生id查询医生信息
        void getFindDoctorByIdModel(String doctorId, String sessionId, IModelCallback callback);

        //上传形象照
        void getUploadImagePicModel(String doctorId, String sessionId, MultipartBody.Part imagePic, IModelCallback callback);

        //查询系统形象照
        void getFindSystemImagePicModel(IModelCallback callback);

        //选择系统提供形象照
        void getChooseImagePicModel(String doctorId, String sessionId, String imagePic, IModelCallback callback);

        //查询医生钱包
        void getFindDoctorWalletModel(String doctorId, String sessionId, IModelCallback callback);

        //查询H币通知消息
        void getHealthyModel(String doctorId, String sessionId, Integer page, Integer count, IModelCallback callback);
        //查询系统通知消息
        void getSystemModel(String doctorId, String sessionId, Integer page, Integer count, IModelCallback callback);
        //查询问诊通知消息
        void getInquiryModel(String doctorId, String sessionId, Integer page, Integer count, IModelCallback callback);

        //model层中的接口回调
        interface IModelCallback {
            void onSuccess(Object data);

            void onFailure(Throwable e);
        }
    }

    //view层  命名必须是IView
    interface IView extends IBaseView {
        void onSuccess(Object data);

        void onFailure(Throwable e);
    }

    //presenter层   命名必须是IPresenter
    interface IPresenter {
        //根据医生id查询医生信息
        void getFindDoctorByIdPresenter(String doctorId, String sessionId);

        //上传形象照
        void getUploadImagePicPresenter(String doctorId, String sessionId, MultipartBody.Part imagePic);

        //查询系统形象照
        void getFindSystemImagePicPresenter();

        //选择系统提供形象照
        void getChooseImagePicPresenter(String doctorId, String sessionId, String imagePic);

        //查询医生钱包
        void getFindDoctorWalletPresenter(String doctorId, String sessionId);

        //查询H币通知消息
        void getHealthyPresenter(String doctorId, String sessionId, Integer page, Integer count);
        //查询系统通知消息
        void getSystemPresenter(String doctorId, String sessionId, Integer page, Integer count);
        //查询问诊通知消息
        void getInquiryPresenter(String doctorId, String sessionId, Integer page, Integer count);

    }

}
