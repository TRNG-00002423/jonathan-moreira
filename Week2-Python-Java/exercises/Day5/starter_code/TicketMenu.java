import java.util.Scanner;

/**
 * Week 2 Exercise — menu-driven console (implement the menu loop).
 *
 * Compile: javac TicketMenu.java
 * Run:     java TicketMenu
 */
public class TicketMenu {

    public static void main(String[] args) {
        String[] tickets = {"BUG-101 Login timeout", "BUG-102 CSV import", "BUG-103 flaky assertion"};
        int[] priorities = {2, 2, 2}; // stretch: update in menu option 2

        try (Scanner in = new Scanner(System.in)){
            boolean quit = false;
            
            System.out.println("================================");
            System.out.println("Welcome to the TicketMenu");

            while(!quit){ 
                System.out.println("================================");
                System.out.println("1:  List Tickets");
                System.out.println("2:  Set Priority");
                System.out.println("3:  Summary");
                System.out.println("4:  Quit");

                System.out.println("\nPlease select an item:");
            
                int optionSelected = 0;

                if(in.hasNextInt()){
                    optionSelected = in.nextInt();
                }
                else{
                    String invalidInput = in.nextLine();
                    System.out.println("ERROR: " + invalidInput + " is not a valid input!");
                }
  
                switch(optionSelected){
                    case 1:
                        System.out.println("===========");
                        System.out.println("Tickets");
                        System.out.println("===========");
                        for(String ticket : tickets){
                            System.out.println(ticket);
                        }
                        break;
                    case 2:
                        System.out.println("===========");
                        System.out.println("Tickets");
                        System.out.println("===========");
                        for(int i = 0; i < tickets.length; i++){
                            System.out.println(i + " " + tickets[i]);
                        }
                        System.out.println("Please select the ticket index + priority");
                        
                        int index = 0;
                        int priority = 0;
                        do { 

                            if(in.hasNextInt()){
                                index = in.nextInt();
                                priority = in.nextInt();
                            }
                            else{
                                String invalidInput = in.nextLine();
                                System.out.println("ERROR: " + invalidInput + " is not a valid input!");
                                continue;
                            }
                            

                            if(index < 0 || index >= tickets.length){
                                System.out.println("Please enter a valid index");
                            }
                            else if (priority < 1 || priority > 3){
                                System.out.println("Please enter a valid priority");
                            }
                        } while ((index < 0 || index >= tickets.length) || (priority < 1 || priority > 3));
                        
                        priorities[index] = priority;
                        System.out.println("Ticket: " + tickets[index] + " | Priority: " + priorities[index]);
                        break;
                    case 3:
                        System.out.println("===========");
                        System.out.println("Summary");
                        System.out.println("===========");
                        System.out.println(tickets.length + " ticket" + ((tickets.length == 1) ? "" : "s"));
                        break;
                    case 4:
                        System.out.println("See you later!");
                        quit = !quit;
                        break;
                    default:
                        System.out.println("Please Enter a Valid input");
                }
                
            }
            
        }
    }
}