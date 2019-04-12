
package filelogin;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FileLogin {
    protected File file ;
    protected String accounts =null;
    protected HashMap<String, String> users;
    protected String userName;
    protected String passWord;
    
    public FileLogin() {
        //writeInFile(accounts, file);
        users = new HashMap();
    }
//    public void writeInFile(String accounts ,File file){
//        try {
//            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
//            printWriter.write(accounts);
//            printWriter.close();
//            System.out.println(accounts);
//        } catch (IOException ex) {
//        }
//    }
//            
    public void readFile() {
        
        try {
            BufferedReader bufferReader = new BufferedReader(new FileReader(file));
            String text=bufferReader.readLine();
            while(text!=null)
            {
                StringTokenizer Tok = new StringTokenizer(text );

        while (Tok.hasMoreElements())
        {
                users.put(Tok.nextToken(), Tok.nextToken());
                
        }
                text=bufferReader.readLine();
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        
    }
    public boolean checkValidity(String name , String pass){
        readFile();
                
        if(users.containsKey(name))
        {
            passWord =users.get(name);
            if(pass.equals(passWord))
            {
                return true;
            }
        }
        return false;
    }


}
