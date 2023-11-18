package main;

import main.people.Firefighter;
import main.people.Human;
import main.people.Policeman;
import main.transport.Bus;
import main.transport.FireTruck;
import main.transport.PoliceCar;
import main.transport.Taxi;

public class Main {
    public static void main(String[] args) {
        Road road = new Road();

        Bus<Human> bus = new Bus<>(20);
        Taxi<Human> taxi = new Taxi<>(4);
        FireTruck fireTruck = new FireTruck(6);
        PoliceCar policeCar = new PoliceCar(2);

        road.addCarToRoad(bus);
        road.addCarToRoad(taxi);
        road.addCarToRoad(fireTruck);
        road.addCarToRoad(policeCar);

        Human passenger1 = new Human("Passenger 1");
        Human passenger2 = new Human("Passenger 2");
        Human passenger3 = new Human("Passenger 3");
        Firefighter firefighter = new Firefighter("Firefighter 1");

        Policeman policeman0 = new Policeman("Policeman 0");
        Policeman policeman1 = new Policeman("Policeman 1");
        //Policeman policeman2 = new Policeman("Policeman 2");

        bus.embark(passenger1);
        bus.embark(passenger2);

        taxi.embark(passenger3);
        fireTruck.embark(firefighter);

        policeCar.embark(policeman0);
        policeCar.embark(policeman1);
        //policeCar.embark(policeman2);

        System.out.println("road.getCountOfHumans(): " + road.getCountOfHumans());

        bus.disembark(passenger1);
        taxi.disembark(passenger1);
        fireTruck.disembark(firefighter);
        policeCar.disembark(policeman1);

        System.out.println("road.getCountOfHumans(): " + road.getCountOfHumans());
    }
}
