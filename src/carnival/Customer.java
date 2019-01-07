package carnival;
import java.util.ArrayList;

/**
 *
 * @author KristofferKeene
 */
public class Customer {
    private String name;
    private int ticketsAvailable;
    private int freeHands = 2;
    private ArrayList<String> prizeList;            // prizes customer won and taking home
    private ArrayList<String> foodInHands;    // food customer purchased but hasn't eaten yet
    
    //*****************************
    
    public Customer(String name) {
        this.name = name;
        this.ticketsAvailable = 20;
        this.freeHands = 2;
        this.prizeList = new ArrayList<>();
        this.foodInHands = new ArrayList<>();
    } // end constructor
    
    //*****************************
    
    public String getName() { 
        return name;
    }
    
    public int getTickets() {
        return ticketsAvailable;
    }

    public void setTickets(int tickets) {
        this.ticketsAvailable = tickets;
    }
    
    public void addPrize(String prize) {
        this.prizeList.add(prize);
    }

    public void getFreeHands() {
        this.freeHands = freeHands;
    }
    
    public ArrayList getFoodInHands() {
        return foodInHands;
    }
    
    public void addFoodInHands(String food) {
        this.foodInHands.add(food);
    }
    
    //************************************
    
    public void listPrizes() {
        
        if (prizeList.size() > 0) {
            System.out.println("You won these prizes: ");
            for (String prize : prizeList) {
                System.out.println(" - " + prize);
            } // end for each loop
        }
        else {
            //System.out.println("No prizes to take home, but hope you still had fun!");
        }
    }
    
    public boolean hasEnoughTickets(Game game) {
        if (this.getTickets() >= game.getTicketCost()) {
            this.setTickets(this.getTickets() - game.getTicketCost());
            return true;
        } else {
            //System.out.println("Sorry, You don't have enough tickets.");
            return false;
        }
    }
    
    public boolean hasEnoughTickets(Ride ride) {
        if (this.getTickets() >= ride.getTicketCost()) {
            this.setTickets(this.getTickets() - ride.getTicketCost());
            return true;
        } else {
            //System.out.println("Sorry, You don't have enough tickets.");
            return false;
        }
    }

    public boolean hasEnoughTickets(Food food) {

        if (this.getTickets() >= food.getTicketCost()) {
            this.setTickets(this.getTickets() - food.getTicketCost());
            this.freeHands--;
            this.addFoodInHands(food.getName());
            return true;
        } else {
            //System.out.println("Sorry, You don't have enough tickets.");
            return false;
        }
    }  
    
    public boolean hasFreeHands() {
        if(freeHands > 0) {
            return true;
        }
        else {
            //System.out.println("You don't have enough hands!");
            return false;
        }
    }
    
    public void addTickets(int tickets) {
        this.ticketsAvailable += tickets;
    }
    
    public void setFreeHands(int item) {
        this.freeHands += item;
    }
    
    public void consumeFood(int choice) {
        System.out.println("Yummm! That " + foodInHands.get(choice-1).toLowerCase() + " was good!");
        foodInHands.remove(choice-1);
        freeHands++;
        
    }
    
} // end class
