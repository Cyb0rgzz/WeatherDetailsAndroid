package company.info.com.weather.viewmodel.adapter;

import android.support.v7.widget.RecyclerView;

import company.info.com.weather.databinding.ViewHourlyWeatherItemBinding;
import company.info.com.weather.viewmodel.WeatherHistoryItemViewModal;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private ViewHourlyWeatherItemBinding binding;

    public MyViewHolder(ViewHourlyWeatherItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        binding.executePendingBindings();
    }

    public void bind(WeatherHistoryItemViewModal weatherHistoryItemViewModal) {
        binding.setViewModal(weatherHistoryItemViewModal);
        binding.executePendingBindings();
    }

}
