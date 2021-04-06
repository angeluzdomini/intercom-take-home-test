package com.test.intercom.util;

import com.test.intercom.constants.CustomConstants;
import com.test.intercom.dataobject.CustomerDO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFileReaderTest {

    CustomerFileReader fileReader = new CustomerFileReader();

    @Test
    void readCustomerFile() {
        List<CustomerDO> customerDOList = new ArrayList<>();
        customerDOList = fileReader.readCustomerFile(CustomConstants.FILE_NAME);
        assertEquals(32, customerDOList.size());
    }

    @Test
    void readCustomerFileInvalidFile() {
        List<CustomerDO> customerDOList = new ArrayList<>();
        customerDOList = fileReader.readCustomerFile("invalid.txt");
        assertEquals(null, customerDOList);
    }

    @Test
    void readCustomerFileNullFileName() {
        List<CustomerDO> customerDOList = new ArrayList<>();
        customerDOList = fileReader.readCustomerFile(null);
        assertEquals(null, customerDOList);
    }
}
