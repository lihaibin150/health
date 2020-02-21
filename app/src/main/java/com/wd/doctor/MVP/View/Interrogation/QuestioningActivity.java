package com.wd.doctor.MVP.View.Interrogation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.IntentUtils;
import com.bwei.example.mylibrary.Tools.Logger;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.bwei.example.mylibrary.Tools.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wd.doctor.MVP.Contracter.InterrogationContracter;
import com.wd.doctor.MVP.Model.Bean.Interrogation.DetailsListBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.MessageBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.RecordListBean;
import com.wd.doctor.MVP.Presenter.InterrogationPresenter;
import com.wd.doctor.MVP.View.Interrogation.Adapter.InterrogationAdapter;
import com.wd.doctor.MVP.View.Interrogation.Adapter.QuestioningAdapter;
import com.wd.doctor.MVP.View.ShowActivity.InterrogationActivity;
import com.wd.doctor.R;
import com.wd.doctor.R2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//问诊聊天页面
public class QuestioningActivity extends BaseActivity<InterrogationPresenter> implements InterrogationContracter.IView {

    private static final String TAG = "QuestioningActivity";
    @BindView(R2.id.ques_backk)
    SimpleDraweeView quesBackk;
    @BindView(R2.id.ques_bell)
    ImageView quesBell;
    @BindView(R2.id.ques_title)
    TextView quesTitle;
    @BindView(R2.id.questioning_recycler)
    RecyclerView questioningRecycler;
    @BindView(R2.id.questoning_edit_text)
    EditText questoningEditText;
    @BindView(R2.id.questoning_but_send)
    Button questoningButSend;
    @BindView(R2.id.introduction_smart)
    SmartRefreshLayout interrSmart;

    private String mId;
    private String mSessionId;
    private ArrayList<RecordListBean.ResultBean> mList;
    int page = 1;
    private QuestioningAdapter mQuestioningAdapter;
    private int mRecordId;
    private int mMsgType;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_questioning;
    }

    @Override
    protected void initData() {
        SPUtils spUtils = new SPUtils(QuestioningActivity.this, "LoginId");
        mId = spUtils.getString("Id", "");
        mSessionId = spUtils.getString("SessionId", "");
        //查询问诊评价详情(存值)
        SPUtils spRecordId = new SPUtils(QuestioningActivity.this, "InterrogationRecordId");
        mRecordId = spRecordId.getInt("recordId");
        mP.getDetailsListPresenter(mId, mSessionId, mRecordId, 1, 5);//查询医生的问诊记录列表
        Logger.d(TAG, "spRecordId:" + mRecordId + "ss");
        interrSmart.setEnableRefresh(true);
        interrSmart.setEnableLoadMore(true);
        interrSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page++;
                mP.getDetailsListPresenter(mId, mSessionId, mRecordId, page, 5);//查询医生的问诊记录列表
                refreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                if (mList != null) {
                    mList.clear();
                } else {
                    ToastUtils.show("当前无问诊消息");
                }
                page = 1;
                mP.getDetailsListPresenter(mId, mSessionId, mRecordId, page, 5);//查询医生的问诊记录列表
                refreshLayout.finishRefresh();
            }
        });

    }

    @Override
    public void onSuccess(Object data) {
        DetailsListBean detailsListBean = (DetailsListBean) data;
        List<DetailsListBean.ResultBean> result = detailsListBean.getResult();
        if ("0000".equals(detailsListBean.getStatus())){
            mMsgType = result.get(0).getMsgType();
            Logger.d(TAG,"mMsgType"+mMsgType);
            if (mMsgType==1){
                ToastUtils.show("文本格式");
            }else if (mMsgType==2){
                ToastUtils.show("图片");
            }else {
                ToastUtils.show("语言");
            }
            mList = new ArrayList<>();
            questioningRecycler.setLayoutManager(new LinearLayoutManager(QuestioningActivity.this));
            mQuestioningAdapter = new QuestioningAdapter(QuestioningActivity.this, result);
            questioningRecycler.setAdapter(mQuestioningAdapter);
        }
    }


    @Override
    public void onDetailsListSuccess(Object data) {
        MessageBean messageBean = (MessageBean) data;
        Logger.d(TAG, "MessageBean:" + messageBean.getMessage());
    }

    @OnClick({R2.id.ques_backk, R2.id.ques_bell, R.id.questoning_but_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ques_backk:
                finish();
                break;
            case R.id.ques_bell://问诊详情页面
                IntentUtils.getInstence().intentStart(QuestioningActivity.this, DetailedInquiryActivity.class);
                break;
            case R.id.questoning_but_send://点击发送消息
                String mEditText = questoningEditText.getText().toString().trim();
                if (mEditText != null) {
                    mP.getMessagePresenter(mId, mSessionId, 3853, mEditText, 1, 456);
                } else {
                    ToastUtils.show("输入不能为空");
                }
                break;
        }
    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public InterrogationPresenter mPresenter() {
        return new InterrogationPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    public void onDetailsListFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}
