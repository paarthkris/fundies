package uk.ac.nulondon;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public final class Image {
    private List<List<Color>> columns;

    private int width;
    private int height;


    public Image(BufferedImage img) {
        width = img.getWidth();
        height = img.getHeight();
        columns = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            List<Color> column = new ArrayList<>();
            columns.add(column);
            for (int j = 0; j < height; j++) {
                column.add(new Color(img.getRGB(i, j)));
            }
        }
    }

    public BufferedImage toBufferedImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color pixel = columns.get(i).get(j);
                image.setRGB(i, j, pixel.getRGB());
            }
        }
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Color> highlightColumn(int i) {
        if( i < 0 || i >= columns.size()){
            throw new IndexOutOfBoundsException("Invalid column index");

        }

        List<Color> highlightedColumn = new ArrayList<>(columns.get(i));
        for (int j = 0; j < height; j++){
            Color c = highlightedColumn.get(j);
            highlightedColumn.set(j, new Color(255, c.getGreen(), c.getBlue()));
        }
        
        return highlightedColumn;
    }

    public List<Color> removeColumn(int i) {
        if(i >= 0 && i <= columns.size()){
            return columns.remove(i);     
        }
        return List.of(null);
    }

    public void addColumn(int index, List<Color> column) {
        //TODO
    }

    public int getGreenest() {
        //TODO
        return 0;
    }
}
