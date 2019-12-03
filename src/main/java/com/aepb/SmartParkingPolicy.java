package com.aepb;

import java.util.Comparator;

public class SmartParkingPolicy extends DefaultParkingPolicy {
    public SmartParkingPolicy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot pick() {
        if (managedParkingLots.get(0).isFull()) {
            throw new NotEmptySlotException();
        }
        return managedParkingLots.stream().max(Comparator.comparing(ParkingLot::getSlot)).get();
    }
}
