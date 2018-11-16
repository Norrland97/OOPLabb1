public interface Movable {

    /**
     * Moves the car forwards, depending on the current speed and direction
     * (updates the coordinates of the car)
     */
    void move();

    /**
     * turns the car to the left by increasing currentDirection
     */
    void turnLeft();

    /**
     * turns the car to the right by decreasing currentDirection
     */
    void turnRight();

}
