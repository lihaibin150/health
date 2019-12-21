package com.wd.doctor.MVP.View.loginActivity;

import android.os.Bundle;
import android.widget.Button;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.IntentUtils;
import com.wd.doctor.MVP.Contracter.LoginContracter;
import com.wd.doctor.MVP.Presenter.LoginPresenter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//信息
public class InformationActivity extends BaseActivity<LoginPresenter> implements LoginContracter.ILoginView {

    @BindView(R.id.but_netgeren)
    Button butNetgeren;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_information;
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

    @OnClick(R.id.but_netgeren)
    public void onClick() {
        IntentUtils.getInstence().intentStart(InformationActivity.this,PersonalActivity.class);
    }
}
