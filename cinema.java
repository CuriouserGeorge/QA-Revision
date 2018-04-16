//You are required to create a simple prototype cinema system 
//that provide the ability to purchase tickets and return the total 
//price of a customer’s order.

import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

abstract class Ticket{

    abstract int get_price();
    abstract String get_name();
    abstract void set_count(int value);
    abstract int get_count();
}

class StandardTicket extends Ticket{

    private int price = 8;
    private String name = "Standard";
    private int count = 0;
    protected int wednesdayDiscount = 2;

    protected Calendar c = Calendar.getInstance();
    protected Date now = new Date();

    protected int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
    public String get_name(){
        return this.name;
    }
    public int get_price(){
        c.setTime(now);
        int wednesday  = 4;
        if(dayOfWeek == wednesday ){
            return (this.price - wednesdayDiscount);
        }
        return this.price;
    }
    public void set_count(int value){
        this.count = value;
    }
    public int get_count(){
        return this.count;
    }
}
class StudentTicket extends StandardTicket{

    private int price = 6;
    private String name = "Student";
    private int count = 0;

        public String get_name(){
        return this.name;
    }
    public int get_price(){
        c.setTime(now);
        int wednesday  = 4;
        if(dayOfWeek == wednesday ){
            return (this.price - wednesdayDiscount);
        }
        return this.price;
    }
    public void set_count(int value){
        this.count = value;
    }
    public int get_count(){
        return this.count;
    }
}
class OAPTicket extends StandardTicket{

    private int price = 6;
    private String name = "OAP";
    private int count = 0;

    public String get_name(){
        return this.name;
    }
    public int get_price(){
        c.setTime(now);
        int wednesday  = 4;
        if(dayOfWeek == wednesday ){
            return (this.price - wednesdayDiscount);
        }
        return this.price;
    }
    public void set_count(int value){
        this.count = value;
    }
    public int get_count(){
        return this.count;
    }
}

class ChildTicket extends StandardTicket{

    private int price = 4;
    private String name = "Child";
    private int count = 0;

    public String get_name(){
        return this.name;
    }
    public int get_price(){
        c.setTime(now);
        int wednesday  = 4;
        if(dayOfWeek == wednesday ){
            return (this.price - wednesdayDiscount);
        }
        return this.price;
    }
    public void set_count(int value){
        this.count = value;
    }
    public int get_count(){
        return this.count;
    }
}

public class cinema{
    public static void main(String args[]){
        ChildTicket childTicket = new ChildTicket();
        StandardTicket standardTicket = new StandardTicket();
        StudentTicket studentTicket = new StudentTicket();
        OAPTicket oapTicket = new OAPTicket();
        int totalPrice = 0;

        Ticket[] ticketSelection = new Ticket[4];
        ticketSelection[0] = standardTicket;
        ticketSelection[1] = childTicket;
        ticketSelection[2] = studentTicket;
        ticketSelection[3] = oapTicket;
        for(int i = 0; i < ticketSelection.length; i++){
            System.out.println("The price of a " + ticketSelection[i].get_name() + " ticket is : " + ticketSelection[i].get_price());
        }

        Scanner reader = new Scanner(System.in);
        int numberOfTickets;
        for(int i = 0; i < ticketSelection.length; i++){

            do{
            System.out.println("How many " + ticketSelection[i].get_name() + " tickets  would you like?");
                while(!reader.hasNextInt()){
                    System.out.println("Please enter a number");
                    reader.next();
                }
                numberOfTickets = reader.nextInt();
            }while(numberOfTickets <= 0);
            ticketSelection[i].set_count(numberOfTickets);

        }
        
        for(int i = 0; i < ticketSelection.length; i++){
            totalPrice += (ticketSelection[i].get_count() * ticketSelection[i].get_price());
        }
        for(int i = 0; i < ticketSelection.length; i++){
            System.out.println("You have ordered " + ticketSelection[i].get_count() + " " + ticketSelection[i].get_name() + " tickets.");
        }        

        System.out.println("The total price is £" + totalPrice +".00");


    }
}
