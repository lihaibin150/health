package com.wd.doctor.MVP.Http.Utils;

import android.content.Context;

import java.io.File;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Http.Utils
 * @ClassName: FileUtil
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:绑定身份证
 * @CreateDate: 2019/12/24 10:01
 * @UpdateDate: 2019/12/24 10:01
 * @Version: 3.5
 */
public class FileUtil {
    public static File getSaveFile(Context context) {
        return new File(context.getFilesDir(), "pic.jpg");
    }
}
