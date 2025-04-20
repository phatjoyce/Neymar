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


public class Game extends Application {
    private Stage primaryStage;
    private int tabWidth = 800;
    private int tabHeight = 450;

    private String characterSaved;
    private int difficultyLevel;
    

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
        //first image
        
        //BackgroundImage myImage = new BackgroundImage("first.png", 800, 450, false, false);
        //ImageView ver= new ImageView();
        //ver.setBackground(myImage); 
        
        
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
        playerDinoButton.setOnAction(e -> playerSelectAction("Dino",1));
        playerBalletButton.setOnAction(e -> playerSelectAction("Ballet",2));
        playerNeymarButton.setOnAction(e -> playerSelectAction("Neymar",3));
        
        
        
        
        
        // HIII THIS IS CAMI
        
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
        
        //second displayed image
        //BackgroundImage myImage2= new BackgroundImage("second.png", 800, 450, false, false);
        //ImageView secondView= new ImageView();
       // secondView.setBackground(myImage2); 
        
    
       
        
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
        
        
        
        //root.setBackground(new Background(myImage));
        
        
        //whole
        //VBox root = new VBox(topPane, bottomPane);
        //root.setSpacing(10);
        //root.setStyle("-fx-padding: 10;");
        
        //sizing of main box application*
        return new Scene(myNewPane2, 800, 450);
        
    }
    private void characterSaveAction(String name){
        //create change variable of saved, declare variable at top
        characterSaved = name;
        primaryStage.setScene(mainRoom()); //next screen
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
        //texts
        Text welcomeText = new Text("Choose who you save");
        Text char1 = new Text("Messi");
        Text char2 = new Text("Ronaldo");
        
        //creates 3 buttons
        Button saveMessi = new Button("replay");
        Button saveRonaldo = new Button("Next Game");

        saveMessi.setPadding(new Insets(30,20,10,10));
        saveRonaldo.setPadding(new Insets(30,20,10,10));
        
        //set all buttons to lead to "chooseMessiRonaldo" screen
        saveMessi.setOnAction(e -> mathRoomReset(m));
        
        
        saveRonaldo.setOnAction(e -> createPuzzleRoom("p1"));
        
        
        //top panel
        HBox topPane = new HBox( char1, char2 );
        //add the changing sizes and padding here**
        
        //bottom panel
        HBox bottomPane = new HBox( saveMessi, saveRonaldo );
        //add the changing sizes and padding here**
        
        
        //whole
        VBox root = new VBox(topPane, bottomPane);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;");
        
        //sizing of main box application*
        return new Scene(root, 800, 450);
        
    }
    private void mathRoomReset(MathRoom m1){
        //create change variable of saved, declare variable at top
        m1 = null;
        primaryStage.setScene(mainRoom()); //next screen
    }
    
    private Scene PuzzleRoomScreen() {
    
        
        //creates 3 buttons
        Button puzzleRoom1 = new Button("Check answers");

        //set all buttons to lead to "chooseMessiRonaldo" screen
        puzzleRoom1.setOnAction(e -> createPuzzleRoom("p1"));
        
        
        BackgroundImage myImage2= new BackgroundImage(new Image("third.png",800, 450,false, true),
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
        Text welcomeText = new Text("Play");
        
        //creates 3 buttons
        Button checkButton = new Button("Check answers");
        checkButton.setPadding(new Insets(30,20,10,10)); 
        
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
           
            
            for (int i = 0; i < fields.length; i++) {
                String userAnswer= fields[i].getText().toLowerCase();
                boolean isCorrect= p.getCorrectAnswers().contains(userAnswer);
        
        //checking each field
        
        //for (int j = 0; j < p.getCorrectAnswers().size(); j++) {
         //   if (userAnswer.equals(p.getCorrectAnswers().get(j))) {
         //       isCorrect = true;
          //      break;
          //  }
       // }
        if (!isCorrect) {
            fields[i].setText("");
            fields[i].setStyle("-fx-border-color: red;");
            
            
            allCorrect= false;
            
    
        } else {
            lockCorrectField(fields[i]);
            
        
        }
    }
        showResult(allCorrect, result);
    

    });

      

        //set all buttons to lead to "chooseMessiRonaldo" screen
        
  //BEN IM COMMENTING THIS OUT SO that I CAN COMPILE      
        HBox roomPuzzle = new HBox(20, checkButton);
   
        BackgroundImage myImage2= new BackgroundImage(new Image("puzzleRoomPicture.png",800, 450,false, true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT); 
        
        BorderPane myNewPane4 = new BorderPane();
        
        
        //bottom panel
        HBox bottomPane3 = new HBox( 95,checkButton );
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
        
        //sizing of main box application*
        
        
        
        
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
    //launch
    public static void main(String[] args) {
        launch();
    }
}



    //String playerSaved;
    
        /*gui for character select
         * gui for which to save
         *      change the player saved variable
         * gui for main screen
         *      add a switch for different room types
         * 
         * 
         * 
         * 
         * 
         */
        
        
        

