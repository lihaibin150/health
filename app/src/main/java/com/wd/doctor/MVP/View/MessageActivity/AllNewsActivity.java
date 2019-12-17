package com.wd.doctor.MVP.View.MessageActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Test.IntentUtils;
import com.bwei.example.mylibrary.Test.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.AllStausBean;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.AllCurrencyActivity;
import com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.AllInterrogationActivity;
import com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.AllSystemActivity;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//全部消息
public class AllNewsActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    @BindView(R.id.all_backk)
    SimpleDraweeView allBackk;
    @BindView(R.id.all_query_bell)
    TextView allQueryBell;
    @BindView(R.id.all_del)
    ImageView allDel;
    @BindView(R.id.all_but)
    Button allBut;
    @BindView(R.id.all_news_meassge)
    RelativeLayout allNewsMeassge;
    @BindView(R.id.sim_system)
    SimpleDraweeView simSystem;
    @BindView(R.id.all_system_text)
    TextView allSystemText;
    @BindView(R.id.all_system_query)
    RelativeLayout allSystemQuery;
    @BindView(R.id.all_system)
    RelativeLayout allSystem;
    @BindView(R.id.sim_inter)
    SimpleDraweeView simInter;
    @BindView(R.id.all_interr_text)
    TextView allInterrText;
    @BindView(R.id.all_interr_query)
    RelativeLayout allInterrQuery;
    @BindView(R.id.all_interrogation)
    RelativeLayout allInterrogation;
    @BindView(R.id.sim_currency)
    SimpleDraweeView simCurrency;
    @BindView(R.id.all_currency_text)
    TextView allCurrencyText;
    @BindView(R.id.all_currency_query)
    RelativeLayout allCurrencyQuery;
    @BindView(R.id.all_currency)
    RelativeLayout allCurrency;
    private String mId;
    private String mSessionId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_all_news;
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
        SPUtils sploginUtils = new SPUtils(AllNewsActivity.this, "LoginId");
        mId = sploginUtils.getString("Id", "");
        mSessionId = sploginUtils.getString("SessionId", "");
        mP.PutAllStausPresenter(mId, mSessionId);
    }

    @Override
    public void onSuccess(Object data) {
        AllStausBean allStausBean = (AllStausBean) data;

    }

    @OnClick({R.id.all_query_bell,R.id.all_backk, R.id.all_del, R.id.all_system, R.id.all_interrogation, R.id.all_currency})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.all_query_bell://全部消息已读
               allCurrencyQuery.setVisibility(View.GONE);
               allInterrQuery.setVisibility(View.GONE);
               allSystemQuery.setVisibility(View.GONE);
                break;
            case R.id.all_backk://关闭
                fileList();
                break;
            case R.id.all_del://关闭通知
                allNewsMeassge.setVisibility(View.GONE);
                break;
            case R.id.all_system://系统消息
                IntentUtils.getInstence().intentStart(AllNewsActivity.this, AllSystemActivity.class);
                break;
            case R.id.all_interrogation://问诊消息
                IntentUtils.getInstence().intentStart(AllNewsActivity.this, AllInterrogationActivity.class);
                break;
            case R.id.all_currency://H币消息
                IntentUtils.getInstence().intentStart(AllNewsActivity.this, AllCurrencyActivity.class);
                break;
        }
    }


    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
