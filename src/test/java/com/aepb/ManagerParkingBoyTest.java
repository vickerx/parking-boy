package com.aepb;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManagerParkingBoyTest {

    @Test
    void should_return_a_valid_ticket_when_park_a_car_given_a_graduate_boy() {
        Car car = new Car();
        ParkingBoy graduate = new ParkingBoy(new ParkingLot(1));
        ParkingManager manager = new ParkingManager(Collections.singletonList(graduate), new ParkingLot(1));
        Ticket ticket = manager.park(car);
        assertNotNull(ticket);
    }

    @Test
    void should_return_a_valid_ticket_when_park_a_car_given_a_graduate_boy_which_is_full_and_a_smart_boy_which_has_slot() {
        Car car = new Car();
        ParkingBoy graduate = new ParkingBoy(new ParkingLot(0));
        SmartParkingBoy smart = new SmartParkingBoy(new ParkingLot(1));
        ParkingManager manager = new ParkingManager(Arrays.asList(graduate, smart), new ParkingLot(1));
        assertNotNull(manager.park(car));
    }

    @Test
    void should_return_a_valid_ticket_when_park_a_car_give_a_graduate_boy_with_lot_is_full_and_a_manager_has_slot_lot() {
        Car car = new Car();
        ParkingBoy graduate = new ParkingBoy(new ParkingLot(0));
        ParkingManager manager = new ParkingManager(Collections.singletonList(graduate), new ParkingLot(1));
        assertNotNull(manager.park(car));
    }

    @Test
    void should_throw_exception_when_park_a_car_given_a_graduate_boy_with_lot_is_full_and_manager_lot_is_full() {
        Car car = new Car();
        ParkingBoy graduate = new ParkingBoy(new ParkingLot(0));
        ParkingManager manager = new ParkingManager(Collections.singletonList(graduate), new ParkingLot(0));
        assertThrows(NotEmptySlotException.class, () -> manager.park(car));
    }

    @Test
    void should_get_a_car_when_take_a_car_with_a_valid_ticket_given_a_graduate_boy_take_a_car() {
        Car car = new Car();
        ParkingBoy graduate = new ParkingBoy(new ParkingLot(1));
        ParkingManager manager = new ParkingManager(Collections.singletonList(graduate), new ParkingLot(1));
        Ticket ticket = manager.park(car);
        Car actualCar = manager.take(ticket);
        assertSame(car, actualCar);
    }

    @Test
    void should_throw_exception_when_take_a_car_twice() {
        Car car = new Car();
        ParkingBoy graduate = new ParkingBoy(new ParkingLot(1));
        ParkingManager manager = new ParkingManager(Collections.singletonList(graduate), new ParkingLot(1));
        Ticket ticket = manager.park(car);
        Car actualCar = manager.take(ticket);
        assertSame(car, actualCar);
        assertThrows(RuntimeException.class, () -> manager.take(ticket));
    }

    @Test
    void should_throw_exception_when_take_a_car_given_a_invalid_ticket() {
        Car car = new Car();
        ParkingBoy graduate = new ParkingBoy(new ParkingLot(1));
        ParkingManager manager = new ParkingManager(Collections.singletonList(graduate), new ParkingLot(1));
        manager.park(car);
        Ticket inValidTicket = new Ticket();
        assertThrows(RuntimeException.class, () -> manager.take(inValidTicket));
    }
}
