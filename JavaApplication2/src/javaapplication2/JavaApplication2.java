
package javaapplication2;

import triptableview.AddTable;
import triptableview.AssignDriver;
import busstation.CustomerGui;
import busstation.Login;
import busstation.InternalTrips;
import busstation.CancelTicket;
import triptableview.DeleteTable;
import busstation.DriverGui;
import busstation.ExternalTrips;
import busstation.ManagerGui;
import busstation.ViewTasks;
import busstation.ViewTickets;
import triptableview.ViewTrips;
import javafx.application.Application;
import javafx.stage.Stage;

public class JavaApplication2 extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Login login =new Login();
        login.setStage(stage);
        login.draw();
        CustomerGui customerGui =new CustomerGui();
        customerGui.setStage(stage);
        customerGui.draw();
        InternalTrips internalTrips = new InternalTrips();
        internalTrips.setStage(stage);
        internalTrips.draw();
        ExternalTrips externalTrips = new ExternalTrips();
        externalTrips.setStage(stage);
        externalTrips.draw();
        CancelTicket cancelTicket = new CancelTicket();
        cancelTicket.setStage(stage);
        cancelTicket.draw();
        customerGui.setCancelTicket(cancelTicket);
        cancelTicket.setCustomerGui(customerGui);
        ViewTickets viewTickets = new ViewTickets();
        viewTickets.setStage(stage);
        viewTickets.draw();
        customerGui.setViewTickets(viewTickets);
        viewTickets.setCustomerGui(customerGui);
        
        ManagerGui managerGui = new ManagerGui();
        managerGui.setStage(stage);
        managerGui.draw();
        managerGui.setLogin(login);
        DriverGui driverGui = new DriverGui();
        driverGui.setStage(stage);
        driverGui.draw();
        ViewTasks viewTasks =new ViewTasks();
        viewTasks.setStage(stage);
        viewTasks.draw();
        driverGui.setViewTasks(viewTasks);
        viewTasks.setDriverGui(driverGui);
        login.setDriverGui(driverGui);
        driverGui.setLogin(login);
        ViewTrips tripTableView = new ViewTrips() ;
        tripTableView.setStage(stage);
        tripTableView.draw();
        managerGui.setTripTableView(tripTableView);
        tripTableView.setManagerGui(managerGui);
        AddTable addTable = new AddTable();
        addTable.setStage(stage);
        addTable.draw();
        DeleteTable deleteTable = new DeleteTable();
        deleteTable.setStage(stage);
        deleteTable.draw();
        AssignDriver assignDriver=new AssignDriver();
        assignDriver.setStage(stage);
        assignDriver.draw();
        managerGui.setAssignDriver(assignDriver);
        assignDriver.setManagerGui(managerGui);
        managerGui.setDeleteTable(deleteTable);
        deleteTable.setManagerGui(managerGui);
        managerGui.setAddTable(addTable);
        addTable.setManagerGui(managerGui);
        login.setManagerGui(managerGui);
        login.setCustomerGui(customerGui);
        customerGui.setLogin(login);
        customerGui.setExternalTrips(externalTrips);
        customerGui.setInternalTrips(internalTrips);
        externalTrips.setCustomerGui(customerGui);
        internalTrips.setCustomerGui(customerGui);
        stage.setTitle("Bus Station");
        stage.setScene(login.getScene());
       
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);    
    }
    
}
