public class Itinerary<E> {

     E details;
    private int adults;
    private int children;
    private int infants;
    private double totalCost;

    public void setDetails(E obj){
        this.details = obj;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public void setInfants(int infants) {
        this.infants = infants;
    }

    public void list(){
        System.out.println(details);
        System.out.println("Adults: "+ adults);
        System.out.println("Children: "+ children);
        System.out.println("Infants: "+ infants);
    }
}
