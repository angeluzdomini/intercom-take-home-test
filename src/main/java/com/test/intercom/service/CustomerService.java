package com.test.intercom.service;

import com.test.intercom.constants.CustomConstants;
import com.test.intercom.dataobject.CustomerDO;
import com.test.intercom.util.CustomerFileReader;

import java.util.List;

/**
 * Customer service to manage customerDO
 */
public class CustomerService {

    /**
     * The Customer do list.
     */
    List<CustomerDO> customerDOList;

    /**
     * The Customer file reader.
     */
    CustomerFileReader customerFileReader;

    /**
     * Gets customer service list.
     *
     * @return the customer service list
     */
    public List<CustomerDO> getCustomerDOList() {
        return customerDOList;
    }

    /**
     * Sets customer service list.
     *
     * @param customerDOList the customer do list
     */
    public void setCustomerDOList(List<CustomerDO> customerDOList) {
        this.customerDOList = customerDOList;
    }

    /**
     * Instantiates a new Customer service
     */
    public CustomerService() {
        this.customerFileReader = new CustomerFileReader();
    }

    /*
     * Updates the customer list from given file using reader and set to CustomerDOList.
     */
    public void updateCustomerListFromFile(String fileName) {
        this.customerDOList = customerFileReader.readCustomerFile(fileName);
    }
}
