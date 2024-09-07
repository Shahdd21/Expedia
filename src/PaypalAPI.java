public class PaypalAPI {

    public static boolean makePayment(PaypalCreditCard card, double money){

        if(card.balance < money)
            return false;
        else {
            card.balance -= money;
            return true;
        }
    }
}
