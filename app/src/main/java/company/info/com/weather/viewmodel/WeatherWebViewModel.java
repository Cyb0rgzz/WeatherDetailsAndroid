package company.info.com.weather.viewmodel;

import android.arch.lifecycle.LifecycleObserver;
import android.databinding.BindingAdapter;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import company.info.com.weather.data.SharedData;

public class WeatherWebViewModel implements LifecycleObserver {

    public void loadBBC(WebView webView){
        //webView.loadUrl("https://www.bbc.com/weather/"+ SharedData.getCityId());
        webView.loadUrl("https://www.amazon.in/");
    }

    @BindingAdapter({"loadUrl"})
    public static void loadSomeThing(WebView webView, LoadUrlListener listener) {
        listener.loadSomeOtherThing(webView);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
    }

    @FunctionalInterface
    public interface LoadUrlListener {
        void loadSomeOtherThing(WebView webView);
    }



}
