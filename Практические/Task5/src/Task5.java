import java.security.MessageDigest;
import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("1 Задание");
        System.out.println(encrypt("Hello"));
        System.out.println(encrypt("Sunshine"));
        System.out.println(decrypt(new int[]{72, 33, -73, 84, -12, -3, 13, -13, -68}));
        System.out.println();
        System.out.println("2 Задание");
        System.out.println(canMove("Pawn", "C2", "C8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Queen", "C4", "D6"));
        System.out.println();
        System.out.println("3 Задание");
        System.out.println(canComplete("butl", "beautifulqq"));
        System.out.println(canComplete("butlz", "beautiful"));
        System.out.println(canComplete("tulb", "beautiful"));
        System.out.println(canComplete("bbutl", "beautiful"));
        System.out.println();
        System.out.println("4 задание");
        System.out.println(sumDigProd(new int[]{16, 28}));
        System.out.println(sumDigProd(new int[]{0}));
        System.out.println(sumDigProd(new int[] {1, 2, 3, 4, 5, 6}));
        System.out.println();
        System.out.println("5 задание");
        System.out.println(sameVowelGroup("toe", "ocelot", "maniac"));
        System.out.println(sameVowelGroup("many", "carriage", "emit", "apricot", "animal"));
        System.out.println(sameVowelGroup("hoops", "chuff", "bot", "bottom"));
        System.out.println();
        System.out.println("6 задание");
        System.out.println(validateCard(1234567890123456L));
        System.out.println(validateCard(1234567890123452L));
        System.out.println();
        System.out.println("7 задание");
        System.out.println(numToEng(0));
        System.out.println(numToEng(18));
        System.out.println(numToEng(1260));
        System.out.println(numToEng(909));
        System.out.println(numToRus(0));
        System.out.println(numToRus(18));
        System.out.println(numToRus(126));
        System.out.println(numToRus(909));
        System.out.println();
        System.out.println("8 задание");
        System.out.println(getSha256Hash("password123"));
        System.out.println(getSha256Hash("Fluffy@home"));
        System.out.println(getSha256Hash("Hey dude!"));
        System.out.println();
        System.out.println("9 задание");
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
        System.out.println();
        System.out.println("10 задание");
        hexLattice(1);
        System.out.println();
        hexLattice(7);
        System.out.println();
        hexLattice(19);
        System.out.println();
        hexLattice(21);
        System.out.println();
    }


    /**
     * Две функции, которые принимают строку и массив и возвращают
     * закодированное или декодированное сообщение.
     */
    public static String encrypt(String s) {
        int[] с = new int[s.length()]; //создаем массив целочисленных чисел
        с[0] = s.charAt(0); //добавляем 1 символ(в ASCII) в массив
        // добавляем разность между двумя символами
        for (int i = 1; i < s.length(); i++) {
            с[i] = s.charAt(i) - s.charAt(i - 1);
        }
        return Arrays.toString(с);
    }


    public static StringBuilder decrypt(int[] c) {
        StringBuilder s = new StringBuilder();
        int sum = c[0];//добавляем первый символ
        s.append((char) sum);
        for (int i = 1; i < c.length; i++) {
            sum += c[i];//добавляем число в переменную sum
            s.append((char) sum);//добавляем символ в строку
        }
        return s;
    }

    /**
     * Функцию, которая принимает имя шахматной фигуры, ее положение и
     * целевую позицию. Функция должна возвращать true, если фигура может двигаться
     * к цели, и false, если она не может этого сделать.
     */
    public static boolean canMove(String name, String a, String b) {
        // разбиваем 1 и 2 строку на координаты
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        boolean result;
        // описываем все возможные ходы для каждой фигуры
        switch (name) {
            case ("Pawn") -> {
                boolean p = (Math.abs((int) x[1] - (int) y[1]) == 1) ||(x[1]=='2' && y[1]=='4') ||( x[1]=='7' && y[1]=='5');
                result = ((Math.abs((int) x[0] - (int) y[0]) == 0) && p);
            }
            case ("Knight") -> {
                result = (Math.abs((int) x[0] - (int) y[0]) == 1) && (Math.abs((int) x[1] - (int) y[1]) == 2)
                        || (Math.abs((int) x[0] - (int) y[0]) == 2) && (Math.abs((int) x[1] - (int) y[1]) == 1);
            }
            case ("Bishop") -> {
                result = (Math.abs((int) x[0] - (int) y[0]) == Math.abs((int) x[1] - (int) y[1]));
            }
            case ("Rook") -> {
                result = (x[0] == y[0]) || (x[1] == y[1]);;
            }
            case ("Queen") -> {
                result = (Math.abs((int) x[0] - (int) y[0]) == Math.abs((int) x[1] - (int) y[1])) || (x[0] == y[0]) || (x[1] == y[1]);
            }
            case ("King") -> {
                result = (Math.abs((int) x[0] - (int) y[0]) <= 1) && (Math.abs((int) x[1] - (int) y[1]) <= 1) ;
            }
            default -> result = false;
        }
        return result;
    }

    /**
     * Функция, которая, учитывая входную строку, определяет, может ли слово быть
     * завершено.
     */
    public static boolean canComplete(String subline, String line) {
        int k = 0;// Счётчик
        // Идем по строке, сравнивания символы между subline и line
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == subline.charAt(k)) {
                k++;
            }
            //если длина subline равна k возвращаем true
            if (subline.length() == k) return true;
        }
        return false;
    }

    /**
     * Функция, которая принимает числа в качестве аргументов, складывает их
     * вместе и возвращает произведение цифр до тех пор, пока ответ не станет длиной
     * всего в 1 цифру.
     */
    public static int sumDigProd(int[] numbers) {
        int n = 0;
        // складываем все числа
        for (int i : numbers) {
            n += i;
        }
        while (n>9) {// проходим через цикл, пока оно больше 9
            int m = 1;
            while (n!=0) {
                m *= (n % 10); // умножаем m на последнюю цифру числа
                n/= 10; // отсекаем последнюю цифру
            }
            n = m; // к n приравниваем произведение
        }
        return n;
    }

    /**
     * Функция, которая выбирает все слова, имеющие все те же гласные (в
     * любом порядке и / или количестве), что и первое слово, включая первое слово.
     */
    public static ArrayList<String> sameVowelGroup(String... lines) {
        ArrayList<String> result = new ArrayList<>(); //список слов
        result.add(lines[0]);// добавляем 1 слово
        String word1 = removeAndSort(lines[0]); //оставляем только гласные
        for (int i = 1; i < lines.length; i++) {
            String word2 = removeAndSort(lines[i]); // оставляем только гласные
            if (word2.equals(word1)) result.add(lines[i]); // добавляем в список, если гласных столько же, как и в 1 слове
        }
        return result;
    }

    // Сортировка
    public static String removeAndSort(String word){
        word = word.toLowerCase().replaceAll("[^aeiouy]", "");
        char[] first = word.toCharArray(); //переводим в массив символов
        Arrays.sort(first); //сортируем
        String sorted = String.valueOf(first);
        sorted = removeDuplicate(sorted);//удаляем повторные символы
        return sorted;
    }

    // Удаление повторных символов
    public static String removeDuplicate(String x) {
        String result = "";
        for (int i = 0; i < x.length(); i++) {
            if (!result.contains("" + x.charAt(i))) {
                result += x.charAt(i);
            }
        }
        return result;
    }

    /**
     * Функция, которая принимает число в качестве аргумента и возвращает
     * true, если это число является действительным номером кредитной карты, а в
     * противном случае-false.
     */
    public static boolean validateCard(long num) {
        int l = String.valueOf(num).length(); // длина номера карты
        if ((l < 14) || (l > 19)) // если не от 14 до 19, то false
            return false;
        int lastDigit = (int) (num%10); // последняя цифра
        StringBuilder number = new StringBuilder(String.valueOf(num/10)).reverse(); // переворачиваем номер карты
        int d;
        for (int i=0; i < number.length(); i= i+2){
            d = Integer.parseInt(number.charAt(i)+"")*2; // удваивание чисел, которые были на нечетных позициях
            if (d/10 > 0){ // если удвоенное значение больше 1 числа, то складываем
                d = d/10 + d%10;
            }
            number.replace(i, i+1, String.valueOf(d)); // меняем на удвоенное значение
        }
        // суммируем
        int s = 0;
        for (int i = 0; i<number.length(); i++){
            s += Integer.parseInt(number.charAt(i)+"");
        }
        // если 10 - последняя цифра суммы равна последнему символу, то true
        return 10 - s % 10 == lastDigit;
    }

    /**
     * Функция, которая принимает положительное целое число от 0 до 999
     * включительно и возвращает строковое представление этого целого числа,
     * написанное на английском языке.
     */
    public static StringBuilder numToEng(int n) {
        StringBuilder result = new StringBuilder();
        // если n равно 0, то возвращаем zero
        if (n == 0) return result.append("zero");
        if (n>999 || n<=0) return new StringBuilder("A number greater than 999 or less than 0");
        // числа от 1 до 19
        String[] SUBTWENTY = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        // десятки
        String[] DECADES = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        if (n / 100 != 0) result.append(String.format("%s hundred ", SUBTWENTY[n / 100]));
        if (n % 100 >= 20) result.append(String.format("%s %s ", DECADES[n % 100 / 10 - 2], SUBTWENTY[n % 10]));
        else result.append(SUBTWENTY[n % 100]);
        return result;
    }

    public static StringBuilder numToRus(int n) {
        StringBuilder result = new StringBuilder();
        if (n == 0) return result.append("ноль");
        if (n>999 || n<=0) return new StringBuilder("Число больше 999 или меньше 0");
        // числа от 1 до 19
        String[] SUBTWENTY = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
                "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать",
                "семнадцать", "восемнадцать", "девятнадцать"};
        // десятки
        String[] DECADES = {"двадцать", "тридцать", "сорок", "пятьдесят",
                "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
        // сотни
        String[] HUNDREDS = {"", "сто", "двести", "триста", "четыреста",
                "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
        result.append(HUNDREDS[n / 100]);
        if (n % 100 >= 20) result.append(String.format(" %s %s ", DECADES[n % 100 / 10 - 2], SUBTWENTY[n % 10]));
        else result.append(SUBTWENTY[n % 100]);
        return result;
    }

    /**
     * Функция, которая возвращает безопасный хеш SHA-256 для данной строки.
     * Хеш должен быть отформатирован в виде шестнадцатеричной цифры.
     */
    public static String getSha256Hash(String Line) {
        try {
            // определяет используемый алгоритм для обработки конкретного сообщения.
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(Line.getBytes());//кодируем в последовательность байтов, а затем хэшируем
            StringBuilder hexString = new StringBuilder(); // хэш
            for (int i : hash) {
                String hex = Integer.toHexString(0xff & i); // форматируем в шестадцатеричные цифры
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Функцию, которая принимает строку и возвращает строку с правильным
     * регистром для заголовков символов в серии "Игра престолов".
     */
    public static StringBuilder correctTitle(String str) {
        String[] words = str.split(" "); // делим строку по пробелам
        StringBuilder result = new StringBuilder(); // результат
        for (int i = 0; i < words.length; i++) {
            // добавляем пробел после предыдущего слова
            if (i>0) {
                result.append(" ");
            }
            String[] wordsN = new String[] {words[i]};
            // если слово равно, то возмодим в нижний регистр
            for (int j = 0; j < wordsN.length; j++) {
                if (wordsN[j].equalsIgnoreCase("and")
                        || wordsN[j].equalsIgnoreCase("the")
                        || wordsN[j].equalsIgnoreCase("of")
                        || wordsN[j].equalsIgnoreCase("in")) {
                    result.append(wordsN[j].toLowerCase());
                }
                // иначе возмодим в вверхний регистр первый символ
                else {
                    result.append(wordsN[j].substring(0, 1).toUpperCase());
                    result.append(wordsN[j].substring(1).toLowerCase());
                }
            }
        }
        return result;
    }

    /**
     * Гексагональная решетка - это привычная двумерная решетка, в которой каждая точка
     * имеет 6 соседей.
     * Центрированное шестиугольное число - это центрированное фигурное число,
     * представляющее шестиугольник с точкой в центре и всеми другими точками,
     * окружающими центральную точку в шестиугольной решетке.
     */
    public static void hexLattice(int n) {
        // вычисляем Центрированное шестиугольное число, присваиваем его n
        for (int i = 1; n >= 1; i++) {
            if (n == 1) {
                n = i;
                break;
            }
            n -= i * 6;
        }
        if (n < 0) System.out.println("Invalid");
        int m = 1 + (n - 1) * 2;
        for (int i = m; i > 0; i--) {
            //строим решетку
            System.out.println(" ".repeat(Math.abs(m + 1 - n)) + "o ".repeat(n));
            if (n <= i) n++;
            else n--;
        }
    }

}
