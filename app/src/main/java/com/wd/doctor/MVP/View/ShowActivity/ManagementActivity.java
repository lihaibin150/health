package com.wd.doctor.MVP.View.ShowActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.IntentUtils;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.ChooseImagePicBean;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.AllCurrencyActivity;
import com.wd.doctor.MVP.View.MyActivity.AdoptionActivity;
import com.wd.doctor.MVP.View.MyActivity.AutomaticActivity;
import com.wd.doctor.MVP.View.MyActivity.DataActivity;
import com.wd.doctor.MVP.View.MyActivity.History.HistoryActivity;
import com.wd.doctor.MVP.View.MyActivity.SetImageActivity;
import com.wd.doctor.MVP.View.MyActivity.WalletActivity;
import com.wd.doctor.R;
import com.wd.doctor.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MultipartBody;

/*
 *管理(我的)
 *  */
public class ManagementActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    private static final String TAG = "ManagementActivity";
    @BindView(R2.id.manage_automatic_img)
    ImageView manageAutomaticImg;
    @BindView(R2.id.manage_backk)
    SimpleDraweeView manageBackk;
    @BindView(R2.id.manage_bell)
    ImageView manageBell;
    @BindView(R2.id.manage_zl)
    RelativeLayout manageZl;
    @BindView(R2.id.manage_historical)
    RelativeLayout manageHistorical;
    @BindView(R2.id.manage_wallet)
    RelativeLayout manageWallet;
    @BindView(R2.id.manage_recommendations)
    RelativeLayout manageRecommendations;
    @BindView(R2.id.manage_automatic)
    RelativeLayout manageAutomatic;
    private Dialog mDialog;
    private View mInflate;
    private Button mPic, mCancel;
    private String mId;
    private String mSessionId;
    private MultipartBody.Part mImage;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_management;
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
        SPUtils sploginUtils = new SPUtils(ManagementActivity.this, "LoginId");
        mId = sploginUtils.getString("Id", "");
        mSessionId = sploginUtils.getString("SessionId", "");
        SPUtils spUtils = new SPUtils(ManagementActivity.this, "ImagePhoto");
        String imagePhotoId = spUtils.getString("ImagePhotoId", "");
//        mP.getChooseImagePicPresenter(mId, mSessionId, imagePhotoId);

        Glide.with(ManagementActivity.this).load(imagePhotoId).into(manageAutomaticImg);

        SPUtils spImagePhoto = new SPUtils(ManagementActivity.this, "ImagePhoto");//从相册获取图片(imagephoneactivity)
        String imagePhotoPath = spImagePhoto.getString("ImagePhotoPath");//相册
        String imagePath = spImagePhoto.getString("ImagePath");//相机
       /* if (imagePhotoPath != null) {
            Glide.with(this).load(imagePhotoPath)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher)
                    .into(manageAutomaticImg);//设置要展示的图片
        }
        if (imagePath != null) {
            Glide.with(this).load(imagePath)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher)
                    .into(manageAutomaticImg);//设置要展示的图片
        }*/
        if (spImagePhoto!=null){
            Glide.with(this).load(imagePhotoPath)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher)
                    .into(manageAutomaticImg);//设置要展示的图片
        }else {
            Glide.with(this).load(imagePath)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher)
                    .into(manageAutomaticImg);//设置要展示的图片
        }

    }

    @Override
    public void onSuccess(Object data) {
        ChooseImagePicBean imagePicBean = (ChooseImagePicBean) data;
        String result = imagePicBean.getResult();
    }

    @Override
    public void onImgSuccess(Object data) {

    }

    @OnClick({R2.id.manage_automatic_img, R2.id.manage_backk, R2.id.manage_bell, R2.id.manage_zl, R2.id.manage_historical, R2.id.manage_wallet, R2.id.manage_recommendations, R2.id.manage_automatic})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.manage_automatic_img://头像
                show(view);
                break;
            case R.id.manage_backk://返回
                finish();
                break;
            case R.id.manage_bell://铃铛
                if (manageBell != null) {
                    IntentUtils.getInstence().intentStart(ManagementActivity.this, AllCurrencyActivity.class);
                }
                break;
            case R.id.manage_zl://查询资料
                IntentUtils.getInstence().intentStart(this, DataActivity.class);
                break;
            case R.id.manage_historical://历史问诊
                IntentUtils.getInstence().intentStart(ManagementActivity.this, HistoryActivity.class);
                break;
            case R.id.manage_wallet://我的钱包
                IntentUtils.getInstence().intentStart(ManagementActivity.this, WalletActivity.class);
                break;
            case R.id.manage_recommendations://被采纳意见
                IntentUtils.getInstence().intentStart(ManagementActivity.this, AdoptionActivity.class);
                break;
            case R.id.manage_automatic://设置自动回复
                IntentUtils.getInstence().intentStart(ManagementActivity.this, AutomaticActivity.class);
                break;
        }
    }

    public void show(View view) {
        mDialog = new Dialog(this, R.style.DialogTheme);
        //填充对话框的布局
        mInflate = LayoutInflater.from(this).inflate(R.layout.manag_ceshi, null);
        //初始化控件
        //形象照
        mPic = mInflate.findViewById(R.id.manag_but_pic);
        //取消
        mCancel = mInflate.findViewById(R.id.manag_but_dismiss);
        //形象照
        mPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtils.getInstence().intentStart(ManagementActivity.this, SetImageActivity.class);
                finish();
            }
        });
        //取消
        mCancel.setOnClickListener(new View.OnClickListener() {
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


    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onImgFailure(Throwable e) {

    }
}
