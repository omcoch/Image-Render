package renderer;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test draw an image
 */
class ImageWriterTest {

    /**
     * Test for basic image write
     */
    @Test
    public void FirstImageTest() {
        ImageWriter imageWriter = new ImageWriter("our first image", 1600, 1000, 800, 500);
        int Nx = imageWriter.getNx();
        int Ny = imageWriter.getNy();
        for (int i = 0; i < Ny; i++) {
            for (int j = 0; j < Nx; j++) {
                if (i % 50 == 0 || j % 50 == 0) {
                    imageWriter.writePixel(j, i, Color.YELLOW);
                } else {
                    imageWriter.writePixel(j, i, Color.BLUE);
                }
            }
        }
        imageWriter.writeToImage();
    }
}