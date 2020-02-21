package com.wd.doctor.MVP.View.MyActivity;

import android.os.Bundle;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.R;
import com.wd.doctor.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//设置自动回复
public class AutomaticActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    @BindView(R2.id.automatic_sim)
    SimpleDraweeView automaticSim;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_automatic;
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

    }

    @Override
    public void onSuccess(Object data) {

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

    @OnClick(R.id.automatic_sim)
    public void onClick() {
        finish();
    }
}
