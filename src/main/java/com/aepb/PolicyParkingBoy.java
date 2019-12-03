package com.aepb;


public class PolicyParkingBoy {

    private ParkingPolicy policy;

    public PolicyParkingBoy(ParkingLot... parkingLots) {
        policy = new DefaultParkingPolicy(parkingLots);
    }

    public void setParkingPolicy(ParkingPolicy policy) {
        this.policy = policy;
    }

    public Ticket park(Car car) {
        ParkingLot lot = policy.pick();
        return lot.park(car);
    }

    public Car take(Ticket ticket) {
        return policy.pick().take(ticket);
    }
}
