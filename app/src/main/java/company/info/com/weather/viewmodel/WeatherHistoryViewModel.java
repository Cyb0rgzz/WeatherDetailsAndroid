package company.info.com.weather.viewmodel;

import android.app.ProgressDialog;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import company.info.com.weather.R;
import company.info.com.weather.data.SharedData;
import company.info.com.weather.util.DateUtil;
import company.info.com.weather.viewmodel.adapter.WeatherAdapter;
import company.info.com.weatherlibs.client.RestAPIClient;
import company.info.com.weatherlibs.models.hourlyweather.HourlyWeatherHistoryDetailsMaster;
import company.info.com.weatherlibs.services.WeatherInterface;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class WeatherHistoryViewModel implements LifecycleObserver  {

    private ProgressDialog progress;
    private Context context;
    private RecyclerView.LayoutManager layoutManager;
    private WeatherAdapter adapter = new WeatherAdapter(this);
    private static SwipeRefreshLayout swipeLayout;

    public void setContext(Context context) {
        this.context = context;
    }

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

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void fetchWeatherHistory() throws InterruptedException {
        WeatherInterface weatherInterface = RestAPIClient.getHourlyWeatherClient().create(WeatherInterface.class);
        showLoadingDialog();
        System.out.println("REQ DATA ----->>>> " + SharedData.getCityData() + ",IN " + DateUtil.getPreviousDate(-1)+ "," +DateUtil.getPreviousDate(0) +","+ WeatherInterface.HOURLY_WEATHER_KEY);
        //weatherInterface.getHourlyWeatherForCity(SharedData.getCityData() + ",IN", "2018-08-28", "2018-08-29", WeatherInterface.HOURLY_WEATHER_KEY)
        weatherInterface.getHourlyWeatherForCity(SharedData.getCityData() + ",IN", DateUtil.getPreviousDate(-1),DateUtil.getPreviousDate(0), WeatherInterface.HOURLY_WEATHER_KEY)
        //weatherInterface.getHourlyWeatherForCity(SharedData.getCityData() + ",IN", "2018-08-20", "2018-08-21", "490b33f743d940668998e0d3bf2deb33")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HourlyWeatherHistoryDetailsMaster>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("on complete ======");
                        dismissLoadingDialog();
                        swipeLayout.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        dismissLoadingDialog();
                        System.out.println("on error ========>" + e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(HourlyWeatherHistoryDetailsMaster hourlyWeatherHistoryDetailsMaster) {
                        adapter.setWeatherHistory(hourlyWeatherHistoryDetailsMaster, SharedData.getResources());
                    }
                });


    }

    public void refreshData() {
        try {
            fetchWeatherHistory();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WeatherAdapter getAdapter() {
        return adapter;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void removeItem(){
        Toast.makeText(context,"Clicked the Line Item", Toast.LENGTH_LONG);
        //adapter.removeSelectedItems();
    }

    @BindingAdapter("swipe")
    public static void refresh(SwipeRefreshLayout layout, RefreshListener listener) {
        swipeLayout = layout;
        layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                listener.refresh();

            }


        });
    }


}
