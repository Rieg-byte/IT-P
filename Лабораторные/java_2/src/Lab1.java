import java.util.Scanner;


public class Lab1 {
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите данные для 1 точки");
        Point3d point1 = new Point3d(in.nextDouble(), in.nextDouble(),in.nextDouble());
        System.out.println("Введите данные для 2 точки");
        Point3d point2 = new Point3d(in.nextDouble(), in.nextDouble(),in.nextDouble());
        System.out.println("Введите данные для 3 точки");
        Point3d point3 = new Point3d(in.nextDouble(), in.nextDouble(),in.nextDouble());
        System.out.println(computeArea(point1, point2, point3));
    }
    // Метод вычисляет площадь треугольника
    public static double computeArea(Point3d point1, Point3d point2, Point3d point3) {
        // Если одна из точек равна другой то площадь не вычисляется
        if (point1.isEquals(point2) || point2.isEquals(point3) || point3.isEquals(point1)) {
            return 0;
        } else {
            double a = point1.distanceTo(point2);
            double b = point2.distanceTo(point3);
            double c = point3.distanceTo(point1);
            double p = (a+b+c)/2;
            return (Math.sqrt(p*(p-a)*(p-b)*(p-c)));
        }
    }
}
