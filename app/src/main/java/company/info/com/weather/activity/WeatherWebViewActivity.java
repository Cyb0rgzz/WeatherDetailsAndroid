package company.info.com.weather.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import company.info.com.weather.R;
import company.info.com.weather.databinding.ActivityWeatherWebViewBinding;
import company.info.com.weather.viewmodel.WeatherWebViewModel;

public class WeatherWebViewActivity extends AppCompatActivity {

    WeatherWebViewModel viewModel = new WeatherWebViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityWeatherWebViewBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_weather_web_view);
        binding.setViewModel(viewModel);

        this.getLifecycle().addObserver(viewModel);
    }
}
