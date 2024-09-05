import java.util.*;

public class TurkishFlightsAPI {

    private static final ArrayList<TurkishFlight> flights = new ArrayList<>();
    static {
        flights.add(new TurkishFlight("Turkish Airline","20-1-2024", "21-1-2024", 150));
        flights.add(new TurkishFlight("Turkish Airline","22-1-2024", "23-1-2024", 200));
        flights.add(new TurkishFlight("Turkish Airline","24-1-2024", "25-1-2024", 250));
    }

    public static ArrayList<TurkishFlight> getFlights(){
        return flights;
    }

    public static void bookFlight(Flight flight, String fromCity, String toCity, int children, int adults, int infants){
        Itinerary<Flight> ite = new Itinerary<>(flight, fromCity, toCity, children, adults);
        ite.addFlight(ite);
    }
}