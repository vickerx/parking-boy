package com.aepb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingBoyTest {
    @Test
    void should_return_ticket_when_parking_boy_park_a_car_given_a_parking_lot() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Ticket ticket = parkingBoy.park(car);
        assertNotNull(ticket);
    }

    @Test
    void should_return_ticket_when_parking_boy_park_a_car_given_a_full_parking_lot_and_another_parking_lot() {
        Car car = new Car();
        ParkingLot fullParkingLot = new ParkingLot(1);
        fullParkingLot.park(new Car());

        ParkingBoy parkingBoy = new ParkingBoy(fullParkingLot, new ParkingLot(2));
        Ticket ticket = parkingBoy.park(car);
        assertNotNull(ticket);
    }

    @Test
    void should_return_ticket_when_parking_boy_park_a_car_given_a_space_slot_in_first_parking_lot_and_full_second_parking_lot() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(2);
        firstParkingLot.park(new Car());

        ParkingLot fullParkingLot2 = new ParkingLot(1);
        fullParkingLot2.park(new Car());
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, fullParkingLot2);

        Ticket ticket = parkingBoy.park(car);
        assertNotNull(ticket);
    }

    @Test
    void should_throw_exception_when_parking_boy_park_a_car_given_all_parking_lot_is_full() {
        Car car = new Car();
        ParkingLot fullParkingLot1 = new ParkingLot(1);
        fullParkingLot1.park(new Car());
        ParkingLot fullParkingLot2 = new ParkingLot(1);
        fullParkingLot2.park(new Car());
        ParkingBoy parkingBoy = new ParkingBoy(fullParkingLot1, fullParkingLot2);
        assertThrows(NotEmptySlotException.class, () -> parkingBoy.park(car));
    }

}
