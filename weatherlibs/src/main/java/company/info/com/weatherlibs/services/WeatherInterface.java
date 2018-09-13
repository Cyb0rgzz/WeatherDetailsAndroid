package company.info.com.weatherlibs.services;

import company.info.com.weatherlibs.models.hourlyweather.HourlyWeatherHistoryDetailsMaster;
import company.info.com.weatherlibs.models.WeatherMaster;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface WeatherInterface {

    static final String HOURLY_WEATHER_KEY = "490b33f743d940668998e0d3bf2deb33";

    @GET("/data/2.5/weather?")
    Observable<WeatherMaster> getWeatherForCity(@Query("q") String cityName,
                                                @Query("appid") String appId);


    @GET("/v2.0/history/hourly?")
    Observable<HourlyWeatherHistoryDetailsMaster> getHourlyWeatherForCity(@Query("city") String cityName,
                                                                          @Query("start_date") String startDate,
                                                                          @Query("end_date") String endDate,
                                                                          @Query("key") String key);
}
