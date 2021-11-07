package com.example.discoverph7460.model;

public class ProvinceData {

    // Create our model class

    String placeName;
    String placeDescription;
    String placeTitle;
    Integer imageurl;
    double placeLatitude;
    double placeLongitude;

    // Generate Constructor
    public ProvinceData(String placeName, String placeDescription, String placeTitle, Integer imageurl, double placeLatitude, double placeLongitude) {
        this.placeName = placeName;
        this.placeDescription = placeDescription;
        this.placeTitle = placeTitle;
        this.imageurl = imageurl;
        this.placeLatitude = placeLatitude;
        this.placeLongitude = placeLongitude;
    }

    // Create getter and setters

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }

    public String getPlaceTitle() {
        return placeTitle;
    }

    public void setPlaceTitle(String placeTitle) {
        this.placeTitle = placeTitle;
    }

    public Integer getImageurl() {
        return imageurl;
    }

    public void setImageurl(Integer imageurl) {
        this.imageurl = imageurl;
    }

    public double getPlaceLatitude() {
        return placeLatitude;
    }

    public void setPlaceLatitude(double placeLatitude) {
        this.placeLatitude = placeLatitude;
    }

    public double getPlaceLongitude() {
        return placeLongitude;
    }

    public void setPlaceLongitude(double placeLongitude) {
        this.placeLongitude = placeLongitude;
    }
}
