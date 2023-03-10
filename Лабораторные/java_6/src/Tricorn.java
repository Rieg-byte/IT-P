import java.awt.geom.Rectangle2D;

//Фрактал Tricorn
public class Tricorn extends FractalGenerator {
    public static final int MAX_ITERATIONS = 2000;


    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2;
        range.width = 4;
        range.height = 4;
    }


    public int numIterations(double x, double y) {
        int iteration = 0;
        double z_real = 0;
        double z_imaginary = 0;
        while (iteration < MAX_ITERATIONS && z_real * z_real + z_imaginary * z_imaginary < 4) {
            double z_realUpdated = z_real * z_real - z_imaginary * z_imaginary + x;
            double z_imaginaryUpdated = -2 * z_real * z_imaginary + y;
            z_real = z_realUpdated;
            z_imaginary = z_imaginaryUpdated;
            iteration += 1;
        }
        if (iteration == MAX_ITERATIONS) {
            return -1;
        }
        return iteration;
    }


    public String toString() {
        return "Tricorn";
    }
}
