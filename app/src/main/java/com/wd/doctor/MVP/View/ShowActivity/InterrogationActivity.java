package com.wd.doctor.MVP.View.ShowActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.IntentUtils;
import com.bwei.example.mylibrary.Tools.Logger;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.bwei.example.mylibrary.Tools.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wd.doctor.MVP.Contracter.InterrogationContracter;
import com.wd.doctor.MVP.Model.Bean.Interrogation.RecordListBean;
import com.wd.doctor.MVP.Presenter.InterrogationPresenter;
import com.wd.doctor.MVP.View.Interrogation.Adapter.InterrogationAdapter;
import com.wd.doctor.MVP.View.Interrogation.DetailedInquiryActivity;
import com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.AllInterrogationActivity;
import com.wd.doctor.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * 问诊详情
 * */
public class InterrogationActivity extends BaseActivity<InterrogationPresenter> implements InterrogationContracter.IView {

    private static final String TAG = "InterrogationActivity";
    int page = 1;//当前页，默认第一页
    @BindView(R.id.interrogation_sim_backk)
    SimpleDraweeView interrogationSimBackk;
    @BindView(R.id.interrogation_sim_bell)
    ImageView interrogationSimBell;
    @BindView(R.id.interr_recycler_recycler)
    RecyclerView interrRecyclerRecycler;
    @BindView(R.id.introduction_recycler_none)
    RelativeLayout introductionRecyclerNone;
    @BindView(R.id.ques_none)
    ImageView quesNone;
    @BindView(R.id.interr_smart)
    SmartRefreshLayout interrSmart;
    private String mId;
    private String mSessionId;
    private ArrayList<RecordListBean.ResultBean> mList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_interrogation;
    }


    @Override
    protected void initData() {
        SPUtils sploginUtils = new SPUtils(InterrogationActivity.this, "LoginId");
        mId = sploginUtils.getString("Id", "");
        mSessionId = sploginUtils.getString("SessionId", "");
        mP.getRecordListPresenter(mId, mSessionId);

        interrSmart.setEnableRefresh(true);
        interrSmart.setEnableLoadMore(true);
        interrSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                mP.getRecordListPresenter(mId, mSessionId);
                refreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                if (mList != null) {
                    mList.clear();
                } else {
                    ToastUtils.show("当前无问诊消息");
                }

                page = 1;
                mP.getRecordListPresenter(mId, mSessionId);
                refreshLayout.finishRefresh();
            }
        });
    }

    @Override
    public void onSuccess(Object data) {
        RecordListBean recordListBean = (RecordListBean) data;
        List<RecordListBean.ResultBean> result = recordListBean.getResult();
        mList = new ArrayList<>();
        //查询问诊评价详情(存值)
        SPUtils spRecordId = new SPUtils(InterrogationActivity.this, "InterrogationRecordId");
        spRecordId.putInt("recordId",result.get(0).getRecordId());
        if (recordListBean.getMessage() != null) {
            interrRecyclerRecycler.setLayoutManager(new LinearLayoutManager(InterrogationActivity.this));
            interrRecyclerRecycler.setAdapter(new InterrogationAdapter(InterrogationActivity.this, result));
        } else {
            introductionRecyclerNone.setVisibility(View.VISIBLE);
        }

    }


    @OnClick({R.id.interrogation_sim_backk, R.id.interrogation_sim_bell})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.interrogation_sim_backk:
                finish();
                break;
            case R.id.interrogation_sim_bell:
                IntentUtils.getInstence().intentStart(InterrogationActivity.this, AllInterrogationActivity.class);
                break;
        }
    }
    @Override
    public InterrogationPresenter mPresenter() {
        return new InterrogationPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
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
