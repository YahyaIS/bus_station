
package busstation;

public class Trip {
    private String id;
    private String from;
    private String destination;
    private String vehicle;
    private String way;
    private String stops;
    private String price;
    private String date;
    private String time;
    private int seats;

    public Trip(String id, String from, String destination, String vehicle, 
            String way, String stops, String date, String time, String price,
            int seats) {
        this.id = id;
        this.from = from;
        this.destination = destination;
        this.vehicle = vehicle;
        this.way = way;
        this.stops = stops;
        this.price = price;
        this.date = date;
        this.time = time;
        this.seats = seats;
    }

    

    
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDestination() {
        return destination;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getWay() {
        return way;
    }

    public String getStops() {
        return stops;
    }

    public String getPrice() {
        return price;
    }

    public int getSeats() {
        return seats;
    }
    
}
