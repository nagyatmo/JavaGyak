package com.nagyadam;

public class Suv extends Car{
    private int seats;
    public Suv(int doors, int wheels, String model, String engine, String colour, int seats){
        super();
        this.seats=seats;
    }



    public static void compareDoorCount(Suv a, Suv b){
        if(a.getDoors()>b.getDoors()){
            System.out.println(a.getModel() + " model has more doors");
        }else{
            System.out.println(b.getModel() + " model has more doors");
        }
    }
}
