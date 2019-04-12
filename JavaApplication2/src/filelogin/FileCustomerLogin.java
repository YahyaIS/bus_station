
package filelogin;

import java.io.File;
import java.util.HashMap;

public class FileCustomerLogin extends FileLogin{

    public FileCustomerLogin() {
        file= new File("passengerAccounts.txt");
        users = new HashMap();
    }
    
}
