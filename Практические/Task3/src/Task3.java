public class Task3 {
    public static void main(String[] args) {
        //Используем функцию solutions
        System.out.println("1 Используем функцию solutions");
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));
        //Используем функцию findZip
        System.out.println("2 Используем функцию findZip");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));
        System.out.println(findZip("all files are compressed"));
        //Используем функцию checkPerfect
        System.out.println("3 Используем функцию checkPerfect");
        System.out.println(checkPerfect(12));
        System.out.println(checkPerfect(496));
        //Используем функцию flipEndChair
        System.out.println("4 Используем функцию flipEndChair");
        System.out.println(flipEndChars("ada"));
        System.out.println(flipEndChars("Ad"));
        //Используем функцию isValidHexCode;
        System.out.println("5 Используем функцию isValidHexCode");
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CZVC5Z"));
        System.out.println(isValidHexCode("CD5C5Z"));
        //Используем функцию same;
        System.out.println("6 Используем функцию same");
        System.out.println(same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.println(same(new int[]{9, 8, 7, 6}, new int[]{4, 4, 3, 1}));
        System.out.println("7 Используем функцию isKaprekar");
        System.out.println(isKaprekar(3));
        System.out.println("8 Используем функцию longestZero");
        System.out.println(longestZero("01101000000011000"));
        System.out.println("9 Используем функцию nextPrime");
        System.out.println(nextPrime(11));
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println("10 Используем функцию rightTriangle");
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(145, 105, 100) );
        System.out.println(rightTriangle(70, 130, 110) );


    }

    //Возвращает количество корней квадратного уравнения
    public static int solutions(int a, int b, int c) {
        int d = b * b - 4 * a * c;
        if (d > 0) return 2;
        else if (d == 0) return 1;
        else return 0;
    }

    //Возвращает позицию второго вхождения "zip"
    public static int findZip(String s) {
        int x = s.indexOf("zip");
        int x1 = s.indexOf("zip", x + 1);
        return x1;
    }

    //Проверяет ли число совершенным. Совершенное число - это число, которое можно записать как
    //сумму его множителей, исключая само число.
    public static boolean checkPerfect(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }

    //Меняет между собой первый символ и последний, если длина строки меньше двух и 1 и -1 символ не равны между собой
    public static String flipEndChars(String s) {
        if (s.length() >= 2) {
            char startChar = s.charAt(0);
            char endChar = s.charAt(s.length() - 1);
            if (startChar != endChar) return endChar + s.substring(1, s.length() - 1) + startChar;
            else return "Two's a pair";
        } else return "Incompatible";
    }

    //Проверяет является ли строка допустимым шестнадцатеричным кодом
    public static boolean isValidHexCode(String s) {
        boolean result = true;
        char startChar = s.charAt(0);
        if (startChar == '#' && s.length() == 7) {
            for (int i = 1; i <= s.length() - 1; i++) {
                int c = s.charAt(i);
                if ((c >= 48 && c <= 57) || (c >= 97 && c <= 102) || (c >= 65 && c <= 70)) result=true;
                else return false;
            }
            return result;
        } else return false;
    }

    //Функция, которая возвращает true, если два массива имеют одинаковое
    //количество уникальных элементов, и false в противном случае.
    public static boolean same(int[] a, int[] a1) {
        int k = 0;
        int k1 = 0;
        for (int i = 1; i <= a.length - 1; i++) {
            if (a[i] != a[i - 1]) k += 1;
        }
        for (int i = 1; i <= a1.length - 1; i++) {
            if (a1[i] != a1[i - 1]) k1 += 1;
        }
        return k == k1;
    }

    //Число Капрекара
    //Число Капрекара-это положительное целое число, которое после возведения в
    //квадрат и разбиения на две лексикографические части равно сумме двух
    //полученных новых чисел:
    public static boolean isKaprekar(int n) {
        int square = n * n;
        String s = "" + square;
        String l = "";
        String r = "";
        double count = s.length();
        if (count % 2 == 0 && s.length() > 1) {
            for (int i = 0; i <= (s.length() - 1) / 2; i++) {
                l += s.charAt(i);
            }
            for (int i = ((s.length()) / 2); i <= (s.length() - 1); i++) {
                r += s.charAt(i);
            }
        } else if (count % 2 != 0 && s.length() > 1) {
            for (int i = 0; i <= ((s.length()) / 2) - 1; i++) {
                l += s.charAt(i);
            }
            for (int i = ((s.length()) / 2); i <= (s.length() - 1); i++) {
                r += s.charAt(i);
            }
        } else {
            for (int i = 0; i <= s.length() - 1; i++) {
                l += "0";
                r += s.charAt(i);
            }
        }
        int sum = Integer.parseInt(l) + Integer.parseInt(r);
        return sum == n;
    }

    //я возвращает самую длинную последовательность
    //последовательных нулей в двоичной строке.
    public static String longestZero(String s) {
        String result = "";
        int max = 0;
        int min = Integer.MIN_VALUE;
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                max += 1;
                r += s.charAt(i);
            } else {
                if (max > min) {
                    min = max;
                    max = 0;
                    result = r;
                    r = "";
                } else {
                    r = "";
                }
            }
        }
        return result;
    }

    //возвращает следующее
    //простое число
    public static int nextPrime(int num) {
        int result = -1;
        for (int n = num; n < Integer.MAX_VALUE; n++) {
            if (isPrime(n)){
                result = n;
                break;
            }
        }
        return result;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n > 2;
    }

    //является ли стороны ребрами прямоугольного треугольника
    public static boolean rightTriangle(int x, int y, int z) {
        int hypo = Math.max(Math.max(x, y), z);
        int minC = Math.min(Math.min(x, y), z);
        int medC = 0;
        if(hypo > x && x > minC) medC = x;
        else if(hypo > y && y > minC) medC = y;
        else medC = z;
        return (hypo*hypo) == (medC*medC + minC*minC);
    }
}


