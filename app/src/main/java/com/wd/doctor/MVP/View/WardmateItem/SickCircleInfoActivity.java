package com.wd.doctor.MVP.View.WardmateItem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Test.Logger;
import com.bwei.example.mylibrary.Test.SPUtils;
import com.bwei.example.mylibrary.Test.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.WardmateContracter;
import com.wd.doctor.MVP.Model.Bean.Patients.PublishCommentBean;
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
    @BindView(R.id.sick_cirle_smile)
    ImageView sickCirleSmile;
    @BindView(R.id.sick_cirle_wifi)
    ImageView sickCirleWifi;
    @BindView(R.id.linear)
    LinearLayout linear;
    @BindView(R.id.sick_circle_recycler)
    RelativeLayout sickCircleRecycler;

    private String mId;
    private String mSessionId;
    private String mWardId;
    private String mAmount;
    private SickCircleInfoBean.ResultBean mResult;
    private String mSickCircleId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sick_circle_info;
    }


    @Override
    protected void initData() {
        //搜索页面传过来的id
        Intent intent = getIntent();
        mSickCircleId = intent.getStringExtra("sickCircleId");
        Logger.d(TAG, "SickmAmount" +mWardId);

        //取值(取病友圈id)
        SPUtils spWardMate = new SPUtils(SickCircleInfoActivity.this, "Wardmate");
        mWardId = spWardMate.getString("WardId");
        mAmount = spWardMate.getString("Amount");
        SPUtils spUtils = new SPUtils(SickCircleInfoActivity.this, "LoginId");
        mId = spUtils.getString("Id");
        mSessionId = spUtils.getString("SessionId");
        //详情
        mP.getSickCircleInfoPresenter(mId, mSessionId, mWardId);
        //评论(病友圈)
        sickCirleWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEdit = sickEdit.getText().toString().trim();
                mP.getPublishCommentPresenter(mId, mSessionId, mWardId, mEdit);
                finish();
                Logger.d(TAG, "SickEdit" + mEdit);
            }
        });
        int parseInt = Integer.parseInt(mAmount);
        if (parseInt ==0){
            sickPrice.setVisibility(View.INVISIBLE);
        }else {
            sickPrice.setText(parseInt + "H");
        }

    }

    @Override
    public void onSuccess(Object data) {
        Logger.d(TAG, "SickCircleInfo" + data);
        SickCircleInfoBean circleInfoBean = (SickCircleInfoBean) data;
        mResult = circleInfoBean.getResult();
        if ("0000".equals(circleInfoBean.getStatus())) {
            sickTitle.setText(mResult.getTitle());
            sickName.setText(mResult.getDepartmentName());
            sickDepartmentsView.setText(mResult.getDepartmentName());
            sickDetailsView.setText(mResult.getDetail());
            sickDiseaseView.setText(mResult.getDisease());
            sickTreatmentView.setText(mResult.getTreatmentHospital());

        if (mResult.getWhetherContent()!=0) {
//            Glide.with(SickCircleInfoActivity.this).load(mResult.getTreatmentProcess()).into(sickImgView);
//                sickImgView.setImageResource(Integer.parseInt(mResult.getTreatmentProcess()));
        } else {
            sickImgView.setImageResource(R.drawable.ic_launcher_background);
        }
    }

    }

    //评论
    @Override
    public void onWardmateSuccess(Object data) {
        PublishCommentBean commentBean = (PublishCommentBean) data;
        mP.getSickCircleInfoPresenter(mId, mSessionId, mSickCircleId);
        if ("0000".equals(commentBean.getStatus())) {
            ToastUtils.show("评论成功");
        } else {
            ToastUtils.show("您已经评论了,不能重复评价!");
        }

    }

    @OnClick({R.id.sick_but, R.id.sick_backk, R.id.sick_bell})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sick_backk:
                finish();
                break;
            case R.id.sick_bell:
                break;

            case R.id.sick_but://我来解答
                if (sickCircleRecycler == null) {
                    sickCircleRecycler.setVisibility(View.GONE);
                    linear.setVisibility(View.VISIBLE);
                } else {
                    sickCircleRecycler.setVisibility(View.VISIBLE);
                    linear.setVisibility(View.GONE);
                }

                break;
        }
    }

    @Override
    public WardmatePresenter mPresenter() {
        return new WardmatePresenter();
    }

    @Override
    protected void initView() {

    }
    @Override
    public void onFailure(Throwable e) {

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

}
