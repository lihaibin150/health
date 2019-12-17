package com.wd.doctor.MVP.Contracter.API;


import com.wd.doctor.MVP.Model.Bean.Doctor.AllStausBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.ApplyJoinBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.ChooseImagePicBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.CodeBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorHealthyCurrencyNoticeListBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorInquiryNoticeListBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorSystemNoticeListBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.EmailCodeBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.FindDoctorByIdBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.FindDoctorWalletBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.FindSystemImagePicBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.LoginBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.UploadImagePicBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.UserPwdBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.DetailsListBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.EvaluateBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.InquiryBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.MessageBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.RecordBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.RecordListBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.UsrInfoBean;
import com.wd.doctor.MVP.Model.Bean.Patients.FindSickCircleListBean;
import com.wd.doctor.MVP.Model.Bean.Patients.PublishCommentBean;
import com.wd.doctor.MVP.Model.Bean.Patients.SearchSickCircleBean;
import com.wd.doctor.MVP.Model.Bean.Patients.SickCircleInfoBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * 接口
 **/
public interface Api {
    //发送邮箱验证码
    @FormUrlEncoded
    @POST("v1/sendEmailCode")
    Observable<EmailCodeBean> EMAILCODE(@Field("email") String email);

    //登录
    @FormUrlEncoded
    @POST("v1/login")
    Observable<LoginBean> LOGIN(@Field("email") String email, @Field("pwd") String pwd);

    //校验验证码
    @FormUrlEncoded
    @POST("v1/checkCode")
    Observable<CodeBean> CODE_BEAN(@Field("email") String email, @Field("code") String code);

    //重置用户密码（忘记密码用）
    @FormUrlEncoded
    @PUT("v1/resetUserPwd")
    Observable<UserPwdBean> USER_PWD_BEAN(@Field("email") String email, @Field("pwd1") String pwd1, @Field("pwd2") String pwd2);

    //申请入驻
    @POST("v1/applyJoin")
    Observable<ApplyJoinBean> APPLYJOIN(@Query("email") String email, @Query("code") String code, @Query("pwd1") String pwd1, @Query("pwd2") String pwd2, @Query("name") String name, @Query("inauguralHospital") String inauguralHospital, @Query("departmentName") String departmentName, @Query("jobTitle") String jobTitle, @Query("personalProfile") String personalProfile, @Query("goodField") String goodField);

    /*我的*/
    //根据医生id查询医生信息
    @GET("verify/v1/findDoctorById")
    Observable<FindDoctorByIdBean> FINDDOCTORBYID(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId);

    //上传形象照
    @Multipart
    @POST("verify/v1/uploadImagePic")
    Observable<UploadImagePicBean> UPLOADIMAGEPIC(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Part MultipartBody.Part imagePic);

    //查询系统形象照
    @GET("v1/findSystemImagePic")
    Observable<FindSystemImagePicBean> SYSTEMIMAGEPIC();

    //选择系统提供形象照
    @FormUrlEncoded
    @POST("verify/v1/chooseImagePic")
    Observable<ChooseImagePicBean> CHOOSEIMAGEPIC(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Field("imagePic") String imagePic);

    //绑定银行卡
    @POST("verify/v1/bindDoctorBankCard")
    Observable<FindDoctorByIdBean> DOCTOR_BY_ID_BEAN_OBSERVABLE(@Header("doctorId") Integer doctorId, @Header("sessionId") String sessionId, @Query("bankCardNumber") String bankCardNumber, @Query("bankName") String bankName, @Query("bankCardType") Integer bankCardType);

    //查询医生钱包
    @GET("verify/v1/findDoctorWallet")
    Observable<FindDoctorWalletBean> DOCTOR_WALLET(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId);

    /*问诊列表*/
    //查询医生的问诊记录列表
    @GET("inquiry/verify/v1/findInquiryRecordList")
    Observable<RecordListBean> RECORD_LIST(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId);

    //查询用户详细信息
    @GET("inquiry/verify/v1/findUserInfo")
    Observable<UsrInfoBean> USR_INFO(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("userId") Integer userId);

    //结束问诊
    @PUT("inquiry/verify/v1/endInquiry")
    Observable<InquiryBean> INQUIRY(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("recordId") Integer recordId);

    //查询问诊聊天记录
    @PUT("inquiry/verify/v1/findInquiryDetailsList")
    Observable<DetailsListBean> DETAILS_LIST(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("recordId") Integer recordId);

    //发送消息(推送)
    @PUT("inquiry/verify/v1/pushMessage")
    Observable<MessageBean> MESSAGE(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("recordId") Integer recordId);

    //查询医生历史问诊记录列表
    @GET("inquiry/verify/v1/findHistoryInquiryRecord")
    Observable<RecordBean> RECORD(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("page") Integer page, @Query("count") Integer count);

    //查询问诊评价详情
    @GET("inquiry/verify/v1/findDoctorEvaluate")
    Observable<EvaluateBean> EVALUATE(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("recordId") Integer recordId);

    /*病友圈*/
    //病友圈列表展示
    @GET("sickCircle/v1/findSickCircleList")
    Observable<FindSickCircleListBean> SICK_CIRCLE_LIST(@Query("departmentId") Integer departmentId, @Query("page") Integer page, @Query("count") Integer count);

    //查询病友圈详情
    @GET("sickCircle/v1/findSickCircleInfo")
    Observable<SickCircleInfoBean> SICK_CIRCLE_INFO(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("sickCircleId") String sickCircleId);

    //根据关键词查询病友圈
    @GET("sickCircle/v1/searchSickCircle")
    Observable<SearchSickCircleBean> SEARCH_SICK_CIRCLE(@Query("keyWord") String keyWord);

    //发表评论
    @POST("sickCircle/verify/v1/publishComment")
    Observable<PublishCommentBean> PUBLISH_COMMENT(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("sickCircleId") String sickCircleId, @Query("content") String content);

    /*消息*/
    //修改消息状态为全部已读
    @PUT("verify/v1/modifyAllStatus")
    Observable<AllStausBean> ALL_STAUS(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId);

    //查询系统通知消息
    @GET("verify/v1/findDoctorSystemNoticeList")
    Observable<DoctorSystemNoticeListBean> DOCTOR_SYSTEM(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("page") Integer page, @Query("count") Integer count);

    //查询问诊通知消息
    @GET("verify/v1/findDoctorInquiryNoticeList")
    Observable<DoctorInquiryNoticeListBean> DOCTOR_INQUIRY(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("page") Integer page, @Query("count") Integer count);

    //查询H币通知消息
    @GET("verify/v1/findDoctorHealthyCurrencyNoticeList")
    Observable<DoctorHealthyCurrencyNoticeListBean> DOCTOR_HEALTHY(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("page") Integer page, @Query("count") Integer count);
}
