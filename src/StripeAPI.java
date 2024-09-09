public class StripeAPI {

    public static boolean makePayment(Card card, double money) {

        if (card.balance < money)
            return false;
        else {
            card.balance -= money;
            return true;
        }
    }
}
