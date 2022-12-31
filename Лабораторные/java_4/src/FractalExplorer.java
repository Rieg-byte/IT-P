import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

/**
 * Класс исследует различные области фрактала, путем его создания,
 * отображения через графический интерфейс Swing и обработки событий,
 * вызванных взаимодействием приложения с пользователем
 */
public class FractalExplorer {
    private int size; //Размер экрана
    private JImageDisplay jDisplay; //Ссылка для обновления отображения в разных методах в процессе вычисления фрактала
    private FractalGenerator fractal; //Будет использоваться ссылка на базовый класс для отображения других видов фракталов в будущем
    private Rectangle2D.Double range; //Объект, указывающий диапазон комплексной плоскости, которая выводится на экран

    /**
     * конструктор, который принимает значение размера отображения в качестве аргумента,
     * затем сохраняет это значение в соответствующем поле, а также инициализует объекты
     * диапазона и фрактального генератора
     * @param display_size
     */
    public FractalExplorer (int display_size) {
        size = display_size;
        range = new Rectangle2D.Double();
        fractal = new Mandelbrot();
        fractal.getInitialRange(range);
        jDisplay = new JImageDisplay(display_size, display_size);
    }

    /**
     * Метод инициализирует графический интерфейс Swing: JFrame,
     * содержащий объект JimageDisplay, и кнопку для сброса отображения.
     */
    public void createAndShowGUI () {
        jDisplay.setLayout(new BorderLayout());
        JFrame frame = new JFrame();
        frame.add(jDisplay, BorderLayout.CENTER);
        JButton button = new JButton("Reset");
        frame.add(button, BorderLayout.SOUTH);
        MyActionListener clearAction = new MyActionListener();
        button.addActionListener(clearAction);
        MyMouseListener mouse = new MyMouseListener();
        jDisplay.addMouseListener(mouse);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /**
     * Метод с типом доступа private для вывода на экран фрактала
     */
    private void drawFractal () {
        for (int x = 0; x < size; x ++) {
            for (int y = 0; y < size; y ++) {
                double xCoord = fractal.getCoord(range.x,range.x + range.width, size, x);
                double yCoord = fractal.getCoord(range.y, range.y + range.height, size, y);
                int iterations = fractal.numIterations(xCoord,yCoord);
                if (iterations == -1) jDisplay.drawPixel(x,y,0);
                else {
                    float hue = 0.7f + (float) iterations / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    jDisplay.drawPixel(x, y, rgbColor);
                }
            }
        }
        jDisplay.repaint();
    }

    /**
     * Класс для обработки событий от кнопки сброса.
     * Обработчик должен сброчить диапазон к начальному,
     * определенному генератором, а затем перерисовать фрактал
     */
    public class MyActionListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            fractal.getInitialRange(range);
            drawFractal();
        }
    }

    /**
     * Класс для обработки работы мыши дисплея
     */
    private class MyMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            double xCoord = fractal.getCoord(range.x, range.x+range.width, size,x);
            int y = e.getY();
            double yCoord = fractal.getCoord(range.y, range.y+range.height, size,y);
            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }

    public static void main (String[] args) {
        FractalExplorer display = new FractalExplorer(300);
        display.createAndShowGUI();
        display.drawFractal();
    }
}