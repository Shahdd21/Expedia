import java.util.ArrayList;

public class Itinerary<E> {

    private E flight_or_hotel;
    private int adults;
    private int children;
    private int infants;
    private String fromCity;
    private String toCity;
    private double totalCost;

    private ArrayList<Itinerary<E>> reservations = new ArrayList<>();

    Itinerary(){}

    Itinerary(E flight_or_hotel, int adults, int children, int infants, String fromCity, String toCity){
        this.flight_or_hotel = flight_or_hotel;
        this.adults = adults;
        this.children = children;
        this.infants = infants;
        this.fromCity = fromCity;
        this.toCity = toCity;
    }

    public void add(Itinerary<E> itinerary){
        reservations.add(itinerary);
    }

    public void list(){
        for(Itinerary<E> itinerary : reservations){
            System.out.println("From City: "+ itinerary.fromCity+" to City: "+ itinerary.toCity);
            System.out.println(itinerary.flight_or_hotel.toString());
            System.out.println(itinerary.adults);
            System.out.println(itinerary.children);
            System.out.println(itinerary.infants);
        }
    }
}
