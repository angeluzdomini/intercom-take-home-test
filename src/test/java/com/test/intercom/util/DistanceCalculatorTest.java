package com.test.intercom.util;

import com.test.intercom.constants.CustomConstants;
import com.test.intercom.dataobject.LocationDO;
import com.test.intercom.exceptions.InvalidLocationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

    LocationDO origin = new LocationDO(CustomConstants.ORIGIN_LATITUDE, CustomConstants.ORIGIN_LONGITUDE);

    LocationDO location = new LocationDO(53.2451022, -6.238335);

    LocationDO invalidLocation = new LocationDO(93.2451022, -6.238335);

    @Test
    void calculateDistance() throws InvalidLocationException {
        double distance = DistanceCalculator.calculateDistance(location, origin);
        assertEquals(10.56, distance);
    }

    @Test
    void calculateDistanceInvalid() {
        assertThrows(InvalidLocationException.class, () -> {
            DistanceCalculator.calculateDistance(invalidLocation, origin);
        });
    }

    @Test
    void calculateDistanceNull() {
        assertThrows(InvalidLocationException.class, () -> {
            DistanceCalculator.calculateDistance(location, null);
        });
    }
}
