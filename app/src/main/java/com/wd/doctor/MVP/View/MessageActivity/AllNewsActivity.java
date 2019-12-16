package com.wd.doctor.MVP.View.MessageActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bwei.example.mylibrary.Test.IntentUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.AllCurrencyActivity;
import com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.AllInterrogationActivity;
import com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.AllSystemActivity;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//全部消息
public class AllNewsActivity extends AppCompatActivity {

    @BindView(R.id.all_backk)
    SimpleDraweeView allBackk;
    @BindView(R.id.back_bell)
    TextView backBell;
    @BindView(R.id.all_del)
    ImageView allDel;
    @BindView(R.id.all_but)
    Button allBut;
    @BindView(R.id.all_system)
    RelativeLayout allSystem;
    @BindView(R.id.all_text_size)
    TextView allTextSize;
    @BindView(R.id.all_query)
    RelativeLayout allQuery;
    @BindView(R.id.all_interrogation)
    RelativeLayout allInterrogation;
    @BindView(R.id.all_currency)
    RelativeLayout allCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_news);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.all_system, R.id.all_interrogation, R.id.all_currency})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.all_system://系统消息
                IntentUtils.getInstence().intentStart(AllNewsActivity.this, AllSystemActivity.class);
                break;
            case R.id.all_interrogation://问诊消息
                IntentUtils.getInstence().intentStart(AllNewsActivity.this, AllInterrogationActivity.class);
                break;
            case R.id.all_currency://H币消息
                IntentUtils.getInstence().intentStart(AllNewsActivity.this, AllCurrencyActivity.class);
                break;
        }
    }
}
