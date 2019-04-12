

package triptableview;

import busstation.Trip;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddTable extends TripTableView{
    private final HBox hb = new HBox();
    private String[] allD = new String[100];
    private final String[] allV = new String[3];
    private final String[] allW = new String[2];
    private final String[] allS = new String[3];

    @Override
    void drawBox(Label label , Button button)
    {
        Label errorLabel = new Label();
        final TextField addIdField = new TextField();
        addIdField.setPromptText("Id:");
        addIdField.setMaxWidth(idColumn.getPrefWidth());
        final TextField addFromField = new TextField();
        addFromField.setPromptText("From:");
        addFromField.setMaxWidth(fromColumn.getPrefWidth());
        final TextField addDestinationField = new TextField();
        addDestinationField.setPromptText("Destination:");
        addDestinationField.setMaxWidth(destinationColumn.getPrefWidth());
        final TextField addVehicleField = new TextField();
        addVehicleField.setMaxWidth(vehicleColumn.getPrefWidth());
        addVehicleField.setPromptText("Vehicle:");
        final TextField addWayField = new TextField();
        addWayField.setMaxWidth(wayColumn.getPrefWidth());
        addWayField.setPromptText("Way:");
        final TextField addStopField = new TextField();
        addStopField.setMaxWidth(stopColumn.getPrefWidth());
        addStopField.setPromptText("Stop:");
        final TextField addDateField = new TextField();
        addDateField.setPromptText("Date:");
        addDateField.setMaxWidth(dateColumn.getPrefWidth());
        final TextField addTimeField = new TextField();
        addTimeField.setPromptText("Time:");
        addTimeField.setMaxWidth(timeColumn.getPrefWidth());
        final TextField addCostField = new TextField();
        addCostField.setMaxWidth(costColumn.getPrefWidth());
        addCostField.setPromptText("Cost:");
        final TextField addSeatsField = new TextField();
        addSeatsField.setMaxWidth(seatsColumn.getPrefWidth());
        addSeatsField.setPromptText("Seats:");
        final Button addButton = new Button("Add");
        
        addButton.setOnAction((ActionEvent e) -> {
            fillAll();
            if(verifyDestination(addDestinationField.getText())&&
                    verifyFrom(addFromField.getText())&&verifyVehicle(addVehicleField.getText())
                    &&verifyWay(addWayField.getText())&&verifyStop(addStopField.getText()))
            {
            data.add(new Trip(
                    addIdField.getText(),
                    addFromField.getText(),
                    addDestinationField.getText(),
                    addVehicleField.getText(),
                    addWayField.getText(),
                    addStopField.getText(),
                    addDateField.getText(),
                    addTimeField.getText(),
                    addCostField.getText(),
                    Integer.valueOf(addSeatsField.getText())
            ));
                Trip trip1=new Trip(addIdField.getText(),addFromField.getText(),
                        addDestinationField.getText(),addVehicleField.getText(),
                        addWayField.getText(), addStopField.getText(), 
                        addDateField.getText(),addTimeField.getText(),
                        addCostField.getText(), 
                        Integer.parseInt(addSeatsField.getText()));
                trips[i]=trip1;
            tripsFile.setTrips(trips);
            tripsFile.writeInTripFile(fileName);
                    addIdField.clear();
                    addFromField.clear();
                    addDestinationField.clear();
                    addVehicleField.clear();
                    addWayField.clear();
                    addStopField.clear();
                    addDateField.clear();
                    addTimeField.clear();
                    addCostField.clear();
                    addSeatsField.clear();
            }
            else
            {
                errorLabel.setText("Unavailable Trip !");
            }
        });
        hb.getChildren().clear();
        hb.getChildren().addAll(addIdField ,addFromField ,addDestinationField ,addVehicleField, addWayField, addStopField,addDateField ,addTimeField , addCostField ,addSeatsField , addButton );
        hb.setSpacing(3);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        
        vbox.getChildren().addAll(label ,button, table , hb ,errorLabel);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
    }
    boolean verifyDestination(String dString )
    {
        int j=0;
        while(allD[j]!=null)
        {
            if(dString.equals(allD[j])){
                    return true;}
                j++;
        }
        return false;
    }
    boolean verifyFrom(String fString )
    {
        int j=0;
        while(allD[j]!=null)
        {
            if(fString.equals(allD[j])){
                    return true;}
                j++;
        }
        return false;
    }
    boolean verifyVehicle(String vString)
    {
        int j;
        for(j=0;j<3;j++)
            if(vString.equals(allV[j])){
                    return true;}
        return false;
    }
    boolean verifyWay(String wString)
    {
        int j;
        for(j=0;j<2;j++)
            if(wString.equals(allW[j])){
                    return true;}
        return false;
    }
    boolean verifyStop(String sString)
    {
        int j;
        for(j=0;j<3;j++)
            if(sString.equals(allS[j])){
                    return true;}
        return false;
    }
    void fillAll()
    {
        if(fileName.equals("InternalTrips.txt"))
            allD=tripsFile.readCity("Internal.txt");
        else
            allD=tripsFile.readCity("External.txt");
        allV[0]="Bus";
        allV[1]="Mini-Bus";
        allV[2]="Limo";
        allW[0]="one-way";
        allW[1]="round-trip";
        allS[0]="no-stop";
        allS[1]="one-stop";
        allS[2]="multi-stop";
        
    }
}


