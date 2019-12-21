package com.wd.doctor.MVP.View.MyActivity;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;
import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.IntentUtils;
import com.bwei.example.mylibrary.Tools.Logger;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.bwei.example.mylibrary.Tools.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.MVP.View.ShowActivity.ManagementActivity;
import com.wd.doctor.MVP.View.widget.ImageUtil;
import com.wd.doctor.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

//设置形象照
public class SetImageActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    private static final String TAG = "SetImageActivity";
    @BindView(R.id.set_img_camera)
    ImageView setImgCamera;
    @BindView(R.id.set_image_but)
    TextView setImageBut;
    @BindView(R.id.set_sim_photo_pic)
    SimpleDraweeView setSimPhotoPic;
    @BindView(R.id.set_rela_photo_pic)
    RelativeLayout setRelaPhotoPic;
    private Dialog mDialog;
    private View mInflate;
    private Button mPic, mDiesmiss, mAlbum, mImage;
    private MultipartBody.Part picture;
    private String path = "";
    private Uri mUriForFile;
    //需要的权限数组 读/写/相机
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
    private String mId;
    private String mSessionId;
    private SPUtils mSpImagePhoto;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_image;
    }

    @Override
    protected void initData() {
        //存相机照片传到其他activity
        mSpImagePhoto = new SPUtils(SetImageActivity.this, "ImagePhoto");

        SPUtils spUtils = new SPUtils(SetImageActivity.this, "LoginId");
        mId = spUtils.getString("Id");
        mSessionId = spUtils.getString("SessionId");
   /*     setImgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setImgCamera != null) {
                    Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//用来打开相机的Intent
                    //这句作用是如果没有相机则该应用不会闪退，要是不加这句则当系统没有相机应用的时候该应用会闪退
                    if (takePhotoIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePhotoIntent, 0);//启动相机
                    }
                }
            }
        });*/
        //完成设置
        setImageBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtils.getInstence().intentStart(SetImageActivity.this, ManagementActivity.class);
                finish();
            }
        });
     /*   setImgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(v);
            }
        });
        setSimPhotoPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(v);
            }
        });*/
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
        //形象照
        mImage = mInflate.findViewById(R.id.set_but_image);
        /*点击*/
        //调起相机
        mPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //检查是否已经获得相机的权限
                if (verifyPermissions(SetImageActivity.this, PERMISSIONS_STORAGE[2]) == 0) {
                    ActivityCompat.requestPermissions(SetImageActivity.this, PERMISSIONS_STORAGE, 3);
                } else {
                    //已经有权限
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 0);
                    mDialog.dismiss();
                }
            }
        });
        //形象照
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtils.getInstence().intentStart(SetImageActivity.this, ImagePhotoActivity.class);
                finish();
            }
        });
        //相册
        mAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show("打开相册");
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        "image*/*");
                intent.setType("image/*");
                setSimPhotoPic.setVisibility(View.VISIBLE);
                startActivityForResult(intent, 1);
                mDialog.dismiss();
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

    //相机
    public File saveBitmapFile(Bitmap bitmap) {
        String timeStamp = String.valueOf(new Date().getTime());
        File file = new File(Environment.getExternalStorageDirectory() +
                File.separator + timeStamp + ".jpg");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:  //相机返回的数据（相机的返回码）
                if (data != null) {
                    try {
                        Bitmap bitmap = data.getParcelableExtra("data");
                        if (bitmap != null) {
                            File file1 = saveBitmapFile(bitmap);//相机回调后的图片
                            RequestBody requestBody1 = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
                            MultipartBody.Part formData1 = MultipartBody.Part.createFormData("image", file1.getName(), requestBody1);
                            mSpImagePhoto.putString("ImagePath", String.valueOf(file1));//相机
                            Glide.with(this).load(file1)
                                    .placeholder(R.mipmap.ic_launcher_round)
                                    .error(R.mipmap.ic_launcher)
                                    .into(setSimPhotoPic);//设置要展示的图片
                            setRelaPhotoPic.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                break;
            case 1:
                //判断是不是选中图片了
                if (resultCode == Activity.RESULT_OK) {
                    Uri uri = data.getData();
                    if (uri != null) {
                        //用一个工具类获取图片的绝对路径,我会粘到下方
                        String path = ImageUtil.getPath(this, uri);//相册回调后的图片
                        Logger.d(TAG, "ath" + path);
                        mSpImagePhoto.putString("ImagePhotoPath", path);
                        Glide.with(this).load(path)
                                .placeholder(R.mipmap.ic_launcher_round)
                                .error(R.mipmap.ic_launcher)
                                .into(setSimPhotoPic);//设置要展示的图片
                        setRelaPhotoPic.setVisibility(View.GONE);
                        if (path != null) {
                            //转换为file类型
                            File file = new File(path);
                            //进行类型转换,因为在RetrofitService定义的是@Part MultipartBody.Part,所以要转成这样的格式
                            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                            picture = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
                        }
                    }
                } else {
                    Toast.makeText(this, "取消相册", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    @OnClick({R.id.set_sim_photo_pic, R.id.set_img_camera, R.id.set_image_but})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.set_sim_photo_pic:
                show(view);
                break;
            case R.id.set_img_camera:
                show(view);
                break;
            case R.id.set_image_but:
                finish();
                break;
        }
    }
    @Override
    public void onSuccess(Object data) {
       /* FindSystemImagePicBean chooseImagePicBean = (FindSystemImagePicBean) data;
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
        }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
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
    public HomePresenter mPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {

    }


}
