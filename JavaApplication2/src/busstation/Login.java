
package busstation;

import filelogin.FileCustomerLogin;
import filelogin.FileDriverLogin;
import filelogin.FileManagerLogin;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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

public class Login {
    private Scene scene;
    private Stage stage;
    private ManagerGui managerGui = new ManagerGui();
    private DriverGui driverGui = new DriverGui();
    private String userName;
    private CustomerGui customerGui;
    private final FileCustomerLogin fileCustomerLogin = new FileCustomerLogin();
    private final FileManagerLogin fileMangerLogin = new FileManagerLogin();
    private final FileDriverLogin fileDriverLogin = new FileDriverLogin();
    private final GridPane grid =new GridPane();
    
    public Login() {
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
        //
    }
    public void draw(){
        Text usernameLabel =new Text("Username:");
        Text passwordLabel =new Text("Password:");
        TextField usernameField =new TextField();
        PasswordField passwordField =new PasswordField();
        Text commentLabel = new Text();
        RadioButton customerButton = new RadioButton("Customer");
        RadioButton driverButton = new RadioButton("Driver");
        RadioButton managerButton = new RadioButton("Manager");
        Button loginButton = new Button("Login");
        ToggleGroup group = new ToggleGroup();
        customerButton.setToggleGroup(group);
        //customerButton.setSelected(true);
        driverButton.setToggleGroup(group);
        managerButton.setToggleGroup(group);
       
        Image img = new Image("file:Bus-Station-Chiang-Mai-5.jpg");
        BackgroundImage background = new BackgroundImage(img,
                                                     BackgroundRepeat.NO_REPEAT,
                                                     BackgroundRepeat.NO_REPEAT,
                                                     BackgroundPosition.DEFAULT,
                                                     BackgroundSize.DEFAULT);
        grid.setBackground(new Background(background));
        grid.setMinWidth(img.getWidth());
        grid.setMinHeight(img.getHeight());
        grid.add(usernameLabel, 0, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(usernameField, 1, 0);
        grid.add(passwordField, 1, 1);
        grid.add(loginButton,6 ,2);
        grid.add(commentLabel, 0, 3);
        grid.add(customerButton, 0, 2);
        grid.add(driverButton, 1, 2);
        grid.add(managerButton, 2, 2);
        grid.setAlignment(Pos.CENTER);
        usernameLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        usernameLabel.setFill(Color.YELLOW); 
        passwordLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        passwordLabel.setFill(Color.YELLOW);
        commentLabel.setFill(Color.YELLOW);
        customerButton.setStyle("-fx-text-fill: yellow;");
        driverButton.setStyle("-fx-text-fill: yellow;");
        managerButton.setStyle("-fx-text-fill: yellow;");
        scene =new Scene(grid,800,700);
        loginButton.setOnAction((ActionEvent event) -> {
            userName=usernameField.getText();
            String passWord=passwordField.getText();
            if(customerButton.isSelected()){
                if(fileCustomerLogin.checkValidity(userName, passWord))
                {
                    customerGui.setUserName(userName);
                    stage.setScene(customerGui.getScene());
                    commentLabel.setText(" ");
                }
                else
                    commentLabel.setText("Invalid username or password!");
            }
            else if(driverButton.isSelected()){
                    if(fileDriverLogin.checkValidity(userName, passWord))
                {
                    Driver driver=fileDriverLogin.getDriver();
                    driverGui.setDriver(driver);
                    driverGui.draw();
                    stage.setScene(driverGui.getScene());
                    commentLabel.setText(" ");
                }
                else
                    commentLabel.setText("Invalid username or password!");
            }
            else if(managerButton.isSelected()){
                 if(fileMangerLogin.checkValidity(userName, passWord))
                {
                    stage.setScene(managerGui.getScene());
                    commentLabel.setText(" ");
                }
                else
                    commentLabel.setText("Invalid username or password!");
            }
            usernameField.clear();
            passwordField.clear();
            
        });
    }

    public void setCustomerGui(CustomerGui customerGui) {
        this.customerGui = customerGui;
    }

    public void setManagerGui(ManagerGui managerGui) {
        this.managerGui = managerGui;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public String getUserName() {
        return userName;
    }

    
public void setDriverGui(DriverGui driverGui) {
        this.driverGui = driverGui;
    }
}
