package company.info.com.weatherlibs.models.hourlyweather;

public class HourlyWeatherHistoryDetailsMaster {

    private String city_id;

    private String city_name;

    private String lon;

    private String timezone;

    private String state_code;

    private HourlyWeather[] data;

    private String station_id;

    private String country_code;

    private String[] sources;

    private String lat;

    public String getCity_id ()
    {
        return city_id;
    }

    public void setCity_id (String city_id)
    {
        this.city_id = city_id;
    }

    public String getCity_name ()
    {
        return city_name;
    }

    public void setCity_name (String city_name)
    {
        this.city_name = city_name;
    }

    public String getLon ()
    {
        return lon;
    }

    public void setLon (String lon)
    {
        this.lon = lon;
    }

    public String getTimezone ()
    {
        return timezone;
    }

    public void setTimezone (String timezone)
    {
        this.timezone = timezone;
    }

    public String getState_code ()
    {
        return state_code;
    }

    public void setState_code (String state_code)
    {
        this.state_code = state_code;
    }

    public HourlyWeather[] getData ()
    {
        return data;
    }

    public void setData (HourlyWeather[] data)
    {
        this.data = data;
    }

    public String getStation_id ()
    {
        return station_id;
    }

    public void setStation_id (String station_id)
    {
        this.station_id = station_id;
    }

    public String getCountry_code ()
    {
        return country_code;
    }

    public void setCountry_code (String country_code)
    {
        this.country_code = country_code;
    }

    public String[] getSources ()
    {
        return sources;
    }

    public void setSources (String[] sources)
    {
        this.sources = sources;
    }

    public String getLat ()
    {
        return lat;
    }

    public void setLat (String lat)
    {
        this.lat = lat;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [city_id = "+city_id+", city_name = "+city_name+", lon = "+lon+", timezone = "+timezone+", state_code = "+state_code+", data = "+data+", station_id = "+station_id+", country_code = "+country_code+", sources = "+sources+", lat = "+lat+"]";
    }
}