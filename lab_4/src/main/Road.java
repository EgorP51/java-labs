package main;

import main.transport.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Road {
    public List<Vehicle<?>> carsInRoad = new ArrayList<>();

    public int getCountOfHumans() {
        int count = 0;
        for (Vehicle<?> vehicle : carsInRoad) {
            count += vehicle.getOccupiedSeats();
        }
        return count;
    }

    public void addCarToRoad(Vehicle<?> vehicle) {
        carsInRoad.add(vehicle);
    }
}