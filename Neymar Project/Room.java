import java.util.ArrayList;


public class Room 
{
    protected String name; //im changing this to protected to give it access to puzzleroom
    protected String description;
    
    //private ArrayList<String> questionBank;
    //private ArrayList<String> answerBank;
    //move these to subclass
    
    //private ArrayList<Key> inventory;
    protected boolean keyStatus;
    
    public Room(String x, boolean k)
    {
        this.name = x;
        this.keyStatus = k;
        //this.inventory = new ArrayList<Key>();
        //this.inventory.add(k);
        
    }
    
    //only ever needs to remove, and removes at index 0
    public void removeKey() {
        //inventory.remove(0);
    }
    

    
}
