import java.util.*;

public class TurkishFlightsAPI {

   private static ArrayList<Itinerary> reservations = new ArrayList<>();


    public static ArrayList<TurkishFlight> getFlights(){

        ArrayList<TurkishFlight> flights = new ArrayList<>();
            flights.add(new TurkishFlight("20-1-2024","21-1-2024",150));
            flights.add(new TurkishFlight("22-1-2024","23-1-2024",200));
            flights.add(new TurkishFlight("24-1-2024","25-1-2024",250));

        return flights;
    }

    public static <E> void reserve(int adults, int children, int infants, E target){

        Itinerary<E> booking = new Itinerary<E>();
        booking.setAdults(adults);
        booking.setDetails(target);
        booking.setChildren(children);
        booking.setInfants(infants);

        reservations.add(booking);
    }

    public static ArrayList<Itinerary> getReservations(){
        return reservations;
    }
}

class TurkishFlight{
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