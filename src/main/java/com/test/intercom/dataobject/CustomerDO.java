package com.test.intercom.dataobject;

/**
 * The type Customer do to store customer data from the file.
 */
public class CustomerDO {

    /**
     * The Id.
     */
    int id;

    /**
     * The Name.
     */
    String name;

    /**
     * The Location.
     */
    LocationDO location;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public LocationDO getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(LocationDO location) {
        this.location = location;
    }

    /**
     * Instantiates a new Customer do.
     *
     * @param id        the id
     * @param name      the name
     * @param latitude  the latitude
     * @param longitude the longitude
     */
    public CustomerDO(int id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.location = new LocationDO(latitude, longitude);
    }
}
