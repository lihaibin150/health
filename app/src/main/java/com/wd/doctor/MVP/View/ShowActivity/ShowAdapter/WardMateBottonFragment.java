package com.wd.doctor.MVP.View.ShowActivity.ShowAdapter;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Base.BaseFragment;
import com.bwei.example.mylibrary.Net.NetworkJudgment;
import com.bwei.example.mylibrary.Tools.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wd.doctor.MVP.Contracter.WardmateContracter;
import com.wd.doctor.MVP.Model.Bean.Patients.FindSickCircleListBean;
import com.wd.doctor.MVP.Presenter.WardmatePresenter;
import com.wd.doctor.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//病友圈列表展示
public class WardMateBottonFragment extends BaseFragment<WardmatePresenter> implements WardmateContracter.IView {

    @BindView(R.id.ward_recycler)
    RecyclerView wardRecycler;
    @BindView(R.id.ward_smart)
    SmartRefreshLayout refreshLayout;
    private int mDepartmentId;
    int page = 1;//当前页，默认第一页
    private ArrayList<FindSickCircleListBean.ResultBean> mList;
    private WardMateBottonAdapter mMyRecViewFindSickCircleAdapter;

    @Override
    protected WardmatePresenter Presenter() {
        return new WardmatePresenter();
    }

    @Override
    protected void initData() {
        mList = new ArrayList<>();
        Bundle arguments = getArguments();
        mDepartmentId = arguments.getInt("departmentId");
        mPresenter.getSickCircleListPresenter(mDepartmentId, 1, 5);
        //设置全局的Header构建器
//        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
//            @Override
//            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
//                layout.setPrimaryColorsId(R.color.colorPrimaryDark, android.R.color.white);//全局设置主题颜色
//                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
//            }
//        });
//        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
//            @Override
//            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
//                //指定为经典Footer，默认是 BallPulseFooter
//                return new ClassicsFooter(context).setDrawableSize(20);
//            }
//        });
        refreshLayout.setEnableRefresh(true);
        refreshLayout.setEnableLoadMore(true);
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page++;
                mPresenter.getSickCircleListPresenter(mDepartmentId, page, 5);
                refreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mList.clear();
                page = 1;
                mPresenter.getSickCircleListPresenter(mDepartmentId, page, 5);
                refreshLayout.finishRefresh();
            }
        });

        //滚动
        refreshLayout.setScrollBoundaryDecider(new ScrollBoundaryDecider() {
            @Override
            public boolean canRefresh(View content) {
                if (wardRecycler == null) return false;
                if (wardRecycler.computeVerticalScrollOffset() == 0)
                    return true;
                return false;
            }

            @Override
            public boolean canLoadMore(View content) {
                if (wardRecycler == null) return false;
                //获取recyclerView的高度
                wardRecycler.getHeight();
                //整个View控件的高度
                int scrollRange = wardRecycler.computeVerticalScrollRange();
                //当前屏幕之前滑过的距离
                int scrollOffset = wardRecycler.computeVerticalScrollOffset();
                //当前屏幕显示的区域高度
                int scrollExtent = wardRecycler.computeVerticalScrollExtent();
                int height = wardRecycler.getHeight();
                if (height > scrollRange) {
                    return false;
                }
                if (scrollRange <= scrollOffset + scrollExtent) {
                    return true;
                }
                return false;
            }
        });
        if (NetworkJudgment.Network(getActivity())) {
            ToastUtils.show("当前有网络");
        } else {
            refreshLayout.setEnableLoadMore(true);//启用加载
            refreshLayout.setEnableRefresh(true);//启用刷新

        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ward_mate_botton;
    }

    @Override
    public void onWardmateSuccess(Object data) {
        FindSickCircleListBean findSickCircleListBean = (FindSickCircleListBean) data;
        List<FindSickCircleListBean.ResultBean> result = findSickCircleListBean.getResult();
        mList.addAll(result);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        wardRecycler.setLayoutManager(linearLayoutManager);
        mMyRecViewFindSickCircleAdapter = new WardMateBottonAdapter(getActivity(), mList);
        wardRecycler.setAdapter(mMyRecViewFindSickCircleAdapter);
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
