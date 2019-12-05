package com.aepb;

import java.util.Comparator;
import java.util.List;

public class SuperParkingPolicy extends DefaultParkingPolicy {
    @Override
    public ParkingLot pick(List<ParkingLot> parkingLots) {
        ParkingLot lot = parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .max(Comparator.comparing(ParkingLot::getSlotRate)).orElseThrow(NotEmptySlotException::new);
        return lot;
    }

}
