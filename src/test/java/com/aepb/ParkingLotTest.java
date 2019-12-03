package com.aepb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void should_get_a_ticket_when_park_car_in_parking_lot_successfully() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingLot.park(car);
        assertNotNull(ticket);
    }

    @Test
    void should_park_failure_when_park_car_in_full_parking_lot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        assertThrows(RuntimeException.class, () -> parkingLot.park(car), "parking lot is full");

    }

    @Test
    void should_take_a_car_successfully_when_given_a_valid_ticket() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingLot.park(car);

        Car actualCar = parkingLot.take(ticket);
        assertSame(car, actualCar);
    }

    @Test
    void should_take_a_car_failure_when_given_a_invalid_ticket() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(car);
        Ticket invalidTicket = new Ticket();
        assertThrows(RuntimeException.class,
                () -> parkingLot.take(invalidTicket), "ticket is invalid,can't take the car");

    }

    @Test
    void should_throw_exception_when_take_a_car_given_same_ticket_twice() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingLot.park(car);
        parkingLot.take(ticket);
        assertThrows(RuntimeException.class, () -> parkingLot.take(ticket));
    }
}
