package com.wd.doctor.MVP.Contracter;

import com.bwei.example.mylibrary.Base.IBaseView;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Contracter
 * @ClassName: WardmateContracter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/13 8:54
 * @UpdateDate: 2019/12/13 8:54
 * @Version: 3.5
 */

//病友圈(契约类)
public interface WardmateContracter {
    //model层   命名必须是IModel
    interface IModel {
        //病友圈(查询科室列表)
        void getDepartmentModel(WardmateContracter.IModel.IModelCallback callback);

        //病友圈列表展示
        void getSickCircleListModel(Integer doctorId, Integer page, Integer count, WardmateContracter.IModel.IModelCallback callback);

        //查询病友圈详情
        void getSickCircleInfoModel(String doctorId, String sessionId, String sickCircleId, WardmateContracter.IModel.IModelCallback callback);

        //根据关键词查询病友圈
        void getSearchSickCircleModel(String keyWord, WardmateContracter.IModel.IModelCallback callback);

        //发表评论
        void getPublishCommentModel(String doctorId, String sessionId, String sickCircleId, String content, WardmateContracter.IModel.IModelCallback callback);

        //model层中的接口回调
        interface IModelCallback {
            void onSuccess(Object data);

            void onFailure(Throwable e);

            void onWardmateSuccess(Object data);

            void onWardmateFailure(Throwable e);
        }
    }

    //view层  命名必须是IView
    interface IView extends IBaseView {
        void onSuccess(Object data);

        void onFailure(Throwable e);

        void onWardmateSuccess(Object data);

        void onWardmateFailure(Throwable e);
    }

    //presenter层   命名必须是IPresenter
    interface IPresenter {
        //病友圈(查询科室列表)
        void getDepartmentPresenter();

        //病友圈列表展示
        void getSickCircleListPresenter(Integer doctorId, Integer page, Integer count);

        //查询病友圈详情
        void getSickCircleInfoPresenter(String doctorId, String sessionId, String sickCircleId);

        //根据关键词查询病友圈
        void getSearchSickCirclePresenter(String keyWord);

        //发表评论
        void getPublishCommentPresenter(String doctorId, String sessionId, String sickCircleId, String content);

    }
}
