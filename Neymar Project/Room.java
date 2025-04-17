import java.util.ArrayList;


public class Room
{
    private String name;
    private String description;
    
    //private ArrayList<String> questionBank;
    //private ArrayList<String> answerBank;
    //move these to subclass
    
    private ArrayList<Key> inventory;
    
    public Room(String x, Key k)
    {
        this.name = x;
        this.inventory = new ArrayList<Key>();
        this.inventory.add(k);
        
    }
    
    //only ever needs to remove, and removes at index 0
    public void removeKey() {
        inventory.remove(0);
    }
    

    
}
