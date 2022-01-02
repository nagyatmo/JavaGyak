package com.nagyadam;

public class Car {

    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    public Car(int doors, int wheels, String model, String engine, String colour){
        this.doors=doors;
        this.wheels=wheels;
        this.model=model;
        this.engine=engine;
        this.colour=colour;
    }
    public Car() {

    }
    public int getDoors(){
        return this.doors;
    }
    public void setDoors(int a){
        this.doors=a;
    }

    public String getModel(){
        return this.model;
    }

    public static void compareDoorCount(Car a, Car b){
        if(a.getDoors()>b.getDoors()){
            System.out.println(a.getModel() + " model has more doors");
        }else{
            System.out.println(b.getModel() + " model has more doors");
        }
    }
}
