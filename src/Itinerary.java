import java.util.ArrayList;

public class Itinerary<E> {

    private String flight_name;
    private String fromPlace;
    private String toPlace;
    private String fromDate;
    private String toDate;
    private double cost;
    private int adults;
    private int children;
    private int infants;
    private double totalCost;

    private static ArrayList<Itinerary<Flight>> flightReservations = new ArrayList<>();

    Itinerary(String flight_name, String fromPlace, String toPlace, String fromDate, String toDate, double cost,
              int adults, int children, int infants){
        this.flight_name = flight_name;
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.cost = cost;
        this.children = children;
        this.adults = adults;
        this.infants = infants;

        totalCost += cost;
    }

    public static void add(Itinerary<Flight> itinerary){
        flightReservations.add(itinerary);
    }

    public static void list(){
        for(Itinerary<Flight> flight : flightReservations){
            System.out.println(flight.flight_name);
            System.out.println(flight.fromPlace);
            System.out.println(flight.toPlace);
            System.out.println(flight.fromDate);
            System.out.println(flight.toDate);
            System.out.println(flight.cost);
        }
    }
}
