package com.wd.doctor.MVP.View.LoginActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Test.IntentUtils;
import com.wd.doctor.MVP.Contracter.LoginContracter;
import com.wd.doctor.MVP.Presenter.LoginPresenter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//申请入驻
public class ApplyJoinActivity extends BaseActivity<LoginPresenter> implements LoginContracter.ILoginView {

    @BindView(R.id.apply_et_email)
    EditText applyEtEmail;
    @BindView(R.id.apply_tv_verificationcode)
    TextView applyVerifiCationcode;
    @BindView(R.id.apply_et_code)
    EditText applyEtCode;
    @BindView(R.id.apply_et_pwd)
    EditText applyEtPwd;
    @BindView(R.id.togg_apply_eye_e)
    ToggleButton toggApplyEyeE;
    @BindView(R.id.apply_et_pwd_two)
    EditText applyEtPwdTwo;
    @BindView(R.id.togg_apply_eye)
    ToggleButton toggApplyEye;
    @BindView(R.id.apply_bt_next)
    Button applyBtNext;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_apply_join;
    }

    @Override
    public LoginPresenter mPresenter() {
        return null;
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

    @OnClick({R.id.apply_tv_verificationcode, R.id.apply_bt_next})
    public void onClick(View view) {
        switch (view.getId()) {
            //验证码
            case R.id.apply_tv_verificationcode:

                break;
                //下一步
            case R.id.apply_bt_next:
                IntentUtils.getInstence().intentStart(ApplyJoinActivity.this,InformationActivity.class);
                break;
        }
    }
}
