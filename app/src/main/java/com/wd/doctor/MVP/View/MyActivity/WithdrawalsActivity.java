package com.wd.doctor.MVP.View.MyActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.R;
import com.wd.doctor.R2;

//提现页面
public class WithdrawalsActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_withdrawals;
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
}
