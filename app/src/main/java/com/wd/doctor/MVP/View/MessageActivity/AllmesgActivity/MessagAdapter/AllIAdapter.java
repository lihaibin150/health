package com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.MessagAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorInquiryNoticeListBean;
import com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.AllInterrogationActivity;
import com.wd.doctor.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.MessagAdapter
 * @ClassName: AllIAdapter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/17 9:14
 * @UpdateDate: 2019/12/17 9:14
 * @Version: 3.5
 */

//问诊
public class AllIAdapter extends RecyclerView.Adapter {
    Context mContext;
    DoctorInquiryNoticeListBean.ResultBean result;
    private View mInflate;

    public AllIAdapter(AllInterrogationActivity allInterrogationActivity, DoctorInquiryNoticeListBean.ResultBean result) {
        this.mContext = allInterrogationActivity;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mInflate = LayoutInflater.from(mContext).inflate(R.layout.all_interrogation_layout, parent, false);
        return new ViewHolder(mInflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).mName.setText(result.content);
            Date date = new Date(result.createTime);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd  hh:mm");
            ((ViewHolder) holder).mTime.setText(simpleDateFormat.format(date));
        }
    }

    @Override
    public int getItemCount() {
        if (result != null) {
            return 1;
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTime, mName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.interrogation_name);
            mTime = itemView.findViewById(R.id.interrogation_time);
        }
    }
}
