package com.wd.doctor.MVP.View.ShowActivity.ShowAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.example.mylibrary.Test.SPUtils;
import com.wd.doctor.MVP.Model.Bean.Patients.FindSickCircleListBean;
import com.wd.doctor.MVP.View.WardmateItem.SickCircleInfoActivity;
import com.wd.doctor.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.View.ShowActivity.ShowAdapter
 * @ClassName: WardMateBottonAdapter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/13 10:00
 * @UpdateDate: 2019/12/13 10:00
 * @Version: 3.5
 */


public class WardMateBottonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    List<FindSickCircleListBean.ResultBean> result;
    private View mInflate;

    public WardMateBottonAdapter(FragmentActivity wardmateActivity, List<FindSickCircleListBean.ResultBean> result) {
        this.mContext = wardmateActivity;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mInflate = LayoutInflater.from(mContext).inflate(R.layout.wardmate_layout_botton, parent, false);
        return new ViewHolder(mInflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {

            ((ViewHolder) holder).bottonDetail.setText(result.get(position).getDetail());
            ((ViewHolder) holder).bottonName.setText(result.get(position).getTitle());
            Date date = new Date(result.get(position).getReleaseTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd  hh:mm");
            ((ViewHolder) holder).bottonTime.setText(simpleDateFormat.format(date));

            if (result.get(position).getAmount() == 0) {
                ((ViewHolder) holder).bottonImg.setVisibility(View.GONE);
                ((ViewHolder) holder).bottonPrice.setVisibility(View.GONE);
            } else {
                ((ViewHolder) holder).bottonPrice.setText(result.get(position).getAmount());
                ((ViewHolder) holder).bottonImg.setVisibility(View.VISIBLE);
                ((ViewHolder) holder).bottonPrice.setVisibility(View.VISIBLE);
            }
            ((ViewHolder) holder).bottonRelative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SPUtils spUtils = new SPUtils(mContext, "wardmate");
                    spUtils.putString("wardId", result.get(position).getSickCircleId() + "");
                    spUtils.putString("Amount", result.get(position).getAmount() + "");
                    Intent intent = new Intent(mContext, SickCircleInfoActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.botton_name)
        TextView bottonName;
        @BindView(R.id.botton_detail)
        TextView bottonDetail;
        @BindView(R.id.botton_time)
        TextView bottonTime;
        @BindView(R.id.botton_relative)
        RelativeLayout bottonRelative;
        @BindView(R.id.botton_price)
        TextView bottonPrice;
        @BindView(R.id.botton_img)
        ImageView bottonImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
