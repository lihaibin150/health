package com.wd.doctor.MVP.Contracter;

import com.bwei.example.mylibrary.Base.IBaseView;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Contracter
 * @ClassName: LoginContracter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/11 16:56
 * @UpdateDate: 2019/12/11 16:56
 * @Version: 3.5
 */


public interface LoginContracter {
    //model层   命名必须是IModel
    interface ILoginModel {

        //发送邮箱验证码
        void PostEmailCodeModel(String email,
                                ILoginModelCallback callback);

        //登录
        void PostLoginModel(String email,
                            String pwd,
                            ILoginModelCallback callback);

        //校验验证码
        void PostCodeModel(String email,
                           String code,
                           ILoginModelCallback callback);

        //重置用户密码（忘记密码用）
        void PutUserPwdModel(String email,
                             String pwd1,
                             String pwd2,
                             ILoginModelCallback callback);

        //申请入驻
        void PostApplyJoinModel(String email, String code,
                                String pwd1,
                                String pwd2,
                                String name,
                                String inauguralHospital,
                                String departmentName,
                                String jobTitle,
                                String personalProfile,
                                String goodField,
                                ILoginModelCallback callback);

        //model层中的接口回调
        interface ILoginModelCallback {
            void onLoginSuccess(Object data);

            void onApplyJoinSuccess(Object data);

            void onEmailCodeSuccess(Object data);

            void onLoginFailure(Throwable e);

            void onApplyJoinFailure(Throwable e);

            void onEmailCodeFailure(Throwable e);
        }
    }

    //view层  命名必须是IView
    interface ILoginView extends IBaseView {
        void onLoginSuccess(Object data);

        void onApplyJoinSuccess(Object data);

        void onEmailCodeSuccess(Object data);

        void onLoginFailure(Throwable e);

        void onApplyJoinFailure(Throwable e);

        void onEmailCodeFailure(Throwable e);
    }

    //presenter层   命名必须是IPresenter
    interface ILoginPresenter {
        //登录
        void PostLoginPresenter(String email, String pwd);

        //申请入驻
        void PostApplyJoinPresenter(String email, String code,
                                    String pwd1,
                                    String pwd2,
                                    String name,
                                    String inauguralHospital,
                                    String departmentName,
                                    String jobTitle,
                                    String personalProfile,
                                    String goodField);

        //发送邮箱验证码
        void PostEmailCodePresenter(String email);

        //校验验证码
        void PostCodePresenter(String email,
                               String code);

        //重置用户密码（忘记密码用）
        void PutUserPwdPresenter(String email,
                                 String pwd1,
                                 String pwd2);
    }
}
