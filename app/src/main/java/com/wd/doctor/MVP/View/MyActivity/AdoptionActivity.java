package com.wd.doctor.MVP.View.MyActivity;

import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwei.example.mylibrary.Base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.R;
import com.wd.doctor.R2;

import butterknife.BindView;

//被采纳意见
public class AdoptionActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    @BindView(R2.id.adoption_backk)
    SimpleDraweeView adoptionBackk;
    @BindView(R2.id.adoption_sim_view)
    SimpleDraweeView adoptionSimView;
    @BindView(R2.id.adoption_text_name)
    TextView adoptionTextName;
    @BindView(R2.id.adoption_text_view)
    TextView adoptionTextView;
    @BindView(R2.id.adoption_text_disease)
    TextView adoptionTextDisease;
    @BindView(R2.id.adoption_text_time)
    TextView adoptionTextTime;
    @BindView(R2.id.relative)
    RelativeLayout relative;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_adoption;
    }

    @Override
    public HomePresenter mPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
    }

    @Override
    public void onSuccess(Object data) {

    }

    @Override
    public void onImgSuccess(Object data) {

    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onImgFailure(Throwable e) {

    }


}
