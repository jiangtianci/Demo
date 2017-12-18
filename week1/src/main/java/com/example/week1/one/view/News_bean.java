package com.example.week1.one.view;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by dell on 2017/12/2.
 */
@Entity
public class News_bean {
    @Id
    String desc;

    @Generated(hash = 142268248)
    public News_bean(String desc) {
        this.desc = desc;
    }

    @Generated(hash = 1329642343)
    public News_bean() {
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
