package com.nagyadam.animal;

public class Main {
    public static void main(String[] args){
        Animal animal = new Animal("Animal", 1, 1,5, 5);
        Dog yorkie = new Dog("Yorkie",1,1,2,4,1,4,"long silky");
        Dog shiba = new Dog("Shiba",1,1,2,6,1,4,"short silky");
        System.out.println(shiba.getWeight());
        shiba.eat();
        System.out.println(shiba.getWeight());
        shiba.move();
        shiba.move();
        shiba.move();
        System.out.println(shiba.getWeight());

        shiba.compareWeight(yorkie);
    }
}
