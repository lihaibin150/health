package com.wd.doctor.MVP.View.MyActivity.unbindactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//银行卡
import com.bwei.example.mylibrary.Base.BaseActivity;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.R;
//银行卡
public class BankCardActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bank_card;
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
    public void onImgSuccess(Object data) {

    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onImgFailure(Throwable e) {

    }
}
