package triptableview;

import busstation.Trip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;



public class AssignDriver extends TripTableView{
    private final HBox hb = new HBox();
    @Override
    void drawBox(Label label , Button button)
    {
        Text errorText = new Text();
        Button submitButton = new Button("Submit");
        ObservableList<String> driverList = 
    FXCollections.observableArrayList(
        "ostaseif",
        "sherbini"
        
    );
final ComboBox driverBox = new ComboBox(driverList);
        Text driverText = new Text("Driver:");
        submitButton.setOnAction((ActionEvent event) -> {
            if (driverBox.getValue() != null && !driverBox.getValue().toString().isEmpty()){
                String name =driverBox.getValue().toString();
                Trip selectedItem = (Trip) table.getSelectionModel().getSelectedItem();
                tripsFile.writeDriverFile(name+".txt",selectedItem);
                stage.setScene(managerGui.getScene());
            }
            else ;
        });
        
        hb.getChildren().addAll(driverText ,driverBox ,submitButton ,errorText);
        hb.setSpacing(3);
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        
        vbox.getChildren().addAll(hb,label , button, table);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
    }
}
