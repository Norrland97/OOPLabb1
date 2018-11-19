import java.awt.*;
import java.lang.*;

/**
 * Represents a car and the abilities it has, which includes the number of doors, the engine power
 * the current speed, the current direction, the current position, the color of the car and the model name.
 */

public class Car implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private double currentDirection;
    private Point currentPos;
    private Color color; // Color of the car
    private String modelName; // The car model name

    /**
     * The constructor of Car
     *
     * @param nrDoors     The ammount of doors for the new car
     * @param enginePower The power of the enging in Horsepower
     * @param color       The color of the Car
     * @param modelName   The modelname of the car
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        this.modelName = modelName;
        this.currentDirection = 0;
        this.currentPos = new Point(0, 0);
    }

    //----------------Getters and setters----------------


    /**
     * @return Returns the position of the car
     */
    public Point getCurrentPos() {
        return currentPos;
    }



    /**
     * @return Returns current direction of Car
     */
    public double getCurrentDirection() {
        return currentDirection;
    }



    /**
     * @return Returns the ammount of doors on the Car
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * @return Returns the power of the engine of the car
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * @return Returns the speed of the car
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * @return returns the color of the car
     */
    public Color getColor() {
        return color;
    }

    /**
     * changes the color of the car
     *
     * @param clr the color of the car
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * "Starts up the engine"
     * Actually: gives the car an small ammount of speed
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Sets the speed of the car to 0, The car stops;
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * An internal method to get the speed factor of the car
     *
     * @return speedFactor, the base speedfactor of Car
     */
    protected double speedFactor() {
        return enginePower * 0.1;
    }

    //--------Change speed----------

    /**
     * A method used to increase the speed of the car based of the cars speedFactor and the ammount
     * given to increase it. Cannot increase the speed of the car higher than enginePower.
     *
     * @param amount A value between 0 and 1 given to increase the speed of the car;
     */
    private void incrementSpeed(double amount) {

        currentSpeed = getCurrentSpeed() + speedFactor() * amount;

        if(currentSpeed >= enginePower)
            currentSpeed = enginePower;

    }

    /**
     * This lowers the speed of the car
     *
     * @param amount The amount of the speed to slow down the car. Cannot lower the speed of the car
     *               lower than 0.
     */
    private void decrementSpeed(double amount) {

        currentSpeed = getCurrentSpeed() - speedFactor() * amount;

        if(currentSpeed < 0)
            currentSpeed = 0;
    }

    //-------------movement of the car------------


    /**
     * Moves the car forwards, depending on the current speed and direction
     * (updates the coordinates of the car)
     */
    @Override
    public void move() {


        currentPos.x = (int) Math.round(currentPos.x + Math.cos(currentDirection) * currentSpeed);
        currentPos.y = (int) Math.round(currentPos.y + Math.sin(currentDirection) * currentSpeed);


    }


    /**
     * turns the car to the left by increasing currentDirection
     */
    @Override
    public void turnLeft() {
        currentDirection++;
    }

    /**
     * turns the car to the right by decreasing currentDirection
     */
    @Override
    public void turnRight() {
        currentDirection--;
    }


    /**
     * A method used to increase the speed of the car based of the cars speedFactor and the ammount
     * given to increase it. Cannot increase the speed of the car higher than enginePower.
     *
     * @param amount A value between 0 and 1 given to increase the speed of the car;
     */
    public void gas(double amount) {
        if(amount < 0 ){
            amount = 0;
        } else if (amount > 1){
            amount = 1;
        }
        incrementSpeed(amount);
    }

    /**
     * This lowers the speed of the car
     *
     * @param amount The amount of the speed to slow down the car cannot be lower than 0 or higher than 1
     */
    public void brake(double amount) {
        if(amount < 0 ){
            amount = 0;
        } else if (amount > 1){
            amount = 1;
        }
        decrementSpeed(amount);
    }
}
