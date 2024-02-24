package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;

import java.util.Iterator;
import java.util.List;

public class CarFinder {
    public Car findById(String id, List<Car> carData){
        for(Car Car : carData){
            if(Car.getCarId().equals(id)){
                return Car;
            }
        }
        return null;
    }

    public Iterator<Car> findAll(List<Car> carData){
        return carData.iterator();
    }
}