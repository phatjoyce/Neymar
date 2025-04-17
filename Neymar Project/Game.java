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
        
       
        

        //set all buttons to lead to "chooseMessiRonaldo" screen
        playerDinoButton.setOnAction(e -> playerSelectAction("Dino",1));
        playerBalletButton.setOnAction(e -> playerSelectAction("Ballet",2));
        playerNeymarButton.setOnAction(e -> playerSelectAction("Neymar",3));
        
        
        
        
        
        // HIII THIS IS CAMI
        
        //bottom panel
        HBox bottomPane = new HBox(20, playerDinoButton, playerBalletButton, playerNeymarButton );
        //add the changing sizes and padding here**
        
        BackgroundImage myImage= new BackgroundImage(new Image("second.png",800, 450,false, true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
       
        //whole
        //VBox root = new VBox(bottomPane);
        //root.setSpacing(10);
        //root.setStyle("-fx-padding: 10;");
        
        

        BorderPane myNewPane = new BorderPane();
        //root.setBackground(new Background(myImage));
        
        
        myNewPane.setAlignment(bottomPane, Pos.CENTER);

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

        //set all buttons to lead to "chooseMessiRonaldo" screen
        saveMessi.setOnAction(e -> characterSaveAction("Messi"));
        saveRonaldo.setOnAction(e -> characterSaveAction("Ronaldo"));
        
        
        //top panel
        HBox topPane = new HBox( char1, char2 );
        //add the changing sizes and padding here**
        
        //bottom panel
        HBox bottomPane = new HBox( 20, saveMessi, saveRonaldo );
        //add the changing sizes and padding here**
        
        
        //whole
        VBox root = new VBox(topPane, bottomPane);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;");
        
        //sizing of main box application*
        return new Scene(root, 400, 300);
        
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
        Button mr1 = new Button("Math Room 1");
        Button mr2 = new Button("Math Room 2");
        
<<<<<<< HEAD
        VBox roomMenuBar = new VBox(20, mr1, mr2);
=======
        mr1.setOnAction(e -> createMathRoom("m1"));
        mr2.setOnAction(e -> createMathRoom("m2"));
        
        VBox roomMenuBar = new VBox(mr1, mr2);
>>>>>>> b52ea7e76747d284221fffc23d3c557c5be082ed
        
        
        //Right pane
        VBox rightPane = new VBox();
        
        
        //whole
        HBox root = new HBox(healthBar, roomMenuBar, rightPane);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;");
        
        //sizing of main box application*
        return new Scene(root, 400, 300);
        
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
        Button saveMessi = new Button("test");
        Button saveRonaldo = new Button("set");

        //set all buttons to lead to "chooseMessiRonaldo" screen
        saveMessi.setOnAction(e -> mathRoomReset(m));
        saveRonaldo.setOnAction(e -> mathRoomReset(m));
        
        
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
        return new Scene(root, 400, 300);
        
    }
    private void mathRoomReset(MathRoom m1){
        //create change variable of saved, declare variable at top
        m1 = null;
        primaryStage.setScene(mainRoom()); //next screen
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
        
        
        

