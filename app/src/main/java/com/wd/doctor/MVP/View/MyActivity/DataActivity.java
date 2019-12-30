package com.wd.doctor.MVP.View.MyActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.Logger;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.FindDoctorByIdBean;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.R;
import com.wd.doctor.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//根据医生id查询医生信息(个人资料)
public class DataActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    private static final String TAG = "DataActivity";
    @BindView(R2.id.manage_backk)
    SimpleDraweeView manageBackk;
    @BindView(R2.id.data_name)
    TextView dataName;
    @BindView(R2.id.data_hospital)
    TextView dataHospital;
    @BindView(R2.id.data_departments)
    TextView dataDepartments;
    @BindView(R2.id.data_title)
    TextView dataTitle;
    @BindView(R2.id.data_introduction)
    TextView dataIntroduction;
    @BindView(R2.id.data_field)
    TextView dataField;
    private String mId;
    private String mSessionId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_data;
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
        
        SPUtils spUtils = new SPUtils(DataActivity.this, "LoginId");
        mId = spUtils.getString("Id", "");
        mSessionId = spUtils.getString("SessionId", "");
        mP.getFindDoctorByIdPresenter(mId, mSessionId);
    }

    @Override
    public void onSuccess(Object data) {
        Logger.d(TAG, "data个人资料:" + data);
        FindDoctorByIdBean doctorByIdBean = (FindDoctorByIdBean) data;
        FindDoctorByIdBean.ResultBean result = doctorByIdBean.getResult();
        Logger.d(TAG, "FindDoctorByIdBean个人资料:" + result);
        dataName.setText(result.getName());
        dataTitle.setText(result.getJobTitle());
        dataHospital.setText(result.getInauguralHospital());
        dataDepartments.setText(result.getDepartmentName());
        dataIntroduction.setText(result.getPersonalProfile());
        dataField.setText(result.getGoodField());
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

    @OnClick({R2.id.manage_backk, R2.id.data_field})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.manage_backk:
                finish();
                break;
            case R.id.data_field:
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
