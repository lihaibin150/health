package com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.R;
//问诊消息
public class AllInterrogationActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView  {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_all_interrogation;
    }

    @Override
    public HomePresenter mPresenter() {
        return null;
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
    public void onFailure(Throwable e) {

    }
}
