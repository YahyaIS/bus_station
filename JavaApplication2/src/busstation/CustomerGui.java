package busstation;

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

public class CustomerGui {
    private Scene scene;
    private Stage stage;
    private String userName;
    private Login login;
    private CancelTicket cancelTicket;
    private ViewTickets viewTickets;
    private InternalTrips internalTrips;
    private ExternalTrips externalTrips;
    public CustomerGui() {
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

    public void setInternalTrips(InternalTrips internalTrips) {
        this.internalTrips = internalTrips;
    }
    
    private final GridPane grid= new GridPane();
    
public void draw(){
    Button externalTicketButton = new Button("Buy External ticket");
    Button internalTicketButton =  new Button("Buy Internal ticket");
    Button cancelTicketButton = new Button("Cancel ticket");
    Button logoutButton = new Button("Logout");
    Button view = new Button("View tickets");
    externalTicketButton.setPrefSize(150, 31);
    internalTicketButton.setPrefSize(150, 31);
    view.setPrefSize(80, 31);
    cancelTicketButton.setPrefSize(110, 31);
    logoutButton.setPrefSize(80, 31);
    externalTicketButton.setStyle("-fx-background-color: BLACK");
    internalTicketButton.setStyle("-fx-background-color: BLACK");
    view.setStyle("-fx-background-color: BLACK");
    cancelTicketButton.setStyle("-fx-background-color: BLACK");
    logoutButton.setStyle("-fx-background-color: BLACK");
    externalTicketButton.setTextFill(Color.AQUA);
    internalTicketButton.setTextFill(Color.AQUA);
    view.setTextFill(Color.AQUA);
    cancelTicketButton.setTextFill(Color.AQUA);
    logoutButton.setTextFill(Color.AQUA);
    grid.add(externalTicketButton,0,0);
    grid.add(internalTicketButton, 1, 0);
    grid.add(cancelTicketButton,0,1);
    grid.add(logoutButton,5,5);
    grid.add(view,1,1);
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
    grid.setAlignment(Pos.CENTER);
    externalTicketButton.setOnAction((ActionEvent event) -> {
        externalTrips.setUserName(userName);
        stage.setScene(externalTrips.getScene());
    });
    internalTicketButton.setOnAction((ActionEvent event) -> {
        
        internalTrips.setUserName(userName);
        stage.setScene(internalTrips.getScene());
    });
    cancelTicketButton.setOnAction((ActionEvent event) -> {
        cancelTicket.setUserName(userName);
        cancelTicket.draw();
        stage.setScene(cancelTicket.getScene());
    });
    
    view.setOnAction((ActionEvent event) -> {
        viewTickets.setUserName(userName);
        viewTickets.draw();
        stage.setScene(viewTickets.getScene());
    });
    
    
    logoutButton.setOnAction((ActionEvent event) -> {
        stage.setScene(login.getScene());
    });
    
    scene =new Scene(grid,800,700);
   
}

    public void setExternalTrips(ExternalTrips externalTrips) {
        this.externalTrips = externalTrips;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCancelTicket(CancelTicket cancelTicket) {
        this.cancelTicket = cancelTicket;
    }

    public ViewTickets getViewTickets() {
        return viewTickets;
    }

    

    public void setViewTickets(ViewTickets viewTickets) {
        this.viewTickets = viewTickets;
    }

    

    
    
    

    
}