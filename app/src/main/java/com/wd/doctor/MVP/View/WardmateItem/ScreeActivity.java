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
import com.wd.doctor.MVP.Model.Bean.SearchHistory;
import com.wd.doctor.MVP.Presenter.WardmatePresenter;
import com.wd.doctor.MVP.View.WardmateItem.Adapter.SeachRecordAdapter;
import com.wd.doctor.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//病友圈(搜索)
public class ScreeActivity extends BaseActivity<WardmatePresenter> implements WardmateContracter.IView {


    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.et_find)
    EditText etFind;
    @BindView(R.id.tv_find)
    TextView tvFind;
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
    private SeachRecordAdapter mSeachRecordAdapter;
    private ArrayList<String> list = new ArrayList<>();
    private String keyWord;
    private final int DELETEONE = 0X001;
    private final int DELETEALL = 0X002;

    private List<SearchHistory> mList = new ArrayList<>();
    ;

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
        /*tvRecommandsearch.setText(getIntent().getStringExtra("recommandsearch"));
        recommandsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editSearch.setText(tvRecommandsearch.getText());
                insertHistory();
            }
        });

        adapter = new SearchAdapter(ScreeActivity.this, mList);
        listviewSearchHistory.setLayoutManager(new LinearLayoutManager(this));
        listviewSearchHistory.setAdapter(adapter);
        adapter.setOnDeleteListener(new SearchAdapter.OnDeleteListener() {
            @Override
            public void OnDelete(int position) {
                deleteHistory(DELETEONE, position);
            }
        });
        adapter.setOnItemClickListener(new SearchAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                editSearch.setText(mList.get(position).getName());
                insertHistory();
            }
        });
        //清除所有搜索记录
        btnClearall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteDialog();
//                queryHistory();
            }
        });*/

      /*  editSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finish();
                keyWord = editSearch.getText().toString();
                if (!TextUtils.isEmpty(keyWord)) {
                    //搜索
                    mP.getSearchSickCirclePresenter(keyWord);
                    ToastUtils.show("正在搜索" + keyWord + "有关的信息");
                    list.add(keyWord);
//                    screeLinear1.setVisibility(View.GONE);
//                    screeLinear2.setVisibility(View.VISIBLE);
                } else {
                    ToastUtils.show("不能输入空");
                }
            }
        });*/
       /* editSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH && !TextUtils.isEmpty(editSearch.getText().toString().trim())) {
                    ToastUtils.show(editSearch.getText().toString().trim());
                    insertHistory();
                }
                return true;
            }
        });
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().length() > 0) {
                    btnSearchdelete.setVisibility(View.VISIBLE);
                } else {
                    btnSearchdelete.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btnSearchdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editSearch.setText("");
            }
        });
    }
*/
        etFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        etFind.setOnEditorActionListener(new TextView.OnEditorActionListener() {

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
                    if (etFind.getText().toString().isEmpty()) {
                        ToastUtils.show("搜索栏不能为空！");
                    } else {
                        //搜索
                        doSearch();
                    }
                    return true;
                }
                return false;
            }
        });
        tvFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String history_one = tvHistoryOne.toString();
                //搜索
                mP.getSearchSickCirclePresenter(history_one);
                linear1  .setVisibility(View.GONE);
                linear2.setVisibility(View.VISIBLE);
            }
        });
    }

    private void doSearch() {
        tvFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String history_one = tvHistoryOne.toString();
                //搜索
                mP.getSearchSickCirclePresenter(history_one);
                linear1  .setVisibility(View.GONE);
                linear2.setVisibility(View.VISIBLE);
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
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recSearchSickCircleView.setLayoutManager(linearLayoutManager);
            mSeachRecordAdapter = new SeachRecordAdapter(result, ScreeActivity.this);
            recSearchSickCircleView.setAdapter(mSeachRecordAdapter);
            imgNoneFind.setVisibility(View.GONE);
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
        imgBack.setOnClickListener(new View.OnClickListener() {
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
