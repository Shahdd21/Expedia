public class User {
    private String full_name;
    private String username;
    private String password;
    private String email;
    private PaypalCreditCard card1;
    private StripeCreditCard card2;

    public User(){
    }

    public User(String full_name, String username, String password, String email,
                PaypalCreditCard card1, StripeCreditCard card2){
        this.full_name = full_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.card1 = card1;
        this.card2 = card2;
    }

    public String getFull_name(){
        return full_name;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public Card getCard1() {
        return card1;
    }

    public Card getCard2(){
        return card2;
    }

    public void setCard1(PaypalCreditCard card1) {
        this.card1 = card1;
    }

    public void setCard2(StripeCreditCard card2) {
        this.card2 = card2;
    }
}
