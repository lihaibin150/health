package com.wd.doctor.MVP.View.MyActivity.unbindactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.IntentUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//去绑定(绑定身份证,银行卡)
public class UnbindActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {


    @BindView(R.id.unbind_sim_backk)
    SimpleDraweeView unbindSimBackk;
    @BindView(R.id.unbind_sim_unbind)
    SimpleDraweeView unbindSimUnbind;
    @BindView(R.id.unbind_sim_bankcard)
    SimpleDraweeView unbindSimBankcard;
    @BindView(R.id.unbind_text_unbind)
    TextView unbindTextUnbind;
    @BindView(R.id.unbind_text_bancard)
    TextView unbindTextBancard;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_unbind;
    }

    @OnClick({R.id.unbind_text_bancard,R.id.unbind_text_unbind,R.id.unbind_sim_backk, R.id.unbind_sim_unbind, R.id.unbind_sim_bankcard})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.unbind_sim_backk://返回
                finish();
                break;
            case R.id.unbind_text_unbind://身份证
                IntentUtils.getInstence().intentStart(UnbindActivity.this, IDCardActivity.class);
                break;
            case R.id.unbind_sim_unbind://身份证
                IntentUtils.getInstence().intentStart(UnbindActivity.this, IDCardActivity.class);
                break;
            case R.id.unbind_sim_bankcard://银行卡
                IntentUtils.getInstence().intentStart(UnbindActivity.this, BankCardActivity.class);
                break;
            case R.id.unbind_text_bancard://银行卡
                IntentUtils.getInstence().intentStart(UnbindActivity.this, BankCardActivity.class);
                break;
        }
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

    }

    @Override
    public void onSuccess(Object data) {

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
}
