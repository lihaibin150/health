package com.wd.doctor.MVP.View.MyActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Test.IntentUtils;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

//设置形象照
public class SetImageActivity extends BaseActivity {

    @BindView(R.id.set_img_camera)
    ImageView setImgCamera;
    @BindView(R.id.set_image_but)
    TextView setImageBut;
    private Dialog mDialog;
    private View mInflate;
    private Button mPic, mDiesmiss, mAlbum;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_image;
    }

    @Override
    public HomePresenter mPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        setImageBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setImgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(v);
            }
        });
    }

    public void show(View view) {
        mDialog = new Dialog(this, R.style.DialogTheme);
        //填充对话框的布局
        mInflate = LayoutInflater.from(this).inflate(R.layout.set_ceshi, null);
        //初始化控件
        //拍照
        mPic = mInflate.findViewById(R.id.set_but_pic);
        //取消
        mDiesmiss = mInflate.findViewById(R.id.set_but_dismiss);
        //相册
        mAlbum = mInflate.findViewById(R.id.set_but_album);
        /*点击*/
        //相册
        mAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtils.getInstence().intentStart(SetImageActivity.this, ImagePhotoActivity.class);
                finish();
            }
        });
        //取消
        mDiesmiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });
        //将布局设置给Dialog
        mDialog.setContentView(mInflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = mDialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;//设置Dialog距离底部的距离
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        mDialog.show();//显示对话框
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}
