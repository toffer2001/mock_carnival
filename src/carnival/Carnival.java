/****************************************
 * Carnival.java
 * Kristoffer Keene
 * 
 * This project simulates a carnival.
 ****************************************/
package carnival;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KristofferKeene
 */
public class Carnival {

    /**
     * @param args the command line arguments
     */
    
    static Scanner scanner = new Scanner(System.in);
    
    // declare games
    static Game waterShooter;
    static Game balloonDartToss;
    static Game ringToss;
    
    // declare customer
    static Customer customer;
    
    // declare rides
    static Ride ferrisWheel;
    static Ride carousel;
    
    // declare food
    static Food soda;
    static Food hotDog;
    static Food popcorn;
    static Food cottonCandy;
    
    public static ArrayList<String> foodOptions = new ArrayList<>();
    
    public static void main(String[] args) {
        
        System.out.println("Final Project by Kristoffer Keene\n\n" +
                "\033[35mWelcome \033[31mto \033[32mthe \033[34mCarnival!\033[0m");
        System.out.println("\033[36m------------------------\033[0m");
        
        // Let the games, rides, and food begin
        initializeGames();
        initializeRides();
        initializeFoods();
        
        // prompt customer name
        System.out.print("\033[4mWhat is your name? ");
        String newCustomer = scanner.nextLine();
        customer = new Customer(newCustomer);
        
        // List menu options to do at the carnival
        int choice = 0;
        do {
            choice = listOptions();
            customerSelection(choice);
        } while (choice != 9);
        
    } // end main
    
    
    public static void initializeGames() {
        
        String[] waterShooterPrizes = {"Stuffed Bear", "Plastic Bear", "Bear Key Chain", "No Prize"};
        waterShooter = new Game("Water Shooter", 4);
        waterShooter.setPrizeList(waterShooterPrizes);
        
        String[] balloonDartTossPrizes = {"Stuffed Tiger", "Plastic Tiger", "Tiger Key Chain", "No Prize"};
        balloonDartToss = new Game("Balloon Dart Toss", 4);
        balloonDartToss.setPrizeList(balloonDartTossPrizes);
        
        String[] ringTossPrizes = {"Stuffed Pig", "Plastic Pig", "Pig Key Chain", "No Prize"};
        ringToss = new Game("Ring Toss", 4);
        ringToss.setPrizeList(ringTossPrizes);
    } // end intitalizeGames
    
    public static void initializeRides() {
        ferrisWheel = new Ride("Ferris Wheel", 6);
        carousel = new Ride ("Carousel", 6);
    } // end initializeRides
    
    public static void initializeFoods() {
        soda = new Food("Soda", 3);
        hotDog = new Food("Hot Dog", 5);
        popcorn = new Food("Popcorn", 5);
        cottonCandy = new Food("Cotton Candy", 5);
        foodOptions.add(soda.getName());
        foodOptions.add(hotDog.getName());
        foodOptions.add(popcorn.getName());
        foodOptions.add(cottonCandy.getName());
    } // end intiailizeFoods
    
    public static int listOptions() {
        
        System.out.println("\nYou have " + customer.getTickets() + " tickets");
        
        String LIST_FMT = "%-30s%-30s\n";

        System.out.printf(LIST_FMT, "1. Water Shooter", "5. Feeris Wheel");
        System.out.printf(LIST_FMT, "2. Balloon Dart Toss", "6. Carousel");
        System.out.printf(LIST_FMT, "3. Ring Toss", "7. Get Food");
        System.out.printf(LIST_FMT, "4. Add Tickets", "8. Eat Food");
        System.out.printf(LIST_FMT, "9. Exit Carnival", "\n");
        
        System.out.print("What do you want to do? ");
        return scanner.nextInt();
    } // end listOptions
    
    public static void customerSelection(int choice) {
        switch (choice) {
            case 1:
                if (customer.hasEnoughTickets(waterShooter)) {
                    waterShooter.playGame(customer);
                }
                else {
                    printNotEnoughTickets();
                }
                break;
                
            case 2:

                if (customer.hasEnoughTickets(balloonDartToss)) {
                    balloonDartToss.playGame(customer);
                }
                else {
                    printNotEnoughTickets();
                }
                
                break;
                
            case 3:
                if (customer.hasEnoughTickets(ringToss)) {
                    ringToss.playGame(customer);
                }
                else {
                    printNotEnoughTickets();
                }
                break;
                
            case 4:
                System.out.print("How many tickets would you like to add? ");
                int ticketsToAdd = scanner.nextInt();               
                customer.addTickets(ticketsToAdd);
                break;
                
            case 5:
                if (customer.hasEnoughTickets(ferrisWheel)) {
                    //ferrisWheel.rideRide(); // removed method as instructions required Ride object to not print
                    System.out.println("Enjoy the " + ferrisWheel.getname() + " ride");
                }
                else {
                    printNotEnoughTickets();
                }
                break;
                
            case 6:
                if (customer.hasEnoughTickets(carousel)) {
                    //carousel.rideRide(); // removed method as instructions required Ride object to not print
                    System.out.println("Enjoy the " + carousel.getname() + " ride");
                }
                else {
                    printNotEnoughTickets();
                }
                break;
                
            case 7:
                    int foodChoice = listFoodOptions(customer);
                    customerSelectionFood(foodChoice);
                break;
                
            case 8:
                if (customer.getFoodInHands().size() > 0) {
                    int consumeFoodChoice = listFoodInHand(customer);
                    if (consumeFoodChoice > 0) {
                        customer.consumeFood(consumeFoodChoice);
                    } else {
                        System.out.println("Not a valid choice");
                    }
                } else {
                    System.out.println("You don't have any food to eat, and need to purchase something.");

                }
                break;
                
            case 9:
                System.out.println("\nAll Done! Hope you had a great time, " + customer.getName());
                customer.listPrizes();
                break;
            default:
                System.out.println("Please enter a valid option");
                break;
        } // end switch
                
    } // end customerSelection
    
    public static int listFoodOptions(Customer customer) {
        System.out.println("Food Choices");

        // created for loop to list "odds" then "evens" like example
        String LIST_FMT = "%-15s%-15s\n";

        for (int i = 0; i < foodOptions.size() - 2; i += 2) {
            System.out.printf(LIST_FMT, i + 1 + ". " + foodOptions.get(i), i + 3 + ". " + foodOptions.get(i + 2));
            for (int j = 1; j < foodOptions.size() - 2; j += 2) {
                System.out.printf(LIST_FMT, j + 1 + ". " + foodOptions.get(j), j + 3 + ". " + foodOptions.get(j + 2));
            } // end inner for
        } // end out for
        
        // alternative for each loop if just want to list all food options in a straight list        
//        int i=1;
//        for (String option : Food.foodOptions) {
//            System.out.println(i+ ". " + option);
//            i++;
//        }

        System.out.print("Which one do you want? ");
        return scanner.nextInt();

    } // end listFoodOptions
    
    public static void customerSelectionFood(int choice) {
        
        switch (choice) {
            case 1:
                if (customer.hasFreeHands()) {
                    if (customer.hasEnoughTickets(soda)) {
                        System.out.println("Enjoy your " + soda.getName().toLowerCase());
                    } else {
                        printNotEnoughTickets();
                    }
                } else {
                    printNotEnoughFreeHands();
                }
                break;
            case 2:
                if (customer.hasFreeHands()) {
                    if (customer.hasEnoughTickets(hotDog)) {
                        System.out.println("Enjoy your " + hotDog.getName().toLowerCase());
                    }
                    else {
                        printNotEnoughTickets();
                    }
                } else {
                    printNotEnoughFreeHands();
                }
                break;
            case 3:
                if (customer.hasFreeHands()) {
                    if (customer.hasEnoughTickets(popcorn)) {
                        System.out.println("Enjoy your " + popcorn.getName().toLowerCase());
                    } else {
                        printNotEnoughTickets();
                    }
                } else {
                    printNotEnoughFreeHands();
                }
                break;
            case 4:
                if (customer.hasFreeHands()) {
                    if (customer.hasEnoughTickets(cottonCandy)) {
                        System.out.println("Enjoy your " + cottonCandy.getName().toLowerCase());
                    } else {
                        printNotEnoughTickets();
                    }
                } else {
                    printNotEnoughFreeHands();
                }
                break;
            default:
                System.out.println("Not a valid option");
                break;
        }
    }
    
    public static int listFoodInHand(Customer customer) {
        int count = 1;
        for (Object food : customer.getFoodInHands()) {
            System.out.print(count + ". " + food + "\t\t");
            count++;
        } //  end for
        
        int choice = 0;
        System.out.print("\nWhich do you want to consume? ");
        choice = scanner.nextInt();
        
        if (choice > customer.getFoodInHands().size()) {
            return -1;
        } else {
            return choice;
        }

    } // end listFoodInHand
    
    // created these additional methods in driver class per instructions to have customer class to only print directly to screen
    // for eat food method and to display food name, otherwise I had less redundant code when I had some additional printing
    // in the customer class which is commented out.
    
    public static void printNotEnoughTickets() {
        System.out.println("Sorry, You don't have enough tickets.");
    }
    
    public static void printNotEnoughFreeHands() {
        System.out.println("You don't have enough hands!");
    }
    
} // end Carnival class
