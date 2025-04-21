import java.util.ArrayList;


public class Player
{
    private String name;
    private int health;
    //private Room location;
    private int inventory;

    public Player(String x){
        this.name = x;
        this.health = 3;
        //this.inventory = new ArrayList<Key>();
        //this.location = startingRoom;
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
    public Room setLocation(Room r){
        location = r;
    }
    */
    
}
