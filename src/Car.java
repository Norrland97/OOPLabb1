import java.awt.*;

public class Car implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private double currentDirection;
    private Point currentPos;
    private Color color; // Color of the car
    private String modelName; // The car model name

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        this.modelName = modelName;
        this.currentDirection = 0;
        this.currentPos = new Point(0,0);
    }

    //----------------Getters and setters----------------


    public Point getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(Point currentPos) {
        this.currentPos = currentPos;
    }

    public double getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(double currentDirection) {
        this.currentDirection = currentDirection;
    }


    public int getNrDoors() {
        return nrDoors;
    }

    protected double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    protected double speedFactor() {
        return enginePower * 0.1;
    }

    //--------Change speed----------

    protected void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * This lowers the speed of the car
     * @param amount The amount of the speed to slow down the car
     */
    protected void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
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




    @Override
    public void turnLeft() {
        currentDirection++;
    }

    @Override
    public void turnRight() {
        currentDirection--;
    }
}
