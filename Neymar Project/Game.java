import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class Game extends Application {
    private Stage primaryStage;
    

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
        Text char1 = new Text("dino");
        Text char2 = new Text("ballet");
        Text char3 = new Text("Neymar");
        
        //creates 3 buttons
        Button playerDinoButton = new Button("Start Game");
        Button playerBalletButton = new Button("Start Game");
        Button playerNeymarButton = new Button("Start Game");

        //set all buttons to lead to "chooseMessiRonaldo" screen
        playerDinoButton.setOnAction(e -> playerSelectAction("Dino",1));
        playerBalletButton.setOnAction(e -> playerSelectAction("Ballet",2));
        playerNeymarButton.setOnAction(e -> playerSelectAction("Neymar",3));
        
        
        
        
        // HIII THIS IS CAMI
        
        //top panel
        HBox topPane = new HBox( char1, char2, char3 );
        //add the changing sizes and padding here**
        
        //bottom panel
        HBox bottomPane = new HBox( playerDinoButton, playerBalletButton, playerNeymarButton );
        //add the changing sizes and padding here**
        
        //whole
        VBox root = new VBox(topPane, bottomPane);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;");
        
        return new Scene(root, 400, 300);
    }
    //Player Select Screen methods
    private void playerSelectAction(String name, int difficulty){
        //create new player with difficulty
        //Player p1 = new Player(name, difficulty);
        primaryStage.setScene(chooseMessiRonaldoScreen());
    }
    
    
    
    // Choosing Messi/Ronaldo Screen
    private Scene chooseMessiRonaldoScreen() {
        //texts
        Text welcomeText = new Text("Choose who you save");
        Text char1 = new Text("Messi");
        Text char2 = new Text("Ronaldo");
        
        //creates 3 buttons
        Button saveMessi = new Button("Messi");
        Button saveRonaldo = new Button("Ronaldo");

        //set all buttons to lead to "chooseMessiRonaldo" screen
        //**change the scene loop to **MAIN PAGE** instead of choosing screen
        saveMessi.setOnAction(e -> characterSaveAction("Messi"));
        saveRonaldo.setOnAction(e -> characterSaveAction("Ronaldo"));
        
        
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
    private void characterSaveAction(String name){
        //create change variable of saved, declare variable at top
        //savedChar = name;
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
        //hbox
        
        
        
        //Left pane buttons menu
        Button mr1 = new Button("Math Room 1");
        Button mr2 = new Button("Math Room 2");
        
        VBox roomMenuBar = new VBox(mr1, mr2);
        
        
        //Right pane
        VBox rightPane = new VBox();
        
        
        //whole
        HBox root = new HBox(roomMenuBar, rightPane);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;");
        
        //sizing of main box application*
        return new Scene(root, 400, 300);
        
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
        
        
        

