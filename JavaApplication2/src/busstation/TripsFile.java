
package busstation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public final class TripsFile {
    private  File tripFile ;
    private String[] city=new String[100];
    private Trip[] trips = new Trip[100];
    private Ticket[] tickets = new Ticket[100];
    private int j;
    private int x,y,z,p;
    private File ticketFile ;
    private File driverFile;
    private File citiesFile;
    public TripsFile() {
    }
    
    public  String[] readCity(String fileName)
    {
        citiesFile=new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(citiesFile));
            String line=bufferedReader.readLine();
            int i=0;
            while(line!=null)
            {
                StringTokenizer Tok = new StringTokenizer(line);
                while (Tok.hasMoreElements())
                {
                    String city1=Tok.nextToken();
                    city[i]=city1;
                    i++;
                }
                
                line=bufferedReader.readLine();
                
            }
            city[i]=null;
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return city;
    
    }
    
    public Trip[]  readFile(String fileName) {
        tripFile=new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(tripFile));
            String line=bufferedReader.readLine();
            int i=0;
            while(line!=null)
            {
                StringTokenizer Tok = new StringTokenizer(line);
                while (Tok.hasMoreElements())
                {
                    Trip trip =new Trip(Tok.nextToken(), Tok.nextToken(),
                            Tok.nextToken(), Tok.nextToken(), Tok.nextToken(),
                            Tok.nextToken(),Tok.nextToken(),Tok.nextToken(),
                            Tok.nextToken(),Integer.parseInt(Tok.nextToken()));
                    trips[i]=trip;
                    i++;
                }
                
                line=bufferedReader.readLine();
                
            }
            trips[i]=null;
            y=i;
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return trips;
    }
    
    Ticket[] readTicketFile(String fileName)
    {
        ticketFile= new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(ticketFile));
            String line=bufferedReader.readLine();
            int i=0;
            while(line!=null)
            {
                StringTokenizer Tok = new StringTokenizer(line);
                while (Tok.hasMoreElements())
                {
                    Ticket ticket =new Ticket(Tok.nextToken(),Tok.nextToken(),
                            Tok.nextToken(),Tok.nextToken(),Tok.nextToken(), Tok.nextToken(),
                            Tok.nextToken(), Tok.nextToken(), Tok.nextToken());
                    tickets[i]=ticket;
                    i++;
                }
                line=bufferedReader.readLine();
                
            }
            tickets[i]=null;
            z=i;
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        
        return tickets;
    }
    
    Ticket[] readDriverFile(String fileName)
    {
        driverFile= new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(driverFile));
            String line=bufferedReader.readLine();
            int i=0;
            while(line!=null)
            {
                StringTokenizer Tok = new StringTokenizer(line);
                while (Tok.hasMoreElements())
                {
                    Ticket ticket =new Ticket(Tok.nextToken(),Tok.nextToken(),
                            Tok.nextToken(),Tok.nextToken(),Tok.nextToken(), Tok.nextToken(),
                            Tok.nextToken(), Tok.nextToken(),null);
                    tickets[i]=ticket;
                    i++;
                }
                line=bufferedReader.readLine();
                
            }
            z=i;
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        
        return tickets;
    }
    
    public void writeInTicketFile(String fileName,int o)
    {
        ticketFile = new File(fileName);
        try {
            int i=0;
            try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(ticketFile)))) {
                    if(i==o)
                            i++;
                    
                p=getZ();
                    if(i!=p)
                    {
                     printWriter.write(tickets[i].getId()+ " "+tickets[i].getFrom()
                            + " "+tickets[i].getDestination()+ " "+ 
                            tickets[i].getVehicle()+" "+ tickets[i].getWay()+" "
                            + tickets[i].getStops()+ " "+ tickets[i].getDate()
                            + " "+tickets[i].getTime()+ " "+tickets[i].getPrice());
                     printWriter.append("\r\n");
                     i++;
                    }
                while(i<p)
                    {
                        if(i==o)
                            i++;
                        
                        
                        if(i==p)
                            break;
                        printWriter.append(tickets[i].getId()+ " "+tickets[i].getFrom()
                            + " "+tickets[i].getDestination()+ " "+ 
                            tickets[i].getVehicle()+" "+ tickets[i].getWay()+" "
                            + tickets[i].getStops()+ " "+ tickets[i].getDate()
                            + " "+tickets[i].getTime()+ " "+tickets[i].getPrice());
                        printWriter.append("\r\n");
                        i++;
                    }
                
                printWriter.close();
                //System.out.println();
            }
        } catch (IOException ex) {
        }
    }
    
    public void writeInTripFile(String fileName)
    {
        tripFile=new File(fileName);
        try {
            int i=0;
            try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(tripFile)))) {
                     
                     printWriter.write(trips[i].getId()+ " "+trips[i].getFrom()+
                            " "+trips[i].getDestination()+ " "+ 
                             trips[i].getVehicle()+" "+ trips[i].getWay()+" "
                            + trips[i].getStops()+ " "+ trips[i].getDate()+ 
                             " "+trips[i].getTime()+ " "+trips[i].getPrice()+ " " 
                             +trips[i].getSeats());
                     x=getY();
                for(i=1;i<x+1;i++)
                    {
                        printWriter.append("\r\n");
                        printWriter.write(trips[i].getId()+ " "+trips[i].getFrom()+
                            " "+trips[i].getDestination()+ " "+ 
                             trips[i].getVehicle()+" "+ trips[i].getWay()+" "
                            + trips[i].getStops()+ " "+ trips[i].getDate()+ 
                             " "+trips[i].getTime()+ " "+trips[i].getPrice()+ " " 
                             +trips[i].getSeats());
                    }
                
                printWriter.close();
                //System.out.println();
            }
        } catch (IOException ex) {
        }
    }
    
        public void writeInFile(String fileName ,String id,String from, 
                String destination,String vehicle,String way,String stop,String date,String time,String cost){
        ticketFile=new File(fileName);
            try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(ticketFile, true)))) {
                
                    printWriter.append(id+ " "+from+ " "+ destination+" "+vehicle+" "+ way+" "
                            + stop+ " "+ date+ " "+time+ " "+cost);
                    printWriter.append("\r\n");
                    printWriter.close();
                    } catch (IOException ex) {
        }
            
    }
            
       
        
       public void writeInFile(String fileName){
        try {
            tripFile= new File(fileName);
            int i=0;
            try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(tripFile)))) {
                while(trips[i].getSeats()==0)
                    i++;
                x=getY();
                if(i!=x)
                {
               printWriter.write(trips[i].getId()+ " "+trips[i].getFrom()+
                            " "+trips[i].getDestination()+ " "+ 
                             trips[i].getVehicle()+" "+ trips[i].getWay()+" "
                            + trips[i].getStops()+ " "+ trips[i].getDate()+ 
                             " "+trips[i].getTime()+ " "+trips[i].getPrice()+ " " 
                             +trips[i].getSeats());
               i++;
                }
               while(i<x)
                    {
                        //i++;
                        if(trips[i].getSeats()==0)
                        {
                            i++;
                        }
                        
                        printWriter.append("\r\n");
                        if(i==x)
                            break;
                        printWriter.write(trips[i].getId()+ " "+trips[i].getFrom()+
                            " "+trips[i].getDestination()+ " "+ 
                             trips[i].getVehicle()+" "+ trips[i].getWay()+" "
                            + trips[i].getStops()+ " "+ trips[i].getDate()+ 
                             " "+trips[i].getTime()+ " "+trips[i].getPrice()+ " " 
                             +trips[i].getSeats());
                        i++;
                    }
                
                printWriter.close();
            }
        } catch (IOException ex) {
        }
    }
       
       public void writeDriverFile(String name ,Trip trip)
       {
           driverFile = new File(name);
        
            try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(driverFile,true)))) {
                    
                    printWriter.append(trip.getId()+ " "+trip.getFrom()
                            + " "+trip.getDestination()+ " "+ 
                            trip.getVehicle()+" "+ trip.getWay()+" "
                            + trip.getStops()+ " "+ trip.getDate()
                            + " "+trip.getTime());
                    printWriter.append("\r\n");
                     
                printWriter.close();
            
        } catch (IOException ex) {
        }
       }
       public boolean search(String fileName,Trip trip)
    {
        readFile(fileName);
        j=0;
            while(trips[j]!=null)
            {
                if(trip.getFrom().equals(trips[j].getFrom()))
                {
                if(trip.getDestination().equals(trips[j].getDestination()))
                {
                    if(trip.getVehicle().equals(trips[j].getVehicle()))
                    {
                        if(trip.getWay().equals(trips[j].getWay()))
                        {
                            if(trip.getStops().equals(trips[j].getStops()))
                            {
                                return true;
                            }
                        }
                    }
                }
            }
                j++;
            }
        return false;
    }

    public int getZ() {
        return z;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public Trip getTrip(){
        return trips[j];
    }
    public void setTrip(Trip trip){
        trips[j]=trip;
    }
    public Trip[] getTrips() {
        return trips;
    }

    public void setTrips(Trip[] trips) {
        this.trips = trips;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public int getJ() {
        return j;
    }

    

}