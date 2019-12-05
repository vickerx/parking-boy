package com.aepb;

import java.util.Comparator;
import java.util.List;

public class SmartParkingPolicy extends DefaultParkingPolicy {
    @Override
    public ParkingLot pick(List<ParkingLot> parkingLots) {
        if (parkingLots.get(0).isFull()) {
            throw new NotEmptySlotException();
        }
        return parkingLots.stream().max(Comparator.comparing(ParkingLot::getSlot)).get();
    }
}
