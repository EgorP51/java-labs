package main.transport;

import main.people.Human;

public class Taxi<T extends Human> extends Car<T> {
    public Taxi(int maxSeats) {
        super(maxSeats);
    }
}

