import java.util.ArrayList;

public class Itinerary<E> {

    private E flight_or_hotel;
    private int adults;
    private int children;
    private String fromCity;
    private String toCity;
    private double totalCost;

    private static final ArrayList<Itinerary<Flight>> bookedFlights = new ArrayList<>();
   // private final ArrayList<Itinerary<Hotel>> bookedHotels = new ArrayList<>();

    Itinerary(){}

    Itinerary(E flight_or_hotel, String fromCity, String toCity, int children, int adults){
        this.flight_or_hotel = flight_or_hotel;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.children = children;
        this.adults = adults;
    }

    public void addFlight(Itinerary<Flight> ite){
        bookedFlights.add(ite);
    }

//    public void addHotels(Hotel hotel, String city, String country, int children, int adults, int infants){
//        bookedHotels.add(new Itinerary<>(hotel,city,country,children,adults,infants));
//    }

    public static void displayFlights(){

        for(Itinerary itinerary : bookedFlights){
            System.out.println(itinerary.flight_or_hotel.toString());
            System.out.println(itinerary.children+" "+ itinerary.adults);
        }
    }
}
