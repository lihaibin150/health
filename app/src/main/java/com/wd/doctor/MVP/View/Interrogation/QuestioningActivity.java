package com.wd.doctor.MVP.View.Interrogation;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.InterrogationContracter;
import com.wd.doctor.MVP.Model.Bean.Interrogation.InquiryBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.RecordListBean;
import com.wd.doctor.MVP.Presenter.InterrogationPresenter;
import com.wd.doctor.MVP.View.Interrogation.Adapter.QuestioningAdapter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//问诊列表
public class QuestioningActivity extends BaseActivity<InterrogationPresenter> implements InterrogationContracter.IView {

    @BindView(R.id.ques_backk)
    SimpleDraweeView quesBackk;
    @BindView(R.id.ques_bell)
    ImageView quesBell;
    @BindView(R.id.ques_recycler)
    RecyclerView quesRecycler;
    @BindView(R.id.ques_recycler_none)
    RelativeLayout quesRecyclerNone;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_questioning;
    }

    @Override
    public InterrogationPresenter mPresenter() {
        return new InterrogationPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        SPUtils spUtils = new SPUtils(QuestioningActivity.this, "LoginId");
        String id = spUtils.getString("Id", "");
        String sessionId = spUtils.getString("SessionId", "");
        mP.getRecordListPresenter(id, sessionId);
    }

    //问诊首页
    @Override
    public void onSuccess(Object data) {
        RecordListBean recordListBean = (RecordListBean) data;
        RecordListBean.ResultBean result = recordListBean.result;
        if (result != null) {
            quesRecycler.setLayoutManager(new LinearLayoutManager(QuestioningActivity.this));
            quesRecycler.setAdapter(new QuestioningAdapter(QuestioningActivity.this, result));
        } else {
            quesRecyclerNone.setVisibility(View.VISIBLE);
        }

    }

    //结束问诊
    @Override
    public void onDetailsListSuccess(Object data) {
        InquiryBean inquiryBean = (InquiryBean) data;
    }

    @Override
    public void onFailure(Throwable e) {

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

    @OnClick({R.id.ques_backk, R.id.ques_bell})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ques_backk:
                finish();
                break;
            case R.id.ques_bell:
                break;
        }
    }
}
