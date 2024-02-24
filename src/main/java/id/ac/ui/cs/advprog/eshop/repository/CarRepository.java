package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;
import id.ac.ui.cs.advprog.eshop.repository.CarFinder;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class CarRepository {
    static int id = 0;
    private List<Car> carData = new ArrayList<>();
    private CarFinder carFinder = new CarFinder();
    public Car create(Car car){
        if(car.getCarId() == null){
            UUID uuid = UUID.randomUUID();
            car.setCarId(uuid.toString());
        }
        carData.add(car);
        return car;
    }

    public Iterator<Car> findAll(){
        return carFinder.findAll(carData);
    }

    public Car findById(String id){
        return carFinder.findById(id, carData);
    }

    public Car update(String id, Car updatedCar){
        for (int i = 0; i < carData.size(); i++) {
            Car car = carData.get(i);
            if(car.getCarId().equals(id)){
                car.setCarName(updatedCar.getCarName());
                car.setCarColor(updatedCar.getCarColor());
                car.setCarQuantity(updatedCar.getCarQuantity());
                return car;
            }
        }
        return null; // Handle the case where the car is not found
    }

    public void delete(String id){carData.removeIf(car -> car.getCarId().equals(id));}
}