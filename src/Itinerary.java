import java.util.ArrayList;

public class Itinerary<E extends Bookable> {

    private E flight_or_hotel;
    private int adults;
    private int children;
    private String fromCity;
    private String toCity;

    private static double totalCost = 0.0;

    private static final ArrayList<Itinerary<? extends Bookable>> bookedItems = new ArrayList<>();

    Itinerary(){}

    Itinerary(E flight_or_hotel, String fromCity, String toCity, int children, int adults){
        this.flight_or_hotel = flight_or_hotel;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.children = children;
        this.adults = adults;

        totalCost += flight_or_hotel.getCost();
    }

    public void add(){
        bookedItems.add(this);
    }

    public static void list(){
        for(Itinerary<? extends Bookable> ite : bookedItems){
            System.out.println(ite.flight_or_hotel.toString());
            System.out.println("From: "+ite.fromCity);
            System.out.println("to: "+ite.toCity);
            System.out.println("Adults: "+ite.adults+" children: "+ite.children);
            System.out.println("-----------------------------");
        }

        Itinerary ite = new Itinerary<>();
        System.out.println("Total cost: "+ite.totalCost);
    }

    public static double getTotalCost(){
        return totalCost;
    }

    public static void removeFromTotalCost(int cnt){

        while(cnt > 0){

            int size = bookedItems.size();
            Itinerary<? extends Bookable> ite = bookedItems.get(size-1);

            totalCost -= ite.flight_or_hotel.getCost();

            bookedItems.remove(ite);
            --cnt;
        }
    }
}
