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

import com.bumptech.glide.Glide;
import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.Logger;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.bwei.example.mylibrary.Tools.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.WardmateContracter;
import com.wd.doctor.MVP.Model.Bean.Patients.PublishCommentBean;
import com.wd.doctor.MVP.Model.Bean.Patients.SickCircleInfoBean;
import com.wd.doctor.MVP.Presenter.WardmatePresenter;
import com.wd.doctor.R;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    @BindView(R.id.sick_Treatment_detaile)
    TextView sickTreatmentDetaile;
    @BindView(R.id.sick_Treatment_time)
    TextView sickTreatmentTime;
    @BindView(R.id.sick_text_answer)
    TextView sickTextAnswer;
    @BindView(R.id.sick_cirle_recycler)
    RelativeLayout sickCirleRecycler;

    private String mId;
    private String mSessionId;
    private String mWardId;
    private String mAmount;
    private SickCircleInfoBean.ResultBean mResult;
    private String mSickCircleId;
    private String mEdit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sick_circle_info;
    }


    @Override
    protected void initData() {
        //搜索页面传过来的id
        Intent intent = getIntent();
        mSickCircleId = intent.getStringExtra("sickCircleId");
        Logger.d(TAG, "SickmAmount" + mWardId);

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
                mEdit = sickEdit.getText().toString().trim();
                mP.getPublishCommentPresenter(mId, mSessionId, mWardId, mEdit);
                Logger.d(TAG, "SickEdit" + mEdit);
            }
        });
        int parseInt = Integer.parseInt(mAmount);
        if (parseInt == 0) {
            sickPrice.setVisibility(View.INVISIBLE);
        } else {
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
            sickDetailsView.setText(mResult.getDetail());//	病症详情
            sickDiseaseView.setText(mResult.getDisease());//病症
            Date date = new Date(mResult.getTreatmentStartTime());
            String day = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                day = simpleDateFormat.format(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
            sickTreatmentTime.setText(day);//治疗开始时间
            sickTreatmentDetaile.setText(mResult.getTreatmentProcess());
            sickTreatmentView.setText(mResult.getTreatmentHospital());//治疗医院
            if (mResult.getPicture() != null) {
                Glide.with(SickCircleInfoActivity.this).load(mResult.getPicture()).into(sickImgView);
            }
            if (mResult.getWhetherContent() == 1) {
                sickCirleRecycler.setVisibility(View.VISIBLE);
                linear.setVisibility(View.GONE);
                sickCircleRecycler.setVisibility(View.GONE);
                sickTextAnswer.setText(mResult.getContent());
                ToastUtils.show("已经评论过");
            }
        }

    }

    //评论
    @Override
    public void onWardmateSuccess(Object data) {
        PublishCommentBean commentBean = (PublishCommentBean) data;
        mP.getSickCircleInfoPresenter(mId, mSessionId, mSickCircleId);
        if (commentBean.getMessage() != null) {
            if ("0000".equals(commentBean.getStatus())) {
                ToastUtils.show("评论成功");
                sickCirleRecycler.setVisibility(View.VISIBLE);
                sickCircleRecycler.setVisibility(View.GONE);
                linear.setVisibility(View.GONE);
                sickTextAnswer.setText(mEdit);
            } else {
                sickCirleRecycler.setVisibility(View.GONE);
                linear.setVisibility(View.VISIBLE);
                ToastUtils.show("您已经评论了,不能重复评价!");
            }
        } else {
            ToastUtils.show("输入不能为空");
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
