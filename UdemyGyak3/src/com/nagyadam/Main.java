package com.nagyadam;

public class Main {
    public static void main(String[] args){
        Car porsche = new Car(3, 4, "911","v8","red");
        Car holden = new Car(3,4,"Vaux","v4","blue");
        Suv BMW = new Suv(5, 4, "x6", "v8", "black", 7);
        Suv Audi = new Suv(3, 4, "Q7", "v8", "black", 7);




        /*Account Szamla1 = new Account(69420, 10000,"Nagy Adam", "nagyadam998@gmail.com", 205726963);
        System.out.println(Szamla1.getPhoneNumber());
        System.out.println(Szamla1.getBalance());
        Szamla1.depositFunds(5000);
        Szamla1.withdrawFunds(16000);*/


        Cylinder cylinder = new Cylinder(10,10);
        System.out.println(cylinder.getVolume());
    }
}
