package com.wd.doctor.MVP.View.Interrogation.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Model.Bean.Interrogation.DetailsListBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.RecordListBean;
import com.wd.doctor.MVP.View.Interrogation.QuestioningActivity;
import com.wd.doctor.R;

import java.util.List;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.View.Interrogation.Adapter
 * @ClassName: QuestioningAdapter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/30 14:40
 * @UpdateDate: 2019/12/30 14:40
 * @Version: 3.5
 */


public class QuestioningAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private getposition getposition;
    List<DetailsListBean.ResultBean> result;

    public QuestioningAdapter(QuestioningActivity questioningActivity, List<DetailsListBean.ResultBean> result) {
        this.mContext = questioningActivity;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.user_layout, parent, false);
            return new MyUserHolder(inflate);
        } else if (viewType == 1) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.doctor_layout, parent, false);
            return new MyDoctorHolder(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 0:
                if (holder instanceof MyUserHolder) {
                    ((MyUserHolder) holder).mUserSimContent.setImageURI(Uri.parse(result.get(position).getDoctorHeadPic()));
                    ((MyUserHolder) holder).mUserTextContent.setText(result.get(position).getContent());
                    if (getposition != null) {
                        getposition.getposition(position);
                    }
                }
                break;
            case 1:
                if (holder instanceof MyDoctorHolder) {
                    ((MyDoctorHolder) holder).mDoctorSimContent.setImageURI(Uri.parse(result.get(position).getUserHeadPic()));
                    ((MyDoctorHolder) holder).mDoctorTextContent.setText(result.get(position).getContent());
                    if (getposition != null) {
                        getposition.getposition(position);
                    }
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    @Override
    public int getItemViewType(int position) {
        int direction = result.get(position).getDirection();
        if (direction == 1) {
            return 1;
        } else if (direction == 2) {
            return 0;
        }
        return 0;
    }

    class MyUserHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView mUserSimContent;
        private final TextView mUserTextContent;

        public MyUserHolder(@NonNull View itemView) {
            super(itemView);
            mUserSimContent = itemView.findViewById(R.id.user_sim_content);
            mUserTextContent = itemView.findViewById(R.id.user_text_content);
        }
    }

    class MyDoctorHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView mDoctorSimContent;
        private final TextView mDoctorTextContent;

        public MyDoctorHolder(@NonNull View itemView) {
            super(itemView);
            mDoctorSimContent = itemView.findViewById(R.id.doctor_sim_content);
            mDoctorTextContent = itemView.findViewById(R.id.doctor_text_content);
        }
    }

    public void setId(getposition getposition) {
        this.getposition = getposition;
    }

    public interface getposition {
        void getposition(int position);
    }
}
