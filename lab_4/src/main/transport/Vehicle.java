package main.transport;

import main.people.Human;

public class Vehicle<T extends Human> {
    private int maxSeats;
    private int occupiedSeats;

    public Vehicle(int maxSeats) {
        this.maxSeats = maxSeats;
        this.occupiedSeats = 0;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getOccupiedSeats() {
        return occupiedSeats;
    }

    public void embark(T passenger) {
        if (occupiedSeats < maxSeats) {
            System.out.println(passenger.getName() + " boarded the vehicle.");
            occupiedSeats++;
        } else {
            System.out.println("All seats are occupied.");
            //throw new RuntimeException("All seats are occupied.");
        }
    }

    public void disembark(T passenger) {
        if (occupiedSeats > 0) {
            System.out.println(passenger.getName() + " disembarked from the vehicle.");
            occupiedSeats--;
        } else {
            System.out.println(passenger.getName() + " is not in the vehicle.");
            //throw new RuntimeException(passenger.getName() + " is not in the vehicle.");
        }
    }
}