
package busstation;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConfirmTrip {
    private Stage subStage = new Stage();
    private Trip trip ;
    private Ticket ticket;
    private String fileName;
    private String userName;
    private final TripsFile tripsFile = new TripsFile();
    private int i=0;
    private final int x=0;
    public void draw()
    {
        
        //subStage.initModality(Modality.APPLICATION_MODAL);
        Label availableLabel = new Label();
        Label timeLabel = new Label("Time: "+ trip.getTime());
        Label dateLabel = new Label("Date: "+ trip.getDate());
        Label costLabel = new Label();
        availableLabel.setText("Trip is available");
        costLabel.setText("Price: "+ trip.getPrice());
        Button confirmButton = new Button("Buy");
        Button backButton = new Button("Back");
        VBox layout = new VBox(10);
        layout.getChildren().addAll(availableLabel, dateLabel ,timeLabel,costLabel , confirmButton , backButton);
        confirmButton.setOnAction((ActionEvent event) -> {
            tripsFile.search(fileName,trip);
            trip.setSeats(trip.getSeats()-1);
            tripsFile.setTrip(trip);
            tripsFile.setX(x);
            tripsFile.writeInFile(fileName);
            tripsFile.writeInFile(userName+".txt",trip.getId(),trip.getFrom(),
                    trip.getDestination(), trip.getVehicle(), trip.getWay(), 
                    trip.getStops() ,trip.getDate(),trip.getTime(), trip.getPrice());
            subStage.close();
        });
        backButton.setOnAction(e->subStage.close());
        Scene scene = new Scene(layout);
        subStage.setScene(scene);
        subStage.show();
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Stage getStage() {
        return subStage;
    }

    public void setStage(Stage stage) {
        this.subStage = stage;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    
}
