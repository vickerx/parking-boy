package com.aepb;

public class SuperParkingBoy extends ParkingBoy {
    public SuperParkingBoy(ParkingLot... parkingLots) {
        super(new SuperParkingPolicy(), parkingLots);
    }

}
