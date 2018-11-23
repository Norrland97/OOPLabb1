import java.awt.*;

public class Car extends Vehicle {

    private int nrDoors;

    public Car(double enginePower, Color color, String modelName, int nrDoors) {
        super(enginePower, color, modelName);
        this.nrDoors = nrDoors;
    }

    /**
     * @return Returns the ammount of doors on the Car
     */
    public int getNrDoors() {
        return nrDoors;
    }

}
