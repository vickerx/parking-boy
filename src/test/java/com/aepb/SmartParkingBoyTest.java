package com.aepb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {

    @Test
    void should_return_a_valid_ticket_when_smart_parking_boy_park_a_car_in_a_have_space_parking_lot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Ticket ticket = smartParkingBoy.park(car);
        assertNotNull(ticket);

    }

    @Test
    void should_throw_exception_when_smart_parking_boy_park_a_car_in_a_full_parking_lot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(0);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        assertThrows(NotEmptySlotException.class, () -> smartParkingBoy.park(car));
    }

    @Test
    void should_return_a_valid_ticket_and_park_in_more_space_parking_lot_when_smart_parking_boy_park_a_car_in_two_have_different_space_parking_lots() {
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);
        Ticket ticket = smartParkingBoy.park(car);
        assertNotNull(ticket);
        Car actualCar = parkingLot2.take(ticket);
        assertSame(car, actualCar);

    }

    @Test
    void should_return_a_valid_ticket_and_park_in_first_parking_lot_when_smart_parking_boy_park_a_car_in_two_have_different_space_parking_lots() {
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);
        Ticket ticket = smartParkingBoy.park(car);
        assertNotNull(ticket);
        Car actualCar = parkingLot1.take(ticket);
        assertSame(car, actualCar);
    }

    @Test
    void should_return_a_car_when_smart_boy_take_a_car_with_a_valid_ticket() {
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1);
        Ticket ticket = parkingLot1.park(car);
        Car actualCar = smartParkingBoy.take(ticket);
        assertSame(car, actualCar);
    }
}
