package busbookingsystem;
import java.util.ArrayList;
import java.util.Scanner;

class Booking {
    String userName;
    int seatsBooked;
    String from;
    String destination;

    Booking(String userName, int seatsBooked, String from,String destination) {
        this.userName = userName;
        this.seatsBooked = seatsBooked;
        this.from=from;
        this.destination=destination;
        
    }

    void displayBooking() {
        System.out.println("Name: " + userName + ", Seats Booked: " + seatsBooked + ",source: " + from + ",destination: " + destination );
    }
}

public class BusBookingSystem {
    static int totalSeats = 30;
    static int availableSeats = 30;
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void viewSeats() {
        System.out.println("Available Seats: " + availableSeats);
    }

    static void bookTicket() {
        System.out.print("Enter your name: ");
        String userName = sc.next();
        System.out.print("Enter number of seats to book: ");
        int seats = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your source:");
         String from=sc.nextLine();
         
         System.out.print("enter your destination:");
          String destination=sc.nextLine();
          

        if (seats <= availableSeats) {
            bookings.add(new Booking(userName, seats,from,destination));
            availableSeats -= seats;
            System.out.println("Booking successful!");
        } else {
            System.out.println("Not enough seats available.");
        }
    }

    static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            System.out.println("All Bookings:");
            for (Booking b : bookings) {
                b.displayBooking();
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Bus Booking System ---");
            System.out.println("1. View Available Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewSeats();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Thank you! Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

}
