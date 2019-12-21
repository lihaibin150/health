package com.wd.doctor.MVP.View.loginActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.IntentUtils;
import com.bwei.example.mylibrary.Tools.ToastUtils;
import com.wd.doctor.MVP.Contracter.LoginContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.ApplyJoinBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.EmailCodeBean;
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
    @BindView(R.id.apply_code_hong)
    TextView applyCodeHong;
    @BindView(R.id.apply_pwd_hong)
    TextView applyPwdHong;
    @BindView(R.id.apply_pwd_two_hong)
    TextView applyPwdTwoHong;
    @BindView(R.id.apply_pwd_next)
    TextView applyPwdNext;
    @BindView(R.id.apply_email_hong)
    TextView applyEmailHong;
    private EmailCodeBean mEmailCodeBean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_apply_join;
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
        String mEmail = applyEtEmail.getText().toString().trim();
        String pwd = applyEtPwd.getText().toString().trim();
        String pwdtwo = applyEtPwdTwo.getText().toString().trim();

//        mP.PostApplyJoinPresenter();
        applyEtPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());//默认为隐藏
        toggApplyEyeE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //判断事件源的选中状态
                if (isChecked) {
                    //显示密码
                    applyEtPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//密码显示
                    toggApplyEyeE.setBackgroundResource(R.drawable.login_z);//选中时显示的图标
                } else {
                    //设置转换方法
                    applyEtPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());//密码隐藏
                    toggApplyEyeE.setBackgroundResource(R.mipmap.login_yc);//选中时隐藏的图标
                }
                //每次显示或者关闭时，密码显示编辑的线不统一在最后，下面是为了统一
                applyEtPwd.setSelection(applyEtPwd.length());//设置选择
            }
        });
        applyEtPwdTwo.setTransformationMethod(PasswordTransformationMethod.getInstance());//默认为隐藏
        toggApplyEye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //判断事件源的选中状态
                if (isChecked) {
                    //显示密码
                    applyEtPwdTwo.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//密码显示
                    toggApplyEye.setBackgroundResource(R.drawable.login_z);//选中时显示的图标
                } else {
                    //设置转换方法
                    applyEtPwdTwo.setTransformationMethod(PasswordTransformationMethod.getInstance());//密码隐藏
                    toggApplyEye.setBackgroundResource(R.mipmap.login_yc);//选中时隐藏的图标
                }
                //每次显示或者关闭时，密码显示编辑的线不统一在最后，下面是为了统一
                applyEtPwdTwo.setSelection(applyEtPwdTwo.length());//设置选择
            }
        });
    }

    @Override
    public void onLoginSuccess(Object data) {
        ApplyJoinBean applyJoinBean = (ApplyJoinBean) data;

    }

    //验证码
    @Override
    public void onEmailCodeSuccess(Object data) {
        mEmailCodeBean = (EmailCodeBean) data;

    }

    @OnClick({R.id.apply_tv_verificationcode, R.id.apply_bt_next, R.id.apply_et_code, R.id.apply_et_pwd, R.id.apply_et_pwd_two, R.id.apply_et_email})
    public void onClick(View view) {
        switch (view.getId()) {
            //验证码
            case R.id.apply_tv_verificationcode:
                String mEmail = applyEtEmail.getText().toString().trim();
                if (!TextUtils.isEmpty(mEmail)) {
                    ToastUtils.show(mEmailCodeBean.message);
                    mP.PostEmailCodePresenter(mEmail);
                } else {
                    ToastUtils.show("邮箱不能为空");
                    applyEmailHong.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.apply_et_email://点击邮箱隐藏提示
                applyEmailHong.setVisibility(View.GONE);
                break;
            //下一步
            case R.id.apply_bt_next:
                String mCode = applyEtCode.getText().toString().trim();
//                String mEmail = applyEtEmail.getText().toString().trim();
                String mPwd = applyEtPwd.getText().toString().trim();
                String mPwdTwo = applyEtPwdTwo.getText().toString().trim();
                if (!TextUtils.isEmpty(mCode) || !TextUtils.isEmpty(mPwd)) {
                    IntentUtils.getInstence().intentStart(ApplyJoinActivity.this, InformationActivity.class);
                } else {
                    ToastUtils.show("输入不能为空");
                    applyCodeHong.setVisibility(View.VISIBLE);
                    applyPwdTwoHong.setVisibility(View.VISIBLE);
                    applyPwdHong.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.apply_et_code://点击请输入验证码关闭提示
                applyCodeHong.setVisibility(View.GONE);
                break;
            case R.id.apply_et_pwd://点击密码关闭提示
                applyPwdHong.setVisibility(View.GONE);
                break;
            case R.id.apply_et_pwd_two://点击密码关闭提示
                applyPwdTwoHong.setVisibility(View.GONE);
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
