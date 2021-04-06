package com.test.intercom;


import com.test.intercom.constants.CustomConstants;
import com.test.intercom.responseobject.CustomerRO;
import com.test.intercom.service.CustomerService;
import com.test.intercom.service.InvitationListService;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class for the invitation list generator application.
 */
public class InvitationListGeneratorApp {

    /**
     * The main method of application generating and printing invitation list.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<CustomerRO> result = new ArrayList<>();
        CustomerService customerService = new CustomerService();
        InvitationListService invitationListService = new InvitationListService(CustomConstants.ORIGIN_LATITUDE,
                                                                                CustomConstants.ORIGIN_LONGITUDE);

        customerService.updateCustomerListFromFile(CustomConstants.FILE_NAME);
        if(customerService.getCustomerDOList() != null) {
            result = invitationListService
                .calculateInvitationList(customerService.getCustomerDOList(), CustomConstants.RADIUS);
        }
        if(result == null || result.isEmpty()) {
            System.out.println("Sorry! No customers found within given radius.");
        } else {
            for (CustomerRO customerRO : result) {
                System.out.println("id: " + customerRO.getId() + ", name: " + customerRO.getName());
            }
        }
    }
}
