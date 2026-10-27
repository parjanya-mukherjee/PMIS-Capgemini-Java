interface Rentable {
    double calculateRent(int days);
    boolean isAvailable();
}
abstract class Vehicle implements Rentable {
    String id;
    String model;
    double dailyRate;
    boolean availability = true;
}
class car extends Vehicle{
    int calculateRent(int days){
        return (dailyRate*days);
    }
}
class bike extends Vehicle{
    int calculateRent(int days){
        if(days<7){
            return (dailyRate*days);
        }
        else{
            return (dailyRate*days*0.9); 
        }
    }
}
class truck extends Vehicle{
    int calculateRent(int days){
        return (dailyRate*days+500);
    }
}
public class Vehicle {
    
}
