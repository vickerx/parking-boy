package com.aepb;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParkingLot {

    private int capacity;
    private int slot;

    private Map<Ticket, Car> parkingLot = new HashMap<>(capacity);

    public ParkingLot() {
        this(2);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.slot = capacity;
    }

    public Ticket park(Car car) {
        if (isFull()) {
            throw new RuntimeException("parking lot is full");
        }
        Ticket ticket = new Ticket();
        parkingLot.put(ticket, car);
        slot--;
        return ticket;
    }

    public Car take(Ticket ticket) {
        Car car = parkingLot.remove(ticket);
        if (Objects.isNull(car)) {
            throw new RuntimeException("ticket is invalid,can't take the car");
        }
        slot++;
        return car;
    }

    public boolean isFull() {
        return slot == 0;
    }

    public int getSlot() {
        return slot;
    }

    public double getSlotRate() {
        return ((double) slot) / capacity;
    }

    public boolean hasCar(Ticket ticket) {
        return null != parkingLot.get(ticket);
    }
}
