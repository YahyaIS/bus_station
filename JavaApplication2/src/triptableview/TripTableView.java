package triptableview;

import busstation.ManagerGui;
import busstation.Trip;
import busstation.TripsFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public abstract class TripTableView {
    protected Stage stage ;
    protected Scene scene;
    protected String fileName;
    protected ManagerGui managerGui ;
    protected Trip[] trips = new Trip[100];
    protected Trip trip ;
    protected final TableView table;
    protected TripsFile tripsFile = new TripsFile();
    protected int i;
    public TripTableView() {
        this.table = new TableView();
    }
    protected TableColumn idColumn;
    protected TableColumn fromColumn;
    protected TableColumn destinationColumn;
    protected TableColumn vehicleColumn;
    protected TableColumn wayColumn;
    protected TableColumn stopColumn;
    protected TableColumn dateColumn;
    protected TableColumn timeColumn;
    protected TableColumn costColumn;
    protected TableColumn seatsColumn;
    
    protected final ObservableList<Trip> data =FXCollections.observableArrayList();
    public void draw(){
        if(fileName!=null)
        {
        i=0;
        trips=tripsFile.readFile(fileName);
        data.clear();
        while(trips[i]!=null)
        {
            Trip trip1=new Trip(trips[i].getId(),trips[i].getFrom(),
                    trips[i].getDestination(),trips[i].getVehicle(),trips[i].getWay()
                    ,trips[i].getStops(),trips[i].getDate(),trips[i].getTime(),
                    trips[i].getPrice() ,trips[i].getSeats());
            data.add(trip1);
            i++;
        }
        scene = new Scene(new Group());
        stage.setWidth(800);
        stage.setHeight(700);
        final Label label = new Label("Trips");
        label.setFont(new Font("Arial", 20));
        Button backButton =new Button("Back");
        
        table.setEditable(true);
        idColumn = new TableColumn("Id");
        idColumn.setMinWidth(80);
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        fromColumn = new TableColumn("From");
        fromColumn.setMinWidth(80);
        fromColumn.setCellValueFactory(new PropertyValueFactory("from"));
        destinationColumn = new TableColumn("Destination");
        destinationColumn.setMinWidth(80);
        destinationColumn.setCellValueFactory(new PropertyValueFactory("destination"));
        vehicleColumn = new TableColumn("Vehicle");
        vehicleColumn.setMinWidth(80);
        vehicleColumn.setCellValueFactory(new PropertyValueFactory("Vehicle"));
        wayColumn = new TableColumn("way");
        wayColumn.setMinWidth(80);
        wayColumn.setCellValueFactory(new PropertyValueFactory("way"));
        stopColumn = new TableColumn("stop");
        stopColumn.setMinWidth(80);
        stopColumn.setCellValueFactory(new PropertyValueFactory("stops"));
        dateColumn = new TableColumn("Date");
        dateColumn.setMinWidth(80);
        dateColumn.setCellValueFactory(new PropertyValueFactory("date"));
        timeColumn = new TableColumn("Time");
        timeColumn.setMinWidth(80);
        timeColumn.setCellValueFactory(new PropertyValueFactory("time"));
        costColumn = new TableColumn("Cost");
        costColumn.setMinWidth(80);
        costColumn.setCellValueFactory(new PropertyValueFactory("price"));
        seatsColumn = new TableColumn("Available Seats");
        seatsColumn.setMinWidth(80);
        seatsColumn.setCellValueFactory(new PropertyValueFactory("Seats"));
        table.autosize();
        table.getColumns().clear();
        table.setItems(data);
        table.getColumns().addAll(idColumn,fromColumn,destinationColumn, 
                vehicleColumn, wayColumn , stopColumn ,dateColumn,timeColumn, 
                costColumn , seatsColumn);

        backButton.setOnAction((ActionEvent event) -> {
            stage.setScene(managerGui.getScene());
        });
        drawBox(label , backButton);
        }
        
    }
   abstract void drawBox(Label label , Button button);

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setManagerGui(ManagerGui managerGui) {
        this.managerGui = managerGui;
    }

}
