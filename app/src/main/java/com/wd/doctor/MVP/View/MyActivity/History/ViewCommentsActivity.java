package com.wd.doctor.MVP.View.MyActivity.History;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.Logger;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.bwei.example.mylibrary.Tools.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.InterrogationContracter;
import com.wd.doctor.MVP.Model.Bean.Interrogation.EvaluateBean;
import com.wd.doctor.MVP.Presenter.InterrogationPresenter;
import com.wd.doctor.R;
import com.wd.doctor.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//查看评价
public class ViewCommentsActivity extends BaseActivity<InterrogationPresenter> implements InterrogationContracter.IView {

    private static final String TAG = "ViewCommentsActivity";
    @BindView(R2.id.comments_sim_view)
    SimpleDraweeView commentsSimView;
    @BindView(R2.id.comments_doctor)
    TextView commentsDoctor;
    @BindView(R2.id.comments_doctor_rating_bar)
    RatingBar commentsDoctorRatingBar;
    @BindView(R2.id.comments_service_rating_bar)
    RatingBar commentsServiceRatingBar;
    @BindView(R2.id.comments_gift_sim)
    SimpleDraweeView commentsGiftSim;
    private String mId;
    private String mSessionId;
    private int mRecordId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_view_comments;
    }

    @Override
    protected void initData() {
        //查询医生的问诊记录列表
        SPUtils spRecordId = new SPUtils(ViewCommentsActivity.this, "InterrogationRecordId");
        mRecordId = spRecordId.getInt("recordId");
        SPUtils spUtils = new SPUtils(ViewCommentsActivity.this, "LoginId");
        mId = spUtils.getString("Id", "");
        mSessionId = spUtils.getString("SessionId", "");
        mP.getEvaluatePresenter(mId, mSessionId, mRecordId);
    }

    @Override
    public void onSuccess(Object data) {
        EvaluateBean evaluateBean = (EvaluateBean) data;
        EvaluateBean.ResultBean result = evaluateBean.getResult();
        Logger.d(TAG, "EvaluateBean:" + evaluateBean.getMessage());
        if ("0000".equals(evaluateBean.getStatus())) {
            if (result!=null){
                commentsDoctor.setText(result.getMajorDegree());
                commentsDoctorRatingBar.setRating(result.getSatisfactionDegree());
            }
        }
    }

    @Override
    public void onDetailsListSuccess(Object data) {

    }


    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onDetailsListFailure(Throwable e) {

    }

    @Override
    public InterrogationPresenter mPresenter() {
        return new InterrogationPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.comments_sim_view)
    public void onClick() {
        finish();
    }
}
