package com.wd.doctor.MVP.View.MyActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.entity.SimpleBannerInfo;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Model.Bean.Doctor.FindSystemImagePicBean;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.R;

import java.util.AbstractList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//形象照
public class ImagePhotoActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {


    @BindView(R.id.imqu_btn_butone)
    Button imquBtnButone;
    @BindView(R.id.imqu_xb_xbannerone)
    XBanner imquXbXbannerone;
    private String mSessionId;
    private String mId;
    private String mImagePic;

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
        SPUtils spUtils = new SPUtils(ImagePhotoActivity.this, "LoginId");
        mId = spUtils.getString("Id", "");
        mSessionId = spUtils.getString("SessionId", "");
        imquBtnButone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mP.getChooseImagePicPresenter(mId, mSessionId, mImagePic);
                mP.getFindSystemImagePicPresenter();
                finish();
            }
        });


    }

    @Override
    public void onSuccess(Object data) {
        FindSystemImagePicBean chooseImagePicBean = (FindSystemImagePicBean) data;
        List<FindSystemImagePicBean.ResultBean> result = chooseImagePicBean.getResult();
        if ("0000".equals(chooseImagePicBean.getStatus())) {
            imquXbXbannerone.setBannerData(R.layout.fresco_query, new AbstractList<SimpleBannerInfo>() {
                @Override
                public SimpleBannerInfo get(int index) {
                    return null;
                }

                @Override
                public int size() {
                    return result.size();
                }
            });
            imquXbXbannerone.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    SimpleDraweeView fresco_sdv_freone = view.findViewById(R.id.fresco_sdv_freone);
                    mImagePic = result.get(position).getImagePic();
                    Uri parse = Uri.parse(mImagePic);
                    fresco_sdv_freone.setImageURI(parse);
                }
            });
        }
       /* FindSystemImagePicBean imagePicBean = (FindSystemImagePicBean) data;
        List<FindSystemImagePicBean.ResultBean> result = imagePicBean.getResult();
        imagePhotoPic.setLayoutManager(new LinearLayoutManager(ImagePhotoActivity.this, RecyclerView.HORIZONTAL, false));
        imagePhotoPic.setAdapter(new ImagePhotoAdapter(ImagePhotoActivity.this, result));
        if ("0000".equals(imagePicBean.getStatus())) {
            imagePhotoPic.setLayoutManager(new LinearLayoutManager(ImagePhotoActivity.this, LinearLayoutManager.HORIZONTAL, false));
            imagePhotoBut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ImagePhotoActivity.this, ManagementActivity.class);
                    for (int i = 0; i < result.size(); i++) {
                        intent.putExtra("ImagePhoto", imagePicBean.getResult().get(i).getImagePic());
                    }
                    startActivity(intent);
                    finish();
                }
            });
        }*/
    }

    @Override
    public void onImgSuccess(Object data) {

    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onImgFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}
