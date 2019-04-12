
package busstation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

public class InternalTrips {
    private Scene scene;
    private Stage stage;
    private String userName;
    private CustomerGui customerGui = new CustomerGui();
    private final ConfirmTrip confirmTrip =new ConfirmTrip();
    private final TripsFile tripsFile=new TripsFile();
    private String[] internalCity=new String[100];
    private Trip trip = new Trip(null ,null ,null ,null ,null, null, null, null, null, 0);
    private int i=0,j=0;
    
    GridPane grid= new GridPane();
    public InternalTrips() {
    }
    public void draw(){
        Button submitButton = new Button("Submit");
        Button backButton = new Button("Back");
        Text tripLabel =new Text();
        Text fromLabel = new Text("From:");
        
        ObservableList<String> fromList = 
    FXCollections.observableArrayList(
    );
final ComboBox fromBox = new ComboBox(fromList);
        Text destinationLabel = new Text("Destination:");
        ObservableList<String> destinationList = 
    FXCollections.observableArrayList(
    );
final ComboBox destinationBox = new ComboBox(destinationList);
        Text vehicleLabel = new Text("Vehicle:");
        ObservableList<String> options2 = 
    FXCollections.observableArrayList(
        "Bus",
        "Mini-Bus",
        "Limo"
    );
final ComboBox vehicleBox = new ComboBox(options2);
        Text wayLabel = new Text("Way:");
        ObservableList<String> options3 = 
    FXCollections.observableArrayList(
        "one-way",
        "round-trip"
    );
final ComboBox wayBox = new ComboBox(options3);
        Text stopLabel = new Text("Stop type:");
        ObservableList<String> options4 = 
    FXCollections.observableArrayList(
        "no-stop",
        "one-stop",
        "multi-stop"
    );
final ComboBox stopBox = new ComboBox(options4);
        internalCity=tripsFile.readCity("Internal.txt");
        fromList.clear();
        destinationList.clear();
        while(internalCity[j]!=null)
        {
        fromList.add(internalCity[j]);
        destinationList.add(internalCity[j]);
        j++;
        }
        fromLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        fromLabel.setFill(Color.AQUA);
        vehicleLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        vehicleLabel.setFill(Color.AQUA);
        destinationLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        destinationLabel.setFill(Color.AQUA);
        wayLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        wayLabel.setFill(Color.AQUA);
        stopLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        stopLabel.setFill(Color.AQUA);
        submitButton.setStyle("-fx-background-color: BLACK");
        backButton.setStyle("-fx-background-color: BLACK");        
        submitButton.setTextFill(Color.AQUA);
        backButton.setTextFill(Color.AQUA);
        
        grid.add(fromLabel, 0, 0);
        grid.add(destinationLabel,0 , 1);
        grid.add(vehicleLabel,0 , 2);
        grid.add(wayLabel,0 , 3);
        grid.add(stopLabel,0 , 4);
        grid.add(fromBox,1 , 0);
        grid.add(destinationBox,1 , 1);
        grid.add(vehicleBox,1 , 2);
        grid.add(wayBox,1 , 3);
        grid.add(stopBox,1 , 4);
        grid.add(submitButton, 2, 4);
        grid.add(tripLabel,0,5);
        grid.add(backButton,2,5);
        
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));
    grid.setHgap(10);
    grid.setVgap(10);
    Image img = new Image("file:164793260-starry-sky-wallpapers.jpg");
        BackgroundImage background = new BackgroundImage(img,
                                                     BackgroundRepeat.NO_REPEAT,
                                                     BackgroundRepeat.NO_REPEAT,
                                                     BackgroundPosition.DEFAULT,
                                                     BackgroundSize.DEFAULT);
        grid.setBackground(new Background(background));
        grid.setMinWidth(img.getWidth());
        grid.setMinHeight(img.getHeight());
        scene =new Scene(grid,450,250);
        submitButton.setOnAction((ActionEvent event) -> {
            if (fromBox.getValue() != null && !fromBox.getValue().toString().isEmpty()){
                trip.setFrom(fromBox.getValue().toString());
            }
            else trip.setFrom(" ");
            
            if (destinationBox.getValue() != null && !destinationBox.getValue().toString().isEmpty()){
                trip.setDestination(destinationBox.getValue().toString());
            }
            else trip.setDestination(" ");
            
                
            if (vehicleBox.getValue() != null && !vehicleBox.getValue().toString().isEmpty()){
                trip.setVehicle(vehicleBox.getValue().toString());
            }
            else 
                trip.setVehicle(" ");
            if (destinationBox.getValue() != null && !destinationBox.getValue().toString().isEmpty()){
                trip.setWay(wayBox.getValue().toString());
            }
            else 
                trip.setWay(" ");
            if (destinationBox.getValue() != null && !destinationBox.getValue().toString().isEmpty()){
                trip.setStops(stopBox.getValue().toString());
            }
            else 
                trip.setStops(" ");
            if(tripsFile.search("InternalTrips.txt",trip))
            {
                i=tripsFile.getJ();
                confirmTrip.setI(i);
                confirmTrip.setFileName("InternalTrips.txt");
                trip=tripsFile.getTrip();
                confirmTrip.setUserName(userName);
                confirmTrip.setTrip(trip);
                stage.setScene(customerGui.getScene());
                confirmTrip.draw();
            }
            else
            {
                tripLabel.setText("trip unavailable");
//                
//                stage.setScene(scene);
//                draw();
            }
                
        });
        backButton.setOnAction((ActionEvent event) -> {
            stage.setScene(customerGui.getScene());
        });
    }


    public void setCustomerGui(CustomerGui customerGui) {
        this.customerGui = customerGui;
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
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
