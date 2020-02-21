package com.wd.doctor.MVP.View.widget;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.View.widget
 * @ClassName: RecordSQLiteOpenHelper
 * @Author: 作者名: 李海斌
 * @Description: 作用描述: 搜索框
 * @CreateDate: 2019/12/16 16:48
 * @UpdateDate: 2019/12/16 16:48
 * @Version: 3.5
 */

public class RecordSQLiteOpenHelper  extends SQLiteOpenHelper {
    private static String name = "record.db";
    private static Integer version = 1;


    public RecordSQLiteOpenHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //打开数据库，建立了一个叫records的表，里面只有一列name来存储历史记录：
        db.execSQL("create table records(id integer primary key autoincrement,name varchar(200))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}