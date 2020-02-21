package com.wd.doctor.MVP.View.WardmateItem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.MVP.Model.Bean.Patients.SearchSickCircleBean;
import com.wd.doctor.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.View.WardmateItem.Adapter
 * @ClassName: SeachRecordAdapter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:搜索
 * @CreateDate: 2019/12/16 16:55
 * @UpdateDate: 2019/12/16 16:55
 * @Version: 3.5
 */

public class SeachRecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<SearchSickCircleBean.ResultBean> list;
    private Context context;

    public SeachRecordAdapter(List<SearchSickCircleBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.seach_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SearchSickCircleBean.ResultBean resultBean = list.get(position);
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).tv_detail_search.setText(resultBean.getDetail());
            ((MyViewHolder) holder).tv_title_search.setText(resultBean.getTitle());
            Date date = new Date(resultBean.getReleaseTime());
            String day = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                day = simpleDateFormat.format(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ((MyViewHolder) holder).tv_releaseTime_search.setText(day);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.onId(resultBean.getSickCircleId() + "");
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_detail_search, tv_title_search, tv_releaseTime_search;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_detail_search = itemView.findViewById(R.id.tv_detail_search);
            tv_title_search = itemView.findViewById(R.id.tv_title_search);
            tv_releaseTime_search = itemView.findViewById(R.id.tv_releaseTime_search);
        }
    }


    private onClick onClick;

    public void setOnClick(onClick onClick) {
        this.onClick = onClick;
    }

    public interface onClick {
        void onId(String sickCircleId);
    }
}
