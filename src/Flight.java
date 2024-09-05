public abstract class Flight {

    protected String airlineName;
    protected String fromDate;
    protected String toDate;
    protected double cost;

    Flight(){}

    Flight(String airlineName, String fromDate, String toDate, double cost){

        this.airlineName = airlineName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.cost = cost;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getToDate() {
        return toDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public double getCost() {
        return cost;
    }
}
