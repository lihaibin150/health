package com.wd.doctor.MVP.View.loginActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.wd.doctor.R;
import com.wd.doctor.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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


public class GuidePageActivity extends AppCompatActivity {

    @BindView(R2.id.tv_miao)
    TextView tvMiao;
    int count = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_page);
        ButterKnife.bind(this);
        Message message = handler.obtainMessage(1);
        handler.sendMessageDelayed(message, 1000);

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    count--;
                    if (count > 0) {
                        Message message = handler.obtainMessage(1);
                        handler.sendMessageDelayed(message, 1000);
                    } else {
                        Intent intent = new Intent(GuidePageActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
            }
        }

    };

    @OnClick(R.id.tv_miao)
    public void onClick() {
        count=0;
    }
}
