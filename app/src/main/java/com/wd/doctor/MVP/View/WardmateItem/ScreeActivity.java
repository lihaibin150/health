package com.wd.doctor.MVP.View.WardmateItem;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Test.ToastUtils;
import com.wd.doctor.MVP.Contracter.WardmateContracter;
import com.wd.doctor.MVP.Model.Bean.Patients.SearchSickCircleBean;
import com.wd.doctor.MVP.Presenter.WardmatePresenter;
import com.wd.doctor.MVP.View.WardmateItem.Adapter.SeachRecordAdapter;
import com.wd.doctor.R;

import java.util.ArrayList;
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
    private ArrayList<String> list = new ArrayList<>();
    private String keyWord;


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

        screeTvFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyWord = etFind.getText().toString();
                if (!TextUtils.isEmpty(keyWord)) {
                    //搜索
                    mP.getSearchSickCirclePresenter(keyWord);
                    ToastUtils.show("正在搜索" + keyWord + "有关的信息");
                    list.add(keyWord);
                    screeLinear1.setVisibility(View.GONE);
                    screeLinear2.setVisibility(View.VISIBLE);
                } else {
                    ToastUtils.show("不能输入空");
                }
            }
        });
        screeTvHistoryOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String history_one = screeTvHistoryOne.toString();
                //搜索
                mP.getSearchSickCirclePresenter(history_one);
                screeLinear1.setVisibility(View.GONE);
                screeLinear2.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onSuccess(Object data) {
        SearchSickCircleBean circleBean = (SearchSickCircleBean) data;
        List<SearchSickCircleBean.ResultBean> result = circleBean.getResult();
        if (result.size() == 0) {
            screescreeImgNoneFind.setImageResource(R.mipmap.no_search_message);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recSearchSickCircleView.setLayoutManager(linearLayoutManager);
            mSeachRecordAdapter = new SeachRecordAdapter(result, ScreeActivity.this);
            recSearchSickCircleView.setAdapter(mSeachRecordAdapter);
            screescreeImgNoneFind.setVisibility(View.GONE);
            mSeachRecordAdapter.notifyDataSetChanged();
            mSeachRecordAdapter.setOnClick(new SeachRecordAdapter.onClick() {
                @Override
                public void onId(String sickCircleId) {
                    Intent intent = new Intent(ScreeActivity.this, SickCircleInfoActivity.class);
                    intent.putExtra("sickCircleId", sickCircleId);
                    startActivity(intent);
                    finish();
                }
            });
        }
        screeImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
