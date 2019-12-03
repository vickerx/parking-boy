package com.aepb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SuperParkingBoyTest {

    @Test
    void should_return_a_valid_ticket_when_super_parking_boy_park_a_car_in_a_have_space_parking_lot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot);
        Ticket ticket = superParkingBoy.park(car);
        assertNotNull(ticket);

    }

    @Test
    void should_throw_exception_when_super_parking_boy_park_a_car_in_a_full_parking_lot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(0);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot);
        assertThrows(NotEmptySlotException.class, () -> superParkingBoy.park(car));
    }


    @Test
    void should_return_a_valid_ticket_and_park_in_more_space_parking_lot_when_super_parking_boy_park_a_car_in_two_have_different_space_parking_lots() {
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingLot2.park(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot1, parkingLot2);
        Ticket ticket = superParkingBoy.park(car);
        Car actualCar = parkingLot1.take(ticket);
        assertSame(car, actualCar);

    }

    @Test
    void should_return_a_valid_ticket_and_park_in_first_parking_lot_when_super_parking_boy_park_a_car_in_two_have_same_space_parking_lots() {
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot1, parkingLot2);
        Ticket ticket = superParkingBoy.park(car);
        assertNotNull(ticket);
        Car actualCar = parkingLot1.take(ticket);
        assertSame(car, actualCar);
    }

    @Test
    void should_return_a_valid_ticket_when_super_parking_boy_park_a_car_in_a_full_parking_lots_and_another_has_space_lot() {
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot1, parkingLot2);
        assertNotNull(superParkingBoy.park(car));
    }

    @Test
    void should_return_a_car_when_super_boy_take_a_car_with_a_valid_ticket() {
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot1);
        Ticket ticket = parkingLot1.park(car);
        Car actualCar = superParkingBoy.take(ticket);
        assertSame(car, actualCar);
    }

}
