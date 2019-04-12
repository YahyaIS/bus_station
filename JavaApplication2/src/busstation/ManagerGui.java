package busstation;

import triptableview.AddTable;
import triptableview.AssignDriver;
import triptableview.DeleteTable;
import triptableview.ViewTrips;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ManagerGui {
    private Login login;
    private Scene scene;
    private Stage stage;
    private final GridPane grid = new GridPane();
    private ViewTrips tripTableView ;
    private DeleteTable deleteTable ;
    private AddTable addTable ;
    private AssignDriver assignDriver;
    public ManagerGui(){    
    }

    

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setTripTableView(ViewTrips tripTableView) {
        this.tripTableView = tripTableView;
    }
    
    public void draw(){
        Button reviewExternal = new Button("Review External trips");
        Button reviewInternal = new Button("Review Internal trips");
        Button addExternal = new Button("Add External trips");
        Button addInternal = new Button("Add Internal trips");
        Button removeExternal = new Button("Remove External trips");
        Button removeInternal = new Button("Remove Internal trips");
        Button logout = new Button("Logout");
        Button assignExternal = new Button("Assign drivers(External)");
        Button assignInternal = new Button("Assign drivers(Internal)");
        
        grid.add(reviewExternal, 0, 0);
        grid.add(reviewInternal, 1, 0);
        grid.add(addExternal, 0, 1);
        grid.add(addInternal, 1, 1);
        grid.add(removeExternal, 0, 2);
        grid.add(removeInternal, 1, 2);
        grid.add(logout, 5, 5);
        grid.add(assignExternal, 0, 3);
        grid.add(assignInternal, 1, 3);
        reviewExternal.setPrefSize(150, 31);
        reviewInternal.setPrefSize(150, 31);
        assignExternal.setPrefSize(150, 31);
        assignInternal.setPrefSize(150, 31);
        logout.setPrefSize(80, 31);
        addExternal.setPrefSize(150, 31);
        addInternal.setPrefSize(150, 31);
        removeExternal.setPrefSize(150, 31);
        removeInternal.setPrefSize(150, 31);
        reviewExternal.setStyle("-fx-background-color: BLACK");
        reviewInternal.setStyle("-fx-background-color: BLACK");
        assignExternal.setStyle("-fx-background-color: BLACK");
        assignInternal.setStyle("-fx-background-color: BLACK");
        logout.setStyle("-fx-background-color: BLACK");
        addExternal.setStyle("-fx-background-color: BLACK");
        addInternal.setStyle("-fx-background-color: BLACK");
        removeExternal.setStyle("-fx-background-color: BLACK");
        removeInternal.setStyle("-fx-background-color: BLACK");
        reviewExternal.setTextFill(Color.AQUA);
        reviewInternal.setTextFill(Color.AQUA);
        assignExternal.setTextFill(Color.AQUA);
        assignInternal.setTextFill(Color.AQUA);
        removeExternal.setTextFill(Color.AQUA);
        removeInternal.setTextFill(Color.AQUA);
        addExternal.setTextFill(Color.AQUA);
        addInternal.setTextFill(Color.AQUA);
        logout.setTextFill(Color.AQUA);
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
    Image img = new Image("file:1_fzSHwR5vbLlI76IZYrZ9Cg.jpeg");
        BackgroundImage background = new BackgroundImage(img,
                                                     BackgroundRepeat.NO_REPEAT,
                                                     BackgroundRepeat.NO_REPEAT,
                                                     BackgroundPosition.DEFAULT,
                                                     BackgroundSize.DEFAULT);
        grid.setBackground(new Background(background));
        grid.setMinWidth(img.getWidth());
        grid.setMinHeight(img.getHeight());
        grid.setAlignment(Pos.CENTER);
        
         reviewExternal.setOnAction((ActionEvent event) -> {
             tripTableView.setFileName("ExternalTrips.txt");
             tripTableView.draw();
             stage.setScene(tripTableView.getScene());
    });
         reviewInternal.setOnAction((ActionEvent event) -> {
             tripTableView.setFileName("InternalTrips.txt");
             tripTableView.draw();
             stage.setScene(tripTableView.getScene());
    });
        
         addExternal.setOnAction((ActionEvent event) -> {
             addTable.setFileName("ExternalTrips.txt");
             addTable.draw();
             stage.setScene(addTable.getScene());
    });
         addInternal.setOnAction((ActionEvent event) -> {
             addTable.setFileName("InternalTrips.txt");
             addTable.draw();
             stage.setScene(addTable.getScene());
    });
         removeExternal.setOnAction((ActionEvent event) -> {
             deleteTable.setFileName("ExternalTrips.txt");
             deleteTable.draw();
             stage.setScene(deleteTable.getScene());
    });
         
         removeInternal.setOnAction((ActionEvent event) -> {
             deleteTable.setFileName("InternalTrips.txt");
             deleteTable.draw();
             stage.setScene(deleteTable.getScene());
    });
         assignExternal.setOnAction((ActionEvent event) -> {
             assignDriver.setFileName("ExternalTrips.txt");
             assignDriver.draw();
             stage.setScene(assignDriver.getScene());
    });
         
         assignInternal.setOnAction((ActionEvent event) -> {
             assignDriver.setFileName("InternalTrips.txt");
             assignDriver.draw();
             stage.setScene(assignDriver.getScene());
    });
         logout.setOnAction((ActionEvent event) -> {
             stage.setScene(login.getScene());
             
    });
    scene = new Scene(grid,800,700);
    }    

    public void setAddTable(AddTable addTable) {
        this.addTable = addTable;
    }
    
    public void setLogin(Login login) {
        this.login = login;
    }

    public void setDeleteTable(DeleteTable deleteTable) {
        this.deleteTable = deleteTable;
    }

    public void setAssignDriver(AssignDriver assignDriver) {
        this.assignDriver = assignDriver;
    }

    
    
    
}
