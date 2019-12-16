package com.wd.doctor.MVP.View.ShowActivity.ShowAdapter;

import android.content.Context;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Base.BaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.wd.doctor.MVP.Contracter.WardmateContracter;
import com.wd.doctor.MVP.Model.Bean.Patients.FindSickCircleListBean;
import com.wd.doctor.MVP.Presenter.WardmatePresenter;
import com.wd.doctor.R;

import java.util.List;

import butterknife.BindView;

public class WardMateBottonFragment extends BaseFragment<WardmatePresenter> implements WardmateContracter.IView {

    @BindView(R.id.ward_recycler)
    RecyclerView wardRecycler;
    @BindView(R.id.ward_smart)
    SmartRefreshLayout refreshLayout;
    private int mDepartmentId;


    @Override
    protected WardmatePresenter Presenter() {
        return new WardmatePresenter();
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        mDepartmentId = arguments.getInt("departmentId");
//        mPresenter.getSickCircleListPresenter(2, 1, 5);

        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorAccent, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        refreshLayout.setDragRate(0.5f);//显示下拉高度/手指真实下拉高度=阻尼效果
        refreshLayout.setReboundDuration(300);//回弹动画时长（毫秒）

        refreshLayout.setHeaderHeight(100);//Header标准高度（显示下拉高度>=标准高度 触发刷新）
        refreshLayout.setFooterHeight(100);//Footer标准高度（显示上拉高度>=标准高度 触发加载）

        refreshLayout.setHeaderMaxDragRate(2);//最大显示下拉高度/Header标准高度
        refreshLayout.setFooterMaxDragRate(2);//最大显示下拉高度/Footer标准高度
        refreshLayout.setHeaderTriggerRate(1);//触发刷新距离 与 HeaderHeight 的比率1.0.4
        refreshLayout.setFooterTriggerRate(1);//触发加载距离 与 FooterHeight 的比率1.0.4

        refreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        refreshLayout.setEnableLoadMore(false);//是否启用上拉加载功能
        refreshLayout.setEnableAutoLoadMore(true);//是否启用列表惯性滑动到底部时自动加载更多
        refreshLayout.setEnablePureScrollMode(false);//是否启用纯滚动模式
        refreshLayout.setEnableNestedScroll(false);//是否启用嵌套滚动
        refreshLayout.setEnableOverScrollBounce(true);//是否启用越界回弹
        refreshLayout.setEnableScrollContentWhenLoaded(true);//是否在加载完成时滚动列表显示新的内容
        refreshLayout.setEnableHeaderTranslationContent(true);//是否下拉Header的时候向下平移列表或者内容
        refreshLayout.setEnableFooterTranslationContent(true);//是否上拉Footer的时候向上平移列表或者内容
        refreshLayout.setEnableLoadMoreWhenContentNotFull(true);//是否在列表不满一页时候开启上拉加载功能

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ward_mate_botton;
    }


    @Override
    public void onWardmateSuccess(Object data) {
        mPresenter.getSickCircleListPresenter(mDepartmentId, 1, 5);
        FindSickCircleListBean findSickCircleListBean = (FindSickCircleListBean) data;
        List<FindSickCircleListBean.ResultBean> result = findSickCircleListBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        wardRecycler.setLayoutManager(linearLayoutManager);
        WardMateBottonAdapter myRecViewFindSickCircleAdapter = new WardMateBottonAdapter(getActivity(), result);
        wardRecycler.setAdapter(myRecViewFindSickCircleAdapter);
    }
    @Override
    public void onSuccess(Object data) {

    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onWardmateFailure(Throwable e) {

    }
}
