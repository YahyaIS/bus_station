package busstation;

import triptableview.TripTableView;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class DriverGui {
    private Scene scene;
    private Stage stage;
    private Login login;
    private Driver driver=new Driver(null, null,null,null,null);
    private TripTableView table;
    private ViewTasks viewTasks;
    private final GridPane grid = new GridPane();
    
     public void draw() {
         if(driver.getName()!=null){
        Text name = new Text("Name: "+driver.getName());
        Text id = new Text("ID: "+driver.getId());
        Text number = new Text("Number: "+driver.getNumber());
        Text address = new Text("Address: "+driver.getAddress());
        Button logout = new Button("Logout");
        Button view = new Button("View tasks");
        name.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        id.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        number.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        address.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        
        grid.add(name,0,0);
        grid.add(id,4,0);
        grid.add(number,0,4);
        grid.add(address,4,4);
        grid.add(view, 5, 5);
        grid.add(logout, 8, 5);
        
    
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        Image img = new Image("file:stock-photo-bus-driver-word-isolated-on-white-background-with-icons-representing-education-698310253.jpg");
        BackgroundImage background = new BackgroundImage(img,
                                                     BackgroundRepeat.NO_REPEAT,
                                                     BackgroundRepeat.NO_REPEAT,
                                                     BackgroundPosition.DEFAULT,
                                                     BackgroundSize.DEFAULT);
        grid.setBackground(new Background(background));
        grid.setMinWidth(img.getWidth());
        grid.setMinHeight(img.getHeight());
       // grid.setBackground(new Background(new BackgroundFill(Color.MAROON, CornerRadii.EMPTY, Insets.EMPTY)));
        grid.setAlignment(Pos.CENTER);
        
        view.setOnAction((ActionEvent event) -> {
            viewTasks.setUserName(driver.getName());
            viewTasks.draw();
            stage.setScene(viewTasks.getScene());
    });
        logout.setOnAction((ActionEvent event) -> {
                stage.setScene(login.getScene());
    });
        
        scene = new Scene(grid,450,250);
    }
    }

    public void setViewTasks(ViewTasks viewTasks) {
        this.viewTasks = viewTasks;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
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

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    

}
