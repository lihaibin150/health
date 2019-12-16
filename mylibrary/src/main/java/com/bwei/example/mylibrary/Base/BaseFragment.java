package com.bwei.example.mylibrary.Base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bwei.example.mylibrary.Net.NetWork;
import com.bwei.example.mylibrary.app.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {

    public P mPresenter;
    private View mInflate;
    private Unbinder mBind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mInflate = inflater.inflate(getLayoutId(), container, false);
        mBind = ButterKnife.bind(this, mInflate);
        return mInflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = Presenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initView();
        initData();
    }

    protected abstract P Presenter();

    protected void initView() {
    }

    protected abstract void initData();

    protected abstract int getLayoutId();

    //释放资源
    @Override
    public void onDetach() {
        super.onDetach();
        mBind.unbind();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    //判断是否有网络
    public boolean NetWorkUtils() {
        return NetWork.hasNetwork(context());
    }

    //无网提醒
    public void NoNetwork() {
        Toast.makeText(context(), "无网，请检查网络", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getContext() != null ? App.getAppContext() : getContext();
    }
}
