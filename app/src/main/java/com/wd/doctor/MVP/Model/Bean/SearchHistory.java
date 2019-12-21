package com.wd.doctor.MVP.Model.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * @ProjectName: health_doctor
 * @Package: com.bwei.example.mylibrary.Bean
 * @ClassName: SearchHistory
 * @Author: 作者名: 李海斌
 * @Description: 作用描述:
 * @CreateDate: 2019/12/19 13:53
 * @UpdateDate: 2019/12/19 13:53
 * @Version: 3.5
 */

@Entity
public class SearchHistory {
    @Id(autoincrement = true) //自增主键
    private Long id;
    @Unique // 搜索记录(唯一)
    private String name;
    @Generated(hash = 822577210)
    public SearchHistory(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1905904755)
    public SearchHistory() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}