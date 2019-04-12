
package filelogin;

import busstation.Driver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FileDriverLogin extends FileLogin{
    private final Driver[] drivers=new Driver[10];
    private Driver driver;
    private int i=0;
    public FileDriverLogin() {
        file= new File("driverAccounts.txt");
        users = new HashMap();
    }

    @Override
    public void readFile() {
        
        try {
            BufferedReader bufferReader = new BufferedReader(new FileReader(file));
            String text=bufferReader.readLine();
            while(text!=null)
            {
                StringTokenizer Tok = new StringTokenizer(text,",");

        while (Tok.hasMoreElements())
        {
            Driver driver1=new Driver(Tok.nextToken(), Tok.nextToken(), Tok.nextToken()
                    , Tok.nextToken(), Tok.nextToken());
            users.put(driver1.getName(),driver1.getPassWord() );
        drivers[i]=driver1;
        }
        i++;
                text=bufferReader.readLine();
            }
            drivers[i]=null;
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        
    }
    @Override
    public boolean checkValidity(String name , String pass){
        readFile();
        i=0;
        if(users.containsKey(name))
        {
            passWord =users.get(name);
            if(pass.equals(passWord))
            {
                while(drivers[i]!=null)
                {
                if(drivers[i].getName().equals(name))
                {
                driver=drivers[i];
                return true;
                }
                i++;
                }
            }
        }
        return false;
    }
    public Driver getDriver() {
        return driver;
    }

    
}
