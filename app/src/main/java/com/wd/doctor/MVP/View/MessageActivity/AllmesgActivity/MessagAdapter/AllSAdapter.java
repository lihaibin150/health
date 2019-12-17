package com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.MessagAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorSystemNoticeListBean;
import com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.AllSystemActivity;
import com.wd.doctor.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.View.MessageActivity.AllmesgActivity.MessagAdapter
 * @ClassName: AllSAdapter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/17 8:48
 * @UpdateDate: 2019/12/17 8:48
 * @Version: 3.5
 */

//系统消息
public class AllSAdapter extends RecyclerView.Adapter {
    Context mContext;
    DoctorSystemNoticeListBean.ResultBean result;
    private View mInflate;

    public AllSAdapter(AllSystemActivity allSystemActivity, DoctorSystemNoticeListBean.ResultBean result) {
        this.mContext = allSystemActivity;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mInflate = LayoutInflater.from(mContext).inflate(R.layout.all_sysyem_layout, parent, false);
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
            mName = itemView.findViewById(R.id.system_name);
            mTime = itemView.findViewById(R.id.system_time);
        }
    }
}
