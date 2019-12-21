package com.wd.doctor.MVP.View.Interrogation.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Tools.SPUtils;
import com.bwei.example.mylibrary.Tools.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Model.Bean.Interrogation.RecordListBean;
import com.wd.doctor.MVP.View.Interrogation.DetailedInquiryActivity;
import com.wd.doctor.MVP.View.Interrogation.QuestioningActivity;
import com.wd.doctor.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.View.Interrogation.Adapter
 * @ClassName: QuestioningAdapter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/15 20:05
 * @UpdateDate: 2019/12/15 20:05
 * @Version: 3.5
 */


public class QuestioningAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    RecordListBean.ResultBean result;
    private View mInflate;

    public QuestioningAdapter(QuestioningActivity questioningActivity, RecordListBean.ResultBean result) {
        this.mContext = questioningActivity;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mInflate = LayoutInflater.from(mContext).inflate(R.layout.questioning_layout, parent, false);
        return new ViewHolder(mInflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            if (result!=null){
            ((ViewHolder) holder).questioningName.setText(result.nickName);
            ((ViewHolder) holder).questioningSim.setImageURI(result.userHeadPic);
            Date date = new Date(result.inquiryTime);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd  hh:mm");
            ((ViewHolder) holder).questioningTime.setText(simpleDateFormat.format(date));
            ((ViewHolder) holder).questioningLinear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SPUtils spUtils = new SPUtils(mContext, "RecordList");
                    spUtils.putInt("recordId", result.recordId);//聊天id
                    spUtils.putInt("userId", result.userId);//用户id
                    Intent intent = new Intent(mContext, DetailedInquiryActivity.class);
                    mContext.startActivity(intent);
                }
            });
            }else {
                ToastUtils.show("当前无问诊消息");
            }
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.questioning_sim)
        SimpleDraweeView questioningSim;
        @BindView(R.id.questioning_name)
        TextView questioningName;
        @BindView(R.id.questioning_details)
        TextView questioningDetails;
        @BindView(R.id.questioning_time)
        TextView questioningTime;
        @BindView(R.id.questioning_prompt)
        ImageView questioningPrompt;
        @BindView(R.id.questioning_delete)
        TextView questioningDelete;
        @BindView(R.id.questioning_linear)
        LinearLayout questioningLinear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
