package com.test.intercom.util;

import com.test.intercom.constants.CustomConstants;
import com.test.intercom.dataobject.LocationDO;
import com.test.intercom.exceptions.InvalidLocationException;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Distance calculator to calculate distance between any two locations.
 */
public class DistanceCalculator {

    /**
     * Calculate distance based on given locations and return in kilometres. The calculation is done using great-circle distance formula.
     *
     * @param locationA the location a
     * @param locationB the location b
     * @return the double
     */
    public static double calculateDistance(LocationDO locationA, LocationDO locationB) throws InvalidLocationException {

        if(locationA != null && locationB != null) {

            validateLocation(locationA);
            validateLocation(locationA);

            //Convert latitudes and longitudes to radian
            double latitudeA = Math.toRadians(locationA.getLatitude());
            double latitudeB = Math.toRadians(locationB.getLatitude());
            double longitudeA = Math.toRadians(locationA.getLongitude());
            double longitudeB = Math.toRadians(locationB.getLongitude());

            //great-circle distance formula
            double angle = Math.acos(
                Math.sin(latitudeA) * Math.sin(latitudeB) + Math.cos(latitudeA) * Math.cos(latitudeB) * Math
                    .cos(longitudeA - longitudeB));

            angle = Math.toDegrees(angle);

            //calculate distance in KM from the angle.
            double distance = 60 * angle * CustomConstants.NAUTICAL_TO_KM;

            //set the precision for KM to 2 decimal points.
            Double distanceWithPrecision = BigDecimal.valueOf(distance).setScale(2, RoundingMode.HALF_UP).doubleValue();
            return distanceWithPrecision;
        } else {
            throw new InvalidLocationException("Given locations are invalid/null.");
        }
    }

    /*
     * Validate that latitude and longitude values are within the ranges.
     */
    private static void validateLocation(LocationDO location) throws InvalidLocationException {
        if((location.getLatitude() < -90 || location.getLatitude() > 90) || (location.getLongitude() < -180 || location.getLongitude() > 180)) {
            throw new InvalidLocationException("Given locations are invalid/null.");
        }
    }
}
