public abstract class Flight {

    protected abstract String getName();
    protected abstract String getFromDate();
    protected abstract String getToDate();
    protected abstract double getCost();

    public static void reserve(Itinerary<Flight> flight, String name){

        if(name.equals("Turkish Airline"))
            TurkishFlightsAPI.reserve(flight);
//        else if(name.equals("AirCanada Flight"))
//            AirCanadaAPI.reserve(flight);
    }
}
