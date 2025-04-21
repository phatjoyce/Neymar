import java.util.ArrayList;


public class Room
{
    private String name;
    private String description;
    private boolean keyStatus;
    
    public Room(String x, boolean k)
    {
        this.name = x;
        this.keyStatus = k;
    }
    
    public void removeKey() {
        keyStatus = false;
    }
}
