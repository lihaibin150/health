package com.wd.doctor.MVP.View.LoginActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Test.IntentUtils;
import com.bwei.example.mylibrary.Test.Logger;
import com.bwei.example.mylibrary.Test.SPUtils;
import com.bwei.example.mylibrary.Test.ToastUtils;
import com.wd.doctor.MVP.Contracter.LoginContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.LoginBean;
import com.wd.doctor.MVP.Model.MD5.RsaCoder;
import com.wd.doctor.MVP.Presenter.LoginPresenter;
import com.wd.doctor.MVP.View.MyActivity.SetImageActivity;
import com.wd.doctor.MainShowActivity;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContracter.ILoginView {

    private static final String TAG = "LoginActivity";
    @BindView(R.id.login_et_email)
    EditText loginEtEmail;
    @BindView(R.id.login_et_pwd)
    EditText loginEtPwd;
    @BindView(R.id.togg_log_eye)
    ToggleButton toggLogEye;
    @BindView(R.id.login_usepwd)
    TextView loginUsepwd;
    @BindView(R.id.login_applyJoin)
    TextView loginApplyJoin;
    @BindView(R.id.login_bt_but)
    Button loginBtBut;
    @BindView(R.id.login_eye_b)
    ImageView loginEyeB;
    private LoginBean mLoginBean;
    private String mEncryptpwd;
    private SPUtils mSpUtils;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
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
        mSpUtils = new SPUtils(LoginActivity.this, "LoginActivity");
        boolean log = mSpUtils.getBoolean("log", true);
        if (log) {
            loginEtEmail.setText(mSpUtils.getString("email", ""));
            loginEtPwd.setText(mSpUtils.getString("pwd", ""));
        }
        loginEtPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());//默认为隐藏
        loginEyeB.setBackgroundResource(R.mipmap.login_icon_lock_n);//默认锁头(关)
        toggLogEye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //判断事件源的选中状态
                if (isChecked) {
                    //显示密码
                    loginEtPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    toggLogEye.setBackgroundResource(R.drawable.login_z);//选中时显示的图标
                    loginEyeB.setBackgroundResource(R.mipmap.login_icon_unlock_n);//锁头(开)
                } else {
                    //设置转换方法
                    loginEtPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    toggLogEye.setBackgroundResource(R.mipmap.login_yc);//选中时隐藏的图标
                    loginEyeB.setBackgroundResource(R.mipmap.login_icon_lock_n);//锁头(关)
                }
                //每次显示或者关闭时，密码显示编辑的线不统一在最后，下面是为了统一
                loginEtPwd.setSelection(loginEtPwd.length());//设置选择
            }
        });
    }

    @Override
    public void onLoginSuccess(Object data) {
        mLoginBean = (LoginBean) data;
        //存值
        SPUtils spUtils = new SPUtils(LoginActivity.this, "LoginId");
        spUtils.putString("Id", mLoginBean.getResult().getId() + "");//医生id
        spUtils.putString("SessionId", mLoginBean.getResult().getSessionId());
        spUtils.putString("ImagePicId", mLoginBean.getResult().getWhetherHaveImagePic() + "");//形象照
        spUtils.putString("dataName", mLoginBean.getResult().getName());
        spUtils.putString("dataJobTitle", mLoginBean.getResult().getJobTitle());
        spUtils.putString("dataInauguralHospital", mLoginBean.getResult().getInauguralHospital());
        spUtils.putString("dataDepartmentName", mLoginBean.getResult().getDepartmentName());

        Logger.d(TAG, "mLoginBean:" + mLoginBean);
        if ("0000".equals(mLoginBean.getStatus())) {
            if (mLoginBean.getResult().getWhetherHaveImagePic() == 1) {
                //跳转首页
                IntentUtils.getInstence().intentStart(LoginActivity.this, MainShowActivity.class);
                ToastUtils.show("登录成功");
            } else {
                //跳转形象照
                IntentUtils.getInstence().intentStart(LoginActivity.this, SetImageActivity.class);
                ToastUtils.show("当前无形象照,进入形象照");
            }
            finish();

        } else {
            ToastUtils.show("登录失败");
        }
    }

    @OnClick({R.id.login_usepwd, R.id.login_applyJoin, R.id.login_bt_but})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_usepwd://忘记密码
                IntentUtils.getInstence().intentStart(LoginActivity.this, UsePwdActivity.class);
                break;
            case R.id.login_applyJoin:
                IntentUtils.getInstence().intentStart(LoginActivity.this, ApplyJoinActivity.class);
                break;
            case R.id.login_bt_but:
                String mEmail = loginEtEmail.getText().toString();
                String mPwd = loginEtPwd.getText().toString();
                if (!mEmail.isEmpty() || !mPwd.isEmpty()) {
                    try {
                        mEncryptpwd = RsaCoder.encryptByPublicKey(mPwd);
                        mSpUtils.putBoolean("log", true);
                        mSpUtils.putString("email", mEmail);
                        mSpUtils.putString("pwd", mPwd);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    mP.PostLoginPresenter(mEmail, mEncryptpwd);
                } else {
                    ToastUtils.show("输入不能为空");
                }

                break;
        }
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
}
