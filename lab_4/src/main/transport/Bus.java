package main.transport;

import main.people.Human;

public class Bus<T extends Human> extends Vehicle<T> {
    public Bus(int maxSeats) {
        super(maxSeats);
    }
}