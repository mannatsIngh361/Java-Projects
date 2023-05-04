import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int numberOfSeatsAvailable = 50; // Initial number of seats available
            int numberOfSeatsBooked = 0; // Initial number of seats booked
            
            while(true) {
                System.out.println("Welcome to the Train Ticket Booking System");
                System.out.println("1. Book a ticket");
                System.out.println("2. Cancel a ticket");
                System.out.println("3. View available seats");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                
                int choice = input.nextInt();
                
                switch(choice) {
                    case 1:
                        if(numberOfSeatsAvailable == 0) {
                            System.out.println("Sorry, there are no seats available.");
                        } else {
                            numberOfSeatsAvailable--;
                            numberOfSeatsBooked++;
                            System.out.println("Ticket booked successfully!");
                        }
                        break;
                    case 2:
                        if(numberOfSeatsBooked == 0) {
                            System.out.println("Sorry, no tickets have been booked yet.");
                        } else {
                            numberOfSeatsAvailable++;
                            numberOfSeatsBooked--;
                            System.out.println("Ticket cancelled successfully!");
                        }
                        break;
                    case 3:
                        System.out.println("Number of seats available: " + numberOfSeatsAvailable);
                        System.out.println("Number of seats booked: " + numberOfSeatsBooked);
                        break;
                    case 4:
                        System.out.println("Thank you for using the Train Ticket Booking System!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                        
                }
                
            }
        }
        
    }
}

