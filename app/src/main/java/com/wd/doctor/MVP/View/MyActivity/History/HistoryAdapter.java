package com.wd.doctor.MVP.View.MyActivity.History;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Tools.IntentUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Model.Bean.Interrogation.RecordBean;
import com.wd.doctor.MVP.Model.Bean.Interrogation.RecordListBean;
import com.wd.doctor.MVP.View.ShowActivity.InterrogationActivity;
import com.wd.doctor.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.View.MyActivity.History
 * @ClassName: HistoryAdapter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/25 9:10
 * @UpdateDate: 2019/12/25 9:10
 * @Version: 3.5
 */

public class HistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    List<RecordBean.ResultBean> list;
    private View inflate;

    public HistoryAdapter(HistoryActivity HistoryActivity, List<RecordBean.ResultBean> result) {
        this.mContext = HistoryActivity;
        this.list = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = View.inflate(mContext, R.layout.history_layout_adapter, null);
        return new MyList(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyList) {
            ((MyList) holder).historySimPhoto.setImageURI(list.get(position).getUserHeadPic());
            ((MyList) holder).historyTextName.setText(list.get(position).getNickName());
            Date date = new Date(list.get(position).getInquiryTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ((MyList) holder).historyTextTime.setText(simpleDateFormat.format(date));
            ((MyList) holder).historyButRecord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {//查看历史问诊
                    IntentUtils.getInstence().intentStart(mContext, InterrogationActivity.class);
                }
            });
            ((MyList) holder).historyButRecord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {//点击跳转到查看评价页面
                    IntentUtils.getInstence().intentStart(mContext,ViewCommentsActivity.class);
                }
            });
            if (list.get(position).getStatus() == 1) {//查看评价
                ((MyList) holder).historyButEvaluation.setVisibility(View.GONE);
                ((MyList) holder).historyButNoEvaluation.setVisibility(View.VISIBLE);
            } else {
                ((MyList) holder).historyButEvaluation.setVisibility(View.VISIBLE);
                ((MyList) holder).historyButNoEvaluation.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyList extends RecyclerView.ViewHolder {
        @BindView(R.id.history_sim_photo)
        SimpleDraweeView historySimPhoto;
        @BindView(R.id.history_text_name)
        TextView historyTextName;
        @BindView(R.id.history_text_time)
        TextView historyTextTime;
        @BindView(R.id.history_but_record)
        Button historyButRecord;
        @BindView(R.id.history_but_evaluation)
        Button historyButEvaluation;
        @BindView(R.id.history_but_no_evaluation)
        TextView historyButNoEvaluation;

        public MyList(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
