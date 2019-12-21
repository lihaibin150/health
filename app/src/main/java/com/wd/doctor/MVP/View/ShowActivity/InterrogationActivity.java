package com.wd.doctor.MVP.View.ShowActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.IntentUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.InterrogationContracter;
import com.wd.doctor.MVP.Presenter.InterrogationPresenter;
import com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.AllInterrogationActivity;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * 问诊详情
 * */
public class InterrogationActivity extends BaseActivity<InterrogationPresenter> implements InterrogationContracter.IView {

    @BindView(R.id.manage_backk)
    SimpleDraweeView manageBackk;
    @BindView(R.id.manage_bell)
    ImageView manageBell;
    @BindView(R.id.interr_recycler)
    RecyclerView interrRecycler;
    @BindView(R.id.interr_swipe)
    SwipeRefreshLayout interrSwipe;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_interrogation;
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
    }

    @Override
    public void onSuccess(Object data) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.manage_backk, R.id.manage_bell})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.manage_backk:
                finish();
                break;
            case R.id.manage_bell:
                IntentUtils.getInstence().intentStart(InterrogationActivity.this, AllInterrogationActivity.class);
                break;
        }
    }

    @Override
    public void onDetailsListSuccess(Object data) {

    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onDetailsListFailure(Throwable e) {

    }
}
