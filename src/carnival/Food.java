package carnival;

//import java.util.ArrayList;

/**
 *
 * @author KristofferKeene
 */
public class Food {
    private String name;
    private int ticketCost;
    // moved ArrayList to main driver
    //public static ArrayList<String> foodOptions = new ArrayList<>();
    
    //************************************
    
    public Food(String name, int ticketCost) {
        this.name = name;
        this.ticketCost = ticketCost;
        //foodOptions.add(name);
    } // end constructor
    
    //************************************
    
    public String getName() {
        return this.name;
    }
    
    public int getTicketCost() {
        return this.ticketCost;
    }

//    public ArrayList<String> getFoodOptions() {
//        return foodOptions;
//    }
 
    

}
