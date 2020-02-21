package com.wd.doctor.MVP.Model;

import com.bwei.example.mylibrary.Tools.Logger;
import com.wd.doctor.MVP.Contracter.WardmateContracter;
import com.wd.doctor.MVP.Http.Utils.CommonObserver;
import com.wd.doctor.MVP.Http.Utils.CommonSchedulers;
import com.wd.doctor.MVP.Http.Utils.RequestNet;
import com.wd.doctor.MVP.Http.Utils.RequestNetWardmate;
import com.wd.doctor.MVP.Model.Bean.Patients.FindDepartmentBean;
import com.wd.doctor.MVP.Model.Bean.Patients.FindSickCircleListBean;
import com.wd.doctor.MVP.Model.Bean.Patients.PublishCommentBean;
import com.wd.doctor.MVP.Model.Bean.Patients.SearchSickCircleBean;
import com.wd.doctor.MVP.Model.Bean.Patients.SickCircleInfoBean;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Model
 * @ClassName: WardmateModel
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/13 9:20
 * @UpdateDate: 2019/12/13 9:20
 * @Version: 3.5
 */

//病友圈Model
public class WardmateModel implements WardmateContracter.IModel {
    //病友圈(查询科室列表)
    @Override
    public void getDepartmentModel(IModelCallback callback) {
        RequestNetWardmate.getInstance().create()
                .FIND_DEPARTMENT()
                .compose(CommonSchedulers.<FindDepartmentBean>io2main())
                .subscribe(new CommonObserver<FindDepartmentBean>() {
                    @Override
                    public void onNext(FindDepartmentBean departmentBean) {
                        callback.onSuccess(departmentBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }

    //病友圈列表展示
    @Override
    public void getSickCircleListModel(Integer doctorId, Integer page, Integer count, IModelCallback callback) {
        RequestNet.getInstance().create()
                .SICK_CIRCLE_LIST(doctorId, page, count)
                .compose(CommonSchedulers.<FindSickCircleListBean>io2main())
                .subscribe(new CommonObserver<FindSickCircleListBean>() {
                    @Override
                    public void onNext(FindSickCircleListBean sickCircleListBean) {
                        callback.onWardmateSuccess(sickCircleListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onWardmateFailure(e);
                    }
                });
    }

    //查询病友圈详情
    @Override
    public void getSickCircleInfoModel(String doctorId, String sessionId, String sickCircleId, IModelCallback callback) {
        RequestNet.getInstance().create()
                .SICK_CIRCLE_INFO(doctorId, sessionId, sickCircleId)
                .compose(CommonSchedulers.<SickCircleInfoBean>io2main())
                .subscribe(new CommonObserver<SickCircleInfoBean>() {
                    @Override
                    public void onNext(SickCircleInfoBean circleInfoBean) {
                        callback.onSuccess(circleInfoBean);
                        Logger.d("circleInfoBean", "SickCircleInfo" + circleInfoBean.getMessage());
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }

    //根据关键词查询病友圈
    @Override
    public void getSearchSickCircleModel(String keyWord, IModelCallback callback) {
        RequestNet.getInstance().create()
                .SEARCH_SICK_CIRCLE(keyWord)
                .compose(CommonSchedulers.<SearchSickCircleBean>io2main())
                .subscribe(new CommonObserver<SearchSickCircleBean>() {
                    @Override
                    public void onNext(SearchSickCircleBean searchSickCircleBean) {
                        callback.onSuccess(searchSickCircleBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }

    //发表评论
    @Override
    public void getPublishCommentModel(String doctorId, String sessionId, String sickCircleId, String content, IModelCallback callback) {
        RequestNet.getInstance().create()
                .PUBLISH_COMMENT(doctorId, sessionId, sickCircleId, content)
                .compose(CommonSchedulers.<PublishCommentBean>io2main())
                .subscribe(new CommonObserver<PublishCommentBean>() {
                    @Override
                    public void onNext(PublishCommentBean publishCommentBean) {
                        callback.onWardmateSuccess(publishCommentBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onWardmateFailure(e);
                    }
                });
    }

}
