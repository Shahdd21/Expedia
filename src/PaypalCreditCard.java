public class PaypalCreditCard {
    String name;
    String address;
    String expire_date;
    int ccv;
    double balance;

    PaypalCreditCard(){}

    PaypalCreditCard(String name, String address, String id, String expire_date, int ccv, double balance){
        this.name = name;
        this.address = address;
        this.expire_date = expire_date;
        this.ccv = ccv;
        this.balance = balance;
    }
}
