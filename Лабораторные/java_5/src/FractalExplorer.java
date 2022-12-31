import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

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
        JButton resetButton = new JButton("Reset");
        ResetButtonHandler clearAction = new ResetButtonHandler();
        resetButton.addActionListener(clearAction);
        MyMouseListener mouse = new MyMouseListener();
        jDisplay.addMouseListener(mouse);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        String[] items = {"Mandelbrot", "Tricorn", "BurningShip"};
        JComboBox comboBox = new JComboBox(items);
        JLabel label = new JLabel("Fractal:");
        JPanel panelBox = new JPanel();
        panelBox.add(label);
        panelBox.add(comboBox);
        frame.add(panelBox, BorderLayout.NORTH);

        ChooseButtonHandler chooseAction = new ChooseButtonHandler();
        comboBox.addActionListener(chooseAction);

        JButton saveButton = new JButton("Save Image");
        SaveImageButton saveAction = new SaveImageButton();
        saveButton.addActionListener(saveAction);
        JPanel panelButtons = new JPanel();
        panelButtons.add(resetButton);
        panelButtons.add(saveButton);
        frame.add(panelButtons, BorderLayout.SOUTH);

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




    /**
     * Класс для обработки кнопки сброса
     */
    public class ResetButtonHandler implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            fractal.getInitialRange(range);
            drawFractal();
        }
    }

    /**
     * Класс для обработки кнопки выбора с выпадающим списком
     */
    public class ChooseButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JComboBox combo = (JComboBox)e.getSource();
            String name = (String) combo.getSelectedItem();
            if (name == "Mandelbrot"){
                fractal = new Mandelbrot();
            }
            if (name == "Tricorn") {
                fractal = new Tricorn();
            }
            if (name == "BurningShip") {
                fractal = new BurningShip();
            }
            fractal.getInitialRange(range);
            drawFractal();
        }
    }

    /**
     * Класс для обработки кнопки сохранения изображения
     */
    public class SaveImageButton implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
            chooser.setFileFilter(filter);
            chooser.setAcceptAllFileFilterUsed(false);
            int result = chooser.showSaveDialog(jDisplay);
            if (result == JFileChooser.APPROVE_OPTION) {
                File dir = chooser.getSelectedFile();
                String dir_string = dir.toString();
                try{
                    BufferedImage image = jDisplay.getImage();
                    ImageIO.write(image, "png", dir);
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(chooser, exception.getMessage(),"Can not save image", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }


    public static void main (String[] args) {
        FractalExplorer display = new FractalExplorer(300);
        display.createAndShowGUI();
        display.drawFractal();
    }
}