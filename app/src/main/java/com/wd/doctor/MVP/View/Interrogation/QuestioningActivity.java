package com.wd.doctor.MVP.View.Interrogation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.IntentUtils;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wd.doctor.MVP.Contracter.InterrogationContracter;
import com.wd.doctor.MVP.Model.Bean.Interrogation.MessageBean;
import com.wd.doctor.MVP.Presenter.InterrogationPresenter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//问诊聊天页面
public class QuestioningActivity extends BaseActivity<InterrogationPresenter> implements InterrogationContracter.IView {

    private static final String TAG = "QuestioningActivity";
    @BindView(R.id.ques_backk)
    SimpleDraweeView quesBackk;
    @BindView(R.id.ques_bell)
    ImageView quesBell;
    @BindView(R.id.ques_title)
    TextView quesTitle;
    @BindView(R.id.questioning_recycler)
    RecyclerView questioningRecycler;
    @BindView(R.id.im_smart)
    SmartRefreshLayout imSmart;
    @BindView(R.id.questoning_edit_text)
    EditText questoningEditText;
    @BindView(R.id.questoning_but_send)
    Button questoningButSend;
    private String mId;
    private String mSessionId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_questioning;
    }

    @Override
    protected void initData() {
        SPUtils spUtils = new SPUtils(QuestioningActivity.this, "LoginId");
        mId = spUtils.getString("Id", "");
        mSessionId = spUtils.getString("SessionId", "");
        mP.getMessagePresenter(mId,mSessionId,3853,"我的",1,456);
    }


    @Override
    public void onSuccess(Object data) {
        MessageBean messageBean = (MessageBean) data;

    }

    //结束问诊
    @Override
    public void onDetailsListSuccess(Object data) {

    }

    @OnClick({R.id.ques_backk, R.id.ques_bell})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ques_backk:
                finish();
                break;
            case R.id.ques_bell://问诊详情页面
                IntentUtils.getInstence().intentStart(QuestioningActivity.this, DetailedInquiryActivity.class);
                break;
        }
    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public InterrogationPresenter mPresenter() {
        return new InterrogationPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    public void onDetailsListFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}
