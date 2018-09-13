package company.info.com.weatherlibs.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class WeatherMaster implements Parcelable {
    private String id;

    private String dt;

    private Clouds clouds;

    private Coord coord;

    private Wind wind;

    private String cod;

    private String visibility;

    private Sys sys;

    @SerializedName("name")
    private String name;

    private String base;

    @SerializedName("weather")
    private Weather[] weather;

    private Main main;


    protected WeatherMaster(Parcel in) {
        id = in.readString();
        dt = in.readString();
        cod = in.readString();
        visibility = in.readString();
        name = in.readString();
        base = in.readString();
        weather = in.createTypedArray(Weather.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(dt);
        dest.writeString(cod);
        dest.writeString(visibility);
        dest.writeString(name);
        dest.writeString(base);
        dest.writeTypedArray(weather, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WeatherMaster> CREATOR = new Creator<WeatherMaster>() {
        @Override
        public WeatherMaster createFromParcel(Parcel in) {
            return new WeatherMaster(in);
        }

        @Override
        public WeatherMaster[] newArray(int size) {
            return new WeatherMaster[size];
        }
    };

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getDt ()
    {
        return dt;
    }

    public void setDt (String dt)
    {
        this.dt = dt;
    }

    public Clouds getClouds ()
    {
        return clouds;
    }

    public void setClouds (Clouds clouds)
    {
        this.clouds = clouds;
    }

    public Coord getCoord ()
    {
        return coord;
    }

    public void setCoord (Coord coord)
    {
        this.coord = coord;
    }

    public Wind getWind ()
    {
        return wind;
    }

    public void setWind (Wind wind)
    {
        this.wind = wind;
    }

    public String getCod ()
    {
        return cod;
    }

    public void setCod (String cod)
    {
        this.cod = cod;
    }

    public String getVisibility ()
    {
        return visibility;
    }

    public void setVisibility (String visibility)
    {
        this.visibility = visibility;
    }

    public Sys getSys ()
    {
        return sys;
    }

    public void setSys (Sys sys)
    {
        this.sys = sys;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getBase ()
    {
        return base;
    }

    public void setBase (String base)
    {
        this.base = base;
    }

    public Weather[] getWeather ()
    {
        return weather;
    }

    public void setWeather (Weather[] weather)
    {
        this.weather = weather;
    }

    public Main getMain ()
    {
        return main;
    }

    public void setMain (Main main)
    {
        this.main = main;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", dt = "+dt+", clouds = "+clouds+", coord = "+coord+", wind = "+wind+", cod = "+cod+", visibility = "+visibility+", sys = "+sys+", name = "+name+", base = "+base+", weather = "+weather+", main = "+main+"]";
    }

}