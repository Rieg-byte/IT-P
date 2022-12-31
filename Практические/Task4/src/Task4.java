import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Task4 {
    public static void main(String[] args) {
        System.out.println("1 Задание");
        essay(10, 7, "hello my name is Bessie and this is my essay");
        essay(6, 12, "legendary Finnish NKVD from Kizlyar masters");
        System.out.println();

        System.out.println("2 Задание");
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));

        System.out.println("3 Задание");
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toCamelCase("geran_iran_russia"));
        System.out.println(toSnakeCase("malorossiyaZov"));
        System.out.println(toSnakeCase("baZa"));
        System.out.println(toSnakeCase("finkaNkvd"));
        System.out.println();

        System.out.println("4 Задание");
        System.out.println(overTime(9, 17, 30, 1.5F));
        System.out.println(overTime(16, 18, 30, 1.8F));
        System.out.println(overTime(13.25F, 15, 30, 1.5F));
        System.out.println();

        System.out.println("5 Задание");
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        System.out.println(BMI("154 pounds", "2 meters"));
        System.out.println();

        System.out.println("6 Задание");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));
        System.out.println();

        System.out.println("7 Задание");
        System.out.println(toStarShorthand("abbvvccc"));
        System.out.println(toStarShorthand("77777geff"));
        System.out.println(toStarShorthand("abc"));
        System.out.println(toStarShorthand(""));
        System.out.println();

        System.out.println("8 Задание");
        System.out.println(doesRhyme("Novo russia", "Malo russia"));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAeM."));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(doesRhyme("and frequently do?", "you gotta move."));
        System.out.println(doesRhyme("and frequently deo?", "you gotta move."));
        System.out.println();

        System.out.println("9 Задание");
        System.out.println(trouble(451999277, 41177722899L));
        System.out.println(trouble(1222345, 12345));
        System.out.println(trouble(666789, 12345667));
        System.out.println(trouble(33789, 12345337));
        System.out.println(trouble(1234555, 1231319191955L));
        System.out.println();

        System.out.println("10 Задание");
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));
        System.out.println();

    }

    /**
     * №1
     * Не больше определённого количества символов в строке, исключая пробелы
     * n - количество слов
     * k - максимальное количество символов в одной строке
     * – Если Бесси набирает Слово, и это слово может поместиться в текущей строке, поместите
     * его в эту строку. В противном случае поместите слово на следующую строку и
     * продолжайте добавлять к этой строке. Конечно, последовательные слова в одной строке
     * все равно должны быть разделены одним пробелом. В конце любой строки не должно
     * быть места.
     * – К сожалению, текстовый процессор Бесси только что сломался. Пожалуйста,
     * помогите ей правильно оформить свое эссе!
     */
    public static void essay(int n, int k, String str) {
        String[] a = str.split(" ");  //делим строку по пробелам
        StringBuilder sum = new StringBuilder(); //переменная, к которой прибавляются слова без пробелов
        StringBuilder result = new StringBuilder(); //переменная, к которой прибавляются слова с пробелами
        if(a.length==n){//проверка что слов действительно n количество
            for (int i = 0; i < a.length; i++) {
                if ((sum.length() + a[i].length()) <= k) {  //если длина строки не считая пробелов и самого слова меньше k, то
                    sum.append(a[i]);                       //к строке sum прибавляем слово(a[i])
                    result.append(a[i] + " ");                 //к строке result прибавляем a[i] и пробел
                } else {
                    if (a[i].length()>k){
                        System.out.println("Слово больше k");
                        break;
                    } else {
                        System.out.println(result);    //иначе просто выводим result
                        sum.setLength(0); //приравнимаем длину к нулю
                        result.setLength(0); //приравнимаем к нулю
                        sum.append(a[i]); //добавляем a[i]
                        result.append(a[i] + " ");
                    }
                }
                if (i==a.length-1)      //если слово последнее, то просто выводим его
                    System.out.println(result);
            }
        } else System.out.println("количество слов не равно n");
    }

    /**
     * №2
     * Напишите функцию, которая группирует строку в кластер скобок. Каждый кластер
     * должен быть сбалансирован.
     */
    public static ArrayList<String> split(String s) {
        int k = 0; //счётчик
        ArrayList<String> result = new ArrayList<>();
        String cluster = "";
        //проходим по строке
        for (int i = 0; i<s.length();i++){
            //если ( k++ иначе k--
            if (s.charAt(i)=='('){
                k++;
                cluster+='(';
            } else {
                k--;
                cluster+=')';
                //если равен нулю то добавляем и обнуляем кластер
            } if (k==0){
                result.add(cluster);
                cluster = "";
            }
        }
        return result;

    }

    /**
     * #3
     * Создайте две функции toCamelCase () и toSnakeCase (), каждая из которых берет
     * одну строку и преобразует ее либо в camelCase, либо в snake_case.
     */
    public static StringBuilder toCamelCase(String s) {
       StringBuilder result = new StringBuilder();
       for (int i = 1; i<=s.length(); i++){
           if (s.charAt(i-1)!='_'){//если пред.символ не _ добавляем
               result.append(s.charAt(i-1));
           } else if (s.charAt(i-1)=='_') {//иначе добавляем символ.toUpperCase и увелчиваем i
               result.append(String.valueOf(s.charAt(i)).toUpperCase());
               i++;
           }
       }
       return result;
    }

    public static StringBuilder toSnakeCase(String s) {
        StringBuilder result = new StringBuilder();//Объявляем переменую result
        for (int i = 0; i<s.length(); i++){//проходимся по строке
            if (s.charAt(i)>'Z' && s.charAt(i)<='z'){//если строчная добавляем
                result.append(s.charAt(i));
            } else if (s.charAt(i)>='A' && s.charAt(i)<='Z') {//иначе добавляем _ и используем toLowerCase
                result.append('_');
                result.append(String.valueOf(s.charAt(i)).toLowerCase());
            }
        }
        return result;
    }

    /**
     * №4
     * Напишите функцию, которая вычисляет сверхурочную работу и оплату, связанную
     * с сверхурочной работой.
     * Работа с 9 до 5: обычные часы работы
     * После 5 вечера это сверхурочная работа
     * Ваша функция получает массив с 4 значениями:
     * – Начало рабочего дня, в десятичном формате, (24-часовая дневная нотация)
     * – Конец рабочего дня. (Тот же формат)
     * – Почасовая ставка
     * – Множитель сверхурочных работ
     */
    public static String overTime(double start, double end, double pay, double mn) {
        if (end<=17) {
            return "$"+((end-start)*pay);    //умножаем ставку на часы работы
        } else {         //иначе
            return "$"+(pay*((17-start)+(end-17)*mn)); //умножаем множитель на кол-во сверхурочных часов
        }
    }

    /**
     * №5
     * Индекс массы тела (ИМТ) определяется путем измерения вашего веса в
     * килограммах и деления на квадрат вашего роста в метрах. Категории ИМТ таковы:
     * Недостаточный вес: <18,5
     * Нормальный вес: 18.5-24.9
     * Избыточный вес: 25 и более
     * Создайте функцию, которая будет принимать вес и рост (в килограммах, фунтах,
     * метрах или дюймах) и возвращать ИМТ и связанную с ним категорию. Округлите
     * ИМТ до ближайшей десятой.
     */
    public static String BMI(String a, String b) {
        String[] x = a.split(" ");//делием на массив
        String[] y = b.split(" ");
        double h = Double.parseDouble(x[0]);  //переменной h  1 элемент массива x
        double w = Double.parseDouble(y[0]);  //переменной w  1 элемент массива y
        if (x[1].equals("pounds"))//равен ли pounds второй элемент
            h = h * 0.453592;  //перевод из фунтов в кг
        if (y[1].equals("inches"))
            w = w * 0.0254;   //перевод из дюйм в метры
        double bmi = h / Math.pow(w, 2);  //рассчитываем индекс
        //сравниваем индекс с нормой и выводим результат
        if (bmi < 18.5) {
            return bmi + " Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return bmi + " Normal weight";
        } else {
            return bmi + " Overweight";
        }
    }

    /**
     * №6
     * Метод, который принимает число и возвращает его мультипликативное
     * постоянство, которое представляет собой количество раз, которое вы должны
     * умножать цифры в num, пока не достигнете одной цифры.
     */
    public static int bugger(int a) {
        int k = 0;
        while (a>9) {//проходит через цикл, пока оно больше 9
            int m = 1;
            while (a!=0) {
                m *= (a % 10);//умножаем m на последнюю цифру числа
                a/= 10; //отсекаем последнюю цифру
            }
            a = m;//к a приравниваем произведение
            k++;//к count прибавляем 1
        }
        return k;
    }

    /**
     * №7
     * Напишите функцию, которая преобразует строку в звездную стенографию. Если
     * символ повторяется n раз, преобразуйте его в символ*n.
     */
    public static StringBuilder toStarShorthand(String s) {
        StringBuilder result = new StringBuilder("");
        int k = 1;
        //проходимы по строке
        for (int i = 1; i<s.length(); i++){
            //если равно то увеличиваем счётчик и i < s.length-1
            if (s.charAt(i)==s.charAt(i-1)){
                if (i<s.length()-1) k++;
                //иначе увеличиваем счётчик и добавляем символ с *
                else {
                    k++; result.append(s.charAt(i-1)).append('*').append(k);
                }
                //если не равно то обнуляем k до 1 и добавляем символ с *
            } else if (s.charAt(i)!=s.charAt(i-1)){
                if(k>1){
                    result.append(s.charAt(i-1)).append('*').append(k); k=1;
                } else {
                    //если i < s.length-1 то добавляем символ иначе добавляем два символа
                    if (i<s.length()-1) result.append(s.charAt(i-1));
                    else result.append(s.charAt(i-1)).append(s.charAt(i));
                }
            }
        }
        return result;
    }

    /**
     * №8
     * Создайте функцию, которая возвращает true, если две строки рифмуются, и false в
     * противном случае. Для целей этого упражнения две строки рифмуются, если
     * последнее слово из каждого предложения содержит одни и те же гласные.
     */
    public static boolean doesRhyme(String firstLine, String secondLine) {
        //Заменяем любой символ кроме ^ гласных на пустой
        String word1 = firstLine.substring(firstLine.lastIndexOf(' ')).toLowerCase().replaceAll("[^aeiouy]", "");
        String word2 = secondLine.substring(secondLine.lastIndexOf(' ')).toLowerCase().replaceAll("[^aeiouy]", "");
        char[] first = word1.toCharArray(); //переводим в массив символов
        char[] second = word2.toCharArray();
        Arrays.sort(first); //сортируем
        Arrays.sort(second);
        String sorted1 = Arrays.toString(first); //переводим в строку
        String sorted2 = Arrays.toString(second);
        return removeDuplicate(sorted1).equals(removeDuplicate(sorted2)); //сравнимаем
    }
    //удаляем дубликаты
    public static String removeDuplicate(String x){
        String result = "";
        for (int i = 0; i<x.length(); i++){
            if (!result.contains(""+x.charAt(i))){
                result+=x.charAt(i);
            }
        }
        return result;
    }

    /**
     * №9
     * Создайте функцию, которая принимает два целых числа и возвращает true, если
     * число повторяется три раза подряд в любом месте в num1 и то же самое число
     * повторяется два раза подряд в num2.
     */
    public static boolean trouble(long firstNumber, long secondNumber) {
        String first = Long.toString(firstNumber);//переводим во строку
        String second = Long.toString(secondNumber);
        //цикл с шагом +111
        if (first.contains("000") && second.contains("00")){
            return true;
        }
        for (int i = 1111; i < 2000; i += 111){
            //проверка на наличие цифр, которые повторяются три и два раза
            if (first.contains(Integer.toString(i % 1000)) && second.contains(Integer.toString(i % 100))) {
                return true;
            }
        }
        return false;
    }

    /**
     * №10
     * Предположим, что пара одинаковых символов служит концами книги для всех
     * символов между ними. Напишите функцию, которая возвращает общее количество
     * уникальных символов (книг, так сказать) между всеми парами концов книги.
     */
    public static int countUniqueBooks(String line, char marker) {
        StringBuilder s = new StringBuilder();
        boolean f = false;
        // если встречен первый конец, пока не будет встречен второй, все символы буду добавляться в s
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            //если текущий символ равен концу то !false
            if (currentChar == marker) {
                f = !f;
                //иначе добавляем
            } else if (f) s.append(currentChar);
        }
        //удаляем дубликаты и возвращаем количество
        int count = removeDuplicate(s.toString()).length();
        return count;
    }

}
