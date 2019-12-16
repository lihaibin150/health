package com.wd.doctor.MVP.Model;

import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Contracter.LoginContracter;
import com.wd.doctor.MVP.Http.Utils.CommonObserver;
import com.wd.doctor.MVP.Http.Utils.CommonSchedulers;
import com.wd.doctor.MVP.Http.Utils.RequestNet;
import com.wd.doctor.MVP.Model.Bean.Doctor.ApplyJoinBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.CodeBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.EmailCodeBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.LoginBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.UserPwdBean;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Model
 * @ClassName: LoginModel
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/11 17:03
 * @UpdateDate: 2019/12/11 17:03
 * @Version: 3.5
 */

/**
 * 声明规范：
 * 1、命名规范为 "${业务模块}Model"  如：我的模块 Model 命名为 "HomeModel"
 * 2、必须 implements 对应锲约中的IModel接口 如: {@link HomeContracter.IModel}
 * <p>
 * <p>
 * 使用规范：
 * 1、使用 {@link com.wd.doctor.MVP.Http.Utils.RequestNet} 类的 create() 方法构造默认的IApi
 * 2、使用 compose()配合 {@link CommonSchedulers} 切换线程
 * 3、使用 {@link CommonObserver} 代替 {@link io.reactivex.Observer} ,避免每次强制重写 onSubscribe() 和 onComplete()
 */
public class LoginModel implements LoginContracter.ILoginModel {
    //验证码
    @Override
    public void PostEmailCodeModel(String email, ILoginModelCallback callback) {
        RequestNet.getInstance().create()
                .EMAILCODE(email)
                .compose(CommonSchedulers.<EmailCodeBean>io2main())
                .subscribe(new CommonObserver<EmailCodeBean>() {
                    @Override
                    public void onNext(EmailCodeBean emailCodeBean) {
                        callback.onEmailCodeSuccess(emailCodeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onEmailCodeFailure(e);
                    }
                });
    }

    //登录
    @Override
    public void PostLoginModel(String email, String pwd, ILoginModelCallback callback) {
        RequestNet.getInstance().create()
                .LOGIN(email, pwd)
                .compose(CommonSchedulers.<LoginBean>io2main())
                .subscribe(new CommonObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        callback.onLoginSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onLoginFailure(e);
                    }
                });
    }

    //校验验证码
    @Override
    public void PostCodeModel(String email, String code, ILoginModelCallback callback) {
        RequestNet.getInstance().create()
                .CODE_BEAN(email, code)
                .compose(CommonSchedulers.<CodeBean>io2main())
                .subscribe(new CommonObserver<CodeBean>() {
                    @Override
                    public void onNext(CodeBean codeBean) {
                        callback.onEmailCodeSuccess(codeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onEmailCodeFailure(e);
                    }
                });
    }

    //重置用户密码（忘记密码用）
    @Override
    public void PutUserPwdModel(String email, String pwd1, String pwd2, ILoginModelCallback callback) {
        RequestNet.getInstance().create()
                .USER_PWD_BEAN(email, pwd1, pwd2)
                .compose(CommonSchedulers.<UserPwdBean>io2main())
                .subscribe(new CommonObserver<UserPwdBean>() {
                    @Override
                    public void onNext(UserPwdBean userPwdBean) {
                        callback.onLoginSuccess(userPwdBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onLoginFailure(e);
                    }
                });
    }

    //申请入驻
    @Override
    public void PostApplyJoinModel(String email, String code, String pwd1, String pwd2, String name, String inauguralHospital, String departmentName, String jobTitle, String personalProfile, String goodField, ILoginModelCallback callback) {
        RequestNet.getInstance().create()
                .APPLYJOIN(email, code, pwd1, pwd2, name, inauguralHospital, departmentName, jobTitle, personalProfile, goodField)
                .compose(CommonSchedulers.<ApplyJoinBean>io2main())
                .subscribe(new CommonObserver<ApplyJoinBean>() {
                    @Override
                    public void onNext(ApplyJoinBean applyJoinBean) {
                        callback.onLoginSuccess(applyJoinBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onLoginFailure(e);
                    }
                });
    }
}
