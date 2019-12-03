package com.aepb;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(new SmartParkingPolicy(parkingLots));
    }


}
