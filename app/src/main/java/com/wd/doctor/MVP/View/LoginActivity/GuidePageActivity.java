package com.wd.doctor.MVP.View.LoginActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Base.BasePresenter;
import com.wd.doctor.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;

/**
 * @Package: com.wd.doctor.MVP.View.LoginActivity
 * @describe(描述)：GuidePageActivity.java
 * @ClassName: GuidePageActivity
 * @data（日期）: 2019/12/11
 * @time（时间）: 17:36
 * @author（作者）: 李海斌
 * @UpdateRemark: 更新说明：Android
 * @Version: 3.5
 **/

//引导页
public class GuidePageActivity extends BaseActivity {

    @BindView(R.id.guide_text)
    TextView guideText;
    private Intent intent;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            intent = new Intent(GuidePageActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

    };

    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            Message message = new Message();
            message.what = 0;
            handler.sendMessage(message);
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide_page;
    }

    @Override
    public BasePresenter mPresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    protected void initData() {
        timer.schedule(timerTask, 3000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
