package com.bwei.example.mylibrary.app;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.bwei.example.mylibrary.R;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.bwei.example.mylibrary.Tools.ToastUtils;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.io.File;

/**
 * @Package: com.bwei.example.shoppingcart.app
 * @describe(描述)：App.java
 * @ClassName: App
 * @data（日期）: 2019/11/5
 * @time（时间）: 18:55
 * @author（作者）: 李海斌
 * @UpdateRemark: 更新说明：Android
 * @Version: 3.5
 **/


public class App extends Application {
    //全局上下文
    public static App sContext;

    public static App getInstance() {
        return sContext;
    }

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.design_default_color_primary, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        //吐司上下文
        ToastUtils.init(sContext);
        //图片缓存处理
        Fresco.initialize(this, ImagePipelineConfig.newBuilder(this)
                //图片缓存路径
                .setMainDiskCacheConfig(DiskCacheConfig.newBuilder(this)
                        .setBaseDirectoryPath(new File(Environment.getExternalStorageDirectory().getAbsolutePath()))
                        .setMaxCacheSize(10 * 1024 * 1024)
                        .build())
                .build());
    }

    public static App getAppContext() {
        return sContext;
    }
}
