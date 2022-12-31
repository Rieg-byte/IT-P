import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
//отображает фрактал
public class JImageDisplay extends JComponent{
    //Управляет изображением, содержимое которого можно записать
    private BufferedImage image;
    //Инициализирует объект класса BufferedImage новым изображением
    //с этой высотой, шириной и типом изображения
    //также вызывает метод setPreferredSize, чтобы ему передать объект класса Dimension
    public JImageDisplay (int h, int w) {
        image = new BufferedImage(h,w, BufferedImage.TYPE_INT_RGB);
        Dimension size = new Dimension(h,w);
        super.setPreferredSize(size);
    }

    //выводит на экран данные изображения
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,image.getWidth(),image.getHeight(),null);

    }

    //устанавлвиает все пиксели изображения в чёрный цвет
    public void clearImage() {
        for (int i=0; i < image.getHeight(); i++ ) {
            for (int j = 0; j < image.getWidth(); j ++) {
                drawPixel(i,j,0);
            }
        }
    }

    //устанавливает пиксель в определённый цвет
    public void drawPixel (int x, int y, int rgbColor) {
        image.setRGB(x,y,rgbColor);
    }
}