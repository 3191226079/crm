package com.sc.crmsys.bean;

public class CityBean {
    private String cityNumber;

    private String cityName;

    private String cityUpper;

    private String cityGrade;

    private String cityRemarks;

    public String getCityNumber() {
        return cityNumber;
    }

    public void setCityNumber(String cityNumber) {
        this.cityNumber = cityNumber == null ? null : cityNumber.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getCityUpper() {
        return cityUpper;
    }

    public void setCityUpper(String cityUpper) {
        this.cityUpper = cityUpper == null ? null : cityUpper.trim();
    }

    public String getCityGrade() {
        return cityGrade;
    }

    public void setCityGrade(String cityGrade) {
        this.cityGrade = cityGrade == null ? null : cityGrade.trim();
    }

    public String getCityRemarks() {
        return cityRemarks;
    }

    public void setCityRemarks(String cityRemarks) {
        this.cityRemarks = cityRemarks == null ? null : cityRemarks.trim();
    }
}