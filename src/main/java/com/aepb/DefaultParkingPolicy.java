package com.aepb;

import java.util.Arrays;
import java.util.List;

public class DefaultParkingPolicy implements ParkingPolicy {

    protected List<ParkingLot> managedParkingLots;

    public DefaultParkingPolicy(ParkingLot... parkingLots) {
        if (parkingLots.length == 0) {
            throw new IllegalManagedParkingLotException();
        }
        managedParkingLots = Arrays.asList(parkingLots);
    }

    @Override
    public ParkingLot pick() {
        return managedParkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst()
                .orElseThrow(NotEmptySlotException::new);
    }

}
