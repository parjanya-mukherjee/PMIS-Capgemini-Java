
import java.util.ArrayList;
import java.util.List;

interface Rentable {
    double calculateRent(int days);
    boolean isAvailable();
}

abstract class Vehicle implements Rentable {
    String id;
    String model;
    double dailyRate;
    boolean availability = true;

    Vehicle(String id, String model, double dailyRate) {
        this.id = id;
        this.model = model;
        this.dailyRate = dailyRate;
    }

    public boolean isAvailable() {
        return availability;
    }

    public String getDetails() {
        return getClass().getSimpleName() + " " + model + " (" + id + ")";
    }
}

class Car extends Vehicle {
    Car(String id, String model, double dailyRate) {
        super(id, model, dailyRate);
    }

    public double calculateRent(int days) {
        return dailyRate * days;
    }
}

class Bike extends Vehicle {
    Bike(String id, String model, double dailyRate) {
        super(id, model, dailyRate);
    }

    public double calculateRent(int days) {
        double rent = dailyRate * days;
        return days >= 7 ? rent * 0.9 : rent;
    }
}

class Truck extends Vehicle {
    Truck(String id, String model, double dailyRate) {
        super(id, model, dailyRate);
    }

    public double calculateRent(int days) {
        return dailyRate * days + 500;
    }
}

class Customer {
    String name;
    List<Rental> history = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }
}

class Rental {
    Vehicle vehicle;
    Customer customer;
    int days;
    double amount;

    Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.amount = vehicle.calculateRent(days);
    }

    public void printRental() {
        System.out.printf(
            "%s rented %s for %d days = %.2f%n",
            customer.name, vehicle.getDetails(), days, amount
        );
    }
}

class RentalShop {
    List<Vehicle> fleet = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public void rent(String id, Customer customer, int days)
            throws Exception {

        Vehicle found = null;

        for (Vehicle v : fleet) {
            if (v.id.equals(id)) {
                found = v;
                break;
            }
        }

        if (found == null) {
            throw new Exception("Vehicle " + id + " not found");
        }

        if (!found.isAvailable()) {
            throw new Exception(
                found.getDetails() + " is already rented"
            );
        }

        if (days <= 0) {
            throw new Exception("Rental days must be positive");
        }

        found.availability = false;

        Rental rental = new Rental(found, customer, days);
        customer.history.add(rental);
        rental.printRental();
    }

    public void giveBack(String id) throws Exception {
        for (Vehicle v : fleet) {
            if (v.id.equals(id)) {
                if (v.isAvailable()) {
                    throw new Exception(
                        v.getDetails() + " is not currently rented"
                    );
                }

                v.availability = true;
                return;
            }
        }

        throw new Exception("Vehicle " + id + " not found");
    }

    public void showAvailable() {
        System.out.println("Available vehicles:");

        for (Vehicle v : fleet) {
            if (v.isAvailable()) {
                System.out.println("  " + v.getDetails());
            }
        }
    }
}

public class vrs {
    public static void main(String[] args) {
        RentalShop shop = new RentalShop();

        shop.addVehicle(new Car("C1", "Swift", 2000));
        shop.addVehicle(new Bike("B1", "Activa", 400));
        shop.addVehicle(new Truck("T1", "Tata Ace", 2500));

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");

        
try {
    shop.rent("B1", asha, 8);
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}

try {
    shop.rent("T1", ravi, 2);
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}

try {
    shop.rent("B1", ravi, 3);
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}

try {
    shop.giveBack("B1");
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}



        shop.showAvailable();
    }
}
