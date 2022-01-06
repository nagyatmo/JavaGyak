package OOP.practise.two;

public class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name){
        this.cylinders=cylinders;
        this.name=name;
        this.engine=true;
        this.wheels=4;
    }
    public String startEngine(){
        return name+"'s engine is starting.";
    }
    public String accelerate(){
        return name + " is accelerating";
    }
    public String brake(){
        return name +" is braking";
    }
    public int getCylinders(){
        return cylinders;
    }
    public String getName(){
        return name;
    }
}

