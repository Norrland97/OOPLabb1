import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {

    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    // A list of cars, modify if needed
    static List<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(100, Color.green, "Volvo240", 2));
        cc.cars.add(new Saab95(100, Color.green, "Saab95", 2, false));
        cc.cars.add(new Scania(100, Color.green, "Scania", 2));

        cc.frame.drawPanel.setVehicles(cc.cars);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /**
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getCurrentPos().getX());
                int y = (int) Math.round(car.getCurrentPos().getY());

                if (x < 0) {
                    x = 0;
                    inverseDirection(car);
                } else if (x + 120 > frame.getWidth()) {
                    x = frame.getWidth() - 120;
                    inverseDirection(car);
                }
                if (y < 0) {
                    y = 0;
                    inverseDirection(car);
                } else if (y + 120 > frame.getHeight()) {
                    y = frame.getHeight() - 120;
                    inverseDirection(car);
                }

                //TODO fixa som metod och gå igenom varje bil!
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // ----------- Methods to connect the buttons to actions ---------------

    /**
     * Calls the start engine method for each car once
     */
    void startEngine() {
        for (Car car : cars)
            car.startEngine();
    }

    /**
     * Calls the gas method for each car once
     */
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    /**
     * Calls the brake method for each car once
     */
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void setTurboOn(){
        for (Car c: cars){
            if (c.toString().equals("Saab95")){
                Saab95 s = (Saab95) c;
                s.setTurboOff();
            }
        }
    }

    void setTurboOff(){
        for (Car c: cars){
            if (c.toString().equals("Saab95")){
                Saab95 s = (Saab95) c;
                s.setTurboOn();
            }
        }
    }

    void lowerScaniaFlatBed(){
        for (Car c: cars){
            if (c.toString().equals("Scania")){
                Scania s = (Scania) c;
                for(int i = 0; i < 70; i++)
                    s.lowerBedAngle();
            }
        }
    }

    void raiseScaniaFlatBed(){
        for (Car c: cars){
            if (c.toString().equals("Scania")){
                Scania s = (Scania) c;
                for(int i = 0; i < 70; i++)
                    s.raiseBedAngle();
            }
        }
    }

    private void inverseDirection(Car car){
        for(int i = 0; i < 4; i++){
            car.turnLeft();
        }
    }

}
