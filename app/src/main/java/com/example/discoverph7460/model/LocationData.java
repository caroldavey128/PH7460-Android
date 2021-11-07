package com.example.discoverph7460.model;

public class LocationData {

    // Create our model class

    String locationName;
    String locationDescription;
    String locationTitle;
    Integer locationimageurl;
    double locationLatitude;
    double locationLongitude;





    public LocationData(String locationName, String locationDescription, String locationTitle, Integer locationimageurl, double locationLatitude, double locationLongitude) {
        this.locationName = locationName;
        this.locationDescription = locationDescription;
        this.locationTitle = locationTitle;
        this.locationimageurl = locationimageurl;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;



    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getLocationTitle() {
        return locationTitle;
    }

    public void setLocationTitle(String locationTitle) {
        this.locationTitle = locationTitle;
    }

    public Integer getLocationimageurl() {
        return locationimageurl;
    }

    public void setLocationimageurl(Integer locationimageurl) {
        this.locationimageurl = locationimageurl;
    }

    public double getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(double locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public double getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(double locationLongitude) {
        this.locationLongitude = locationLongitude;
    }


}
