package com.wd.doctor.MVP.View.MyActivity.History;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.Logger;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.bwei.example.mylibrary.Tools.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.InterrogationContracter;
import com.wd.doctor.MVP.Model.Bean.Interrogation.RecordBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.RecordListBean;
import com.wd.doctor.MVP.Presenter.InterrogationPresenter;
import com.wd.doctor.MVP.View.Interrogation.QuestioningActivity;
import com.wd.doctor.R;
import com.wd.doctor.R2;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//历史问诊
public class HistoryActivity extends BaseActivity<InterrogationPresenter> implements InterrogationContracter.IView {

    private static final String TAG = "HistoryActivity";
    @BindView(R2.id.history_sim_backk)
    SimpleDraweeView historySimBackk;
    @BindView(R2.id.history_sim_bell)
    TextView historySimBell;
    @BindView(R2.id.history_recycler_view)
    RecyclerView historyRecyclerView;
    private String mId;
    private String mSessionId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_history;
    }


    @Override
    protected void initData() {
        SPUtils spUtils = new SPUtils(HistoryActivity.this, "LoginId");
        mId = spUtils.getString("Id", "");
        mSessionId = spUtils.getString("SessionId", "");
        mP.getRecordPresenter(mId, mSessionId, 1, 5);
    }

    @Override
    public void onSuccess(Object data) {
        RecordBean recordBean = (RecordBean) data;
        Logger.d(TAG,"RecordListBean:"+recordBean.getMessage());
        if ("0000".equals(recordBean.getStatus())) {
            List<RecordBean.ResultBean> result = recordBean.getResult();
                HistoryAdapter historyAdapter = new HistoryAdapter(HistoryActivity.this, result);
                historyRecyclerView.setAdapter(historyAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HistoryActivity.this);
                historyRecyclerView.setLayoutManager(linearLayoutManager);
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
    public void onDetailsListSuccess(Object data) {

    }

    @Override
    public void onFailure(Throwable e) {

    }

    @OnClick({R2.id.history_sim_backk, R2.id.history_sim_bell})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.history_sim_backk:
                break;
            case R.id.history_sim_bell:
                break;
        }
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
