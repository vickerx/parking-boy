package com.aepb;

import java.util.List;

public class ParkingManager extends ParkingBoy {
    private List<ParkingBoy> parkingBoys;

    public ParkingManager(List<ParkingBoy> parkingBoys, ParkingLot... parkingLots) {
        super(parkingLots);
        this.parkingBoys = parkingBoys;
    }

    @Override
    public Ticket park(Car car) {
        ParkingBoy boy = parkingBoys.stream().filter(ParkingBoy::hasSlot).findFirst().orElse(null);
        if (boy != null) {
            return boy.park(car);
        }
        return super.park(car);
    }

    @Override
    public Car take(Ticket ticket) {
        ParkingBoy boy = parkingBoys.stream().filter(parkingBoy -> parkingBoy.hasCar(ticket)).findFirst().orElse(null);
        if (boy != null) {
            return boy.take(ticket);
        }
        return super.take(ticket);
    }
}
