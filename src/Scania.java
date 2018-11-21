import java.awt.*;

public class Scania extends Car {

    private final double flatBedAngle;

    /**
     * The constructor of Scania
     *  @param nrDoors     The ammount of doors for the new car
     * @param enginePower The power of the enging in Horsepower
     * @param color       The color of the Car
     * @param modelName   The modelname of the car
     * @param flatBedAngle  The current angle of the flatbed
     */
    public Scania(int nrDoors, double enginePower, Color color, String modelName, double flatBedAngle) {
        super(nrDoors, enginePower, color, modelName);
        this.flatBedAngle = flatBedAngle;
    }

    public double getFlatBedAngle() {
        return flatBedAngle;
    }

    
}
