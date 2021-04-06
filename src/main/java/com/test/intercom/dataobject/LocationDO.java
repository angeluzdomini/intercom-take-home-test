package com.test.intercom.dataobject;

/**
 * The type Location do to store location details of a customer entity.
 */
public class LocationDO {

    /**
     * The Latitude.
     */
    double latitude;

    /**
     * The Longitude.
     */
    double longitude;

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets latitude.
     *
     * @param latitude the latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets longitude.
     *
     * @param longitude the longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Instantiates a new Location do.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     */
    public LocationDO(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
