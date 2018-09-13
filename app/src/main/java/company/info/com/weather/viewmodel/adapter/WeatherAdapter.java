package company.info.com.weather.viewmodel.adapter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import company.info.com.weather.R;
import company.info.com.weather.databinding.ViewHourlyWeatherItemBinding;
import company.info.com.weather.viewmodel.WeatherHistoryItemViewModal;
import company.info.com.weather.viewmodel.WeatherHistoryViewModel;
import company.info.com.weatherlibs.models.hourlyweather.HourlyWeather;
import company.info.com.weatherlibs.models.hourlyweather.HourlyWeatherHistoryDetailsMaster;

public class WeatherAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private WeatherHistoryViewModel weatherHistoryViewModel;
    private List<WeatherHistoryItemViewModal> itemWeatherList = new ArrayList<>();
    MyViewHolder mMyViewHolder;
    Map<String, Integer> weatherIconMapping = new HashMap();
    Resources resources;
    String path = "/Users/pdauser/Desktop/images/";

    public WeatherAdapter(WeatherHistoryViewModel weatherHistoryViewModel) {
        populateMap();
      //  weatherIconMapping.put("c04d", "c04d.png");
        this.weatherHistoryViewModel = weatherHistoryViewModel;
    }

    private void populateMap() {
        weatherIconMapping.put("a01d", R.drawable.a01d);
        weatherIconMapping.put("a01n", R.drawable.a01n);
        weatherIconMapping.put("a02d", R.drawable.a02d);
        weatherIconMapping.put("a02n", R.drawable.a02n);
        weatherIconMapping.put("a03n", R.drawable.a03n);
        weatherIconMapping.put("a03d", R.drawable.a03d);
        weatherIconMapping.put("a04d", R.drawable.a04d);
        weatherIconMapping.put("a04n", R.drawable.a04n);
        weatherIconMapping.put("a05d", R.drawable.a05d);
        weatherIconMapping.put("a05n", R.drawable.a05n);
        weatherIconMapping.put("a06d", R.drawable.a06d);
        weatherIconMapping.put("a06n", R.drawable.a06n);

        weatherIconMapping.put("c01d", R.drawable.c01d);
        weatherIconMapping.put("c01n", R.drawable.c01n);
        weatherIconMapping.put("c02d", R.drawable.c02d);
        weatherIconMapping.put("c02n", R.drawable.c02n);
        weatherIconMapping.put("c03d", R.drawable.c03d);
        weatherIconMapping.put("c03n", R.drawable.c03n);
        weatherIconMapping.put("c04d", R.drawable.c04d);
        weatherIconMapping.put("c04n", R.drawable.c04n);

        weatherIconMapping.put("d01d", R.drawable.d01d);
        weatherIconMapping.put("d01n", R.drawable.d01n);
        weatherIconMapping.put("d02d", R.drawable.d02d);
        weatherIconMapping.put("d02n", R.drawable.d02n);
        weatherIconMapping.put("d03d", R.drawable.d03d);
        weatherIconMapping.put("d03n", R.drawable.d03n);

        weatherIconMapping.put("r01d", R.drawable.r01d);
        weatherIconMapping.put("r01n", R.drawable.r01n);
        weatherIconMapping.put("r02d", R.drawable.r02d);
        weatherIconMapping.put("r03n", R.drawable.r03n);
        weatherIconMapping.put("r04d", R.drawable.r04d);
        weatherIconMapping.put("r04n", R.drawable.r04n);
        weatherIconMapping.put("r05d", R.drawable.r05d);
        weatherIconMapping.put("r05n", R.drawable.r05n);
        weatherIconMapping.put("r06d", R.drawable.r06d);
        weatherIconMapping.put("r06n", R.drawable.r06n);

        weatherIconMapping.put("s01n", R.drawable.s01n);
        weatherIconMapping.put("s01d", R.drawable.s01d);
        weatherIconMapping.put("s02n", R.drawable.s02n);
        weatherIconMapping.put("s02d", R.drawable.s02d);
        weatherIconMapping.put("s03n", R.drawable.s03n);
        weatherIconMapping.put("s03d", R.drawable.s03d);
        weatherIconMapping.put("s04n", R.drawable.s04n);
        weatherIconMapping.put("s04d", R.drawable.s04d);
        weatherIconMapping.put("s06n", R.drawable.s06n);
        weatherIconMapping.put("s06d", R.drawable.s06d);

        weatherIconMapping.put("t01n", R.drawable.t01n);
        weatherIconMapping.put("t01d", R.drawable.t01d);
        weatherIconMapping.put("t02n", R.drawable.t02n);
        weatherIconMapping.put("t02d", R.drawable.t02d);
        weatherIconMapping.put("t03n", R.drawable.t03n);
        weatherIconMapping.put("t03d", R.drawable.t03d);
        weatherIconMapping.put("t04n", R.drawable.t04n);
        weatherIconMapping.put("t04d", R.drawable.t04d);
        weatherIconMapping.put("t05n", R.drawable.t05n);
        weatherIconMapping.put("t05d", R.drawable.t05d);

        weatherIconMapping.put("u00n", R.drawable.u00n);
        weatherIconMapping.put("u00d", R.drawable.u00d);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewHourlyWeatherItemBinding binding = ViewHourlyWeatherItemBinding.inflate(layoutInflater, parent, false);
        mMyViewHolder = new MyViewHolder(binding);
        return mMyViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        resources = holder.itemView.getContext().getResources();
        holder.bind(this.itemWeatherList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Recycle Click" + position, Toast.LENGTH_SHORT).show();
                //removeSelectedItems();
                itemWeatherList.remove(position);
                notifyItemRemoved(position);
                Toast.makeText(v.getContext(), "Removed Item" + position, Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemWeatherList.size();
    }

    public void setWeatherHistory(HourlyWeatherHistoryDetailsMaster hourlyWeather, Resources resources) {
        this.resources = resources;
        createWeather(hourlyWeather);
        notifyDataSetChanged();
    }

    private void createWeather(HourlyWeatherHistoryDetailsMaster hourlyWeather) {
        this.itemWeatherList.clear();
        for (HourlyWeather weather : hourlyWeather.getData()) {
            this.itemWeatherList.add(new WeatherHistoryItemViewModal(hourlyWeather.getCity_name(), weather.getWeather().getDescription(), weather.getDatetime(), getWeatherIcon(weather.getWeather().getIcon())));
        }
    }

    private Drawable getWeatherIcon(String icon) {
        Drawable drawable;
      //  drawable = Drawable.createFromPath(path+weatherIconMapping.get(icon));
        drawable = resources.getDrawable(weatherIconMapping.get(icon) == null ? R.drawable.ic_exit_to_app_24dp : weatherIconMapping.get(icon));
        return  drawable;
    }

    public void restoreItem(WeatherHistoryItemViewModal item, int position) {
        itemWeatherList.add(position, item);
        // notify item added by position
        notifyItemInserted(position);
    }

    public void removeSelectedItems() {
        int position = mMyViewHolder.getAdapterPosition();
        itemWeatherList.remove(position);
        notifyItemRemoved(position);
        //notifyItemRangeChanged(position, itemWeatherList.size());

    }
}
