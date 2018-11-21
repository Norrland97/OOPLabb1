import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class CarTrailer extends Car {

    private Boolean flatBedDown;
    private final int maxLoad = 5;
    private Stack<Car> loadedCars = new Stack<>();

    public CarTrailer(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors, enginePower, color, modelName);
        this.flatBedDown = false;
    }

    public void lowerFlatBed(){
        if(getCurrentSpeed() == 0)
            flatBedDown = true;
        else
            System.out.println("Cant lower flat bed while driving");
    }

    public void raiseFlatBed(){
        flatBedDown = false;
    }

    public void loadCar(Car car){

        if (flatBedDown && loadedCars.size() <= maxLoad){
            loadedCars.push(car);
            //Update position of car to the position of CarTrailer
        }else{
            System.out.println("Can only load car when flat bed is down.");
        }
    }

    public void unloadCar(){

        Car car = loadedCars.peek();

        if (flatBedDown && loadedCars.size() > 0){
            loadedCars.pop();
            //Update position of car to the position of CarTrailer
        }else{
            System.out.println("Can only load car when flat bed is down.");
        }
    }

}
