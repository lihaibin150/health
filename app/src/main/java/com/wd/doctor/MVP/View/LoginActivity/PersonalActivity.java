package com.wd.doctor.MVP.View.LoginActivity;

import android.os.Bundle;
import android.widget.Button;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Test.IntentUtils;
import com.wd.doctor.MVP.Contracter.LoginContracter;
import com.wd.doctor.MVP.Presenter.LoginPresenter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
//个人简介
public class PersonalActivity extends BaseActivity<LoginPresenter> implements LoginContracter.ILoginView {

    @BindView(R.id.but_settled)
    Button butSettled;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal;
    }

    @Override
    public LoginPresenter mPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onLoginSuccess(Object data) {

    }

    @Override
    public void onApplyJoinSuccess(Object data) {

    }

    @Override
    public void onEmailCodeSuccess(Object data) {

    }

    @Override
    public void onLoginFailure(Throwable e) {

    }

    @Override
    public void onApplyJoinFailure(Throwable e) {

    }

    @Override
    public void onEmailCodeFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.but_settled)
    public void onClick() {
        IntentUtils.getInstence().intentStart(PersonalActivity.this,CompleteActivity. class);
    }
}
