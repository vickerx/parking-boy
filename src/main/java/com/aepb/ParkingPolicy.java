package com.aepb;

import java.util.List;

public interface ParkingPolicy {

    ParkingLot pick(List<ParkingLot> parkingLots);

}
