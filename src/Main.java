import java.util.*;

public class Main {

    static Scanner input = new Scanner(System.in);
    static Map<String, String> usernames_passwords = new HashMap<>();
    static Set<User> users = new HashSet<>();

    public static void main(String[] args) {

        usernames_passwords.put("shahd","123");
        users.add(new User("Shahd Mahmoud Muhammed","shahd","123", "shahd@gmail.com",
                new PaypalCreditCard("Shahd Mahmoud Muhammed","Alexandria","01202468259",4587,500),new Card())) ;

            while (true) {
                System.out.println("Menu:");
                System.out.println("\t\t1: Login");
                System.out.println("\t\t2: Signup");

                System.out.println("Enter number in range 1-2: ");
                int choice = input.nextInt();

                if (choice == 1)
                    login();
                else if (choice == 2)
                    signup();
                else
                    System.out.println("Wrong input. Try again");
            }
    }

    public static void login(){

        System.out.println("Enter username and password : ");
        String username = input.next();
        String password = input.next();

        if(!usernames_passwords.containsKey(username)){

            System.out.println("The user does not exist. Do you want to sign up ? Y/N");
            String choice = input.next();

            if(choice.equals("Y"))
                signup();
            else if(choice.equals("N"))
                return;
            else
                System.out.println("Wrong input. Try again.");
        }

        else if(usernames_passwords.get(username).equals(password))
            userView(username,password);

        else{
            System.out.println("Password is incorrect. Try again");
        }

    }

    public static void signup(){
        input.nextLine();

        System.out.println("Enter the following information: ");

        System.out.print("Full name: ");
        String full_name = input.nextLine();

        System.out.print("Username: ");
        String user_name = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        System.out.print("E-mail: ");
        String email = input.nextLine();

        System.out.println("Enter the following information of your Paypal card: ");

        System.out.println("Address: ");
        String address = input.nextLine();

        System.out.println("Phone number: ");
        String phone_number = input.nextLine();

        System.out.println("CVV: ");
        int cvv = input.nextInt();

        input.nextLine();

        System.out.println("Balance: ");
        double balance = input.nextDouble();

        input.nextLine();

        PaypalCreditCard card = new PaypalCreditCard(full_name,address,phone_number,cvv,balance);

        users.add(new User(full_name,user_name,password,email,card, new Card())) ;
        usernames_passwords.put(user_name,password);

        System.out.println("Registration Successful !");

        for(int i = 0 ; i < 30 ; ++i)
            System.out.print("*");
        System.out.println();
    }

    public static void userView(String username, String password){

        User user = new User();
        for(User usr : users){
            if (usr.getUsername().equals(username) && usr.getPassword().equals(password))
                user = usr;
            break;
        }

        while(true) {

            System.out.printf("Hello %s | User View\n", user.getFull_name());
            System.out.println("Menu:");
            System.out.println("\t\t1: View Profile");
            System.out.println("\t\t2: Make Itinerary");
            System.out.println("\t\t3: List my itineraries");
            System.out.println("\t\t4: Logout");

            int choice = input.nextInt();

            if (choice == 1) {
            }
            else if (choice == 2) {
                makeItinerary(user);
            }

            else if (choice == 3) {
                Itinerary.list();
            }

            else if(choice == 4){
                break;
            }
            else{
                System.out.println("Wrong input. Try again");
            }
        }
    }

    public static <E> void makeItinerary(User user){

        int itinerary_cnt = 0;

        while(true) {

            System.out.println("Menu:");
            System.out.println("\t\t1: Add Flight");
            System.out.println("\t\t2: Add Hotel");
            System.out.println("\t\t3: Done");
            System.out.println("\t\t4: Cancel");

            int choice = input.nextInt();

            if (choice == 1) {
                addFlight();
                ++itinerary_cnt;
            } else if (choice == 2) {
                addHotel();
                ++itinerary_cnt;
            } else if (choice == 3) {

                if (payment(user))
                    System.out.println("Transaction is successful");

                else {
                    System.out.println("Transaction failed");

                    while(itinerary_cnt > 0){
                        int size = Itinerary.bookedItems.size();
                        Itinerary.bookedItems.remove(size-1);
                        --itinerary_cnt;
                    }
                }

                break;
            }

//            else if (choice == 4) {
//
//            }

        }
    }

    public static <E> void addFlight(){

        input.nextLine();

        System.out.print("Enter from (city): ");
        String fromCity = input.nextLine();

        System.out.print("Enter to (city): ");
        String toCity = input.nextLine();

        System.out.print("Enter from (date): ");
        String fromDate = input.nextLine();

        System.out.print("Enter to (date): ");
        String toDate = input.nextLine();

        System.out.print("Enter number of adults and children :");
        int adults = input.nextInt();
        int children = input.nextInt();

        ArrayList<TurkishFlight> flights = TurkishFlightsAPI.getFlights();

        for(TurkishFlight flight : flights){
            System.out.print("Airline: ");
            System.out.println(flight.getAirlineName());
            System.out.print("Departure date : "+flight.getFromDate()+" ");
            System.out.print("Arrival date : "+flight.getToDate()+" ");
            System.out.println("Cost : "+flight.getCost());
        }

        ArrayList<AirCanada> flights2 = AirCanadaAPI.getFlights();

        for(AirCanada flight : flights2){
            System.out.print("Airline: ");
            System.out.println(flight.getAirlineName());
            System.out.print("Departure date : "+flight.getFromDate()+" ");
            System.out.print("Arrival date : "+flight.getToDate()+" ");
            System.out.println("Cost : "+flight.getCost());
        }

        System.out.print("Enter the number of your choice: ");
        int choice = input.nextInt();

        input.nextLine();

        Flight chosenFlight;

        if(choice < flights.size()) {
            chosenFlight = flights.get(choice - 1);
        }
        else{
            chosenFlight = flights2.get(choice-flights.size()-1);
        }

        Flight.bookFlight(chosenFlight, fromCity, toCity, adults, children);
    }

    public static <E> void addHotel(){

        input.nextLine();

        System.out.print("Enter city: ");
        String city = input.nextLine();

        System.out.print("Enter country: ");
        String country = input.nextLine();

        System.out.print("Enter from (date): ");
        String fromDate = input.nextLine();

        System.out.print("Enter to (date): ");
        String toDate = input.nextLine();

        System.out.print("Enter number of adults and children :");
        int adults = input.nextInt();
        int children = input.nextInt();

        ArrayList<HiltonRoom> Hilton = HiltonAPI.getRooms();

        for(HiltonRoom room : Hilton){

            System.out.print("Hotel : "+room.getHotel_name()+" ");
            System.out.print("Room type: "+room.room_type+" ");
            System.out.print("Price per night: "+room.cost+" ");
            System.out.print("From date: "+room.getFromDate()+" ");
            System.out.println("to date: "+room.getToDate());
        }

        ArrayList<MariottRoom> Marriott = MarriottAPI.getRooms();

        for(MariottRoom room : Marriott){
            System.out.print("Hotel : "+room.getHotel_name()+" ");
            System.out.print("Room type: "+room.room_type+" ");
            System.out.print("Price per night: "+room.cost+" ");
            System.out.print("From date: "+room.getFromDate()+" ");
            System.out.println("to date: "+room.getToDate());
        }

        System.out.print("Enter the number of your choice: ");
        int choice = input.nextInt();

        input.nextLine();

        Hotel chosenHotel;

        if(choice < Hilton.size())
             chosenHotel = Hilton.get(choice-1);
        else
            chosenHotel = Marriott.get(choice-Hilton.size()-1);

        HiltonAPI.bookRoom(chosenHotel,city,country,adults,children);
    }

    public static <E> boolean payment(User user){

        System.out.println("Choose payment method from your cards : ");

        int cnt = 0 ;
        if(user.getCard1() != null) {
            ++cnt;
            System.out.printf("%d: %s\n",cnt, user.getCard1().getCard_name());
        }

        if(user.getCard2().phone_number != null) {
            ++cnt;
            System.out.printf("%d: %s\n",cnt, user.getCard2().getCard_name());
        }

        int card_number = input.nextInt();
        input.nextLine();

        boolean status;
        if(cnt == 2){
            if(card_number == 1){
                status = Card.makePayment(user.getCard1(),Itinerary.getTotalCost());
            }
            else{
                status =  Card.makePayment(user.getCard2(),Itinerary.getTotalCost());
            }
        }

        else{
            status = Card.makePayment(user.getCard1(),Itinerary.getTotalCost());
        }

        return status;
    }
}