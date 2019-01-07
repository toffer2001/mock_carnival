package carnival;

/**
 *
 * @author KristofferKeene
 */
public class Ride {
    
    private String name;
    private int ticketCost;
    
    //************************************
    
    public Ride (String name, int ticketCost) {
        this.name = name;
        this.ticketCost = ticketCost;
    } // end constructor
    
    //************************************
    
    public String getname() {
        return this.name;
    }
    
    public int getTicketCost() {
        return this.ticketCost;
    }
    
    //************************************

    // removed method as instructions required Ride object to not print
    
//    public void rideRide() {
//        System.out.println("Enjoy the " + this.getname() + " ride");
//    }
    
} // end class
