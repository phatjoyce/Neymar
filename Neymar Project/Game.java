import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView; 
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import java.util.ArrayList;
import javafx.scene.paint.Color;


public class Game extends Application {
    private Stage primaryStage;
    private int tabWidth = 800;
    private int tabHeight = 450;

    private String characterSaved;
    private int difficultyLevel;
    private riddleRoom currentRiddleRoom;
    
    private int mathCount = 0;
    private boolean mathCompleted = false;
    private boolean puzzleCompleted = false;
    private boolean riddleCompleted = false;

    @Override
    //starting code that the launch() starts
    //gets the first screen in
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
        primaryStage.setTitle("Insert Game Name");
        
        primaryStage.setScene(playerSelectScreen());
        
        
        primaryStage.show();
        
        
        
        
    }

    
    //Player Select Screen
    private Scene playerSelectScreen() {
        
        
        
        //texts
        Text welcomeText = new Text("Choose your character");
        
       
        
        
        //creates 3 buttons
        Button playerDinoButton = new Button("Start Game");
        Button playerBalletButton = new Button("Start Game");
        Button playerNeymarButton = new Button("Start Game");
        
        playerDinoButton.setPadding(new Insets(30,20,10,10));
        playerBalletButton.setPadding(new Insets(30,20,10,10));
        playerNeymarButton.setPadding(new Insets(30,20,10,10));
        
    

        

        //set all buttons to lead to "chooseMessiRonaldo" screen
        playerDinoButton.setOnAction(e -> playerSelectAction("Dino",0));
        playerBalletButton.setOnAction(e -> playerSelectAction("Ballet",1));
        playerNeymarButton.setOnAction(e -> playerSelectAction("Neymar",2));
        
        
    
        //bottom panel
        //add the changing sizes and padding here**
        
        BackgroundImage myImage= new BackgroundImage(new Image("first.png",800, 450,false, true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
        
        HBox bottomPane = new HBox(80, playerDinoButton, playerBalletButton, playerNeymarButton );

        //whole
        VBox root = new VBox(bottomPane);
        //root.setSpacing(10);
        //root.setStyle("-fx-padding: 10;");
        
        

        BorderPane myNewPane = new BorderPane();
        
        //root.setBackground(new Background(myImage));
        
        
        bottomPane.setAlignment(Pos.BOTTOM_CENTER);

        myNewPane.setBackground(new Background(myImage));
        myNewPane.setCenter(bottomPane);


        
        return new Scene(myNewPane, 800, 450);

    }
    //Player Select Screen methods
    private void playerSelectAction(String name, int difficulty){
        //create new player, sets difficulty, and changes room
        Player p1 = new Player(name);
        difficultyLevel = difficulty;
        primaryStage.setScene(chooseMessiRonaldoScreen());
    }
    
    
    
    // Choosing Messi/Ronaldo Screen //coding direction done //coding aethetics needed
    private Scene chooseMessiRonaldoScreen() {
        
 
       
        
        //texts
        Text welcomeText = new Text("Choose who you save");
        Text char1 = new Text("Messi");
        Text char2 = new Text("Ronaldo");
        
        
        
        
        //creates 3 buttons
        Button saveMessi = new Button("Messi");
        Button saveRonaldo = new Button("Ronaldo");
        saveMessi.setPadding(new Insets(30,20,10,10));
        saveRonaldo.setPadding(new Insets(30,20,10,10));

        //set all buttons to lead to "chooseMessiRonaldo" screen
        saveMessi.setOnAction(e -> characterSaveAction("Messi"));
        saveRonaldo.setOnAction(e -> characterSaveAction("Ronaldo"));
        
        
        
        BackgroundImage myImage2= new BackgroundImage(new Image("third.png",800, 450,false, true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
        
        //HBox topPane = new HBox( char1, char2 );
        
        
        
        BorderPane myNewPane2 = new BorderPane();
        
        //bottom panel
        HBox bottomPane2 = new HBox( 95, saveMessi, saveRonaldo );
        bottomPane2.setAlignment(Pos.BOTTOM_CENTER);
        //add the changing sizes and padding here**
        myNewPane2.setBackground(new Background(myImage2));
        
        myNewPane2.setCenter(bottomPane2);
        
        
        
        
        //sizing of main box application*
        return new Scene(myNewPane2, 800, 450);
        
    }
    private void characterSaveAction(String name){
        //create change variable of saved, declare variable at top
        characterSaved = name;
        primaryStage.setScene(ChoiceRoomScene()); //next screen
    }
    
    private Scene ChoiceRoomScene() {
        //texts
        Text startText = new Text("Choose the room where you want to start");
        startText.setStyle("-fx-font-size: 24px; -fx-text-fill: black; -fx-font-weight: bold;");

        //creates 3 buttons
        Button Math = new Button("Math Games");
        Button puzzles = new Button("Puzzle Games");
        Button riddles = new Button("Riddle Games");
        
        Math.setPadding(new Insets(30,20,10,10));
        puzzles.setPadding(new Insets(30,20,10,10));
        riddles.setPadding(new Insets(30,20,10,10));

        
        
        //set all buttons to lead to "chooseMessiRonaldo" screen
        Math.setOnAction(e ->  primaryStage.setScene(mainRoom()));
        
        
        riddles.setOnAction(e -> primaryStage.setScene(riddleRoomScreen()));
        
        
        puzzles.setOnAction(e -> primaryStage.setScene(PuzzleRoomScreen()));
        //top panel
        HBox topPane = new HBox( 10, Math, riddles, puzzles );
        topPane.setPadding(new Insets(120,0,0,0));
        topPane.setAlignment(Pos.CENTER);
        
        VBox design = new VBox(50, startText, topPane);
        design.setAlignment(Pos.CENTER);
       
        BackgroundImage myImage= new BackgroundImage(new Image("choose.png",800, 450,false, true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
                

        BorderPane myNewPane = new BorderPane();
                
        
        myNewPane.setBackground(new Background(myImage));
        myNewPane.setCenter(design);


        
        return new Scene(myNewPane, 800, 450);
        
        

        
    }
   
    
    
    // Main room screen
    private Scene mainRoom() {
        //texts
        Text welcomeText = new Text("Choose who you save");
        Text char1 = new Text("Messi");
        Text char2 = new Text("Ronaldo");
        
        
        //Top pane
        //health points addition
        HBox healthBar = new HBox();
        
        
        
        //Left pane buttons menu
        Button mr1 = new Button("Easy Room 1");
        Button mr2 = new Button("Difficul Room 2");
      //BEN IM COMMENTING THIS OUT SO that I CAN COMPILE      
        HBox roomMenuBar = new HBox(20, mr1, mr2);
        mr1.setOnAction(e -> createMathRoom("m1"));
        mr2.setOnAction(e -> createMathRoom("m2"));
        //VBox roomMenuBar = new VBox(mr1, mr2);        
        mr1.setPadding(new Insets(30,20,10,10));
        mr2.setPadding(new Insets(30,20,10,10));
        
        //Right pane
        VBox rightPane = new VBox();
        
        
        //whole THIS HAD A MENUBAR IN THE MIDDLE
        HBox root = new HBox(healthBar, roomMenuBar, rightPane);
    
        BackgroundImage myImage3= new BackgroundImage(new Image("Choose which room.png",800, 450,false, true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT); 

        BorderPane myBorderPane3 = new BorderPane();

        HBox bottomPane3 = new HBox(roomMenuBar);
        //add the changing sizes and padding here**
        myBorderPane3.setBackground(new Background(myImage3));
        
        myBorderPane3.setCenter(bottomPane3); 
        bottomPane3.setAlignment(Pos.CENTER);
   
    
         //   root.setSpacing(10);
       // root.setStyle("-fx-padding: 10;");
        
        //sizing of main box application*
        return new Scene(myBorderPane3, 800, 450);
        
    }
    //main room methods
    private void createMathRoom(String name){
        //make new instance of room
        MathRoom m1 = new MathRoom(name, true, difficultyLevel);
        
        //move to room
        primaryStage.setScene(mathRoomScene(m1));
    }
    //gui for math room
    private Scene mathRoomScene(MathRoom m) {
        
        Button mathRoom = new Button("Check answer");
        Button finishGames = new Button("Finish the rest of the games");
        
        
        
        HBox bottomPane = new HBox(mathRoom);
        Button finishGame= new Button("End Game");
        finishGames.setVisible(true);
        
       
        bottomPane.setAlignment(Pos.BOTTOM_CENTER);
        mathRoom.setPadding(new Insets(10,30,10,10)); 
        finishGames.setPadding(new Insets(10,30,10,10)); 
        finishGames.setOnAction(e -> { primaryStage.setScene(ChoiceRoomScene()); 
            checkGameCompletion();
        });
        
        
        BackgroundImage myImage2= new BackgroundImage(new Image("mathRoom.png",800, 450,false, true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);        
        
        BorderPane myNewPane4 = new BorderPane();
        
        Label result = new Label("Enter one word only");
        result.setStyle("-fx-font-size: 20px;");
        result.setAlignment(Pos.BOTTOM_CENTER);
        
        TextField field1 = new TextField();
        field1.setPrefWidth(20);
        HBox resultLabel= new HBox(result);
        resultLabel.setAlignment(Pos.BOTTOM_CENTER);
        resultLabel.setPadding(new Insets(0));
        
        
        Label questionDisplay = new Label(m.displayQuestion());
        questionDisplay.setStyle("-fx-font-size: 20px;");
        Color myColor = new Color(1.0, 0 , 0, 1.0);
        questionDisplay.setTextFill(myColor);
        questionDisplay.setAlignment(Pos.TOP_CENTER);
        HBox disLabel= new HBox(questionDisplay);
        disLabel.setAlignment(Pos.BOTTOM_CENTER);
        disLabel.setPadding(new Insets(0));
        
        
        VBox bottomPane3 = new VBox(25,questionDisplay, field1, mathRoom, finishGames );
        //VBox topPane = new VBox(questionDisplay);
        bottomPane3.setAlignment(Pos.CENTER);
        myNewPane4.setBackground(new Background(myImage2));
         
        
        //myNewPane4.setTop(topPane);
        myNewPane4.setCenter(bottomPane3);
        myNewPane4.setBottom(resultLabel);
     
        bottomPane3.setPadding(new Insets(145, 0, 0, 0)); 
        field1.setMaxWidth(150);
 
        
        //get text on each of the field values
      
        //checking field values
        mathRoom.setOnAction(e -> {
            String userInput = field1.getText().toLowerCase();
            int n = Integer.valueOf(userInput);
            boolean isCorrect = m.checkAnswer(n);
            finishGame.setVisible(false);
            if (isCorrect) {
                field1.setStyle("-fx-border-color: green;");
                result.setText("Congratulations. The answer is correct");
                result.setStyle("-fx-text-fill: green; -fx-font-size: 20px; -fx-font-weight: bold;");
                finishGame.setVisible(false);
                mathCompleted= true;
                checkGameCompletion(); 
                if (mathCount < 4){
                    mathCount++;
                    checkGameCompletion(); 
                }
                else{
                mathCompleted= true;
                }
                checkGameCompletion(); 
            } else {
                mathCompleted= false;
                field1.setStyle("-fx-border-color: red;");
                result.setText("Try again in the red box!");
                result.setStyle("-fx-text-fill: red; -fx-font-size: 20px; -fx-font-weight: bold;");
                checkGameCompletion(); 
            }
            checkGameCompletion(); 
        }
        );
     
        return new Scene(myNewPane4,800, 450);
        
    }
    private void mathRoomReset(MathRoom m1){
        //create change variable of saved, declare variable at top
        m1 = null;
        primaryStage.setScene(mainRoom()); //next screen
    }
    
    private Scene PuzzleRoomScreen() {
    
        
        //creates 3 buttons
        Button puzzleRoom1 = new Button("START NOW");

        //set all buttons to lead to "chooseMessiRonaldo" screen
        puzzleRoom1.setOnAction(e -> createPuzzleRoom("p1"));
        
        
        BackgroundImage myImage2= new BackgroundImage(new Image("Go.png",800, 450,false, true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);        
        
        
        BorderPane myNewPane4 = new BorderPane();
        
        //bottom panel
        HBox bottomPane3 = new HBox( 95,puzzleRoom1  );
        bottomPane3.setAlignment(Pos.BOTTOM_CENTER);
        //add the changing sizes and padding here**
        myNewPane4.setBackground(new Background(myImage2));
        
        myNewPane4.setCenter(bottomPane3);
        
        
    
        
        
        
    return new Scene(myNewPane4, 800, 450);
}
    
    
    
    //puzzle room methods

        private void createPuzzleRoom(String name){
        //make new instance of room
        puzzleRoom p1 = new puzzleRoom(name, true, difficultyLevel);
        
        //move to room
        primaryStage.setScene(PuzzleRoomScene(p1));
    }

    
    private Scene PuzzleRoomScene(puzzleRoom p) {
        //texts
        
        //creates 3 buttons
        Button checkButton = new Button("Check answers");
        checkButton.setPadding(new Insets(30,20,10,10)); 
        
        Button nextGame = new Button("Play other games");
        nextGame.setPadding(new Insets(30,40,10,10)); 
        nextGame.setVisible(true);
 
        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();
        
        field1.setPrefColumnCount(5);
        
        field2.setPrefColumnCount(5);
        field3.setPrefColumnCount(5);
        
        TextField[] fields = {field1,field2,field3};
        
        Label result = new Label();
           
        
        checkButton.setOnAction(e -> {  
            boolean allCorrect = true;
           
            nextGame.setVisible(true);

            for (int i = 0; i < fields.length; i++) {
                String userAnswer= fields[i].getText().toLowerCase();
                boolean isCorrect= p.getCorrectAnswers().contains(userAnswer);
        
                nextGame.setVisible(true);

        if (!isCorrect) {
            fields[i].setText("");
            fields[i].setStyle("-fx-border-color: red;");
            nextGame.setVisible(true);
            allCorrect= false;
            
            
    
        } else {
            lockCorrectField(fields[i]);
            nextGame.setVisible(true);
            puzzleCompleted= true;
            checkGameCompletion(); 
            
        
        }
        checkGameCompletion();
    }
        showResult(allCorrect, result);
    

    });

             
        nextGame.setOnAction(e -> { 
            primaryStage.setScene(riddleRoomScreen());
            checkGameCompletion();
    
    });

        //set all buttons to lead to "chooseMessiRonaldo" screen
        
        nextGame.setVisible(true);
        
        nextGame.setPadding(new Insets(10,30,10,10)); 
        
        nextGame.setOnAction(e -> { checkGameCompletion(); primaryStage.setScene(ChoiceRoomScene());
    });
        
        HBox roomPuzzle = new HBox(90, checkButton);
   
        BackgroundImage myImage2= new BackgroundImage(new Image("puzzleRoomPicture.png",800, 450,false, true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT); 
        
        BorderPane myNewPane4 = new BorderPane();
        
        
        //bottom panel
        HBox bottomPane3 = new HBox( 70,checkButton, nextGame);
        bottomPane3.setAlignment(Pos.BOTTOM_CENTER);
        //add the changing sizes and padding here**
        myNewPane4.setBackground(new Background(myImage2));
        
        myNewPane4.setBottom(bottomPane3);
        
        VBox fieldsBox = new VBox(5);
        fieldsBox.getChildren().addAll(field1, field2, field3);
        fieldsBox.setPrefWidth(20);
      //  fieldsBox.setAlignment(Pos.CENTER_LEFT);
        myNewPane4.setCenter(fieldsBox);
        
        
        HBox resultLabel = new HBox(result);
        resultLabel.setAlignment(Pos.TOP_CENTER);
        resultLabel.setPadding(new Insets(0));
        
        myNewPane4.setTop(resultLabel);
        
        field1.setMaxWidth(150);
        field2.setMaxWidth(150);
        field3.setMaxWidth(150);
        
       // fieldsBox.setPadding(new Insets(20, 50, 0, 0));
      
       BorderPane.setMargin(fieldsBox, new Insets(220, 0, 0, 480));
        
  //get text on each of the field values
        
        
   return new Scene(myNewPane4, 800, 450); 
   
}

    private boolean CheckFields(puzzleRoom p, TextField[] fields){
        boolean fullCorrectAnswers = true;
        for (int i = 0; i<fields.length; i++){
            String userAnswer = fields[i].getText().toLowerCase();
            if (!p.getCorrectAnswers().contains(userAnswer)){
                fullCorrectAnswers= false;
                fields[i].setStyle("-fx-text-fill: red;");
            }else{
                fields[i].setStyle("-fx-text-fill: green;");
                return fullCorrectAnswers;
            }
            }
            return fullCorrectAnswers;
        }
        
    
    private void showResult(boolean allCorrect, Label result){
        if (allCorrect){
            result.setText("Congratulations. All answers are correct");
            result.setStyle("-fx-text-fill: green;-fx-font-size: 20px; -fx-font-weight: bold;");
        } else{
            result.setText("Some answers are not correct. Try again in the red box!");
            result.setStyle("-fx-text-fill: red; -fx-font-size: 20px; -fx-font-weight: bold;");

        }
        }
    
    private void lockCorrectField(TextField field){
        field.setEditable(false);
        field.setStyle(("-fx-border-color: green;"));
    }
    
     private void showResultRiddle(boolean allCorrect, Label result){
        if (allCorrect){
            result.setText("Congratulations. The answer is correct");
            result.setStyle("-fx-text-fill: green;-fx-font-size: 20px; -fx-font-weight: bold;");
        } else{
            result.setText("Try again in the red box!");
            result.setStyle("-fx-text-fill: red; -fx-font-size: 20px; -fx-font-weight: bold;");

        }
        }
    //riddle room
    private Scene riddleRoomScreen() {
    
        
        //creates 3 buttons
      
        Button riddleRoom = new Button("Check answer");
        Button finishGames = new Button("Finish the rest of the games");
        
        HBox bottomPane = new HBox(riddleRoom);
        Button finishGame= new Button("End Game");
        finishGames.setVisible(true);
        
       
        bottomPane.setAlignment(Pos.BOTTOM_CENTER);
        riddleRoom.setPadding(new Insets(10,30,10,10)); 
        finishGames.setPadding(new Insets(10,30,10,10)); 
        
        finishGames.setOnAction(e -> { primaryStage.setScene(ChoiceRoomScene()); checkGameCompletion();
    });
        

        //set all buttons to lead to "riddle Room" screen
        
    
        
        BackgroundImage myImage2= new BackgroundImage(new Image("riddleRoom.png",800, 450,false, true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);        
        
        
        BorderPane myNewPane4 = new BorderPane();
        
           Label result = new Label("Enter one word only");
        result.setStyle("-fx-font-size: 20px;");
         result.setAlignment(Pos.BOTTOM_CENTER);
      String correctAnswer= "mirror";
      
      
        TextField field1 = new TextField();
       
        field1.setPrefWidth(20);
        HBox resultLabel= new HBox(result);
        resultLabel.setAlignment(Pos.BOTTOM_CENTER);
        resultLabel.setPadding(new Insets(0));

        
        
        VBox bottomPane3 = new VBox(25,field1, riddleRoom, finishGames );
         bottomPane3.setAlignment(Pos.CENTER);
         //add the changing sizes and padding here**
         myNewPane4.setBackground(new Background(myImage2));
         
         myNewPane4.setCenter(bottomPane3);
         myNewPane4.setBottom(resultLabel);
     
    bottomPane3.setPadding(new Insets(245, 0, 0, 0)); 
         field1.setMaxWidth(150);
 
        
  //get text on each of the field values
      
      //checking field values
      riddleRoom.setOnAction(e -> {
        String userInput = field1.getText().toLowerCase();

        boolean isCorrect = userInput.equals(correctAnswer.toLowerCase());
        finishGame.setVisible(false);
        if (isCorrect) {
            field1.setStyle("-fx-border-color: green;");
            result.setText("Congratulations. The answer is correct");
            result.setStyle("-fx-text-fill: green; -fx-font-size: 20px; -fx-font-weight: bold;");
            finishGame.setVisible(false);
            riddleCompleted= true;
            checkGameCompletion(); 
        } else {
            field1.setStyle("-fx-border-color: red;");
            result.setText("Try again in the red box!");
            result.setStyle("-fx-text-fill: red; -fx-font-size: 20px; -fx-font-weight: bold;");
        }
        checkGameCompletion();
    });
     
    return new Scene(myNewPane4,800, 450);
        
    }


    
    
    //puzzle room methods

        private void createRiddleRoom(String name){
        //make new instance of room
        riddleRoom r1 = new riddleRoom(name, true, difficultyLevel);
        
        //move to room
        primaryStage.setScene(RiddleRoomScene(r1));
    }

    
    private Scene RiddleRoomScene(riddleRoom r) {
     
       
        Button startGame = new Button("Next Game");
        
        startGame.setOnAction(e -> createRiddleRoom("r1")); 
        Button nextGame = new Button("Save your player now");
        nextGame.setPadding(new Insets(30,40,10,10)); 
        nextGame.setVisible(false);
        
        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();
        
        field1.setPrefColumnCount(5);
        
        field2.setPrefColumnCount(5);
        field3.setPrefColumnCount(5);
        
        TextField[] fields = {field1,field2,field3};
        
       
    
        
        Label result = new Label();
        
        
      
   
        BackgroundImage myImage2= new BackgroundImage(new Image("riddleRoom.png",800, 450,false, true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT); 
        
        BorderPane myNewPane4 = new BorderPane();
        
        
        
        myNewPane4.setBackground(new Background(myImage2));
        
        
        VBox fieldsBox = new VBox(5);
        fieldsBox.getChildren().addAll(field1, field2, field3);
        fieldsBox.setPrefWidth(20);
        myNewPane4.setCenter(fieldsBox);
        
        
        HBox resultLabel = new HBox(result);
        resultLabel.setAlignment(Pos.TOP_CENTER);
        resultLabel.setPadding(new Insets(0));
        
        myNewPane4.setTop(resultLabel);
        
      
       BorderPane.setMargin(field1, new Insets(220, 0, 0, 480));
        
  //get text on each of the field values
  
  
    
        return new Scene(myNewPane4, 800, 450);
        
        //sizing of main box application*
        
       
    }
    
public boolean checkAnswer(TextField userAnswerField, riddleRoom riddle) {
 
    String userAnswer = userAnswerField.getText().toLowerCase();
    
 
    return userAnswer.equals("mirror");
}
//Room to give them the option to choose where to start 

private Scene victoryScene() {
    Label congrats = new Label("You won! You saved " + characterSaved + "!");
    congrats.setStyle("-fx-font-size: 30px; -fx-text-fill: green; -fx-font-weight: bold;");
    
    BackgroundImage myImage2= new BackgroundImage(new Image("lastmaybe.jpg",800, 450,false, true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);  
    
    BorderPane myNewPane4 = new BorderPane();
        
        
        
    myNewPane4.setBackground(new Background(myImage2));
        
        
        
    
    Button playAgain = new Button("Play Again");
    playAgain.setOnAction(e -> resetGame());

    VBox design = new VBox(50, congrats, playAgain);
    myNewPane4.setCenter(design);
    design.setAlignment(Pos.CENTER);


    return new Scene(myNewPane4, 800, 450);
}
private void resetGame() {
    mathCompleted = false;
    puzzleCompleted = false;
    riddleCompleted = false;
    characterSaved = null;

    primaryStage.setScene(playerSelectScreen());
}
private void checkGameCompletion(){
    if (mathCompleted == true && puzzleCompleted == true && riddleCompleted == true) {
        primaryStage.setScene(victoryScene());
    }
}

    //launch
    public static void main(String[] args) {
        launch();
    }

}


   