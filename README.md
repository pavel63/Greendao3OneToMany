# Greendao3OneToMany
Отношения один-ко-многим в Orm Greendao 3


Отношения ONE-TO-MANY:
наиболее часто встречающийся вид отношений
один ко многим-то есть например-один город имеет много улиц
или один клиент может иметь несколько заказов
чтобы не дублировать в таблице одни те же клонки,просто делам “ссылку”
 на записи в другой таблице


связи между таблицами устанавливаются при помощи колонки с id той сущности,на которую ссылаются

Foireign key ссылается на Primary key


создадим новые две таблицы- City и Street:

@Entity
public class City {

    @Id
    private Long _id;

    private String cityName;


    @ToMany(referencedJoinProperty = "cityId")
    private List<Street> streets;
}




@Entity
public class Street {

    @Id
    private Long _id;

    private String streetName;

    private Long cityId;
}


обратим внимание на последнюю строку таблицы City-при помощи аннотации 
@ToOne с параметром referencedJoinProperty мы задаем название внешнего ключа 
в таблице,которая будет ссылаться на нашу таблицу.То есть в данном случае 
в таблице Street в у нас есть колонка cityId,куда мы пишем id необходимого города.

Создаем два города и три улицы:

  City city1=new City(null,"Moscow");
        City city2=new City(null,"London");

        cityDao.insert(city1);
        cityDao.insert(city2);

здесь третьим параметром пишем,какая улица к какому городу относится:
!Важно!-почему-то id в базе начинаются с 1,а не с 0.Это нужно учитывать при установлении отношений и запросах

        Street street1=new Street(null,"Neglinka",1L);
        Street street2=new Street(null,"Baker",2L);
        Street street3=new Street(null,"Kensington",2L);

        streetDao.insert(street1);
        streetDao.insert(street2);
        streetDao.insert(street3);




делаем стандартный запрос и выводим все улицы Лондона:

 
        QueryBuilder<City> cityQueryBuilder=cityDao.queryBuilder().where(CityDao
                .Properties.CityName.eq("London"));
        cityQueryBuilder.build();

        List<City> cityList=cityQueryBuilder.list();

        City city=cityList.get(0);

//вот здесь берется список относящихся к Лондону улиц:

        List<Street>streetList=city.getStreets();
        
     

