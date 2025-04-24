import java.util.Arrays;
import java.util.ArrayList;
import javafx.scene.control.TextField;

/**
 * Write a description of class puzzleRoom here.
 * 
 * @author 
 * @version
 */
public class puzzleRoom extends Room{
    private int level;
    private String checkAnswer;
    private ArrayList<String> wordList;
    
    public puzzleRoom(String x, boolean k, int difficultyLevel){
        super(x,k);
        //this.name= x;
        //this.keyStatus= k;
        this.level= difficultyLevel;
        this.wordList= new ArrayList<>();
        this.wordList.add("belt");
        this.wordList.add("bear");
        this.wordList.add("shoe");
        this.wordList.add("hand");
        this.wordList.add("ball");
        this.wordList.add("mice");
        this.wordList.add("toys");
        this.wordList.add("bat");
        this.wordList.add("dog");
        this.wordList.add("hat");
        this.wordList.add("cow");
        this.wordList.add("zap");
        this.wordList.add("gal");
        this.wordList.add("boy");
        this.wordList.add("cat");
        this.wordList.add("oak");
        
    }
    public ArrayList<String> getCorrectAnswers(){
        
        return this.wordList;
    }
 
    public boolean checkAnswers(TextField[] fields, ArrayList wordList){
        boolean allCorrect= true;
        for (int i= 0; i< fields.length; i++){
            String userAnswer= fields[i].getText().toLowerCase();
            boolean foundAnswer= false;
        for (int y= 0; y< wordList.size(); y++){
            if (userAnswer.equals(wordList.get(y))){
                foundAnswer = true;
                break;
            }
        }
            if (!foundAnswer){
                allCorrect = false;
            }
        } 
        return allCorrect;
        }
}


    