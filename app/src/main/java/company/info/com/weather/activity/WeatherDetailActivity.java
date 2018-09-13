package company.info.com.weather.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import company.info.com.weather.R;
import company.info.com.weather.databinding.ActivityWeatherDetailBinding;
import company.info.com.weather.viewmodel.WeatherDetailViewModel;

public class WeatherDetailActivity extends AppCompatActivity {

    WeatherDetailViewModel weatherDetailViewModel = new WeatherDetailViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityWeatherDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_weather_detail);
        binding.setViewModal(weatherDetailViewModel);

        this.getLifecycle().addObserver(weatherDetailViewModel);
    }
}
