package com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Test.Logger;
import com.bwei.example.mylibrary.Test.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorSystemNoticeListBean;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.MessagAdapter.AllSAdapter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//系统消息
public class AllSystemActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    private static final String TAG = "AllSystemActivity";
    @BindView(R.id.system_all_backk)
    SimpleDraweeView systemAllBackk;
    @BindView(R.id.system_all_recycler)
    RecyclerView systemAllRecycler;
    @BindView(R.id.all_system_meassge)
    RelativeLayout mAllSystem;
    @BindView(R.id.img_yg)
    ImageView mSystem;
    private String mId;
    private String mSessionId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_all_system;
    }

    @Override
    public HomePresenter mPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        SPUtils sploginUtils = new SPUtils(AllSystemActivity.this, "LoginId");
        mId = sploginUtils.getString("Id", "");
        mSessionId = sploginUtils.getString("SessionId", "");
        mP.getSystemPresenter(mId, mSessionId, 1, 5);
    }

    @Override
    public void onSuccess(Object data) {
        DoctorSystemNoticeListBean systemNoticeListBean = (DoctorSystemNoticeListBean) data;
        DoctorSystemNoticeListBean.ResultBean result = systemNoticeListBean.result;
        Logger.d(TAG, "DoctorSystemNoticeList:" + result.content);
        if (result.content==null){
            mAllSystem.setVisibility(View.VISIBLE);
        }else {
            systemAllRecycler.setLayoutManager(new LinearLayoutManager(AllSystemActivity.this));
            systemAllRecycler.setAdapter(new AllSAdapter(AllSystemActivity.this, result));
        }
    }

    @Override
    protected void initView() {

    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.system_all_backk)
    public void onClick() {
        finish();
    }
}
