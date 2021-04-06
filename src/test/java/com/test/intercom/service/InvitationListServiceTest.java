package com.test.intercom.service;

import com.test.intercom.constants.CustomConstants;
import com.test.intercom.dataobject.CustomerDO;
import com.test.intercom.responseobject.CustomerRO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvitationListServiceTest {

    @Test
    void calculateInvitationList() {

        List<CustomerDO> customerDOList = new ArrayList<>();
        customerDOList.add(new CustomerDO(34, "ABC", 53.2451022, -6.238335));
        customerDOList.add(new CustomerDO(2, "DEF", 53.1302756, -6.2397222));
        customerDOList.add(new CustomerDO(23, "GHI", 153.1302756, -6.2397222));

        InvitationListService invitationListService = new InvitationListService(CustomConstants.ORIGIN_LATITUDE, CustomConstants.ORIGIN_LONGITUDE);
        List<CustomerRO> customerROList = invitationListService.calculateInvitationList(customerDOList, CustomConstants.RADIUS);
        assertEquals(2, customerROList.size());
        assertEquals(34, customerROList.get(1).getId());
    }

    @Test
    void calculateInvitationListWithNoResult() {

        List<CustomerDO> customerDOList = new ArrayList<>();
        customerDOList.add(new CustomerDO(34, "ABC", 153.2451022, -6.238335));
        customerDOList.add(new CustomerDO(2, "DEF", 120.1302756, -6.2397222));
        customerDOList.add(new CustomerDO(23, "GHI", 153.1302756, -6.2397222));

        InvitationListService invitationListService = new InvitationListService(CustomConstants.ORIGIN_LATITUDE, CustomConstants.ORIGIN_LONGITUDE);
        List<CustomerRO> customerROList = invitationListService.calculateInvitationList(customerDOList, CustomConstants.RADIUS);
        assertEquals(0, customerROList.size());
    }

    @Test
    void calculateInvitationListWithEmptyInput() {
        List<CustomerDO> customerDOList = new ArrayList<>();
        InvitationListService invitationListService = new InvitationListService(CustomConstants.ORIGIN_LATITUDE, CustomConstants.ORIGIN_LONGITUDE);
        List<CustomerRO> customerROList = invitationListService.calculateInvitationList(customerDOList, CustomConstants.RADIUS);
        assertEquals(0, customerROList.size());
    }

    @Test
    void calculateInvitationListWithNullInput() {
        InvitationListService invitationListService = new InvitationListService(CustomConstants.ORIGIN_LATITUDE, CustomConstants.ORIGIN_LONGITUDE);
        List<CustomerRO> customerROList = invitationListService.calculateInvitationList(null, CustomConstants.RADIUS);
        assertEquals(0, customerROList.size());
    }

    @Test
    void calculateInvitationListWithNullLocation() {

        List<CustomerDO> customerDOList = new ArrayList<>();
        CustomerDO customerDO = new CustomerDO(34, "ABC", 53.2451022, -6.238335);
        customerDO.setLocation(null);
        customerDOList.add(customerDO);
        customerDOList.add(new CustomerDO(2, "DEF", 53.1302756, -6.2397222));
        customerDOList.add(new CustomerDO(23, "GHI", 153.1302756, -6.2397222));

        InvitationListService invitationListService = new InvitationListService(CustomConstants.ORIGIN_LATITUDE, CustomConstants.ORIGIN_LONGITUDE);
        List<CustomerRO> customerROList = invitationListService.calculateInvitationList(customerDOList, CustomConstants.RADIUS);
        assertEquals(1, customerROList.size());
    }
}
