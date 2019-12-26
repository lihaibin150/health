package com.wd.doctor.MVP.Model;

import com.bwei.example.mylibrary.Tools.Logger;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Http.Utils.CommonObserver;
import com.wd.doctor.MVP.Http.Utils.CommonSchedulers;
import com.wd.doctor.MVP.Http.Utils.RequestNet;
import com.wd.doctor.MVP.Model.Bean.Doctor.AllStausBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.ChooseImagePicBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorHealthyCurrencyNoticeListBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorInquiryNoticeListBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorSystemNoticeListBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.FindDoctorByIdBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.FindDoctorWalletBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.FindSystemImagePicBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.UploadImagePicBean;
import com.wd.doctor.MVP.Model.Bean.My.DoctorIdCardBean;

import java.util.Map;

import okhttp3.MultipartBody;

/**
 * 声明规范：
 * 1、命名规范为 "${业务模块}Model"  如：登录模块 Model 命名为 "LoginModel"
 * 2、必须 implements 对应锲约中的IModel接口 如: {@link HomeContracter.IModel}
 * <p>
 * <p>
 * 使用规范：
 * 1、使用 {@link com.wd.doctor.MVP.Http.Utils.RequestNet} 类的 create() 方法构造默认的IApi
 * 2、使用 compose()配合 {@link CommonSchedulers} 切换线程
 * 3、使用 {@link CommonObserver} 代替 {@link io.reactivex.Observer} ,避免每次强制重写 onSubscribe() 和 onComplete()
 */
public class HomeModel implements HomeContracter.IModel{
    //根据医生id查询医生信息
    @Override
    public void getFindDoctorByIdModel(String doctorId, String sessionId, IModelCallback callback) {
        RequestNet.getInstance().create()
                .FINDDOCTORBYID(doctorId, sessionId)
                .compose(CommonSchedulers.<FindDoctorByIdBean>io2main())
                .subscribe(new CommonObserver<FindDoctorByIdBean>() {
                    @Override
                    public void onNext(FindDoctorByIdBean doctorByIdBean) {
                        callback.onSuccess(doctorByIdBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }


    //上传形象照
    @Override
    public void getUploadImagePicModel(String doctorId, String sessionId, MultipartBody.Part imagePic, IModelCallback callback) {
        RequestNet.getInstance().create()
                .UPLOADIMAGEPIC(doctorId, sessionId, imagePic)
                .compose(CommonSchedulers.<UploadImagePicBean>io2main())
                .subscribe(new CommonObserver<UploadImagePicBean>() {
                    @Override
                    public void onNext(UploadImagePicBean imagePicBean) {
                        callback.onImgSuccess(imagePic);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onImgFailure(e);
                    }
                });
    }

    //查询系统形象照
    @Override
    public void getFindSystemImagePicModel(IModelCallback callback) {
        RequestNet.getInstance().create()
                .SYSTEMIMAGEPIC()
                .compose(CommonSchedulers.<FindSystemImagePicBean>io2main())
                .subscribe(new CommonObserver<FindSystemImagePicBean>() {
                    @Override
                    public void onNext(FindSystemImagePicBean imagePicBean) {
                        callback.onSuccess(imagePicBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }

    //选择系统提供形象照
    @Override
    public void getChooseImagePicModel(String doctorId, String sessionId, MultipartBody.Part imagePic, IModelCallback callback) {
        RequestNet.getInstance().create()
                .CHOOSEIMAGEPIC(doctorId, sessionId, imagePic)
                .compose(CommonSchedulers.<ChooseImagePicBean>io2main())
                .subscribe(new CommonObserver<ChooseImagePicBean>() {
                    @Override
                    public void onNext(ChooseImagePicBean imagePicBean) {
                        callback.onSuccess(imagePicBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }

    //查询医生钱包
    @Override
    public void getFindDoctorWalletModel(String doctorId, String sessionId, IModelCallback callback) {
        RequestNet.getInstance().create()
                .DOCTOR_WALLET(doctorId, sessionId)
                .compose(CommonSchedulers.<FindDoctorWalletBean>io2main())
                .subscribe(new CommonObserver<FindDoctorWalletBean>() {
                    @Override
                    public void onNext(FindDoctorWalletBean doctorWalletBean) {
                        callback.onSuccess(doctorWalletBean);
                        Logger.d("s", "dIdBean" + doctorWalletBean.getMessage());
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }
    //修改消息状态为全部已读
    @Override
    public void PutAllStausModel(String doctorId, String sessionId, IModelCallback callback) {
        RequestNet.getInstance().create()
                .ALL_STAUS(doctorId, sessionId)
                .compose(CommonSchedulers.<AllStausBean>io2main())
                .subscribe(new CommonObserver<AllStausBean>() {
                    @Override
                    public void onNext(AllStausBean allStausBean) {
                        callback.onSuccess(allStausBean);
                        Logger.d("s", "allStausBean:" + allStausBean.getMessage());
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }

    //查询H币通知消息
    @Override
    public void getHealthyModel(String doctorId, String sessionId, Integer page, Integer count, IModelCallback callback) {
        RequestNet.getInstance().create()
                .DOCTOR_HEALTHY(doctorId, sessionId, page, count)
                .compose(CommonSchedulers.<DoctorHealthyCurrencyNoticeListBean>io2main())
                .subscribe(new CommonObserver<DoctorHealthyCurrencyNoticeListBean>() {
                    @Override
                    public void onNext(DoctorHealthyCurrencyNoticeListBean doctorHealthy) {
                        callback.onSuccess(doctorHealthy);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }

    //查询系统通知消息
    @Override
    public void getSystemModel(String doctorId, String sessionId, Integer page, Integer count, IModelCallback callback) {
        RequestNet.getInstance().create()
                .DOCTOR_SYSTEM(doctorId, sessionId, page, count)
                .compose(CommonSchedulers.<DoctorSystemNoticeListBean>io2main())
                .subscribe(new CommonObserver<DoctorSystemNoticeListBean>() {
                    @Override
                    public void onNext(DoctorSystemNoticeListBean doctorHealthy) {
                        callback.onSuccess(doctorHealthy);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }

    //查询问诊通知消息
    @Override
    public void getInquiryModel(String doctorId, String sessionId, Integer page, Integer count, IModelCallback callback) {
        RequestNet.getInstance().create()
                .DOCTOR_INQUIRY(doctorId, sessionId, page, count)
                .compose(CommonSchedulers.<DoctorInquiryNoticeListBean>io2main())
                .subscribe(new CommonObserver<DoctorInquiryNoticeListBean>() {
                    @Override
                    public void onNext(DoctorInquiryNoticeListBean doctorHealthy) {
                        callback.onSuccess(doctorHealthy);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }
    //绑定身份证
    @Override
    public void getDoctorIdCardModel(String doctorId, String sessionId, Map<String, Object> BodyMap, IModelCallback callback) {
        RequestNet.getInstance().create()
                .DOCTOR_ID_CARD(doctorId, sessionId,BodyMap)
                .compose(CommonSchedulers.<DoctorIdCardBean>io2main())
                .subscribe(new CommonObserver<DoctorIdCardBean>() {
                    @Override
                    public void onNext(DoctorIdCardBean doctorHealthy) {
                        callback.onSuccess(doctorHealthy);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }


}
