package company.info.com.weather.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import company.info.com.weather.R;
import company.info.com.weather.databinding.ActivityMainBinding;
import company.info.com.weather.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel = new MainViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModal(mainViewModel);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_forward:
                startHistoryActivity();
                return true;
            case R.id.action_info:
                // location found
                return true;
            case R.id.action_exit:
                //finishActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void startHistoryActivity() {
        Intent i = new Intent(MainActivity.this, WeatherHistoryActivity.class);
        startActivity(i);
    }
}
