package busstation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;




public class ViewTickets implements TicketTabelView{
    
    
    private Stage stage;
    private Scene scene;
    private CustomerGui customerGui ;
    private String userName;
    private Ticket[] tickets = new Ticket[100];
    private final TableView table;
    private final TripsFile tripsFile = new TripsFile();
    private int i;
    public ViewTickets() {
        this.table = new TableView();
    }
    private TableColumn idColumn;
    private TableColumn fromColumn;
    private TableColumn destinationColumn;
    private TableColumn vehicleColumn;
    private TableColumn wayColumn;
    private TableColumn stopColumn;
    private TableColumn dateColumn;
    private TableColumn timeColumn;
    private TableColumn costColumn;
    
    protected final ObservableList<Ticket> data =FXCollections.observableArrayList();
    @Override
     public void draw(){
         if(userName!=null)
         {
        i=0;
        tickets=tripsFile.readTicketFile(userName+ ".txt");
        data.clear();
        while(tickets[i]!=null)
        {
            Ticket ticket1=new Ticket(tickets[i].getId(),tickets[i].getFrom(),
                    tickets[i].getDestination(),tickets[i].getVehicle(), 
                    tickets[i].getWay(), tickets[i].getStops(),tickets[i].getDate()
                    ,tickets[i].getTime(),tickets[i].getPrice());
            data.add(ticket1);
            i++;
        }
         }
        scene = new Scene(new Group());
        stage.setWidth(700);
        stage.setHeight(700);
        final Label label = new Label("Tickets");
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
        table.getColumns().clear();
        table.setItems(data);
        table.getColumns().addAll(idColumn,fromColumn,destinationColumn, 
                vehicleColumn, wayColumn , stopColumn ,dateColumn,timeColumn, costColumn );

        backButton.setOnAction((ActionEvent event) -> {
            stage.setScene(customerGui.getScene());
        });
        
        final HBox hb = new HBox();
        
       
        hb.setSpacing(3);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label ,backButton, table , hb );
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
        
    }

    
    
      public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setCustomerGui(CustomerGui customerGui) {
        this.customerGui = customerGui;
    }

    public String getUserName() {
        return userName;
    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    
    
    
    
    
    
}
