package com.bwei.example.mylibrary.Base;

import android.content.Context;

import com.bwei.example.mylibrary.app.App;

import java.lang.ref.WeakReference;

/**
 * BasePresenter声明规范：
 * 1、封装泛型 V extents {@link IBaseView}
 * 2、封装 {@link #attachView(IBaseView)} 和 {@link #detachView()}
 * 3、封装{@link #initModel()} 方便子类初始化 Model
 * 4、封装 {@link #ViewAttached()} 用来判断 V 是否为 null
 * 5、封装 {@link #getView()} 方便获取 V 进行结果回调
 * <p>
 * <p>
 * 子类使用规范：
 * {@link }
 */
public abstract class BasePresenter<V extends IBaseView> {

    private WeakReference<V> mWeakReference;

    public BasePresenter() {
        //初始化model层
        initModel();
    }

    //初始化model
    protected abstract void initModel();

    //绑定View
    protected void attachView(V v) {
        mWeakReference = new WeakReference<>(v);
    }

    //解除绑定
    protected void detachView() {
        if (mWeakReference != null) {
            mWeakReference.clear();
            mWeakReference = null;
        }
    }

    /**
     * 判断view是否挂载
     * <p>
     * 防止出现 presenter 层 view 调用空指针
     * 每次调用业务请求的时候都要先调用方法检查是否与 View 绑定
     * 只有返回ture才进行回调
     */
    protected boolean ViewAttached() {
        if (mWeakReference == null || mWeakReference.get() == null) {
            return false;
        }
        return true;
    }

    //获取view接口
    // 每只有 isViewAttached 返回ture的时候，才能调用他
    protected V getView() {
        return mWeakReference.get();
    }

    // context为上下文
    // 上下文为null，则返回应用上下文
    //IBaseView 上下文
    protected Context mContext() {
        if (ViewAttached() && getView().context() != null) {
            return getView().context();
        }
        return App.getAppContext();
    }
}
