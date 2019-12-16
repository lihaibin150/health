package com.wd.doctor.MVP.View.MyActivity.MyAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Model.Bean.Doctor.FindSystemImagePicBean;
import com.wd.doctor.MVP.View.MyActivity.ImagePhotoActivity;
import com.wd.doctor.R;

import java.util.List;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.View.MyActivity.MyAdapter
 * @ClassName: ImagePhotoAdapter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/16 15:32
 * @UpdateDate: 2019/12/16 15:32
 * @Version: 3.5
 */


public class ImagePhotoAdapter extends RecyclerView.Adapter {
    Context mContext;
    List<FindSystemImagePicBean.ResultBean> result;
    private View mInflate;

    public ImagePhotoAdapter(ImagePhotoActivity imagePhotoActivity, List<FindSystemImagePicBean.ResultBean> result) {
        this.mContext = imagePhotoActivity;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mInflate = LayoutInflater.from(mContext).inflate(R.layout.image_phone_layout, parent, false);
        return new ViewHolder(mInflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            Glide.with(mContext).load(result.get(position).getImagePic()).into(((ViewHolder) holder).mSim);
        }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView mSim;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mSim = itemView.findViewById(R.id.image_sim);
        }
    }
}
