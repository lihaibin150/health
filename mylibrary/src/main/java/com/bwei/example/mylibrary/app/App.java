package com.bwei.example.mylibrary.app;

import android.app.Application;
import android.os.Environment;

import com.bwei.example.mylibrary.Test.ToastUtils;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

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
