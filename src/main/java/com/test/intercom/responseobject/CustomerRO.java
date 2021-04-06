package com.test.intercom.responseobject;

/**
 * The type Customer ro to return customer details as response.
 */
public class CustomerRO implements Comparable<CustomerRO> {

    /**
     * The Id.
     */
    int id;

    /**
     * The Name.
     */
    String name;

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
     * Instantiates a new Customer ro.
     *
     * @param id   the id
     * @param name the name
     */
    public CustomerRO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(CustomerRO o) {
        return this.id - o.id;
    }
}
