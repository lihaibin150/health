package com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.Logger;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorInquiryNoticeListBean;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.MessagAdapter.AllIAdapter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//问诊消息
public class AllInterrogationActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    private static final String TAG = "AllInterrogationActivity";
    @BindView(R.id.all_interr_backk)
    SimpleDraweeView allInterrBackk;
    @BindView(R.id.all_interr_recycler)
    RecyclerView allInterrRecycler;
    private String mId;
    private String mSessionId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_all_interrogation;
    }

    @Override
    public HomePresenter mPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        SPUtils sploginUtils = new SPUtils(AllInterrogationActivity.this, "LoginId");
        mId = sploginUtils.getString("Id", "");
        mSessionId = sploginUtils.getString("SessionId", "");
        mP.getInquiryPresenter(mId, mSessionId, 1, 5);
    }

    @Override
    public void onSuccess(Object data) {
        DoctorInquiryNoticeListBean inquiryNoticeListBean = (DoctorInquiryNoticeListBean) data;
        DoctorInquiryNoticeListBean.ResultBean result = inquiryNoticeListBean.result;
        Logger.d(TAG,"DoctorInquiryNoticeList:"+result.content);

        if (result.content==null){

        }else {
            allInterrRecycler.setLayoutManager(new LinearLayoutManager(AllInterrogationActivity.this));
            allInterrRecycler.setAdapter(new AllIAdapter(AllInterrogationActivity.this, result));
        }
    }

    @Override
    public void onImgSuccess(Object data) {

    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onImgFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.all_interr_backk)
    public void onClick() {
        finish();
    }
}
