package com.wd.doctor.MVP.View.MyActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.FindSystemImagePicBean;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.MVP.View.MyActivity.MyAdapter.ImagePhotoAdapter;
import com.wd.doctor.MVP.View.ShowActivity.ManagementActivity;
import com.wd.doctor.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//形象照
public class ImagePhotoActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    @BindView(R.id.image_photo_but)
    TextView imagePhotoBut;
    @BindView(R.id.xxz)
    TextView xxz;
    @BindView(R.id.image_photo_pic_recycler)
    RecyclerView imagePhotoPic;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_image_photo;
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
        //系统形象照
        mP.getFindSystemImagePicPresenter();

    }

    @Override
    public void onSuccess(Object data) {
        FindSystemImagePicBean imagePicBean = (FindSystemImagePicBean) data;
        List<FindSystemImagePicBean.ResultBean> result = imagePicBean.getResult();
       imagePhotoPic.setLayoutManager(new LinearLayoutManager(ImagePhotoActivity.this,RecyclerView.HORIZONTAL,false));
       imagePhotoPic.setAdapter(new ImagePhotoAdapter(ImagePhotoActivity.this,result));
        if ("0000".equals(imagePicBean.getStatus())) {
            imagePhotoPic.setLayoutManager(new LinearLayoutManager(ImagePhotoActivity.this,LinearLayoutManager.HORIZONTAL,false));
            imagePhotoBut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ImagePhotoActivity.this, ManagementActivity.class);
                    for (int i = 0; i < result.size(); i++) {
                        intent.putExtra("ImagePhoto",imagePicBean.getResult().get(i).getImagePic());
                    }
                    startActivity(intent);
                    finish();
                }
            });

        }
    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}
