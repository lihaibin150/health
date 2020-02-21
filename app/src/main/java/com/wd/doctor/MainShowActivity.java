package com.wd.doctor;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.IntentUtils;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.ChooseImagePicBean;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.MVP.View.MessageActivity.AllNewsActivity;
import com.wd.doctor.MVP.View.ShowActivity.InterrogationActivity;
import com.wd.doctor.MVP.View.ShowActivity.ManagementActivity;
import com.wd.doctor.MVP.View.ShowActivity.WardmateActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//首页
public class MainShowActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    @BindView(R.id.main_bell)
    ImageView mainBell;
    @BindView(R.id.main_interrogation)
    SimpleDraweeView mainInterrogation;
    @BindView(R.id.text_main)
    TextView textMain;
    @BindView(R.id.main_notice)
    RelativeLayout mainNotice;
    @BindView(R.id.main_tip_box_inter)
    RelativeLayout mainTipBoxInter;
    @BindView(R.id.main_wardmate)
    SimpleDraweeView mainWardmate;
    @BindView(R.id.main_tip_box_wardmate)
    RelativeLayout mainTipBoxWardmate;
    @BindView(R.id.wdxx)
    TextView wdxx;
    @BindView(R.id.main_my)
    ImageView mainMy;
    @BindView(R.id.main_headportrait)
    SimpleDraweeView mainHeadportrait;
    @BindView(R.id.main_name)
    TextView mainName;
    @BindView(R.id.main_address)
    TextView mainAddress;
    @BindView(R.id.main_doctor)
    TextView mainDoctor;
    @BindView(R.id.main_subjects)
    TextView mainSubjects;
    @BindView(R.id.main_tip_box_my)
    RelativeLayout mainTipBoxMy;
    private String mId;
    private String mSessionId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public HomePresenter mPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
      /*  SPUtils sploginUtils = new SPUtils(MainShowActivity.this, "LoginId");
        mId = sploginUtils.getString("Id", "");
        mSessionId = sploginUtils.getString("SessionId", "");
        SPUtils spUtils = new SPUtils(MainShowActivity.this, "ImagePhoto");
        String imagePhotoId = spUtils.getString("ImagePhotoId", "");
        mP.getChooseImagePicPresenter(mId, mSessionId, imagePhotoId);*/
        SPUtils spData = new SPUtils(MainShowActivity.this, "LoginId");
        String dataName = spData.getString("dataName", "");
        String dataJobTitle = spData.getString("dataJobTitle", "");
        String dataInauguralHospital = spData.getString("dataInauguralHospital", "");
        String dataDepartmentName = spData.getString("dataDepartmentName", "");
        mainName.setText(dataName);
        mainAddress.setText(dataInauguralHospital);
        mainDoctor.setText(dataJobTitle);
        mainSubjects.setText(dataDepartmentName);

        SPUtils spImagePhoto = new SPUtils(MainShowActivity.this, "ImagePhoto");//从相册获取图片(imagephoneactivity)
        String imagePhotoPath = spImagePhoto.getString("ImagePhotoPath", "");
        if (imagePhotoPath != null) {
            Glide.with(this).load(imagePhotoPath)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher)
                    .skipMemoryCache(true)
                    .into(mainHeadportrait);//设置要展示的图片
        }

    }

    @OnClick({R.id.main_bell, R.id.main_notice, R.id.main_interrogation, R.id.main_wardmate, R.id.main_my, R.id.main_tip_box_inter, R.id.main_tip_box_wardmate, R.id.main_tip_box_my})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_notice://有消息提示
                IntentUtils.getInstence().intentStart(MainShowActivity.this, InterrogationActivity.class);
                break;
            case R.id.main_bell://全部消息
                IntentUtils.getInstence().intentStart(MainShowActivity.this, AllNewsActivity.class);
                break;
            case R.id.main_tip_box_inter://问诊
                IntentUtils.getInstence().intentStart(MainShowActivity.this, InterrogationActivity.class);
                break;
            case R.id.main_interrogation://问诊
                IntentUtils.getInstence().intentStart(MainShowActivity.this, InterrogationActivity.class);
                break;
            case R.id.main_tip_box_wardmate://答疑
                IntentUtils.getInstence().intentStart(MainShowActivity.this, WardmateActivity.class);
                break;
            case R.id.main_wardmate://答疑
                IntentUtils.getInstence().intentStart(MainShowActivity.this, WardmateActivity.class);
                break;
            case R.id.main_my://管理
                IntentUtils.getInstence().intentStart(MainShowActivity.this, ManagementActivity.class);
                break;
            case R.id.main_tip_box_my://管理
                IntentUtils.getInstence().intentStart(MainShowActivity.this, ManagementActivity.class);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onSuccess(Object data) {
        ChooseImagePicBean imagePicBean = (ChooseImagePicBean) data;
        String result = imagePicBean.getResult();
    }

    @Override
    public void onImgSuccess(Object data) {

    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onImgFailure(Throwable e) {

    }
}