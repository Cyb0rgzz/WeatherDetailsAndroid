package company.info.com.weather.viewmodel;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GsonParse {

    String jsonResponse;

    public String getCityId() {
        Gson gson = new Gson();
        JsonObject jsonObj = new JsonParser().parse(jsonResponse).getAsJsonObject();
        String cityId = jsonObj.getAsJsonObject("response").getAsJsonObject("results").getAsJsonArray("results").get(0).getAsJsonObject().get("id").getAsString();
        System.out.println("VALUE : " + cityId);
        return cityId;
    }

    public GsonParse getWeather(String forCity) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://locator-service.api.bbci.co.uk/locations?api_key=AGbFAKx58hyjQScCXIYrxuEwJh2W2cmv&stack=aws&locale=en&filter=international&place-types=settlement%2Cairport%2Cdistrict&order=importance&s=" + forCity.toLowerCase() + "&a=true&format=json")
                .get()
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "2a6fcaa8-cd04-ba1e-7989-b86f92223231")
                .build();

        Response response = client.newCall(request).execute();
        jsonResponse = response.body().string().toString();
        return this;
    }
}
