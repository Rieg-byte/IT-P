import java.util.Arrays;

public class Task2 {
    public static void main(String args[]) {
        //Использование функции repeat 1
        System.out.println("№1 Использование функции repeat");
        System.out.println(repeat("mice", 5));
        System.out.println(repeat("stop", 1));
        //Использование функции differenceMaxMin 2
        System.out.println("№2 Использование функции differenceMaxMin");
        System.out.println(differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println(differenceMaxMin(new int[]{44, 32, 86, 19}));
        //Использование функции isAvgWhole 3
        System.out.println("№3 Использование функции isAvgWhole");
        System.out.println(isAvgWhole(new int[]{1, 3}));
        System.out.println(isAvgWhole(new int[]{1, 2, 3, 4}));
        //Использование функции cumulativeSum 4
        System.out.println("№4 Использование функции cumulativeSum");
        System.out.println(Arrays.toString(cumulativeSum(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(cumulativeSum(new int[]{1, -2, 3})));
        //Использование функции getDecimalPlaces 5
        System.out.println("№5 Использование функции getDecimalPlaces");
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("240222"));
        System.out.println(getDecimalPlaces("24.2"));
        //Использование функции fibonacci
        System.out.println("№6 Использование функции fibonacci");
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(7));
        //Использование функции isValid
        System.out.println("№7 Использование функции isValid");
        System.out.println(isValid("59001"));
        System.out.println(isValid("853a7"));
        System.out.println(isValid("732 32"));
        System.out.println(isValid("393939"));
        //Использование функции isStrangePair
        System.out.println("№8 Использование функции isStrangePair");
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));
        //Использование функции isPrefix и isSuffix
        System.out.println("№9 Использование функции isPrefix и isSuffix");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isPrefix("word", "n-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isSuffix("notebook", "-bake"));
        //Использование функции boxSeq
        System.out.println("№10 Использование функции boxSeq");
        System.out.println(boxSeq(0));
        System.out.println(boxSeq(1));
        System.out.println(boxSeq(5));
    }

    //Метод, который повторяет каждый символ в строке n раз. 1
    public static String repeat(String word, int n) {
        String result = "";
        for (int x = 0; x < word.length(); x++) {
            for (int y = 0; y < n; y++) {
                result += word.charAt(x);
            }
        }
        return result;
    }

    //Метод возвращает разницу между максимальным и минимальным числом массива чисел. 2
    public static int differenceMaxMin(int[] arrayOfNumbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x = 0; x < arrayOfNumbers.length; x++) {
            if (arrayOfNumbers[x] < min) {
                min = arrayOfNumbers[x];
            }
            if (arrayOfNumbers[x] > max) {
                max = arrayOfNumbers[x];
            }
        }
        return max - min;
    }

    //Метод, который проверяет, что среднее значение массива чисел является целым числом
    //Возвращает true или false. 3
    public static boolean isAvgWhole(int[] arrayOfNumbers) {
        double average = 0;
        for (int x = 0; x < arrayOfNumbers.length; x++) {
            average += arrayOfNumbers[x];
        }
        return (average % (arrayOfNumbers.length - 1)==0);
    }

    /*
    Метод, который берет массив целых чисел и возвращает массив, в
    котором каждое целое число является суммой самого себя + всех предыдущих
    чисел в массиве. 4
     */
    public static int[] cumulativeSum(int[] arrayOfNumbers) {
        for (int x = 0; x < (arrayOfNumbers.length - 1); x++) {
            arrayOfNumbers[x + 1] = arrayOfNumbers[x] + arrayOfNumbers[x + 1];
        }
        return arrayOfNumbers;
    }

    /*
    Метод, который возвращает число десятичных знаков, которое имеет
    число (заданное в виде строки). 5
     */
    public static int getDecimalPlaces(String number) {
        int decimalsNumbers = number.indexOf(".");//возвращает индекс данной точки в строке
        if (decimalsNumbers != -1) {
            int l = (number.length() - 1) - decimalsNumbers;
            return l;
        } else return 0;
    }

    /*
    Метод, который возвращает число Фибоначчи 6
     */
    public static int fibonacci(int number) {
        if (number == 0) return 0;
        else if (number <= 2) return 1;
        else return fibonacci(number - 1) + fibonacci(number - 2);
    }

    /*
    Почтовые индексы состоят из 5 последовательных цифр. Учитывая строку,
    напишите функцию, чтобы определить, является ли вход действительным
    почтовым индексом. Действительный почтовый индекс выглядит следующим
    образом:
    – Должно содержать только цифры (не допускается использование нецифровых цифр).
    – Не должно содержать никаких пробелов.
    – Длина не должна превышать 5 цифр.
     */
    public static boolean isValid(String postcode) {
        if (postcode.length() <= 5 && !postcode.contains(" ")) {
            for (int x = 0; x < postcode.length(); x++) {
                char c = postcode.charAt(x);
                if (((int) c < 48) || ((int) c > 57)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /*
    Пара строк образует странную пару, если оба из следующих условий истинны:
    – Первая буква 1-й строки = последняя буква 2-й строки.
    – Последняя буква 1-й строки = первая буква 2-й строки.
    – Создайте функцию, которая возвращает true, если пара строк представляет собой
    странную пару, и false в противном случае.
     */
    public static boolean isStrangePair(String w1, String w2){
        if (w1.isEmpty() && w2.isEmpty()) return true;
        return (w1.charAt(0) == w2.charAt(w2.length() - 1)) && (w1.charAt(w1.length() - 1) == w2.charAt(0));
    }

    /*
    Создайте две функции: isPrefix(word, prefix-) и isSuffix (word, -suffix).
    isPrefix должен возвращать true, если он начинается с префиксного аргумента.
    isSuffix должен возвращать true, если он заканчивается аргументом суффикса.
    В противном случае верните false.
     */
    public static boolean isPrefix(String word, String prefix){
        String p = "";
        for (int x=0; x<=prefix.length()-2; x++){
            p+=word.charAt(x);
        }
        return (p + "-").equals(prefix);
    }

    public static boolean isSuffix(String word, String suffix){
        String p = "";
        for (int x=word.length()-1; x>((word.length()-1)-(suffix.length()-1)); x--){
            p+=word.charAt(x);
        }
        return ("-" + reverseString(p)).equals(suffix);
    }

    public static String reverseString(String s){
        String x = "";
        for (int i = s.length()-1; i>=0; i--){
            x += s.charAt(i);
        }
        return x;
    }

    /*
    Создайте функцию, которая принимает число (шаг) в качестве аргумента и
    возвращает количество полей на этом шаге последовательности.
    Шаг 0: начните с 0
    Шаг 1: Добавьте 3
    Шаг 2: Вычтите 1
    Повторите Шаги 1 И 2 ...
     */
    public static int boxSeq(int n){
        int count = 0;
        if (n==0) return 0;
        for (int x = 1; x<=n; x++){
            if (x%2!=0) count+=3;
            else count--;
        }
        return count;
    }

}

