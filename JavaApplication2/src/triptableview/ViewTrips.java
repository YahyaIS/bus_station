
package triptableview;

import triptableview.TripTableView;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ViewTrips extends TripTableView{
    
    @Override
    void drawBox(Label label , Button button)
    {
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label , button, table);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
    }
    
}
