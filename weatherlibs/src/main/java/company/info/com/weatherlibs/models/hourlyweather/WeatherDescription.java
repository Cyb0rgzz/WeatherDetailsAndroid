package company.info.com.weatherlibs.models.hourlyweather;

public class WeatherDescription {
    private String icon;

    private String description;

    private String code;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ClassPojo [icon = " + icon + ", description = " + description + ", code = " + code + "]";
    }
}
