package com.aepb;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ParkingBoy {

    private ParkingPolicy policy;
    private List<ParkingLot> managedParkingLots;

    public ParkingBoy(ParkingLot... parkingLots) {
        this(new DefaultParkingPolicy(), parkingLots);
    }

    ParkingBoy(ParkingPolicy parkingPolicy, ParkingLot... parkingLots) {
        if (parkingLots.length == 0) {
            throw new IllegalManagedParkingLotException();
        }
        this.managedParkingLots = Arrays.asList(parkingLots);
        this.policy = parkingPolicy;
    }

    public Ticket park(Car car) {
        return policy.pick(managedParkingLots).park(car);
    }

    public Car take(Ticket ticket) {
        ParkingLot parkingLot = managedParkingLots.stream().filter(lot -> lot.hasCar(ticket)).findFirst().orElse(null);
        if (Objects.isNull(parkingLot)) {
            throw new RuntimeException("parking lot is null");
        }
        return parkingLot.take(ticket);
    }

    boolean hasSlot() {
        return managedParkingLots.stream().max(Comparator.comparing(ParkingLot::getSlot)).get().getSlot() != 0;
    }

    boolean hasCar(Ticket ticket) {
        return managedParkingLots.stream().anyMatch(lot -> lot.hasCar(ticket));
    }
}
