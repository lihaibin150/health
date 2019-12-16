package com.wd.doctor.MVP.View.MyActivity.History;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.wd.doctor.MVP.Contracter.InterrogationContracter;
import com.wd.doctor.MVP.Presenter.InterrogationPresenter;
import com.wd.doctor.R;
//历史问诊
public class HistoryActivity extends BaseActivity<InterrogationPresenter> implements InterrogationContracter.IView {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_history;
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
    public void onDetailsListSuccess(Object data) {

    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onDetailsListFailure(Throwable e) {

    }
}
