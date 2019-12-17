package com.wd.doctor.MVP.Presenter;

import com.bwei.example.mylibrary.Base.BasePresenter;
import com.bwei.example.mylibrary.Test.Logger;
import com.wd.doctor.MVP.Contracter.API.Constant;
import com.wd.doctor.MVP.Contracter.WardmateContracter;
import com.wd.doctor.MVP.Model.Bean.Patients.FindDepartmentBean;
import com.wd.doctor.MVP.Model.Bean.Patients.FindSickCircleListBean;
import com.wd.doctor.MVP.Model.Bean.Patients.SickCircleInfoBean;
import com.wd.doctor.MVP.Model.WardmateModel;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Presenter
 * @ClassName: WardmatePresenter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/13 9:31
 * @UpdateDate: 2019/12/13 9:31
 * @Version: 3.5
 */

//病友圈Presenter
public class WardmatePresenter extends BasePresenter<WardmateContracter.IView> implements WardmateContracter.IPresenter {

    private WardmateModel mWardmateModel;

    @Override
    protected void initModel() {
        mWardmateModel = new WardmateModel();
    }

    //病友圈(查询科室列表)
    @Override
    public void getDepartmentPresenter() {
        mWardmateModel.getDepartmentModel(new WardmateContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(FindDepartmentBean.class)) {
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }

            }

            @Override
            public void onFailure(Throwable e) {
                if (ViewAttached()) {
                    getView().onFailure(e);
                }
            }

            @Override
            public void onWardmateSuccess(Object data) {

            }

            @Override
            public void onWardmateFailure(Throwable e) {

            }
        });
    }

    //病友圈列表展示
    @Override
    public void getSickCircleListPresenter(Integer doctorId, Integer page, Integer count) {
        mWardmateModel.getSickCircleListModel(doctorId, page, count, new WardmateContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {

            }

            @Override
            public void onWardmateSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onWardmateSuccess(data);
                    if (data != null && Constant.SUCCESS_CODE.equals(FindSickCircleListBean.class)) {
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onWardmateFailure(Throwable e) {
                if (ViewAttached()) {
                    getView().onWardmateFailure(e);
                }
            }
        });
    }

    //查询病友圈详情
    @Override
    public void getSickCircleInfoPresenter(String doctorId, String sessionId, String sickCircleId) {
        mWardmateModel.getSickCircleInfoModel(doctorId, sessionId, sickCircleId, new WardmateContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    getView().onSuccess(data);
                    Logger.d("aa","Constantad:"+data);
                    if (data != null && Constant.SUCCESS_CODE.equals(SickCircleInfoBean.class)) {
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }

            }

            @Override
            public void onFailure(Throwable e) {
                if (ViewAttached()) {
                    getView().onFailure(e);
                }
            }

            @Override
            public void onWardmateSuccess(Object data) {

            }

            @Override
            public void onWardmateFailure(Throwable e) {

            }
        });
    }

    //根据关键词查询病友圈
    @Override
    public void getSearchSickCirclePresenter(String keyWord) {
        mWardmateModel.getSearchSickCircleModel(keyWord, new WardmateContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                getView().onSuccess(data);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }

            @Override
            public void onWardmateSuccess(Object data) {

            }

            @Override
            public void onWardmateFailure(Throwable e) {

            }
        });
    }

    //发表评论
    @Override
    public void getPublishCommentPresenter(String doctorId, String sessionId, String sickCircleId,String content) {
        mWardmateModel.getPublishCommentModel(doctorId, sessionId, sickCircleId, content, new WardmateContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {

            }

            @Override
            public void onFailure(Throwable e) {

            }

            @Override
            public void onWardmateSuccess(Object data) {
                getView().onWardmateSuccess(data);
            }

            @Override
            public void onWardmateFailure(Throwable e) {
                getView().onWardmateFailure(e);
            }
        });
    }
}
