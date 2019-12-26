package com.wd.doctor.MVP.View.Interrogation;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.Logger;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.bwei.example.mylibrary.Tools.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.InterrogationContracter;
import com.wd.doctor.MVP.Model.Bean.Interrogation.UsrInfoBean;
import com.wd.doctor.MVP.Presenter.InterrogationPresenter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//问诊详情(查询用户详细信息)
public class DetailedInquiryActivity extends BaseActivity<InterrogationPresenter> implements InterrogationContracter.IView {

    private static final String TAG = "DetailedInquiryActivity";
    @BindView(R.id.detailed_sim_head_portrait)
    SimpleDraweeView detailedSimHeadPortrait;
    @BindView(R.id.detailed_text_name)
    TextView detailedTextName;
    @BindView(R.id.detailed_text_disease)
    TextView detailedTextDisease;
    @BindView(R.id.detailed_text_departments)
    TextView detailedTextDepartments;
    @BindView(R.id.detailed_text_details)
    TextView detailedTextDetails;
    @BindView(R.id.detailed_text_type)
    TextView detailedTextType;
    @BindView(R.id.detailed_text_view)
    TextView detailedTextView;
    @BindView(R.id.detailed_text_time)
    TextView detailedTextTime;
    @BindView(R.id.detailed_image_img)
    ImageView detailedImageImg;
    @BindView(R.id.detailed_sim_backk)
    SimpleDraweeView detailedSimBackk;
    @BindView(R.id.detailed_sim_ead_portrait)
    SimpleDraweeView detailedSimEadPortrait;
    private String mId;
    private String mSessionId;
    private int mUserId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detailed_inquiry;
    }

    @Override
    protected void initData() {
        SPUtils spUserId = new SPUtils(DetailedInquiryActivity.this, "RecordList");
        mUserId = spUserId.getInt("userId");
        SPUtils spUtils = new SPUtils(DetailedInquiryActivity.this, "LoginId");
        mId = spUtils.getString("Id", "");
        mSessionId = spUtils.getString("SessionId", "");
        mP.getUserInfoPresenter(mId, mSessionId, 436);
        Logger.d(TAG, "mUserId" + mUserId);


    }

    @Override
    public void onSuccess(Object data) {
//        UsrInfoBean usrInfoBean = (UsrInfoBean) data;
//        Logger.d(TAG, "usrInfoBean:" + usrInfoBean.getMessage());
      /*  UsrInfoBean.ResultBean result = usrInfoBean.getResult();
        if (result != null) {
            detailedTextName.setText(result.getNickName());
        } else {
            ToastUtils.show(usrInfoBean.getMessage());
            detailedTextName.setVisibility(View.GONE);
        }*/

    }

    @Override
    public InterrogationPresenter mPresenter() {
        return new InterrogationPresenter();
    }

    @Override
    protected void initView() {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.detailed_sim_backk)
    public void onClick() {
        finish();
    }
}
