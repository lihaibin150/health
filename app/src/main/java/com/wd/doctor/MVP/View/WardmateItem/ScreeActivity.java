package com.wd.doctor.MVP.View.WardmateItem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.ToastUtils;
import com.bwei.example.mylibrary.app.App;
import com.wd.doctor.MVP.Contracter.WardmateContracter;
import com.wd.doctor.MVP.Model.Bean.Patients.SearchSickCircleBean;
import com.wd.doctor.MVP.Presenter.WardmatePresenter;
import com.wd.doctor.MVP.View.WardmateItem.Adapter.SeachRecordAdapter;
import com.wd.doctor.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//病友圈(搜索)
public class ScreeActivity extends BaseActivity<WardmatePresenter> implements WardmateContracter.IView {


    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.scree_et_search)
    EditText mEditText;
    @BindView(R.id.scree_tv_search)
    TextView mTextView;
    @BindView(R.id.tv_history_one)
    TextView tvHistoryOne;
    @BindView(R.id.linear1)
    LinearLayout linear1;
    @BindView(R.id.rec_searchSickCircle_view)
    RecyclerView recSearchSickCircleView;
    @BindView(R.id.linear2)
    LinearLayout linear2;
    @BindView(R.id.img_none_find)
    ImageView imgNoneFind;
    @BindView(R.id.scree_text_view)
    TextView screeTextView;
    private SeachRecordAdapter mSeachRecordAdapter;
    private String mEt;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_scree;
    }

    @Override
    protected void initData() {
        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // 先隐藏键盘
                    ((InputMethodManager) App.getAppContext()
                            .getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(ScreeActivity.this
                                            .getCurrentFocus().getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                    if (mEditText.getText().toString().isEmpty()) {
                        ToastUtils.show("搜索栏不能为空！");
                    } else {

                    }
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onSuccess(Object data) {
        SearchSickCircleBean circleBean = (SearchSickCircleBean) data;
        List<SearchSickCircleBean.ResultBean> result = circleBean.getResult();
        if (result.size() == 0) {
            imgNoneFind.setImageResource(R.mipmap.no_search_message);
        } else {
//            linear2.setVisibility(View.VISIBLE);
//            linear1.setVisibility(View.GONE);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recSearchSickCircleView.setLayoutManager(linearLayoutManager);
            mSeachRecordAdapter = new SeachRecordAdapter(result, ScreeActivity.this);
            recSearchSickCircleView.setAdapter(mSeachRecordAdapter);
//            imgNoneFind.setVisibility(View.GONE);
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
    }

    @OnClick({R.id.img_back, R.id.scree_tv_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.scree_tv_search:
                mEt = mEditText.getText().toString();
                if (mEt != null) {
                    mP.getSearchSickCirclePresenter(mEt);
                    linear1.setVisibility(View.GONE);
                    linear2.setVisibility(View.VISIBLE);
                } else {
                    linear2.setVisibility(View.GONE);
                    linear1.setVisibility(View.VISIBLE);

                }
                break;
        }
    }

    @Override
    public WardmatePresenter mPresenter() {
        return new WardmatePresenter();
    }

    @Override
    protected void initView() {

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
