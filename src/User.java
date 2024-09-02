public class User {
    private String full_name;
    private String username;
    private String password;
    private String email;
    private String debit_card_number;
    private String credit_card_number;

    public User(){
    }

    public User(String full_name, String username, String password, String email, String debit_card_number, String credit_card_number){
        this.full_name = full_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.debit_card_number = debit_card_number;
        this.credit_card_number = credit_card_number;
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

    public String getDebit(){
        return debit_card_number;
    }

    public String getCredit(){
       return credit_card_number;
    }
}
