package com.wd.doctor.MVP.Contracter.API;

import com.wd.doctor.MVP.Model.Bean.Patients.FindDepartmentBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @ProjectName: health_doctor
 * @Package: com.wd.doctor.MVP.Contracter.API
 * @ClassName: ApiWardmate
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/13 10:05
 * @UpdateDate: 2019/12/13 10:05
 * @Version: 3.5
 */

public interface ApiWardmate {
    //病友圈(查询科室列表)
    @GET("share/knowledgeBase/v1/findDepartment")
    Observable<FindDepartmentBean> FIND_DEPARTMENT();
}
