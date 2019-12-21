package com.wd.doctor.MVP.View.loginActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.Logger;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.wd.doctor.MVP.Contracter.LoginContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.EmailCodeBean;
import com.wd.doctor.MVP.Presenter.LoginPresenter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//忘记密码
public class UsePwdActivity extends BaseActivity<LoginPresenter> implements LoginContracter.ILoginView {

    private static final String TAG = "UsePwdActivity";
    @BindView(R.id.img_back_forget)
    ImageView imgBackForget;
    @BindView(R.id.et_forget_email)
    EditText etForgetEmail;
    @BindView(R.id.bt_code_forget)
    Button btCodeForget;
    @BindView(R.id.et_forget_pwd)
    EditText etForgetPwd;
    @BindView(R.id.bt_next_forget)
    Button btNextForget;
    private String mEmail;
    private String mPwd;
    private SPUtils mSpUtils;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_use_pwd;
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
        mSpUtils = new SPUtils(UsePwdActivity.this, "UsePwdActivity");
        boolean log = mSpUtils.getBoolean("logUse", true);
        if (log) {
            etForgetEmail.setText(mSpUtils.getString("mEmail", ""));
        }
        mEmail = etForgetEmail.getText().toString().trim();
        mPwd = etForgetPwd.getText().toString().trim();
    }
    @Override
    public void onEmailCodeSuccess(Object data) {
        EmailCodeBean emailCodeBean= (EmailCodeBean) data;
        Logger.d(TAG,"emailCode:"+emailCodeBean.message);
        if ("0000".equals(emailCodeBean.status)){
            mSpUtils.putBoolean("logUse", true);
            mSpUtils.putString("mEmail", mEmail);
            Intent intent = new Intent(UsePwdActivity.this, UsePwdTwoActivity.class);
            intent.putExtra("email",mEmail);
            startActivity(intent);
            finish();
        }
    }
    @Override
    public void onLoginSuccess(Object data) {

    }

    @OnClick({R.id.img_back_forget, R.id.bt_code_forget, R.id.bt_next_forget})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back_forget:
                finish();
                break;
            case R.id.bt_code_forget:

                mP.PostEmailCodePresenter(mEmail);
                Logger.d(TAG,"em"+mEmail);
                break;
            case R.id.bt_next_forget:
                mP.PostCodePresenter(mEmail, mPwd);
//                        IntentUtils.getInstence().intentStart(UsePwdActivity.this, UsePwdTwoActivity.class);

                break;
        }
    }

    @Override
    public void onApplyJoinSuccess(Object data) {

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

}
