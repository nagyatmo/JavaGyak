package OOP.practise.two;

public class Mitsubishi extends Car{
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    public String startEngine(){
        return this.getName()+"'s engine is starting.";
    }
    public String accelerate(){
        return this.getName() + " is accelerating";
    }
    public String brake(){
        return this.getName() +" is braking";
    }

}
