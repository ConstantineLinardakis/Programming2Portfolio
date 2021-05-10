/**
*    Big Java Chapter 6 Project > 6.13
*    Application that sells tickets and checks to see if their are available tickets or passes.
*    @author ConstantineLinardakis
*    @since 2020-11-4
*/

import java.util.Scanner;

public class TicketBooth {

     /**
     * Define the number of tickets available.
     */

    public static final int TICKET_COUNT = 100;

    /**
     * Define the maximum number of tickets per user.
     */

    public static final int TICKET_MAX_PER_USER = 4;

     /**
     * Main method, called on start.
     * @param args Start arguments.
     */

    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner in = new Scanner(System.in);

        // Define a variable to store the total number of tickets and buyers
        int tickets = TICKET_COUNT;
        int buyers = 0;

        // Print a status message
        System.out.println(tickets + " tickets will be sold.");

        // Start a loop to sell the tickets
        while(tickets > 0) {
            // Ask the user for the tickets he wants to buy
            System.out.println("How many tickets would you like to buy?");

            // Gather the user input
            int count = in.nextInt();

            // Make sure the number is valid
            if(count < 0 || count > TICKET_MAX_PER_USER) {
                System.out.println("You can only buy up to " + TICKET_MAX_PER_USER + " tickets.");
                continue;
            }

            // Show a message if the user doesn't want to buy a ticket
            if(count == 0) {
                System.out.println("You don't want to buy any tickets, bye!\n");
                continue;
            }

            // Make sure enough tickets are available
            if(tickets < count) {
                System.out.println("There are only " + tickets + " ticket(s) left.");
                continue;
            }

            // 'Buy' the tickets and show a status message
            tickets -= count;
            buyers++;
            System.out.println("You've bought " + count + " ticket(s)!\n");
        }

        // Show a status message
        System.out.println("All tickets have been sold, to " + buyers + " buyers.");
    }
}
