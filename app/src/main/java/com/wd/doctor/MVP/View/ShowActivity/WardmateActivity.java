package com.wd.doctor.MVP.View.ShowActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.IntentUtils;
import com.bwei.example.mylibrary.Tools.Logger;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import com.wd.doctor.MVP.Contracter.WardmateContracter;
import com.wd.doctor.MVP.Model.Bean.Patients.FindDepartmentBean;
import com.wd.doctor.MVP.Presenter.WardmatePresenter;
import com.wd.doctor.MVP.View.MessageActivity.AllNewsActivity;
import com.wd.doctor.MVP.View.ShowActivity.ShowAdapter.WardMateTopAdapter;
import com.wd.doctor.MVP.View.WardmateItem.ScreeActivity;
import com.wd.doctor.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * 答疑(病友圈)
 * */
public class WardmateActivity extends BaseActivity<WardmatePresenter> implements WardmateContracter.IView {

    private static final String TAG = "WardmateActivity";
    @BindView(R.id.wardmate_backk)
    SimpleDraweeView manageBackk;
    @BindView(R.id.wardmate_bell)
    ImageView manageBell;
    private ArrayList<String> tab = new ArrayList<>();
    @BindView(R.id.wardmate_scree)
    ImageView wardmateScree;
    TabLayout wardmateTopTab;
    ViewPager wardmateBottonVp;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wardmate;
    }

    @Override
    public WardmatePresenter mPresenter() {
        return new WardmatePresenter();
    }

    @Override
    protected void initView() {
        wardmateTopTab = findViewById(R.id.wardmate_top_tab);
        wardmateBottonVp = findViewById(R.id.wardmate_botton_vp);
    }

    @Override
    protected void initData() {
        //top标题
        mP.getDepartmentPresenter();

    }

    //top
    @Override
    public void onSuccess(Object data) {
        FindDepartmentBean departmentBean = (FindDepartmentBean) data;
        List<FindDepartmentBean.ResultBean> result = departmentBean.getResult();
        for (int i = 0; i < result.size(); i++) {
            FindDepartmentBean.ResultBean resultBean = result.get(i);
            tab.add(resultBean.getDepartmentName());
            //存值传到(详情页)
            SPUtils spScikMate = new SPUtils(WardmateActivity.this, "WardMate");
            spScikMate.putString("WardId", result.get(i).getId() + "");
            Logger.d(TAG, "SickWardId" + result.get(i).getId() + "");
        }

        wardmateTopTab.setupWithViewPager(wardmateBottonVp);
        WardMateTopAdapter myAdapter = new WardMateTopAdapter(getSupportFragmentManager(), tab, result);
        wardmateBottonVp.setAdapter(myAdapter);
    }

    @Override
    public void onWardmateSuccess(Object data) {

    }

    @OnClick({R.id.wardmate_backk, R.id.wardmate_bell, R.id.wardmate_scree})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.wardmate_backk:
                finish();//返回
                break;
            case R.id.wardmate_bell://病友圈消息
                IntentUtils.getInstence().intentStart(WardmateActivity.this, AllNewsActivity.class);
                break;
            case R.id.wardmate_scree://搜索
                IntentUtils.getInstence().intentStart(WardmateActivity.this, ScreeActivity.class);
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onFailure(Throwable e) {

    }


    @Override
    public void onWardmateFailure(Throwable e) {

    }
}