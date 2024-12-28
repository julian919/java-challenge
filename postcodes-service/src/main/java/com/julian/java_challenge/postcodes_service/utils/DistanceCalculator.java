package com.julian.java_challenge.postcodes_service.utils;

public class DistanceCalculator {

    private final static double EARTH_RADIUS = 6371; // radius in kilometers

    /**
     * Calculates the distance between two geographical coordinates using the
     * Haversine formula.
     *
     * @param latitude   Latitude of the first point.
     * @param longitude  Longitude of the first point.
     * @param latitude2  Latitude of the second point.
     * @param longitude2 Longitude of the second point.
     * @return The distance in kilometers.
     */
    public static double calculateDistance(double latitude, double longitude, double latitude2, double longitude2) {
        double lon1Radians = Math.toRadians(longitude);
        double lon2Radians = Math.toRadians(longitude2);
        double lat1Radians = Math.toRadians(latitude);
        double lat2Radians = Math.toRadians(latitude2);

        double a = haversine(lat1Radians, lat2Radians)
                + Math.cos(lat1Radians) * Math.cos(lat2Radians) * haversine(lon1Radians, lon2Radians);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (EARTH_RADIUS * c);
    }

    private static double haversine(double deg1, double deg2) {
        return square(Math.sin((deg1 - deg2) / 2.0));
    }

    private static double square(double x) {
        return x * x;
    }
}