package carnival;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author KristofferKeene
 */
public class Game {
    
    private String name;
    private int ticketCost;
    private String[] prizeList; // List of prizes if customer wins game
 
    //************************************
    
    public Game(String name, int ticketCost) {
        this.name = name;
        this.ticketCost = ticketCost;
        this.prizeList = new String[4];
    } // end constructor
    
    //*****************************
    
    public String getName() {
        return this.name.toLowerCase();
    }
    
    public int getTicketCost() {
        return this.ticketCost;
    }
    
    public String getPrize(int position) {
        return this.prizeList[position];
    }
    
    public String[] getPrizeList() {
        return this.prizeList;
    }
    
    public void setPrizeList(String[] prizeList) {
        this.prizeList = prizeList;
    }

    //************************************    
    
    public void playGame(Customer customer) {
        Random random = new Random();
        int prizeNumber = (int) (Math.random() * 4) + 1; // could remove "+1" and have the random be 0 to 3, but per instructions kepts 1 to 4
        
        //System.out.println("Prize number: " + (prizeNumber));
        //System.out.println("prize is: " + this.getPrize(prizeNumber-1));
        //System.out.println("Prize list: " + Arrays.toString(this.getPrizeList()));
        System.out.println("Playing " + this.getName() + ", and the result is: " + this.getPrize(prizeNumber-1));
        if (prizeNumber < 4) {
            customer.addPrize(this.getPrize(prizeNumber-1));
        }
        
    } // end playGame
    
} // end class
