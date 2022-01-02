package com.nagyadam.animal;

public class Animal {

    private String name;
    private int brain;
    private int body;
    private int size;
    private int weight;

    public Animal(String name, int brain, int body, int size, int weight) {
        this.name = name;
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weight = weight;
    }

    public void compareWeight( Animal param){
        if(this.getWeight()>param.getWeight()){
            System.out.println(this.name+" is heavier");
        }else{
            System.out.println(param.name+" is heavier");
        }
    }

    public void eat(){
        this.setWeight(this.getWeight()+1);
    }
    public void move(){
        this.setWeight(this.getWeight()-1);
    }

    public String getName() {
        return name;
    }

    public int getBrain() {
        return brain;
    }

    public int getBody() {
        return body;
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrain(int brain) {
        this.brain = brain;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
