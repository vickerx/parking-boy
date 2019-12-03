package com.aepb;

public class ParkingBoy {

    protected ParkingPolicy policy;

    public ParkingBoy(ParkingLot... parkingLots) {
        this(new DefaultParkingPolicy(parkingLots));
    }

    public ParkingBoy(ParkingPolicy parkingPolicy) {
        policy = parkingPolicy;
    }

    public Ticket park(Car car) {
        return policy.pick().park(car);
    }

    public Car take(Ticket ticket) {
        ParkingLot lot = policy.pick();
        return lot.take(ticket);
    }

}
