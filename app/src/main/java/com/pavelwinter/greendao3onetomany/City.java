package com.pavelwinter.greendao3onetomany;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Created by newuser on 08.10.2017.
 */

@Entity
public class City {

    @Id
    private Long _id;

    private String cityName;


    @ToMany(referencedJoinProperty = "cityId")
    private List<Street> streets;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 448079911)
    private transient CityDao myDao;


    @Generated(hash = 1474856835)
    public City(Long _id, String cityName) {
        this._id = _id;
        this.cityName = cityName;
    }


    @Generated(hash = 750791287)
    public City() {
    }


    public Long get_id() {
        return this._id;
    }


    public void set_id(Long _id) {
        this._id = _id;
    }


    public String getCityName() {
        return this.cityName;
    }


    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 2017518862)
    public List<Street> getStreets() {
        if (streets == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StreetDao targetDao = daoSession.getStreetDao();
            List<Street> streetsNew = targetDao._queryCity_Streets(_id);
            synchronized (this) {
                if (streets == null) {
                    streets = streetsNew;
                }
            }
        }
        return streets;
    }


    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1519402831)
    public synchronized void resetStreets() {
        streets = null;
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }


    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 293508440)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCityDao() : null;
    }
}