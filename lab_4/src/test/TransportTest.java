package test;

import main.Road;
import main.people.Firefighter;
import main.people.Human;
import main.people.Policeman;
import main.transport.Bus;
import main.transport.FireTruck;
import main.transport.PoliceCar;
import main.transport.Taxi;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransportTest {

    @Test
    public void testTransport() {
        Road road = new Road();

        Bus<Human> bus = new Bus<>(20);
        Taxi<Human> taxi = new Taxi<>(4);
        FireTruck fireTruck = new FireTruck(6);
        PoliceCar policeCar = new PoliceCar(2);

        road.addCarToRoad(bus);
        road.addCarToRoad(taxi);
        road.addCarToRoad(fireTruck);
        road.addCarToRoad(policeCar);

        // Test embarkation
        Human passenger1 = new Human("Passenger 1");
        Human passenger2 = new Human("Passenger 2");
        Firefighter firefighter = new Firefighter("Firefighter 1");
        Policeman policeman = new Policeman("Policeman 1");

        bus.embark(passenger1);
        taxi.embark(passenger2);
        fireTruck.embark(firefighter);
        policeCar.embark(policeman);

        bus.disembark(passenger1);
        taxi.disembark(passenger2);
        fireTruck.disembark(firefighter);
        policeCar.disembark(policeman);

        for (int i = 0; i < 20; i++) {
            bus.embark(new Human("Passenger " + i));
        }
        assertEquals(20, road.getCountOfHumans());

        bus.embark(new Firefighter("New Passenger"));
        assertEquals(20, road.getCountOfHumans());

        bus.disembark(new Human("New Passenger"));
        assertEquals(19, road.getCountOfHumans());

        //fireTruck.embark(policeman);
    }
}
