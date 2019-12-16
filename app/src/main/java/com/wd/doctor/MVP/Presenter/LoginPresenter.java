package com.wd.doctor.MVP.Presenter;

import com.bwei.example.mylibrary.Base.BasePresenter;
import com.wd.doctor.MVP.Contracter.API.Constant;
import com.wd.doctor.MVP.Contracter.LoginContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.LoginBean;
import com.wd.doctor.MVP.Model.LoginModel;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Presenter
 * @ClassName: LoginPresenter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/11 17:23
 * @UpdateDate: 2019/12/11 17:23
 * @Version: 3.5
 */


public class LoginPresenter extends BasePresenter<LoginContracter.ILoginView> implements LoginContracter.ILoginPresenter {

    private LoginModel mLoginModel;

    @Override
    protected void initModel() {
        mLoginModel = new LoginModel();
    }

    //登录
    @Override
    public void PostLoginPresenter(String email, String pwd) {
        mLoginModel.PostLoginModel(email, pwd, new LoginContracter.ILoginModel.ILoginModelCallback() {
            @Override
            public void onLoginSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()){
                    getView().onLoginSuccess(data);
                    if (data!=null&& Constant.SUCCESS_CODE.equals(LoginBean.class)){
                    }else {
                        getView().onLoginFailure(new Exception("服务器异常"));
                    }
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
                getView().onLoginFailure(e);
            }

            @Override
            public void onApplyJoinFailure(Throwable e) {

            }

            @Override
            public void onEmailCodeFailure(Throwable e) {

            }
        });
    }

    //注册
    @Override
    public void PostApplyJoinPresenter(String email, String code, String pwd1, String pwd2, String name, String inauguralHospital, String departmentName, String jobTitle, String personalProfile, String goodField) {
        mLoginModel.PostApplyJoinModel(email, code, pwd1, pwd2, name, inauguralHospital, departmentName, jobTitle, personalProfile, goodField, new LoginContracter.ILoginModel.ILoginModelCallback() {
            @Override
            public void onLoginSuccess(Object data) {
                getView().onLoginSuccess(data);
            }

            @Override
            public void onApplyJoinSuccess(Object data) {

            }

            @Override
            public void onEmailCodeSuccess(Object data) {

            }

            @Override
            public void onLoginFailure(Throwable e) {
                getView().onLoginFailure(e);
            }

            @Override
            public void onApplyJoinFailure(Throwable e) {

            }

            @Override
            public void onEmailCodeFailure(Throwable e) {

            }
        });
    }

    //验证码
    @Override
    public void PostEmailCodePresenter(String email) {
        mLoginModel.PostEmailCodeModel(email, new LoginContracter.ILoginModel.ILoginModelCallback() {
            @Override
            public void onLoginSuccess(Object data) {
                getView().onEmailCodeSuccess(data);
            }

            @Override
            public void onApplyJoinSuccess(Object data) {

            }

            @Override
            public void onEmailCodeSuccess(Object data) {

            }

            @Override
            public void onLoginFailure(Throwable e) {
                getView().onEmailCodeFailure(e);
            }

            @Override
            public void onApplyJoinFailure(Throwable e) {

            }

            @Override
            public void onEmailCodeFailure(Throwable e) {

            }
        });
    }

    //校验验证码
    @Override
    public void PostCodePresenter(String email, String code) {
        mLoginModel.PostCodeModel(email, code, new LoginContracter.ILoginModel.ILoginModelCallback() {
            @Override
            public void onLoginSuccess(Object data) {
                getView().onEmailCodeSuccess(data);
            }

            @Override
            public void onApplyJoinSuccess(Object data) {

            }

            @Override
            public void onEmailCodeSuccess(Object data) {

            }

            @Override
            public void onLoginFailure(Throwable e) {
                getView().onEmailCodeFailure(e);
            }

            @Override
            public void onApplyJoinFailure(Throwable e) {

            }

            @Override
            public void onEmailCodeFailure(Throwable e) {

            }
        });
    }

    //重置用户密码（忘记密码用）
    @Override
    public void PutUserPwdPresenter(String email, String pwd1, String pwd2) {
        mLoginModel.PutUserPwdModel(email, pwd1, pwd2, new LoginContracter.ILoginModel.ILoginModelCallback() {
            @Override
            public void onLoginSuccess(Object data) {
                getView().onLoginSuccess(data);
            }

            @Override
            public void onApplyJoinSuccess(Object data) {

            }

            @Override
            public void onEmailCodeSuccess(Object data) {

            }

            @Override
            public void onLoginFailure(Throwable e) {
                getView().onLoginFailure(e);
            }

            @Override
            public void onApplyJoinFailure(Throwable e) {

            }

            @Override
            public void onEmailCodeFailure(Throwable e) {

            }
        });
    }
}
