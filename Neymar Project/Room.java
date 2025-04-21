import java.util.ArrayList;


public class Room 
{
    private String name;
    private String description;
    //private boolean keyStatus;
    //protected String name; //im changing this to protected to give it access to puzzleroom
    //protected String description;
    
    //private ArrayList<String> questionBank;
    //private ArrayList<String> answerBank;
    //move these to subclass
    
    //private ArrayList<Key> inventory;
    protected boolean keyStatus;
    
    public Room(String x, boolean k)
    {
        this.name = x;
        this.keyStatus = k;
    }
    
    public void removeKey() {
        keyStatus = false;
    }
}
