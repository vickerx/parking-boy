package com.aepb;

import java.util.List;

public class DefaultParkingPolicy implements ParkingPolicy {

    @Override
    public ParkingLot pick(List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst()
                .orElseThrow(NotEmptySlotException::new);
    }

}
