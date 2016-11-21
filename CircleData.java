package com.redrock.my.myapplication;

/**
 * Created by ASUS on 2016/8/6.
 */
public class CircleData {

    private double rate;
    private String color;
    private String showData;
    private String sideColor;

    public CircleData(String color, double rate, String sideColor) {
        this.color = color;
        this.rate = rate;
        this.sideColor = sideColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getShowData() {
        return showData;
    }

    public void setShowData(String showData) {
        this.showData = showData;
    }

    public String getSideColor() {
        return sideColor;
    }

    public void setSideColor(String sideColor) {
        this.sideColor = sideColor;
    }
}
