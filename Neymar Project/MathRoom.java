
public class MathRoom extends Room{
    int difficultyLevel;
    int questionIndex = (int)(Math.random() * 3);
    
    String[] easyQuestions = {
    "What is 2 + 3?",       
    "What is 7 - 4?",       
    "What is 5 + 6?"       
    };

    String[] mediumQuestions = {
    "What is 8 * 3?",      
    "What is 24 / 6?",      
    "What is 15 + 9?"       
    };

    String[] hardQuestions = {
    "What is (8 + 6) * 2?", 
    "What is 49 / (9 - 2)?",
    "What is 12 * 4 - 6?"  
    };

    // Corresponding answer sets
    int[] easyAnswers = {5, 3, 11};
    int[] mediumAnswers = {24, 4, 24};
    int[] hardAnswers = {28, 7, 42};
    
    // Combined into a 2D array
    String[][] questions = {
        easyQuestions,
        mediumQuestions,
        hardQuestions
    };
    
    int[][] answers = {
        easyAnswers,
        mediumAnswers,
        hardAnswers
    };
    
    public MathRoom(String x, boolean y, int d){
        super(x,y);
        this.difficultyLevel = d;
    }
    public String displayQuestion(){
        return questions[difficultyLevel][questionIndex];
    }
    public boolean checkAnswer(int ans){
        if(ans == answers[difficultyLevel][questionIndex]){
            return true;
        }
        else{
            return false;
        }
    }
    
}
