package company.info.com.weather.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import company.info.com.weather.R;
import company.info.com.weather.databinding.ActivityWeatherHistoryBinding;
import company.info.com.weather.viewmodel.WeatherHistoryViewModel;

public class WeatherHistoryActivity extends AppCompatActivity {

    WeatherHistoryViewModel weatherHistoryViewModel = new WeatherHistoryViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityWeatherHistoryBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_weather_history);
        weatherHistoryViewModel.setLayoutManager(new LinearLayoutManager(this));
        weatherHistoryViewModel.setContext(this);
        binding.setViewModal(weatherHistoryViewModel);

        this.getLifecycle().addObserver(weatherHistoryViewModel);
    }
}
