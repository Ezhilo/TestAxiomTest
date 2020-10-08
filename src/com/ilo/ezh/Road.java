package com.ilo.ezh;

import java.util.Objects;

public class Road {

    private final String NAME;
    private final City CITY_ONE;
    private final City CITY_TWO;
    private final double LENGTH;

    public Road(String NAME, City citiOne, City citiTwo, double length) {
        this.NAME = NAME;
        this.CITY_ONE = citiOne;
        this.CITY_TWO = citiTwo;
        this.LENGTH = length;
        // In Real World length may be longer )
        //this.LENGTH = getLengthBetweenCities(citiOne.getCoordinateX(), citiOne.getCoordinateY(), citiTwo.getCoordinateX(), citiTwo.getCoordinateY());

    }

    public City getCitiOne() {
        return CITY_ONE;
    }

    public City getCitiTwo() {
        return CITY_TWO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Objects.equals(NAME, road.NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME);
    }
//    private static double getLengthBetweenCities(double x1, double y1, double x2, double y2) {
//        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
//    }

}
