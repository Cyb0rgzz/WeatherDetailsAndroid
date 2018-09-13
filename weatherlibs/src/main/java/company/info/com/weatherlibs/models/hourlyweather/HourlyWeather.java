package company.info.com.weatherlibs.models.hourlyweather;

public class HourlyWeather {
    private String clouds;

    private String ts;

    private String elev_angle;

    private String slp;

    private String rh;

    private String wind_dir;

    private String pres;

    private String dewpt;

    private String vis;

    private String dhi;

    private String ghi;

    private String wind_spd;

    private String precip;

    private String h_angle;

    private String uv;

    private String snow;

    private String temp;

    private WeatherDescription weather;

    private String azimuth;

    private String datetime;

    private String dni;

    private String pod;

    public String getClouds ()
    {
        return clouds;
    }

    public void setClouds (String clouds)
    {
        this.clouds = clouds;
    }

    public String getTs ()
    {
        return ts;
    }

    public void setTs (String ts)
    {
        this.ts = ts;
    }

    public String getElev_angle ()
    {
        return elev_angle;
    }

    public void setElev_angle (String elev_angle)
    {
        this.elev_angle = elev_angle;
    }

    public String getSlp ()
    {
        return slp;
    }

    public void setSlp (String slp)
    {
        this.slp = slp;
    }

    public String getRh ()
    {
        return rh;
    }

    public void setRh (String rh)
    {
        this.rh = rh;
    }

    public String getWind_dir ()
    {
        return wind_dir;
    }

    public void setWind_dir (String wind_dir)
    {
        this.wind_dir = wind_dir;
    }

    public String getPres ()
    {
        return pres;
    }

    public void setPres (String pres)
    {
        this.pres = pres;
    }

    public String getDewpt ()
    {
        return dewpt;
    }

    public void setDewpt (String dewpt)
    {
        this.dewpt = dewpt;
    }

    public String getVis ()
    {
        return vis;
    }

    public void setVis (String vis)
    {
        this.vis = vis;
    }

    public String getDhi ()
    {
        return dhi;
    }

    public void setDhi (String dhi)
    {
        this.dhi = dhi;
    }

    public String getGhi ()
    {
        return ghi;
    }

    public void setGhi (String ghi)
    {
        this.ghi = ghi;
    }

    public String getWind_spd ()
    {
        return wind_spd;
    }

    public void setWind_spd (String wind_spd)
    {
        this.wind_spd = wind_spd;
    }

    public String getPrecip ()
    {
        return precip;
    }

    public void setPrecip (String precip)
    {
        this.precip = precip;
    }

    public String getH_angle ()
    {
        return h_angle;
    }

    public void setH_angle (String h_angle)
    {
        this.h_angle = h_angle;
    }

    public String getUv ()
    {
        return uv;
    }

    public void setUv (String uv)
    {
        this.uv = uv;
    }

    public String getSnow ()
    {
        return snow;
    }

    public void setSnow (String snow)
    {
        this.snow = snow;
    }

    public String getTemp ()
    {
        return temp;
    }

    public void setTemp (String temp)
    {
        this.temp = temp;
    }

    public WeatherDescription getWeather ()
    {
        return weather;
    }

    public void setWeather (WeatherDescription weather)
    {
        this.weather = weather;
    }

    public String getAzimuth ()
    {
        return azimuth;
    }

    public void setAzimuth (String azimuth)
    {
        this.azimuth = azimuth;
    }

    public String getDatetime ()
    {
        return datetime;
    }

    public void setDatetime (String datetime)
    {
        this.datetime = datetime;
    }

    public String getDni ()
    {
        return dni;
    }

    public void setDni (String dni)
    {
        this.dni = dni;
    }

    public String getPod ()
    {
        return pod;
    }

    public void setPod (String pod)
    {
        this.pod = pod;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [clouds = "+clouds+", ts = "+ts+", elev_angle = "+elev_angle+", slp = "+slp+", rh = "+rh+", wind_dir = "+wind_dir+", pres = "+pres+", dewpt = "+dewpt+", vis = "+vis+", dhi = "+dhi+", ghi = "+ghi+", wind_spd = "+wind_spd+", precip = "+precip+", h_angle = "+h_angle+", uv = "+uv+", snow = "+snow+", temp = "+temp+", weather = "+weather+", azimuth = "+azimuth+", datetime = "+datetime+", dni = "+dni+", pod = "+pod+"]";
    }
}
