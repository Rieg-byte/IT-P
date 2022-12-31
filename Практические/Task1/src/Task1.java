public class Task1 {
    public static void main (String args[]){
        System.out.println(remainder(5, 5));
        System.out.println(remainder(3, 4));
        System.out.println(remainder(-9, 45));
        System.out.println(remainder(5, 5));
        System.out.println(triArea(3, 2));
        System.out.println(triArea(10, 10));
        System.out.println(animals(2, 3, 5));
        System.out.println(animals(1, 2, 3));
        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(profitableGamble(0.9, 1, 2));
        System.out.println(operation(24, 15, 9));
        System.out.println(operation(24, 26, 2));
        System.out.println(operation(3, 6, 2));
        System.out.println(operation(3, 1, 3));
        System.out.println(operation(24, 23236, 2));
        System.out.println(ctoa('A'));
        System.out.println(ctoa('A'));
        System.out.println(addUpTo(3));
        System.out.println(addUpTo(10));
        System.out.println(nextEdge(9, 2));
        System.out.println(nextEdge(3, 6));
        System.out.println(sumOfCubes(new int[]{1, 5, 9}));
        System.out.println(sumOfCubes(new int[]{2}));
        System.out.println(sumOfCubes(new int[]{}));
        System.out.println(abcmath(5, 2, 1));

    }

    //метод, который возвращает остаток
    public static int remainder(int n1, int n2){
        return n1%n2;
    }

    //метод, который возвращает площадь треугольника
    public static int triArea(int a, int h){
        return (a*h)/2;
    }

    /*метод, который возвращает общее количество ног всех животных
    chickens = 2 legs
    cows = 4 legs
    pigs = 4 legs
     */
    public static int animals(int a, int b, int c){
        return a*2+b*4+c*4;
    }

    //метод, который принимает три аргумента
    //возвращает true если a*b>c и false, если иначе
    public static boolean profitableGamble(double a, int b, int c){
        return a * b > c;
    }

    //принимает три числа и возвращает что нужно сделать с a и b, чтобы получить N
    public static String operation(int n, int a, int b){
        if (a+b==n){
            return "сложить";
        } else if (a-b==n){
            return "вычесть";
        }
        else if (a*b==n) {
            return "умножить";
        }else if (a/b==n) {
            return "разделить";
        }
        else{
            return "none";
        }
    }

    //возвращает значение ASCII переданного символа
    public static int ctoa(char x){
        return x;
    }

    /*
    метод, который берет последнее число из последовательного списка
    чисел и возвращает сумму всех чисел до него и включая его.
     */
    public static int addUpTo(int x) {
        int result=0;
        for (int i = 1; i <= x; i++) {
            result += i;
        }
        return result;
    }

    /*
    метод, который находит максимальное значение третьего ребра
    треугольника, где длины сторон являются целыми числами.
     */
    public static int nextEdge(int n1, int n2) {
        int maxC = 0;
        int minC = 999999;
        for (int i=1; i<=n1+n2; i++){
            if ((n1+n2>i)&&(n1+i>n2)&&(i+n2>n1)){
                if (i<minC){
                    minC = i;
                }
            }
        }
        return minC;
    }

    /*
    метод, который получает на вход массив чисел и возвращает сумму его кубов
     */
    public static int sumOfCubes(int[] x) {
        int sum = 0;
        for (int i=0; i<x.length; i++){
            sum += x[i]*x[i]*x[i];
        }
        return sum;
    }

    //метод который добавляет a b раз и возвращает true, если сумма a делится на c
    public static boolean abcmath(int a, int b, int c) {
        for (int i=0; i<b; i++){
            a += a;
        }
        return a % c == 0;
    }
}
