package com.aepb;

import java.util.Comparator;

public class SuperParkingPolicy extends DefaultParkingPolicy {
    public SuperParkingPolicy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot pick() {
        ParkingLot lot = managedParkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .max(Comparator.comparing(ParkingLot::getSlotRate)).orElseThrow(NotEmptySlotException::new);
        return lot;
    }

}
