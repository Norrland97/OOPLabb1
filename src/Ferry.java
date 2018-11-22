public class Ferry implements Movable {

    private CarTrailer parent;



    @Override
    public void move() {
        parent.move();
    }

    @Override
    public void turnLeft() {
        parent.turnLeft();
    }

    @Override
    public void turnRight() {
        parent.turnRight();
    }

    public void loadCar(Car car){
        
    }
}
