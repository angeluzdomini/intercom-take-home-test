package com.test.intercom.service;

import com.test.intercom.dataobject.CustomerDO;
import com.test.intercom.dataobject.LocationDO;
import com.test.intercom.exceptions.InvalidLocationException;
import com.test.intercom.mapper.CustomerMapper;
import com.test.intercom.responseobject.CustomerRO;
import com.test.intercom.util.DistanceCalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Invitation list service managing the invitations for food and drinks.
 */
public class InvitationListService {

    /**
     * The Origin location.
     */
    LocationDO origin;

    /**
     * Gets origin.
     *
     * @return the origin
     */
    public LocationDO getOrigin() {
        return origin;
    }

    /**
     * Sets origin.
     *
     * @param origin the origin
     */
    public void setOrigin(LocationDO origin) {
        this.origin = origin;
    }

    /**
     * Instantiates a new Invitation list service.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     */
    public InvitationListService(Double latitude, Double longitude) {
        this.origin = new LocationDO(latitude, longitude);
    }

    /**
     * Calculate invitation list based on the customerDO list and search radius and return the customerRO within the given radius based on origin location.
     *
     * @param customerDOList the customer do list
     * @param searchRadius   the search radius
     * @return the list
     */
    public List<CustomerRO> calculateInvitationList(List<CustomerDO> customerDOList, double searchRadius) {
        List<CustomerRO> customerROList = new ArrayList<>();
            if (customerDOList != null) {
                for (CustomerDO customerDO : customerDOList) {

                    //calculate the distance of the customer based on the customer location and origin location.
                    double distance = 0;

                    try {
                        distance = DistanceCalculator.calculateDistance(customerDO.getLocation(), this.origin);
                    } catch (InvalidLocationException e) {
                        continue;
                    }

                    if (distance <= searchRadius) {
                        customerROList.add(CustomerMapper.mapCustomerRO(customerDO));
                    }
                }

                //sorts the ist based on customerRO id
                Collections.sort(customerROList);
            }
        return customerROList;
    }
}
