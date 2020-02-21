package com.wd.doctor.MVP.View.MyActivity.Adapter;

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

import com.bwei.example.mylibrary.Tools.IntentUtils;
import com.bwei.example.mylibrary.Tools.Logger;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.wd.doctor.MVP.Model.Bean.Doctor.DoctorIncomeBean;
import com.wd.doctor.MVP.Model.Bean.Patients.FindSickCircleListBean;
import com.wd.doctor.MVP.View.MyActivity.WalletActivity;
import com.wd.doctor.MVP.View.MyActivity.WithdrawalsActivity;
import com.wd.doctor.MVP.View.ShowActivity.ShowAdapter.WardMateBottonAdapter;
import com.wd.doctor.MVP.View.WardmateItem.SickCircleInfoActivity;
import com.wd.doctor.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.View.MyActivity.Adapter
 * @ClassName: WalletAdapter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/26 17:20
 * @UpdateDate: 2019/12/26 17:20
 * @Version: 3.5
 */


public class WalletAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    List<DoctorIncomeBean.ResultBean> result;
    private View mInflate;


    public WalletAdapter(WalletActivity wardmateActivity, List<DoctorIncomeBean.ResultBean> result) {
        this.mContext = wardmateActivity;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mInflate = LayoutInflater.from(mContext).inflate(R.layout.wallet_layout_botton, parent, false);
        return new ViewHolder(mInflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            if (result.get(position).getIncomeType() == 1) {
                ((ViewHolder) holder).walletName.setText("问诊咨询");
            } else if (result.get(position).getIncomeType() == 2) {
                ((ViewHolder) holder).  walletName.setText("病友圈建议被采纳");
            } else if (result.get(position).getIncomeType() == 3) {
                ((ViewHolder) holder).  walletName.setText("收礼物");
            } else {
                ((ViewHolder) holder). walletName.setText("提现");
            }
            Date date = new Date(result.get(position).getRecordTime());
            String day = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                day = simpleDateFormat.format(date);
            }catch (Exception e){
                e.printStackTrace();
            }
            ((ViewHolder) holder).walletTime.setText(day);
            if (result.get(0).getDirection() == 1) {
                ((ViewHolder) holder).walletBluePrice.setVisibility(View.VISIBLE);
                String MoneyBlue = String.valueOf(result.get(0).getMoney());
                ((ViewHolder) holder).walletBluePrice.setText("+" + MoneyBlue);
            } else {
                ((ViewHolder) holder). walletRedPrice.setVisibility(View.VISIBLE);
                String MoneyRed = String.valueOf(result.get(0).getMoney());
                ((ViewHolder) holder).walletRedPrice.setText("-" + MoneyRed);
            }
        }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.wallet_name)
        TextView walletName;
        @BindView(R.id.wallet_time)
        TextView walletTime;
        @BindView(R.id.wallet_red_price)
        TextView walletRedPrice;
        @BindView(R.id.wallet_blue_price)
        TextView walletBluePrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

