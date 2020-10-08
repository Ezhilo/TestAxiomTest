package com.ilo.ezh;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RoadMap {

    final Map<String, City> CITIES  = new ConcurrentHashMap<>();
    final Map<String, Road> ROADS   = new ConcurrentHashMap<>();

    public RoadMap() {
    }

    public void addCity(String name, double coordinateX, double coordinateY) {

        City city = new City(name, coordinateX, coordinateY);
        City result = CITIES.putIfAbsent(name, city);
        if (result!=null){
            throw new WrongInputException("City " + name + " already exist");
        }
    }

    synchronized public void addRoad(String nameOfRoad, String nameOfCityOne, String nameOfCityTwo, double length) {

        if (ROADS.containsKey(nameOfRoad)) {
            throw new WrongInputException("Road " + nameOfRoad + " already exists");
        }

        City CityOne = CITIES.get(nameOfCityOne);
        if (CityOne == null) {
            throw new WrongInputException("City " + nameOfCityOne + " doesn't exists");
        }

        City CityTwo = CITIES.get(nameOfCityTwo);
        if (CityTwo == null) {
            throw new WrongInputException("City " + nameOfCityTwo + " doesn't exists");
        }

        Road newRoad = new Road(nameOfRoad, CityOne, CityTwo, length);

        CityOne.addRoadToCity(newRoad);
        CityTwo.addRoadToCity(newRoad);
        ROADS.put(nameOfRoad, newRoad);

    }

    synchronized public void deleteRoad(String nameOfRoad) {

        if (!ROADS.containsKey(nameOfRoad)) {
            throw new WrongInputException("Road " + nameOfRoad + " doesn't exists");
        }

        Road road = ROADS.get(nameOfRoad);

        CITIES.get(road.getCitiOne()).DeleteRoadFromCity(road);
        CITIES.get(road.getCitiTwo()).DeleteRoadFromCity(road);

        ROADS.remove(nameOfRoad);

    }

    synchronized public List<Road> getRoadList (String nameOfCity)  {

        if(!CITIES.containsKey(nameOfCity)) {
            System.out.println("City " + nameOfCity + " doesn't exists");
            return null;
        }
        else {
            City city = CITIES.get(nameOfCity);
            return city.getROADS();
        }
    }

    public City getCity(String nameOfCity) {

        City city = CITIES.get(nameOfCity);
        if (city == null) {
            System.out.println("City " + nameOfCity + " doesn't exists");
            return null;
        }
        return city;

    }

}
