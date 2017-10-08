package com.pavelwinter.greendao3onetomany;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by newuser on 08.10.2017.
 */

@Entity
public class Street {

    @Id
    private Long _id;

    private String streetName;

    private Long cityId;

    @Generated(hash = 986664171)
    public Street(Long _id, String streetName, Long cityId) {
        this._id = _id;
        this.streetName = streetName;
        this.cityId = cityId;
    }

    @Generated(hash = 1146976529)
    public Street() {
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Long getCityId() {
        return this.cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
