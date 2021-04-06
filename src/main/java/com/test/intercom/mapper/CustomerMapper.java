package com.test.intercom.mapper;

import com.test.intercom.dataobject.CustomerDO;
import com.test.intercom.responseobject.CustomerRO;


/**
 * Customer mapper to map objects of type customerDO to customerRO
 */
public class CustomerMapper {
    /**
     * Make customerDO to customerRO.
     *
     * @param customerDO the customer do
     * @return the CustomerRO
     */
    public static CustomerRO  mapCustomerRO(CustomerDO customerDO) {
        return new CustomerRO(customerDO.getId(), customerDO.getName());
    }
}
