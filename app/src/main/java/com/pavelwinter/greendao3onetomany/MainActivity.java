package com.pavelwinter.greendao3onetomany;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DaoSession mDaoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mDaoSession=((App)getApplication()).getDaoSession();

        CityDao cityDao=mDaoSession.getCityDao();
        StreetDao streetDao=mDaoSession.getStreetDao();



        City city1=new City(null,"Moscow");
        City city2=new City(null,"London");


        cityDao.insert(city1);
        cityDao.insert(city2);


        Street street1=new Street(null,"Neglinka",1L);
        Street street2=new Street(null,"Baker",2L);
        Street street3=new Street(null,"Kensington",2L);


        streetDao.insert(street1);
        streetDao.insert(street2);
        streetDao.insert(street3);







        QueryBuilder<City> cityQueryBuilder=cityDao.queryBuilder().where(CityDao
                .Properties.CityName.eq("London"));
        cityQueryBuilder.build();

        List<City> cityList=cityQueryBuilder.list();

        City city=cityList.get(0);

        List<Street>streetList=city.getStreets();

        for(int i=0;i<streetList.size();i++) {

            Log.d("STREET_OF_LONDON: ", streetList.get(i).getStreetName());
        }
    }
}
