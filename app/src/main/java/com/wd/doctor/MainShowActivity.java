package com.wd.doctor;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Test.IntentUtils;
import com.bwei.example.mylibrary.Test.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Presenter.LoginPresenter;
import com.wd.doctor.MVP.View.MessageActivity.AllNewsActivity;
import com.wd.doctor.MVP.View.ShowActivity.InterrogationActivity;
import com.wd.doctor.MVP.View.ShowActivity.ManagementActivity;
import com.wd.doctor.MVP.View.ShowActivity.WardmateActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//首页
public class MainShowActivity extends BaseActivity {

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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
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
        SPUtils spData = new SPUtils(MainShowActivity.this, "LoginId");
        String dataName = spData.getString("dataName", "");
        String dataJobTitle = spData.getString("dataJobTitle", "");
        String dataInauguralHospital = spData.getString("dataInauguralHospital", "");
        String dataDepartmentName = spData.getString("dataDepartmentName", "");
        mainName.setText(dataName);
        mainAddress.setText(dataInauguralHospital);
        mainDoctor.setText(dataJobTitle);
        mainSubjects.setText(dataDepartmentName);
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

}