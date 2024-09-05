import java.util.*;

public class Main {

    static Scanner input = new Scanner(System.in);
    static Map<String, String> usernames_passwords = new HashMap<>();
    static Set<User> users = new HashSet<>();

    public static void main(String[] args) {

        usernames_passwords.put("shahd","123");

        while(true) {
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

        System.out.print("Debit Card number: ");
        String debit_number = input.nextLine();

        System.out.print("Credit Card number: ");
        String credit_number = input.nextLine();

        users.add(new User(full_name,user_name,password,email,debit_number,credit_number)) ;
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
        }

        System.out.printf("Hello %s | User View\n", user.getFull_name());
        System.out.println("Menu:");
        System.out.println("\t\t1: View Profile");
        System.out.println("\t\t2: Make Itinerary");
        System.out.println("\t\t3: List my itineraries");
        System.out.println("\t\t4: Logout");

        int choice = input.nextInt();

        if(choice == 1){

        }

        else if(choice == 2)
            makeItinerary(user);

        else if(choice == 3){
            Itinerary itinerary = new Itinerary<>();
            itinerary.list();
        }
    }

    public static <E> void makeItinerary(User user){

        while(true) {
            System.out.println("Menu:");
            System.out.println("\t\t1: Add Flight");
            System.out.println("\t\t2: Add Hotel");
            System.out.println("\t\t3: Done");
            System.out.println("\t\t4: Cancel");

            int choice = input.nextInt();

            if (choice == 1)
                addFlight(user.getFull_name());
//        else if(choice == 2)
//            addHotel();
            else if (choice == 3) {
                System.out.println("Enter payment choice: ");
                System.out.printf("1: Debit Card - Owner : %s Card Number : %s\n", user.getFull_name(), user.getDebit());
                System.out.printf("2: Credit Card - Owner : %s Card Number : %s\n", user.getFull_name(), user.getCredit());

                int n = input.nextInt();

                System.out.println("Money withdrawn successfully");
                System.out.println("Reservation Confirmed");
                System.out.println("Itinerary Reserved");

                break;

            }
//        else if(choice == 4){
//
//        }
//        else{
//            System.out.println("Wrong input. Please try again");
//        }
        }
    }

    public static <E> void addFlight(String fullName){

        String user_fullName = fullName;

        input.nextLine();

        System.out.print("Enter from (city): ");
        String fromCity = input.nextLine();

        System.out.print("Enter to (city): ");
        String toCity = input.nextLine();

        System.out.print("Enter from (date): ");
        String fromDate = input.nextLine();

        System.out.print("Enter to (date): ");
        String toDate = input.nextLine();

        System.out.print("Enter number of adults, children and infants :");
        int adults = input.nextInt();
        int children = input.nextInt();
        int infants = input.nextInt();

        ArrayList<TurkishFlight> flights = TurkishFlightsAPI.getFlights();

        for(TurkishFlight flight : flights){
            System.out.print("Airline: ");
            System.out.println(flight.getName());
            System.out.print("Departure date : "+flight.getFromDate()+" ");
            System.out.print("Arrival date : "+flight.getToDate()+" ");
            System.out.println("Cost : "+flight.getCost());
        }

        System.out.print("Enter the number of your choice: ");
        int choice = input.nextInt();

        input.nextLine();

        Flight chosenFlight = flights.get(choice-1);

        Itinerary<Flight> targetFlight = new Itinerary<Flight>(chosenFlight, adults, children, infants, fromCity, toCity);

        Flight.reserve(targetFlight, chosenFlight.getName());
    }
}