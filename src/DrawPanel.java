import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This panel represent the animated part of the view with the car images.
 */

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize fixa en satans HashMap JUH :D
    private List<BufferedImage> vehicleImages = new ArrayList<>();
    // To keep track of a singel cars position
    Point vehiclePoint = new Point();

    // TODO: Make this genereal for all cars (typ gå igenom en lista med alla bilar och kolla deras position...)
    void moveit(int x, int y) {
        vehiclePoint.x = x;
        vehiclePoint.y = y;
    }

    /**
     * Initializes the panel and reads the images
     */
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);

        //print an error message in case file is not found with a try/catch block

        try {
            BufferedImage vehicleImage = ImageIO.read(new File("src" + File.separator + "pics" + File.separator + "Volvo240.jpg"));
            vehicleImages.add(vehicleImage);
            vehicleImages.add(ImageIO.read(new File("src" + File.separator + "pics" + File.separator + "Saab95.jpg")));
            vehicleImages.add(ImageIO.read(new File("src" + File.separator + "pics" + File.separator + "Scania.jpg")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    String getFilePath(){
        return null;//TODO ersätt filsökvägen från där uppe och gör den generisk
    }

    /**
     * This method is called each time the panel updates/refreshes/repaints itself
     */
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int offset = 0; //TODO kan göras bättre tydligen (Getposition)

        for (BufferedImage image : vehicleImages) {
            g.drawImage(image, vehiclePoint.x, vehiclePoint.y + offset, null); // see javadoc for more info on the parameters
            offset = offset + 100;
        }
    }
}
