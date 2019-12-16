package com.bwei.example.mylibrary.Test;

import android.content.Context;
import android.widget.Toast;

//吐司
public class ToastUtils {
    private static Toast mToast;
    public static boolean isShow = true;
    public static void init(Context context) {
        mToast = Toast.makeText(context, null, Toast.LENGTH_LONG);
    }

    public static void showInt(int resId) {
        mToast.setText(resId);
        mToast.show();
    }

    public static void show(String charSequence) {
        mToast.setText(charSequence);
        mToast.show();
    }

}