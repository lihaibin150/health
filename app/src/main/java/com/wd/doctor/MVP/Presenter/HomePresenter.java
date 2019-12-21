package com.wd.doctor.MVP.Presenter;

import com.bwei.example.mylibrary.Base.BasePresenter;
import com.bwei.example.mylibrary.Tools.Logger;
import com.wd.doctor.MVP.Contracter.API.Constant;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.ChooseImagePicBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorHealthyCurrencyNoticeListBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorInquiryNoticeListBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorSystemNoticeListBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.FindDoctorByIdBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.FindDoctorWalletBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.FindSystemImagePicBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.UploadImagePicBean;
import com.wd.doctor.MVP.Model.HomeModel;

import okhttp3.MultipartBody;

/**
 * @data（日期）: 2019/11/5
 * @time（时间）: 19:55
 * @author（作者）: 李海斌
 * @UpdateRemark: 更新说明：
 **/

public class HomePresenter extends BasePresenter<HomeContracter.IView> implements HomeContracter.IPresenter {

    private HomeModel mHomeModel;

    //根据医生id查询医生信息
    @Override
    public void getFindDoctorByIdPresenter(String doctorId, String sessionId) {
        //2、调用model中的的方法，设置回调监听
        mHomeModel.getFindDoctorByIdModel(doctorId, sessionId, new HomeContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(FindDoctorByIdBean.class)) {
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onImgSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {
                //4、失败回调
                if (ViewAttached()) {
                    getView().onFailure(e);
                }
            }

            @Override
            public void onImgFailure(Throwable e) {

            }
        });
    }

    //上传形象照erride
    @Override
    public void getUploadImagePicPresenter(String doctorId, String sessionId, MultipartBody.Part imagePic) {
        //2、调用model中的的方法，设置回调监听
        mHomeModel.getUploadImagePicModel(doctorId, sessionId, imagePic, new HomeContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {

            }

            @Override
            public void onImgSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onImgSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(UploadImagePicBean.class)) {
                        Logger.d("s", "ddata" + data);
                    } else {
                        getView().onImgFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }

            @Override
            public void onImgFailure(Throwable e) {
                //4、失败回调
                if (ViewAttached()) {
                    getView().onImgFailure(e);
                }
            }
        });
    }

    //查询系统形象照
    @Override
    public void getFindSystemImagePicPresenter() {
//2、调用model中的的方法，设置回调监听
        mHomeModel.getFindSystemImagePicModel(new HomeContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(FindSystemImagePicBean.class)) {
                        Logger.d("s", "ddata" + data);
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onImgSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {
                //4、失败回调
                if (ViewAttached()) {
                    getView().onFailure(e);
                }
            }

            @Override
            public void onImgFailure(Throwable e) {

            }
        });
    }

    //选择系统提供形象照
    @Override
    public void getChooseImagePicPresenter(String doctorId, String sessionId, MultipartBody.Part imagePic) {
        //2、调用model中的的方法，设置回调监听
        mHomeModel.getChooseImagePicModel(doctorId, sessionId, imagePic, new HomeContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(ChooseImagePicBean.class)) {
                        Logger.d("s", "ddata" + data);
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onImgSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {
                //4、失败回调
                if (ViewAttached()) {
                    getView().onFailure(e);
                }
            }

            @Override
            public void onImgFailure(Throwable e) {

            }
        });
    }

    //查询医生钱包
    @Override
    public void getFindDoctorWalletPresenter(String doctorId, String sessionId) {
        //2、调用model中的的方法，设置回调监听
        mHomeModel.getFindDoctorWalletModel(doctorId, sessionId, new HomeContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(FindDoctorWalletBean.class)) {
                        Logger.d("s", "ddata" + data);
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onImgSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {
                //4、失败回调
                if (ViewAttached()) {
                    getView().onFailure(e);
                }
            }

            @Override
            public void onImgFailure(Throwable e) {

            }
        });
    }

    //查询H币通知消息
    @Override
    public void getHealthyPresenter(String doctorId, String sessionId, Integer page, Integer count) {
        //2、调用model中的的方法，设置回调监听
        mHomeModel.getHealthyModel(doctorId, sessionId, page, count, new HomeContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(DoctorHealthyCurrencyNoticeListBean.class)) {
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onImgSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {
                //4、失败回调
                if (ViewAttached()) {
                    getView().onFailure(e);
                }
            }

            @Override
            public void onImgFailure(Throwable e) {

            }
        });
    }

    //查询系统通知消息
    @Override
    public void getSystemPresenter(String doctorId, String sessionId, Integer page, Integer count) {
//2、调用model中的的方法，设置回调监听
        mHomeModel.getSystemModel(doctorId, sessionId, page, count, new HomeContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(DoctorSystemNoticeListBean.class)) {
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onImgSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {
                //4、失败回调
                if (ViewAttached()) {
                    getView().onFailure(e);
                }
            }

            @Override
            public void onImgFailure(Throwable e) {

            }
        });
    }

    //查询问诊通知消息
    @Override
    public void getInquiryPresenter(String doctorId, String sessionId, Integer page, Integer count) {
        //2、调用model中的的方法，设置回调监听
        mHomeModel.getInquiryModel(doctorId, sessionId, page, count, new HomeContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(DoctorInquiryNoticeListBean.class)) {
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onImgSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {
                //4、失败回调
                if (ViewAttached()) {
                    getView().onFailure(e);
                }
            }

            @Override
            public void onImgFailure(Throwable e) {

            }
        });
    }

    //修改消息状态为全部已读
    @Override
    public void PutAllStausPresenter(String doctorId, String sessionId) {
        //2、调用model中的的方法，设置回调监听
        mHomeModel.PutAllStausModel(doctorId, sessionId, new HomeContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                getView().onSuccess(data);
            }

            @Override
            public void onImgSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onImgFailure(Throwable e) {

            }
        });
    }

    // 1、在这个方法中初始化model
    @Override
    protected void initModel() {
        mHomeModel = new HomeModel();
    }

}
