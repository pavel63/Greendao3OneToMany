package com.pavelwinter.greendao3onetomany;

import android.app.Application;

import com.facebook.stetho.Stetho;

import org.greenrobot.greendao.database.Database;

/**
 * Created by newuser on 08.10.2017.
 */

public class App extends Application {

    DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "mydbs");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

        Stetho.initializeWithDefaults(getApplicationContext());
    }

    public DaoSession getDaoSession(){
        return daoSession;

    }
}
