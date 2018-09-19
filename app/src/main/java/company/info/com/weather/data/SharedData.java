package company.info.com.weather.data;

import android.content.res.Resources;

public class SharedData {
    private static String cityData;
    private static String cityID;
    private static String weatherDescription;
    private static Resources resources;

    public static String getCityData() {
        return cityData;
    }

    public static String getCityId() {
        return cityID;
    }

    public static void setCityId(String cityId) {
        SharedData.cityID = cityId;
    }

    public static void setCityData(String cityData) {
        SharedData.cityData = cityData;
    }

    public static String getWeatherDescription() {
        return weatherDescription;
    }

    public static void setWeatherDescription(String weatherDescription) {
        SharedData.weatherDescription = weatherDescription;
    }

    public static Resources getResources() {
        return resources;
    }

    public static void setResources(Resources resources) {
        SharedData.resources = resources;
    }
}
