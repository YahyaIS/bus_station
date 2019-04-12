
package triptableview;

import busstation.Trip;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DeleteTable extends TripTableView{
    private int index;
    private final HBox hb = new HBox();
    @Override
    void drawBox(Label label , Button button)
    {
        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction((ActionEvent event) -> {
            Trip selectedItem = (Trip) table.getSelectionModel().getSelectedItem();
            index=table.getSelectionModel().getSelectedIndex();
            trips[index].setSeats(0);
            tripsFile.setTrips(trips);
            tripsFile.writeInFile(fileName);
            table.getItems().remove(selectedItem);
            
        });
        hb.getChildren().clear();
        hb.getChildren().addAll(deleteButton);
        hb.setSpacing(3);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        
        vbox.getChildren().addAll(label ,button, table , hb );
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
    }
}