package com.test.intercom.service;

import com.test.intercom.constants.CustomConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    @Test
    void updateCustomerListFromFile() {
        CustomerService customerService = new CustomerService();
        customerService.updateCustomerListFromFile(CustomConstants.FILE_NAME);
        assertEquals(32, customerService.getCustomerDOList().size());
    }

    @Test
    void updateCustomerListFromFileNotExist() {
        CustomerService customerService = new CustomerService();
        customerService.updateCustomerListFromFile("invalid.txt");
        assertEquals(null, customerService.getCustomerDOList());
    }
}
