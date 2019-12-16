package com.wd.doctor.MVP.View.WardmateItem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Test.Logger;
import com.bwei.example.mylibrary.Test.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.WardmateContracter;
import com.wd.doctor.MVP.Model.Bean.Patients.SickCircleInfoBean;
import com.wd.doctor.MVP.Presenter.WardmatePresenter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//病友 详情
public class SickCircleInfoActivity extends BaseActivity<WardmatePresenter> implements WardmateContracter.IView {

    private static final String TAG = "SickCircleInfoActivity";
    @BindView(R.id.sick_backk)
    SimpleDraweeView sickBackk;
    @BindView(R.id.wallet_title)
    TextView sickTitle;
    @BindView(R.id.sick_bell)
    ImageView sickBell;
    @BindView(R.id.title)
    RelativeLayout title;
    @BindView(R.id.sick_name)
    TextView sickName;
    @BindView(R.id.sick_Disease)
    TextView sickDisease;
    @BindView(R.id.sick_Disease_view)
    TextView sickDiseaseView;
    @BindView(R.id.sick_Departments)
    TextView sickDepartments;
    @BindView(R.id.sick_Departments_view)
    TextView sickDepartmentsView;
    @BindView(R.id.sick_Details)
    TextView sickDetails;
    @BindView(R.id.sick_Details_view)
    TextView sickDetailsView;
    @BindView(R.id.sick_Treatment)
    TextView sickTreatment;
    @BindView(R.id.sick_Treatment_view)
    TextView sickTreatmentView;
    @BindView(R.id.sick_img)
    TextView sickImg;
    @BindView(R.id.sick_img_view)
    ImageView sickImgView;
    @BindView(R.id.sick_price)
    TextView sickPrice;
    @BindView(R.id.sick_but)
    Button sickBut;
    @BindView(R.id.sick_edit)
    EditText sickEdit;
    private String mId;
    private String mSessionId;
    private String mWardId;
    private String mAmount;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sick_circle_info;
    }

    @Override
    public WardmatePresenter mPresenter() {
        return new WardmatePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        //取值
        SPUtils spWardMate = new SPUtils(SickCircleInfoActivity.this, "wardmate");
        mWardId = spWardMate.getString("wardId");
        mAmount = spWardMate.getString("Amount");
        SPUtils spUtils = new SPUtils(SickCircleInfoActivity.this, "LoginId");
        mId = spUtils.getString("Id");
        mSessionId = spUtils.getString("SessionId");
        mP.getSickCircleInfoPresenter(mId, mSessionId, mWardId);
    }

    @Override
    public void onSuccess(Object data) {
        Logger.d(TAG, "SickCircleInfo" + data);
        SickCircleInfoBean circleInfoBean = (SickCircleInfoBean) data;
        SickCircleInfoBean.ResultBean result = circleInfoBean.getResult();
        sickTitle.setText(result.getTitle());
        sickName.setText(result.getAuthorName());
        sickDepartmentsView.setText(result.getDepartmentName());
        sickDetailsView.setText(result.getDetail());
        sickDiseaseView.setText(result.getDisease());
        sickTreatmentView.setText(result.getTreatmentHospital());
        sickPrice.setText(mAmount);
//        Uri parse = Uri.parse(result.getPicture());
//        sickImgView.setImageResource(parse);
    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onWardmateSuccess(Object data) {

    }

    @Override
    public void onWardmateFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.sick_price, R.id.sick_but, R.id.sick_backk, R.id.sick_bell})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sick_backk:
                finish();
                break;
            case R.id.sick_bell:
                break;
            case R.id.sick_price://H币
                break;
            case R.id.sick_but://我来解答
                sickEdit.setVisibility(View.VISIBLE);
                break;
        }
    }
}
