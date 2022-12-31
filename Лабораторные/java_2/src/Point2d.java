public class Point2d {
    //доступен только в этом классе и в классе-наследнике
    private double xCoord;
    //доступен только в этом классе и в классе-наследнике
    private double yCoord;
    //конструктор инициализации
    public Point2d ( double x, double y) {
        xCoord = x;
        yCoord = y;
    }
    //конструктор по умолчанию
    public Point2d () {
        this(0, 0);
    }
    //возвращает значение координат X, Y
    public double getX () {
        return xCoord;
    }
    public double getY () {
        return yCoord;
    }
    //устанавливает значение координат X, Y
    public void setX ( double val) {
        xCoord = val;
    }
    public void setY ( double val) {
        yCoord = val;
    }
}