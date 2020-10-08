package com.ilo.ezh;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {

    private final String NAME;
    private final double COORDINATE_X;
    private final double COORDINATE_Y;
    private final List<Road> ROADS;

    public City(String name, double coordinateX, double coordinateY) {
        this.NAME = name;
        this.COORDINATE_X = coordinateX;
        this.COORDINATE_Y = coordinateY;
        this.ROADS = new ArrayList<>();
    }

    public double getCoordinateX() {
        return COORDINATE_X;
    }

    public double getCoordinateY() {
        return COORDINATE_Y;
    }

    public List<Road> getROADS() {
        return new ArrayList<>(ROADS);
    }

    void addRoadToCity(Road road) {
        ROADS.add(road);
    }

    void DeleteRoadFromCity(Road road) {
        ROADS.remove(road);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(NAME, city.NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME);
    }
}
