package LLD;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Map;

// If parking slots are available
// Different vehicles different parking spots
// Produce bill/charge vehicle owners for parking
// Parking location
// payment system
interface ParkingSystem {
    PaymentType availablePaymentMethod(Parking location);
    Ticket parkVehicle(VehicleType vehicleType);
    Bill checkOutForParking(Timestamp startTime, Timestamp endTime, VehicleType vehicleType);
    Parking vehicleParkingLocation(VehicleType vehicleType);
}

class ParkingSystemImpl implements ParkingSystem {

    @Override
    public Parking vehicleParkingLocation(VehicleType vehicleType) {
        return null;
    }

    @Override
    public PaymentType availablePaymentMethod(Parking location) {
        return null;
    }

    @Override
    public Bill checkOutForParking(Timestamp startTime, Timestamp endTime, VehicleType vehicleType) {
        return null;
    }

    public boolean payForParking(PaymentType paymentMethod, Payment paymentHandler, double amount) {
        return false;
    }

    public Ticket parkVehicle(VehicleType vehicleType) {
        return null;
    }
}

abstract class Parking {
    int floorNumber;
    int slotNumber;
    int zone;
    VehicleType vehicleType;
    boolean isOccupied;
}

class Ticket {
    Parking parking;
    Vehicle vehicleType;
    Timestamp startTime;
}

class Bill {
    Ticket ticket;
    Timestamp checkoutDate;
    double amountCharged;
}

class Vehicle {
    String registrationNumber;
    VehicleType vehicleType;
}

enum VehicleType {
    FourWheeler,
    TwoWheeler;
}

class Charges {
    VehicleType vehicleType;
    Currency currency;
    TimeUnit timeUnit;
    double rate;
}

interface Payment {
    boolean payCharge(double amount);
}

enum PaymentType {
    Paytm,
    UPI;
}

class PaytmPayment implements Payment {
    @Override
    public boolean payCharge(double amount) {
        System.out.println("Paid " + amount);
        return true;
    }
}

enum Currency {
    INR;
}

enum TimeUnit {
    HOUR,
    DAYS;
}





