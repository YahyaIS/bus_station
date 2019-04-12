
package filelogin;

import java.io.File;
import java.util.HashMap;

public class FileManagerLogin extends FileLogin{

    public FileManagerLogin() {
        file= new File("managerAccounts.txt");
        users = new HashMap();
    }
    
}
