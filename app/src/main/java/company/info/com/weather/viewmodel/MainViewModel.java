package company.info.com.weather.viewmodel;

import android.app.ProgressDialog;
import android.arch.lifecycle.LifecycleObserver;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import company.info.com.weather.R;
import company.info.com.weather.activity.WeatherDetailActivity;
import company.info.com.weather.activity.WeatherHistoryActivity;
import company.info.com.weather.activity.WeatherWebViewActivity;
import company.info.com.weather.data.SharedData;
import company.info.com.weatherlibs.client.RestAPIClient;
import company.info.com.weatherlibs.models.WeatherMaster;
import company.info.com.weatherlibs.services.WeatherInterface;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainViewModel implements LifecycleObserver {

    private static final String appId = "e624811ab1bf40da33e5b3752cf83f8e";
    public final ObservableField<String> cityName = new ObservableField<>();
    private WeatherInterface weatherInterface;
    private String inputValue;
    private Context context;
    private ProgressDialog progress;

    public void showLoadingDialog() {

        if (progress == null) {
            progress = new ProgressDialog(context);
            progress.setTitle(R.string.loading_title);
            progress.setMessage("Please wait...");
        }
        progress.show();
    }

    public void dismissLoadingDialog() {

        if (progress != null && progress.isShowing()) {
            progress.dismiss();
        }
    }

    public void setUp(View view) {
        inputValue = cityName.get();
        context = view.getContext();
    }


    public void getWeatherDetails(View view) {
        setUp(view);
        weatherInterface = RestAPIClient.getClient().create(WeatherInterface.class);
        weatherInterface.getWeatherForCity(inputValue, appId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this::onNext, this::onError, this::onCompleted);

       /* weatherInterface.getWeatherForCity(inputValue, appId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<WeatherMaster>() {
            @Override
            public void onCompleted() {
                dismissLoadingDialog();
                System.out.println("in on complete");
            }

            @Override
            public void onError(Throwable e) {
                dismissLoadingDialog();
                System.out.println("in on error"+e.getMessage());
            }

            @Override
            public void onNext(WeatherMaster weatherMaster) {
                showLoadingDialog();
                System.out.println("in on next");
                Toast.makeText(context,weatherMaster.getName()+" : "+weatherMaster.getWeather()[0].getDescription(),Toast.LENGTH_LONG).show();
                setSharedData(weatherMaster);
                startWeatherDetailActivity(context);
                System.out.println("After On next.................");
            }
        });*/
    }

    private void onCompleted() {
        dismissLoadingDialog();
        System.out.println("in on complete");
    }

    private void onNext(WeatherMaster weatherMaster) {
        showLoadingDialog();
        System.out.println("in on next");
        Toast.makeText(context, weatherMaster.getName() + " : " + weatherMaster.getWeather()[0].getDescription(), Toast.LENGTH_LONG).show();
        setSharedData(weatherMaster);
        startWeatherDetailActivity(context);
        System.out.println("After On next.................");
    }

    private void onError(Throwable throwable) {
        dismissLoadingDialog();
        Toast.makeText(context,throwable.getMessage(), Toast.LENGTH_LONG);
        System.out.println("in on error----->>>>>>>>" + throwable.getMessage());
    }

    public void showWeatherHistory(View view) {
        setUp(view);
        SharedData.setCityData(cityName.get());
        SharedData.setResources(view.getResources());
        showLoadingDialog();
        startWeatherHistoryActivity(context);
        dismissLoadingDialog();
    }

    public void launchWebView(View view){
        setUp(view);
        testMethod();
        Intent intent = new Intent(context, WeatherWebViewActivity.class);
        context.startActivity(intent);
    }

    public void testMethod(){
        AsyncTask.execute( () -> {
                try {
                    SharedData.setCityId(new GsonParse().getWeather(cityName.get()).getCityId());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
    }
    private void startWeatherHistoryActivity(Context context) {
        Intent myIntent = new Intent(context, WeatherHistoryActivity.class);
        context.startActivity(myIntent);
    }

    private void startWeatherDetailActivity(Context context) {
        Intent myIntent = new Intent(context, WeatherDetailActivity.class);
        context.startActivity(myIntent);
    }

    private void setSharedData(WeatherMaster weatherMaster) {
        SharedData.setCityData(weatherMaster.getName());
        SharedData.setWeatherDescription(weatherMaster.getWeather()[0].getDescription());
    }

}
