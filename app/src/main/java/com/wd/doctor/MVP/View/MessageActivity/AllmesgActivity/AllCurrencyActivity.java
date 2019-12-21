package com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.Logger;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorHealthyCurrencyNoticeListBean;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//H币消息
public class AllCurrencyActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    private static final String TAG = "AllCurrencyActivity";
    @BindView(R.id.all_backk)
    SimpleDraweeView allBackk;
    @BindView(R.id.all_currency_recycler)
    RecyclerView allCurrencyRecycler;
    @BindView(R.id.currency_recycler_no_message)
    RelativeLayout currencyRecyclerNoMessage;
    private String mSessionId;
    private String mId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_all_currency;
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
        SPUtils sploginUtils = new SPUtils(AllCurrencyActivity.this, "LoginId");
        mId = sploginUtils.getString("Id", "");
        mSessionId = sploginUtils.getString("SessionId", "");
        mP.getHealthyPresenter(mId, mSessionId, 1, 5);
    }

    @Override
    public void onSuccess(Object data) {
        DoctorHealthyCurrencyNoticeListBean currencyNoticeListBean = (DoctorHealthyCurrencyNoticeListBean) data;
        DoctorHealthyCurrencyNoticeListBean.ResultBean result = currencyNoticeListBean.result;
        Logger.d(TAG,"DoctorHealthyCurrencyNoticeList:"+result.content);
       /* if ("0000".equals(currencyNoticeListBean.status)) {
            allCurrencyRecycler.setLayoutManager(new LinearLayoutManager(AllCurrencyActivity.this));
            allCurrencyRecycler.setAdapter(new AllCAdapter(AllCurrencyActivity.this, result));
        } else {
            ToastUtils.show("当前无消息");
            currencyRecyclerNoMessage.setVisibility(View.VISIBLE);
        }*/
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.all_backk)
    public void onClick() {
        finish();
    }
}
