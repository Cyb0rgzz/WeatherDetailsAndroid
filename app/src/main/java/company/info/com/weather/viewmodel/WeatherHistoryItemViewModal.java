package company.info.com.weather.viewmodel;

import android.graphics.drawable.Drawable;

public class WeatherHistoryItemViewModal {
    private String cityName;
    private String weatherDesc;
    private String date;
    private int position;
    private Drawable icon;

    public WeatherHistoryItemViewModal(String city, String desc, String date, Drawable icon) {
        this.cityName = city;
        this.weatherDesc = desc;
        this.date = date;
        this.icon = icon;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
