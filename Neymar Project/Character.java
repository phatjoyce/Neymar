import java.util.ArrayList;


public class Character
{
    private String name;
    private int health;
    //private Room location;
    private ArrayList<String> inventory;

    public Character(String x){
        this.name = x;
        this.health = 3;
        //this.location = startingRoom;
        this.inventory = new ArrayList<String>();
    }

    
    public void changeHealth(int x){
        health = health + x;
    }
    /*
    public void setLocation(Room z){
        location = z;
    }
    */
    
    public int getHealth(){
        return health;
    }
    public String getName(){
        return name;
    }
    /*
    public Room getLocation(){
        return location;
    }
    */
    
}
