package com.wd.doctor.MVP.View.ShowActivity.ShowAdapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wd.doctor.MVP.Model.Bean.Patients.FindDepartmentBean;

import java.util.ArrayList;
import java.util.List;
/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.View.ShowActivity.ShowAdapter
 * @ClassName: WardMateTopAdapter
 * @Author: 作者名: 李海斌
 * @Description: 作用描述: 病友圈(动态展示列表)
 * @CreateDate: 2019/12/13 10:00
 * @UpdateDate: 2019/12/13 10:00
 * @Version: 3.5
 */

public class WardMateTopAdapter extends FragmentPagerAdapter {
    private ArrayList<String> tab;
    private List<FindDepartmentBean.ResultBean> list;
    private WardMateBottonFragment mWardMateBottonFragment;

    public WardMateTopAdapter(@NonNull FragmentManager fm, ArrayList<String> tab, List<FindDepartmentBean.ResultBean> list) {
        super(fm);
        this.tab = tab;
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("departmentId",list.get(position).getId());
        mWardMateBottonFragment = new WardMateBottonFragment();
        mWardMateBottonFragment.setArguments(bundle);
        return mWardMateBottonFragment;
    }

    @Override
    public int getCount() {
        return tab.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tab.get(position);
    }
}
