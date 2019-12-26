package com.wd.doctor.MVP.View.Interrogation.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Tools.Logger;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.bwei.example.mylibrary.Tools.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Model.Bean.Interrogation.RecordListBean;
import com.wd.doctor.MVP.View.Interrogation.QuestioningActivity;
import com.wd.doctor.MVP.View.ShowActivity.InterrogationActivity;
import com.wd.doctor.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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


public class InterrogationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    List<RecordListBean.ResultBean> result;
    private View mInflate;
    public InterrogationAdapter(InterrogationActivity questioningActivity, List<RecordListBean.ResultBean> result) {
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
            if (result != null) {
                ((ViewHolder) holder).questioningName.setText(result.get(position).getNickName());

                Logger.d("inte", "RecordListn:" + result.get(position).getNickName());
                ((ViewHolder) holder).questioningSim.setImageURI(result.get(position).getUserHeadPic());
                Date date = new Date(result.get(position).getInquiryTime());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd  hh:mm");
                ((ViewHolder) holder).questioningTime.setText(simpleDateFormat.format(date));
                if (result.get(position).getStatus()==2){
                    ((ViewHolder) holder).questioningPrompt.setVisibility(View.VISIBLE);//显示提示(小红点)
                }
                ((ViewHolder) holder).questioningLinear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SPUtils spUtils = new SPUtils(mContext, "RecordList");
                        spUtils.putInt("recordId", result.get(position).getRecordId());//聊天id
                        spUtils.putInt("userId", result.get(position).getUserId());//用户id
                        Intent intent = new Intent(mContext, QuestioningActivity.class);
                        mContext.startActivity(intent);
                    }
                });
            } else {
                ToastUtils.show("当前无问诊消息");
            }

        }
    }

    @Override
    public int getItemCount() {
        return result.size();
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
        @BindView(R.id.questioning_relative)
        RelativeLayout questioningRelative;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
