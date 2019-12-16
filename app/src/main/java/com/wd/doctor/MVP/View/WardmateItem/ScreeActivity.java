package com.wd.doctor.MVP.View.WardmateItem;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.wd.doctor.MVP.Contracter.WardmateContracter;
import com.wd.doctor.MVP.Model.Bean.Patients.SearchSickCircleBean;
import com.wd.doctor.MVP.Presenter.WardmatePresenter;
import com.wd.doctor.MVP.View.WardmateItem.Adapter.SeachRecordAdapter;
import com.wd.doctor.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//病友圈(搜索)
public class ScreeActivity extends BaseActivity<WardmatePresenter> implements WardmateContracter.IView {

    @BindView(R.id.scree_img_back)
    ImageView screeImgBack;
    @BindView(R.id.et_find)
    EditText etFind;
    @BindView(R.id.scree_tv_find)
    TextView screeTvFind;
    @BindView(R.id.scree_tv_history_one)
    TextView screeTvHistoryOne;
    @BindView(R.id.scree_linear1)
    LinearLayout screeLinear1;
    @BindView(R.id.rec_searchSickCircle_view)
    RecyclerView recSearchSickCircleView;
    @BindView(R.id.scree_linear2)
    LinearLayout screeLinear2;
    @BindView(R.id.scree_img_none_find)
    ImageView screescreeImgNoneFind;
    private SeachRecordAdapter mSeachRecordAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_scree;
    }

    @Override
    public WardmatePresenter mPresenter() {
        return new WardmatePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        //搜索
//        mP.getSearchSickCirclePresenter();

    }

    @Override
    public void onSuccess(Object data) {
        SearchSickCircleBean circleBean = (SearchSickCircleBean) data;
        List<SearchSickCircleBean.ResultBean> result = circleBean.getResult();
      /*  if (result.size()==0) {
            screescreeImgNoneFind.setImageResource(R.mipmap.no_search_message);
        }else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recSearchSickCircleView.setLayoutManager(linearLayoutManager);
            mSeachRecordAdapter = new SeachRecordAdapter(result, ScreeActivity.this);
            recSearchSickCircleView.setAdapter(mSeachRecordAdapter);
            screescreeImgNoneFind.setVisibility(View.GONE);
            mSeachRecordAdapter.notifyDataSetChanged();
            mSeachRecordAdapter.setOnClick(new MyRecViewSearchSickCircleAdapter.onClick() {
                @Override
                public void onId(String sickCircleId) {
                    Intent intent = new Intent(ScreeActivity.this, FindSickCircleInfoActivity.class);
                    intent.putExtra("sickCircleId",sickCircleId);
                    startActivity(intent);
                }
            });
        }*/
    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onWardmateSuccess(Object data) {

    }

    @Override
    public void onWardmateFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}
