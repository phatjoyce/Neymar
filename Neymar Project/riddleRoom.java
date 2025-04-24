import java.util.Arrays;
import java.util.ArrayList;
import javafx.scene.control.TextField;


public class riddleRoom extends Room{
    private int level;
    private String checkAnswer;
    private ArrayList<String> wordList;
    
    public riddleRoom(String x, boolean k, int difficultyLevel){
        super(x,k);
     
        this.level= difficultyLevel;
        this.wordList= new ArrayList<>();
        this.wordList.add("mirror");
        
        
    }
    public ArrayList<String> getCorrectAnswers(){
        
        return this.wordList;
    }
 
    public boolean checkAnswers(TextField Answer, ArrayList wordList){
        boolean allCorrect= true;
       
        String userAnswer= Answer.getText().toLowerCase();
            boolean foundAnswer= false;
            if (userAnswer.equals(wordList)){
                foundAnswer = true;
        
            }
        
            if (!foundAnswer){
                allCorrect = false;
            }
            return allCorrect;
        } 
        
        }


