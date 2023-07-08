package com.teamgeneral.forcheck;

public class RvModel2 {
    private String times;
    private String temperatures;
    private String icons;
    private String wind;
    private String forcastCondition;



    public RvModel2(String times, String icons,String temperatures, String forcastCondition,String wind) {
        this.times = times;
        this.icons = icons;
        this.temperatures = temperatures;

        //this.temperatures2 = temperatures2;
        this.wind=wind;
        this.forcastCondition = forcastCondition;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(String temperatures) {
        this.temperatures = temperatures;
    }

    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getForcastCondition() {
        return forcastCondition;
    }

    public void setForcastCondition(String forcastCondition) {
        this.forcastCondition = forcastCondition;
    }
}
