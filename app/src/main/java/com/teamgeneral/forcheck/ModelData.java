package com.teamgeneral.forcheck;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

public class ModelData implements Serializable {
  private Alerts alerts;

  private Current current;

  private Location location;

  private Forecast forecast;

  public Alerts getAlerts() {
    return this.alerts;
  }

  public void setAlerts(Alerts alerts) {
    this.alerts = alerts;
  }

  public Current getCurrent() {
    return this.current;
  }

  public void setCurrent(Current current) {
    this.current = current;
  }

  public Location getLocation() {
    return this.location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Forecast getForecast() {
    return this.forecast;
  }

  public void setForecast(Forecast forecast) {
    this.forecast = forecast;
  }

  public static class Alerts implements Serializable {
  }

  public static class Current implements Serializable {
    private Double feelslike_c;

    private Double uv;

    private String last_updated;

    private Double feelslike_f;

    private Integer wind_degree;

    private Integer last_updated_epoch;

    private Integer is_day;

    private Double precip_in;

    private String wind_dir;

    private Double gust_mph;

    private Double temp_c;

    private Double pressure_in;

    private Double gust_kph;

    private Double temp_f;

    private Double precip_mm;

    private Integer cloud;

    private Double wind_kph;

    private Condition condition;

    private Double wind_mph;

    private Double vis_km;

    private Integer humidity;

    private Double pressure_mb;

    private Double vis_miles;

    public Double getFeelslike_c() {
      return this.feelslike_c;
    }

    public void setFeelslike_c(Double feelslike_c) {
      this.feelslike_c = feelslike_c;
    }

    public Double getUv() {
      return this.uv;
    }

    public void setUv(Double uv) {
      this.uv = uv;
    }

    public String getLast_updated() {
      return this.last_updated;
    }

    public void setLast_updated(String last_updated) {
      this.last_updated = last_updated;
    }

    public Double getFeelslike_f() {
      return this.feelslike_f;
    }

    public void setFeelslike_f(Double feelslike_f) {
      this.feelslike_f = feelslike_f;
    }

    public Integer getWind_degree() {
      return this.wind_degree;
    }

    public void setWind_degree(Integer wind_degree) {
      this.wind_degree = wind_degree;
    }

    public Integer getLast_updated_epoch() {
      return this.last_updated_epoch;
    }

    public void setLast_updated_epoch(Integer last_updated_epoch) {
      this.last_updated_epoch = last_updated_epoch;
    }

    public Integer getIs_day() {
      return this.is_day;
    }

    public void setIs_day(Integer is_day) {
      this.is_day = is_day;
    }

    public Double getPrecip_in() {
      return this.precip_in;
    }

    public void setPrecip_in(Double precip_in) {
      this.precip_in = precip_in;
    }

    public String getWind_dir() {
      return this.wind_dir;
    }

    public void setWind_dir(String wind_dir) {
      this.wind_dir = wind_dir;
    }

    public Double getGust_mph() {
      return this.gust_mph;
    }

    public void setGust_mph(Double gust_mph) {
      this.gust_mph = gust_mph;
    }

    public Double getTemp_c() {
      return this.temp_c;
    }

    public void setTemp_c(Double temp_c) {
      this.temp_c = temp_c;
    }

    public Double getPressure_in() {
      return this.pressure_in;
    }

    public void setPressure_in(Double pressure_in) {
      this.pressure_in = pressure_in;
    }

    public Double getGust_kph() {
      return this.gust_kph;
    }

    public void setGust_kph(Double gust_kph) {
      this.gust_kph = gust_kph;
    }

    public Double getTemp_f() {
      return this.temp_f;
    }

    public void setTemp_f(Double temp_f) {
      this.temp_f = temp_f;
    }

    public Double getPrecip_mm() {
      return this.precip_mm;
    }

    public void setPrecip_mm(Double precip_mm) {
      this.precip_mm = precip_mm;
    }

    public Integer getCloud() {
      return this.cloud;
    }

    public void setCloud(Integer cloud) {
      this.cloud = cloud;
    }

    public Double getWind_kph() {
      return this.wind_kph;
    }

    public void setWind_kph(Double wind_kph) {
      this.wind_kph = wind_kph;
    }

    public Condition getCondition() {
      return this.condition;
    }

    public void setCondition(Condition condition) {
      this.condition = condition;
    }

    public Double getWind_mph() {
      return this.wind_mph;
    }

    public void setWind_mph(Double wind_mph) {
      this.wind_mph = wind_mph;
    }

    public Double getVis_km() {
      return this.vis_km;
    }

    public void setVis_km(Double vis_km) {
      this.vis_km = vis_km;
    }

    public Integer getHumidity() {
      return this.humidity;
    }

    public void setHumidity(Integer humidity) {
      this.humidity = humidity;
    }

    public Double getPressure_mb() {
      return this.pressure_mb;
    }

    public void setPressure_mb(Double pressure_mb) {
      this.pressure_mb = pressure_mb;
    }

    public Double getVis_miles() {
      return this.vis_miles;
    }

    public void setVis_miles(Double vis_miles) {
      this.vis_miles = vis_miles;
    }

    public static class Condition implements Serializable {
      private Integer code;

      private String icon;

      private String text;

      public Integer getCode() {
        return this.code;
      }

      public void setCode(Integer code) {
        this.code = code;
      }

      public String getIcon() {
        return this.icon;
      }

      public void setIcon(String icon) {
        this.icon = icon;
      }

      public String getText() {
        return this.text;
      }

      public void setText(String text) {
        this.text = text;
      }
    }
  }

  public static class Location implements Serializable {
    private String localtime;

    private String country;

    private Integer localtime_epoch;

    private String name;

    private Double lon;

    private String region;

    private Double lat;

    private String tz_id;

    public String getLocaltime() {
      return this.localtime;
    }

    public void setLocaltime(String localtime) {
      this.localtime = localtime;
    }

    public String getCountry() {
      return this.country;
    }

    public void setCountry(String country) {
      this.country = country;
    }

    public Integer getLocaltime_epoch() {
      return this.localtime_epoch;
    }

    public void setLocaltime_epoch(Integer localtime_epoch) {
      this.localtime_epoch = localtime_epoch;
    }

    public String getName() {
      return this.name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Double getLon() {
      return this.lon;
    }

    public void setLon(Double lon) {
      this.lon = lon;
    }

    public String getRegion() {
      return this.region;
    }

    public void setRegion(String region) {
      this.region = region;
    }

    public Double getLat() {
      return this.lat;
    }

    public void setLat(Double lat) {
      this.lat = lat;
    }

    public String getTz_id() {
      return this.tz_id;
    }

    public void setTz_id(String tz_id) {
      this.tz_id = tz_id;
    }
  }

  public static class Forecast implements Serializable {
    private List<Forecastday> forecastday;

    public List<Forecastday> getForecastday() {
      return this.forecastday;
    }

    public void setForecastday(List<Forecastday> forecastday) {
      this.forecastday = forecastday;
    }

    public static class Forecastday implements Serializable {
      private String date;

      private Astro astro;

      private Integer date_epoch;

      private List<Hour> hour;

      private Day day;

      public String getDate() {
        return this.date;
      }

      public void setDate(String date) {
        this.date = date;
      }

      public Astro getAstro() {
        return this.astro;
      }

      public void setAstro(Astro astro) {
        this.astro = astro;
      }

      public Integer getDate_epoch() {
        return this.date_epoch;
      }

      public void setDate_epoch(Integer date_epoch) {
        this.date_epoch = date_epoch;
      }

      public List<Hour> getHour() {
        return this.hour;
      }

      public void setHour(List<Hour> hour) {
        this.hour = hour;
      }

      public Day getDay() {
        return this.day;
      }

      public void setDay(Day day) {
        this.day = day;
      }

      public static class Astro implements Serializable {
        private String moonset;

        private String moon_illumination;

        private String sunrise;

        private String moon_phase;

        private String sunset;

        private Integer is_moon_up;

        private Integer is_sun_up;

        private String moonrise;

        public String getMoonset() {
          return this.moonset;
        }

        public void setMoonset(String moonset) {
          this.moonset = moonset;
        }

        public String getMoon_illumination() {
          return this.moon_illumination;
        }

        public void setMoon_illumination(String moon_illumination) {
          this.moon_illumination = moon_illumination;
        }

        public String getSunrise() {
          return this.sunrise;
        }

        public void setSunrise(String sunrise) {
          this.sunrise = sunrise;
        }

        public String getMoon_phase() {
          return this.moon_phase;
        }

        public void setMoon_phase(String moon_phase) {
          this.moon_phase = moon_phase;
        }

        public String getSunset() {
          return this.sunset;
        }

        public void setSunset(String sunset) {
          this.sunset = sunset;
        }

        public Integer getIs_moon_up() {
          return this.is_moon_up;
        }

        public void setIs_moon_up(Integer is_moon_up) {
          this.is_moon_up = is_moon_up;
        }

        public Integer getIs_sun_up() {
          return this.is_sun_up;
        }

        public void setIs_sun_up(Integer is_sun_up) {
          this.is_sun_up = is_sun_up;
        }

        public String getMoonrise() {
          return this.moonrise;
        }

        public void setMoonrise(String moonrise) {
          this.moonrise = moonrise;
        }
      }

      public static class Hour implements Serializable {
        private Double feelslike_c;

        private Double feelslike_f;

        private Integer wind_degree;

        private Double windchill_f;

        private Double windchill_c;

        private Double temp_c;

        private Double temp_f;

        private Integer cloud;

        private Double wind_kph;

        private Double wind_mph;

        private Integer humidity;

        private Double dewpoint_f;

        private Integer will_it_rain;

        private Double uv;

        private Double heatindex_f;

        private Double dewpoint_c;

        private Integer is_day;

        private Double precip_in;

        private Double heatindex_c;

        private String wind_dir;

        private Double gust_mph;

        private Double pressure_in;

        private Integer chance_of_rain;

        private Double gust_kph;

        private Double precip_mm;

        private Current.Condition condition;

        private Integer will_it_snow;

        private Double vis_km;

        private Integer time_epoch;

        private String time;

        private Integer chance_of_snow;

        private Double pressure_mb;

        private Double vis_miles;

        public Double getFeelslike_c() {
          return this.feelslike_c;
        }

        public void setFeelslike_c(Double feelslike_c) {
          this.feelslike_c = feelslike_c;
        }

        public Double getFeelslike_f() {
          return this.feelslike_f;
        }

        public void setFeelslike_f(Double feelslike_f) {
          this.feelslike_f = feelslike_f;
        }

        public Integer getWind_degree() {
          return this.wind_degree;
        }

        public void setWind_degree(Integer wind_degree) {
          this.wind_degree = wind_degree;
        }

        public Double getWindchill_f() {
          return this.windchill_f;
        }

        public void setWindchill_f(Double windchill_f) {
          this.windchill_f = windchill_f;
        }

        public Double getWindchill_c() {
          return this.windchill_c;
        }

        public void setWindchill_c(Double windchill_c) {
          this.windchill_c = windchill_c;
        }

        public Double getTemp_c() {
          return this.temp_c;
        }

        public void setTemp_c(Double temp_c) {
          this.temp_c = temp_c;
        }

        public Double getTemp_f() {
          return this.temp_f;
        }

        public void setTemp_f(Double temp_f) {
          this.temp_f = temp_f;
        }

        public Integer getCloud() {
          return this.cloud;
        }

        public void setCloud(Integer cloud) {
          this.cloud = cloud;
        }

        public Double getWind_kph() {
          return this.wind_kph;
        }

        public void setWind_kph(Double wind_kph) {
          this.wind_kph = wind_kph;
        }

        public Double getWind_mph() {
          return this.wind_mph;
        }

        public void setWind_mph(Double wind_mph) {
          this.wind_mph = wind_mph;
        }

        public Integer getHumidity() {
          return this.humidity;
        }

        public void setHumidity(Integer humidity) {
          this.humidity = humidity;
        }

        public Double getDewpoint_f() {
          return this.dewpoint_f;
        }

        public void setDewpoint_f(Double dewpoint_f) {
          this.dewpoint_f = dewpoint_f;
        }

        public Integer getWill_it_rain() {
          return this.will_it_rain;
        }

        public void setWill_it_rain(Integer will_it_rain) {
          this.will_it_rain = will_it_rain;
        }

        public Double getUv() {
          return this.uv;
        }

        public void setUv(Double uv) {
          this.uv = uv;
        }

        public Double getHeatindex_f() {
          return this.heatindex_f;
        }

        public void setHeatindex_f(Double heatindex_f) {
          this.heatindex_f = heatindex_f;
        }

        public Double getDewpoint_c() {
          return this.dewpoint_c;
        }

        public void setDewpoint_c(Double dewpoint_c) {
          this.dewpoint_c = dewpoint_c;
        }

        public Integer getIs_day() {
          return this.is_day;
        }

        public void setIs_day(Integer is_day) {
          this.is_day = is_day;
        }

        public Double getPrecip_in() {
          return this.precip_in;
        }

        public void setPrecip_in(Double precip_in) {
          this.precip_in = precip_in;
        }

        public Double getHeatindex_c() {
          return this.heatindex_c;
        }

        public void setHeatindex_c(Double heatindex_c) {
          this.heatindex_c = heatindex_c;
        }

        public String getWind_dir() {
          return this.wind_dir;
        }

        public void setWind_dir(String wind_dir) {
          this.wind_dir = wind_dir;
        }

        public Double getGust_mph() {
          return this.gust_mph;
        }

        public void setGust_mph(Double gust_mph) {
          this.gust_mph = gust_mph;
        }

        public Double getPressure_in() {
          return this.pressure_in;
        }

        public void setPressure_in(Double pressure_in) {
          this.pressure_in = pressure_in;
        }

        public Integer getChance_of_rain() {
          return this.chance_of_rain;
        }

        public void setChance_of_rain(Integer chance_of_rain) {
          this.chance_of_rain = chance_of_rain;
        }

        public Double getGust_kph() {
          return this.gust_kph;
        }

        public void setGust_kph(Double gust_kph) {
          this.gust_kph = gust_kph;
        }

        public Double getPrecip_mm() {
          return this.precip_mm;
        }

        public void setPrecip_mm(Double precip_mm) {
          this.precip_mm = precip_mm;
        }

        public Current.Condition getCondition() {
          return this.condition;
        }

        public void setCondition(Current.Condition condition) {
          this.condition = condition;
        }

        public Integer getWill_it_snow() {
          return this.will_it_snow;
        }

        public void setWill_it_snow(Integer will_it_snow) {
          this.will_it_snow = will_it_snow;
        }

        public Double getVis_km() {
          return this.vis_km;
        }

        public void setVis_km(Double vis_km) {
          this.vis_km = vis_km;
        }

        public Integer getTime_epoch() {
          return this.time_epoch;
        }

        public void setTime_epoch(Integer time_epoch) {
          this.time_epoch = time_epoch;
        }

        public String getTime() {
          return this.time;
        }

        public void setTime(String time) {
          this.time = time;
        }

        public Integer getChance_of_snow() {
          return this.chance_of_snow;
        }

        public void setChance_of_snow(Integer chance_of_snow) {
          this.chance_of_snow = chance_of_snow;
        }

        public Double getPressure_mb() {
          return this.pressure_mb;
        }

        public void setPressure_mb(Double pressure_mb) {
          this.pressure_mb = pressure_mb;
        }

        public Double getVis_miles() {
          return this.vis_miles;
        }

        public void setVis_miles(Double vis_miles) {
          this.vis_miles = vis_miles;
        }
      }

      public static class Day implements Serializable {
        private Double avgvis_km;

        private Double uv;

        private Double avgtemp_f;

        private Double avgtemp_c;

        private Integer daily_chance_of_snow;

        private Double maxtemp_c;

        private Double maxtemp_f;

        private Double mintemp_c;

        private Double avgvis_miles;

        private Integer daily_will_it_rain;

        private Double mintemp_f;

        private Double totalprecip_in;

        private Double totalsnow_cm;

        private Double avghumidity;

        private Current.Condition condition;

        private Double maxwind_kph;

        private Double maxwind_mph;

        private Integer daily_chance_of_rain;

        private Double totalprecip_mm;

        private Integer daily_will_it_snow;

        public Double getAvgvis_km() {
          return this.avgvis_km;
        }

        public void setAvgvis_km(Double avgvis_km) {
          this.avgvis_km = avgvis_km;
        }

        public Double getUv() {
          return this.uv;
        }

        public void setUv(Double uv) {
          this.uv = uv;
        }

        public Double getAvgtemp_f() {
          return this.avgtemp_f;
        }

        public void setAvgtemp_f(Double avgtemp_f) {
          this.avgtemp_f = avgtemp_f;
        }

        public Double getAvgtemp_c() {
          return this.avgtemp_c;
        }

        public void setAvgtemp_c(Double avgtemp_c) {
          this.avgtemp_c = avgtemp_c;
        }

        public Integer getDaily_chance_of_snow() {
          return this.daily_chance_of_snow;
        }

        public void setDaily_chance_of_snow(Integer daily_chance_of_snow) {
          this.daily_chance_of_snow = daily_chance_of_snow;
        }

        public Double getMaxtemp_c() {
          return this.maxtemp_c;
        }

        public void setMaxtemp_c(Double maxtemp_c) {
          this.maxtemp_c = maxtemp_c;
        }

        public Double getMaxtemp_f() {
          return this.maxtemp_f;
        }

        public void setMaxtemp_f(Double maxtemp_f) {
          this.maxtemp_f = maxtemp_f;
        }

        public Double getMintemp_c() {
          return this.mintemp_c;
        }

        public void setMintemp_c(Double mintemp_c) {
          this.mintemp_c = mintemp_c;
        }

        public Double getAvgvis_miles() {
          return this.avgvis_miles;
        }

        public void setAvgvis_miles(Double avgvis_miles) {
          this.avgvis_miles = avgvis_miles;
        }

        public Integer getDaily_will_it_rain() {
          return this.daily_will_it_rain;
        }

        public void setDaily_will_it_rain(Integer daily_will_it_rain) {
          this.daily_will_it_rain = daily_will_it_rain;
        }

        public Double getMintemp_f() {
          return this.mintemp_f;
        }

        public void setMintemp_f(Double mintemp_f) {
          this.mintemp_f = mintemp_f;
        }

        public Double getTotalprecip_in() {
          return this.totalprecip_in;
        }

        public void setTotalprecip_in(Double totalprecip_in) {
          this.totalprecip_in = totalprecip_in;
        }

        public Double getTotalsnow_cm() {
          return this.totalsnow_cm;
        }

        public void setTotalsnow_cm(Double totalsnow_cm) {
          this.totalsnow_cm = totalsnow_cm;
        }

        public Double getAvghumidity() {
          return this.avghumidity;
        }

        public void setAvghumidity(Double avghumidity) {
          this.avghumidity = avghumidity;
        }

        public Current.Condition getCondition() {
          return this.condition;
        }

        public void setCondition(Current.Condition condition) {
          this.condition = condition;
        }

        public Double getMaxwind_kph() {
          return this.maxwind_kph;
        }

        public void setMaxwind_kph(Double maxwind_kph) {
          this.maxwind_kph = maxwind_kph;
        }

        public Double getMaxwind_mph() {
          return this.maxwind_mph;
        }

        public void setMaxwind_mph(Double maxwind_mph) {
          this.maxwind_mph = maxwind_mph;
        }

        public Integer getDaily_chance_of_rain() {
          return this.daily_chance_of_rain;
        }

        public void setDaily_chance_of_rain(Integer daily_chance_of_rain) {
          this.daily_chance_of_rain = daily_chance_of_rain;
        }

        public Double getTotalprecip_mm() {
          return this.totalprecip_mm;
        }

        public void setTotalprecip_mm(Double totalprecip_mm) {
          this.totalprecip_mm = totalprecip_mm;
        }

        public Integer getDaily_will_it_snow() {
          return this.daily_will_it_snow;
        }

        public void setDaily_will_it_snow(Integer daily_will_it_snow) {
          this.daily_will_it_snow = daily_will_it_snow;
        }
      }
    }
  }
}
