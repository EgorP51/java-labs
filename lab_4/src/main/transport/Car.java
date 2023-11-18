package main.transport;

import main.people.Human;

public class Car<T extends Human> extends Vehicle<T> {
    public Car(int maxSeats) {
        super(maxSeats);
    }
}