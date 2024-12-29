package com.julian.java_challenge.postcodes_service.utils;

public class CoordinatesHelper {
    public static boolean validCoordinate(double coordinate) {
        return (180 >= coordinate && coordinate >= -180);
    }
}
