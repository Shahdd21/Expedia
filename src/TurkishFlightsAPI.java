import java.util.*;

public class TurkishFlightsAPI {

   // private static ArrayList<Itinerary<Flight>> reservations = new ArrayList<>();

    private static ArrayList<TurkishFlight> flights = new ArrayList<>();
    static {
        flights.add(new TurkishFlight("20-1-2024", "21-1-2024", 150));
        flights.add(new TurkishFlight("22-1-2024", "23-1-2024", 200));
        flights.add(new TurkishFlight("24-1-2024", "25-1-2024", 250));
    }

    public static ArrayList<TurkishFlight> getFlights(){
        return flights;
    }

    public static void reserve(Itinerary<Flight> chosenFlight){
       // reservations.add(chosenFlight);
        Itinerary.add(chosenFlight);
    }
}

class TurkishFlight extends Flight{
    private String fromDate;
    private String toDate;
    private double cost;

    TurkishFlight(){

    }

    TurkishFlight(String fromDate, String toDate, double cost){
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.cost = cost;
    }

    public String getName(){
        return "Turkish Airline";
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public double getCost() {
        return cost;
    }
}