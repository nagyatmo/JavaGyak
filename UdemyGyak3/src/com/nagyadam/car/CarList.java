package com.nagyadam.car;

import com.nagyadam.Car;

import java.util.ArrayList;

public class CarList {
    private ArrayList<Car> cars = new ArrayList<Car>();

    public void addCars(Car param){
        cars.add(param);
    }

    public void getCars(){
        for(int i=0;i<cars.size();i++){
            System.out.println(cars.get(i).getModel());
        }
    }
}
