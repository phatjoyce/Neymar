
/**
 * Write a description of class puzzleRoom here.
 * 
 * @author 
 * @version
 */
public class puzzleRoom extends Room{
    private int level;
    
    public puzzleRoom(String x, boolean k, int difficultyLevel){
        super(x,k);
        this.name = x;
        
        this.keyStatus = k;
        this.level= difficultyLevel;
    }

}
    