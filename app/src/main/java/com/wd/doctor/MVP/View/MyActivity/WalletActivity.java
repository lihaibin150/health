package com.wd.doctor.MVP.View.MyActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Test.Logger;
import com.bwei.example.mylibrary.Test.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.FindDoctorWalletBean;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//我的钱包
public class WalletActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    private static final String TAG = "WalletActivity";
    @BindView(R.id.wallet_backk)
    SimpleDraweeView walletBackk;
    @BindView(R.id.manage_bell)
    TextView manageBinding;
    @BindView(R.id.wallet_price)
    TextView walletPrice;
    @BindView(R.id.wallet_but_pirce)
    Button walletButPirce;
    @BindView(R.id.wallet_name)
    TextView walletName;
    @BindView(R.id.wallet_time)
    TextView walletTime;
    @BindView(R.id.wallet_red_price)
    TextView walletRedPrice;
    @BindView(R.id.wallet_blue_price)
    TextView walletBluePrice;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wallet;
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
        SPUtils spUtils = new SPUtils(WalletActivity.this, "LoginId");
        String id = spUtils.getString("Id");
        String sessionId = spUtils.getString("SessionId");
        mP.getFindDoctorWalletPresenter(id, sessionId);
        Logger.d(TAG, "FindDoctor:" + id + "==" + sessionId);
    }

    @Override
    public void onSuccess(Object data) {
        Logger.d(TAG, "FindDoctorWalletBean:" + data);
        FindDoctorWalletBean doctorWalletBean = (FindDoctorWalletBean) data;
        FindDoctorWalletBean.ResultBean result = doctorWalletBean.getResult();
//        walletPrice.setText(result.getDoctorId());
//        walletTime.setText(result.getVersion());
    }

    @Override
    public void onFailure(Throwable e) {

    }

    @OnClick({R.id.manage_bell, R.id.wallet_but_pirce})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.manage_bell:

                break;
            case R.id.wallet_but_pirce:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
