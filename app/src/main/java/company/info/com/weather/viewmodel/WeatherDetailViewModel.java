package company.info.com.weather.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.ObservableField;

import company.info.com.weather.data.SharedData;

public class WeatherDetailViewModel implements LifecycleObserver {

    public final ObservableField<String> cityName = new ObservableField<>("default");
    public final ObservableField<String> weatherDescription = new ObservableField<>("No Data Available..");

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void connectListener() {
        System.out.println("==================Inside Vm");
        cityName.set(SharedData.getCityData());
        weatherDescription.set(SharedData.getWeatherDescription());
    }

}
