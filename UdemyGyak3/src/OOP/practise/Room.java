package OOP.practise;

public class Room{
    private double area;
    private boolean hasBed;

    public Room(double area, boolean hasBed) {
        this.area = area;
        this.hasBed = hasBed;
    }

    public double getArea() {
        return area;
    }

    public boolean isHasBed() {
        return hasBed;
    }

    public void makeBed(){
        System.out.println("Bed is cleaned.");
    }

    public void enterRoom(){
        System.out.println("Entered the room.");
    }
}
