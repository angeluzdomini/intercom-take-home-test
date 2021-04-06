package com.test.intercom.mapper;

import com.test.intercom.dataobject.CustomerDO;
import com.test.intercom.responseobject.CustomerRO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerMapperTest {

    @Test
    public void mapCustomerRO() {
        CustomerDO customerDO = new CustomerDO(12, "John Doe", 12.232, 60.007);
        CustomerRO customerRO = CustomerMapper.mapCustomerRO(customerDO);

        assertEquals(12, customerRO.getId());
        assertEquals("John Doe", customerRO.getName());
    }
}
