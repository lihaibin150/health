package com.wd.doctor.MVP.View.MyActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.IntentUtils;
import com.bwei.example.mylibrary.Tools.Logger;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorIncomeBean;
import com.wd.doctor.MVP.Model.Bean.Doctor.FindDoctorWalletBean;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.MVP.View.MyActivity.Adapter.WalletAdapter;
import com.wd.doctor.MVP.View.MyActivity.unbindactivity.UnbindActivity;
import com.wd.doctor.MVP.View.WardmateItem.Adapter.SeachRecordAdapter;
import com.wd.doctor.MVP.View.WardmateItem.ScreeActivity;
import com.wd.doctor.R;
import com.wd.doctor.R2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//我的钱包
public class WalletActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    private static final String TAG = "WalletActivity";
    @BindView(R2.id.wallet_backk)
    SimpleDraweeView walletBackk;
    @BindView(R2.id.wallet_bell)
    TextView manageBinding;
    @BindView(R2.id.wallet_price)
    TextView walletPrice;
    @BindView(R2.id.wallet_but_pirce)
    Button walletButPirce;
    @BindView(R2.id.wallet_recycler_view)
    RecyclerView walletRecyclerView;
    @BindView(R2.id.wallet_smart)
    SmartRefreshLayout refreshLayout;
    private String mId;
    private String mSessionId;
    int page = 1;
    private ArrayList<DoctorIncomeBean.ResultBean> mList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wallet;
    }


    @Override
    protected void initData() {
        SPUtils spUtils = new SPUtils(WalletActivity.this, "LoginId");
        mId = spUtils.getString("Id");
        mSessionId = spUtils.getString("SessionId");
        mP.getFindDoctorWalletPresenter(mId, mSessionId);//医生钱包
        mP.getDoctorIncomePresenter(mId, mSessionId, 1, 10);//医生收入支出详细
        refreshLayout.setEnableRefresh(true);
        refreshLayout.setEnableLoadMore(true);
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                mP.getDoctorIncomePresenter(mId, mSessionId, page, 10);//医生收入支出详细
                refreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mList.clear();
                page = 1;
                mP.getDoctorIncomePresenter(mId, mSessionId, page, 10);//医生收入支出详细
                refreshLayout.finishRefresh();
            }
        });

    }

    @Override
    public void onSuccess(Object data) {
        FindDoctorWalletBean doctorWalletBean = (FindDoctorWalletBean) data;
        FindDoctorWalletBean.ResultBean result = doctorWalletBean.getResult();
        if ("0000".equals(doctorWalletBean.getStatus())) {
            String s = String.valueOf(result.getBalance());
            walletPrice.setText(s);//价格
            walletButPirce.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IntentUtils.getInstence().intentStart(WalletActivity.this, WithdrawalsActivity.class);
                }
            });
        }
    }

    //医生收入支出
    @Override
    public void onImgSuccess(Object data) {
        DoctorIncomeBean doctorIncomeBean = (DoctorIncomeBean) data;
        Logger.d(TAG, "DoctorIncome:" + doctorIncomeBean.getMessage());
        List<DoctorIncomeBean.ResultBean> result = doctorIncomeBean.getResult();
        mList = new ArrayList<>();
        if ("0000".equals(doctorIncomeBean.getStatus())) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            walletRecyclerView.setLayoutManager(linearLayoutManager);
            walletRecyclerView.setAdapter(new WalletAdapter(WalletActivity.this, result));

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
    public void onFailure(Throwable e) {

    }

    @Override
    public void onImgFailure(Throwable e) {

    }

    @OnClick({R2.id.wallet_bell, R2.id.wallet_but_pirce, R2.id.wallet_backk})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.wallet_bell://绑定
                IntentUtils.getInstence().intentStart(WalletActivity.this, UnbindActivity.class);
                break;
            case R.id.wallet_but_pirce://提现

                break;
            case R.id.wallet_backk:
                finish();
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
