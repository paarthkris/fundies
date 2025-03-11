package uk.ac.nulondon;


import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*APPLICATION SERVICE LAYER*/
public final class ImageEditor {

    private Image image;


    /**
     * Loads the image from the file path. PLEASE DO NOT CHANGE
     * @param filePath File path, e. g. /home/img.png
     * @throws IOException If the file is missing or cannot be read
     */
    public void load(String filePath) throws IOException {
        File originalFile = new File(filePath);
        BufferedImage img = ImageIO.read(originalFile);
        image = new Image(img);
    }

    public void save(String filePath) throws IOException {
        BufferedImage img = image.toBufferedImage();
        ImageIO.write(img, "png", new File(filePath));
    }


    public int getWidth() {
        return image.getWidth();
    }


}
