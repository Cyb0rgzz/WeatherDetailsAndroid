package company.info.com.weatherlibs.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fordlabs on 13/08/18.
 */

public class Weather implements Parcelable
{
    private String id;

    private String icon;

    private String description;

    private String main;

    protected Weather(Parcel in) {
        id = in.readString();
        icon = in.readString();
        description = in.readString();
        main = in.readString();
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel in) {
            return new Weather(in);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
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

    public String getIcon ()
    {
        return icon;
    }

    public void setIcon (String icon)
    {
        this.icon = icon;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getMain ()
    {
        return main;
    }

    public void setMain (String main)
    {
        this.main = main;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", icon = "+icon+", description = "+description+", main = "+main+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(icon);
        parcel.writeString(description);
        parcel.writeString(main);
    }
}