import static java.lang.Math.*;


public class Point3d extends Point2d{
    //доступен только в этом классе и в классе-наследнике
    private double zCoord;
    //конструктор инициализации
    public Point3d(double x, double y, double z) {
        super(x, y);
        zCoord=z;
    }
    //конструктор по умолчанию
    public Point3d () {
        this(0, 0, 0);
    }
    //возвращает значение координат Z
    public double getZ () {
        return zCoord;
    }
    //устанавливает значение координат Z
    public void setZ ( double val) {
        zCoord = val;
    }
    //проверяет, что все значения двух объектов равны
    public boolean isEquals(Point3d n) {
        return ((getX() ==  n.getX()) && (getY() ==  n.getY()) && (getZ() ==  n.getZ()));
    }
    //возвращает расстояние между двумя точками
    public double distanceTo(Point3d p) {
        return sqrt(pow(p.getX() - getX(), 2) + pow(p.getY() - getY(), 2) + pow(p.getZ() - getZ(), 2));
    }
}
