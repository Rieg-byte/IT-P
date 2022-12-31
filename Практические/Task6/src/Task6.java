import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Task6 {
    public static void main(String[] args) {
        System.out.println("1 Задание");
        System.out.println(bell(1));
        System.out.println(bell(2));
        System.out.println(bell(10));
        System.out.println();

    }

    private static boolean existA(String a, String[] massive) {
        for (String s : massive) {
            if (a.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Функция, которая принимает
     * число n и возвращает соответствующее число Белла.
     */
    public static int bell(int n) {
        int result;
        double d = 1; // переменна в котором будет храниться сумма k^n/k!
        long fact = 1;
        for (int k = 1; k < 50; k++) {
            fact *= k;
            d += Math.pow(k, n) / fact;
        }
        result = (int) (d / Math.exp(1)); // делим сумму на e
        return result;
    }

    /**
     * Первая функция translateWord (word) получает слово на английском и возвращает это
     * слово, переведенное на латинский язык. Вторая функция translateSentence (предложение)
     * берет английское предложение и возвращает это предложение, переведенное на латинский
     * язык.
     */
    public static String translateWord(String word) {
        if (word.equals("")) return "";
        if (word.matches("^(?i:[aeiouy]).*")) return word + "yay";
        else {
            int k = word.indexOf(word.replaceAll("[^aeiouy]", "").charAt(0));
            if ((int) word.charAt(0) > 96) return word.substring(k) + word.substring(0, k) + "ay";
            else
                return (char) ((int) word.charAt(k) - 32) + word.substring(k + 1) + word.substring(0, k).toLowerCase() + "ay";
        }
    }

    public static String translateSentence(String sentence) {
        StringBuilder result = new StringBuilder();
        int begin = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.substring(i, i + 1).matches("\\W")) {
                result.append(translateWord(sentence.substring(begin, i)));
                result.append(sentence.charAt(i));
                begin = i + 1;
            }

        }
        return result.toString();
    }

    //3 завершённость строки
    public static boolean validColor(String line) {
        if (line.replaceAll("\\w", "") == (line.replaceAll("^[(,.)]", ""))) return false;
        String[] pars = line.split(",,|[(,)]");
        try {
            if (pars.length == 4)
                return pars[0].equals("rgb") && Integer.parseInt(pars[1]) <= 255 && Integer.parseInt(pars[2]) <= 255 && Integer.parseInt(pars[3]) <= 255;
            if (pars.length == 5)
                return pars[0].equals("rgba") && Integer.parseInt(pars[1]) <= 255 && Integer.parseInt(pars[2]) <= 255 && Integer.parseInt(pars[3]) <= 255 && Float.parseFloat(pars[4]) <= 1;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    //4 ссылка
    public static String stripUrlParams(String http) {
        if (http.indexOf('?') == -1) return http;
        String[] pars = http.split("[&,?=]");
        HashMap<String, String> uniq = new HashMap<>();
        for (int i = 1; i < pars.length; i += 2) uniq.put(pars[i], pars[i + 1]);
        return pars[0] + '?' + (uniq.toString().replaceAll(", ", "&").replaceAll("[{}]", ""));
    }

    public static String stripUrlParams(String http, String[] expt) {
        if (http.indexOf('?') == -1) return http;
        String[] pars = http.split("[&,?=]");
        HashMap<String, String> uniq = new HashMap<>();
        for (int i = 1; i < pars.length; i += 2) if (!existA(pars[i], expt)) uniq.put(pars[i], pars[i + 1]);
        return pars[0] + '?' + (uniq.toString().replaceAll(", ", "&").replaceAll("[{}]", ""));
    }

    //5 Три самых длинных слова
    public static String getHashTags(String sentence) {
        if (sentence.equals("")) return "Empty input";
        String[] wordSet = sentence.split("\\W");
        Arrays.sort(wordSet, (String o1, String o2) -> Integer.compare(o2.length(), o1.length()));
        List<String> result = new ArrayList<>(3);
        result.add("#" + wordSet[0].toLowerCase());
        for (int i = 1; i < wordSet.length; i++) {
            if (wordSet[i] != wordSet[i - 1]) result.add("#" + wordSet[i].toLowerCase());
            if (result.size() == 3) break;
        }
        return result.toString();
    }


    //6 Улам
    public static int ulam(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        int i, j;
        for (i = 3, j = 2; j < n; i++) {
            int count = 0;
            for (int k = 0; k < arr.size() - 1; k++) {
                for (int l = k + 1; l < arr.size(); l++) {
                    if (arr.get(k) + arr.get(l) == i)
                        count++;
                    if (count > 1)
                        break;
                }
                if (count > 1)
                    break;
            }
            if (count == 1) {
                arr.add(i);
                j++;
            }
        }
        return i - 1;
    }

    // Задание №7. Длинная неповторяющаяся строка
    public static String longestNonrepeatingSubstring(String str) {
        String res = "", temp = "";
        for(int i = 0; i < str.length(); ++i){
            for(int j = i; j < str.length(); ++j){
                if(!temp.contains(String.valueOf(str.charAt(j))))
                    temp += str.charAt(j);
                else{
                    if(temp.length() > res.length())
                        res = temp;
                    temp = "";
                    j = str.length();
                }
            }
        }
        return res;
    }

    // Задание №8. Римское число
    public static String convertToRoman(int num) {
        String fs = "";
        while(num != 0){
            if(num >= 1000){
                num -= 1000;
                fs += "M";
            }
            else if(num >= 900){
                num -= 900;
                fs += "CM";
            }
            else if(num >= 500){
                num -= 500;
                fs += "D";
            }
            else if(num >= 400){
                num -= 400;
                fs += "CD";
            }
            else if(num >= 100){
                num -= 100;
                fs += "C";
            }
            else if(num >= 90){
                num -= 90;
                fs += "XC";
            }
            else if(num >= 50){
                num -= 50;
                fs += "L";
            }
            else if(num >= 40){
                num -= 40;
                fs += "XL";
            }
            else if(num >= 10){
                num -= 10;
                fs += "X";
            }
            else if(num >= 9){
                num -= 9;
                fs += "IX";
            }
            else if(num >= 5){
                num -= 5;
                fs += "V";
            }
            else if(num >= 4){
                num -= 4;
                fs += "IV";
            }
            else if(num > 0){
                num -= 1;
                fs += "I";
            }
        }
        return fs;
    }

    // Задание №9. Верна ли формула?
    static int a = 4;
    public static int calc(String str) {
        str = str.replaceAll("[()]", "");
        str = str.replaceAll(" ", "");
        if(str.equals("a"))
            return a;
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String[] tokens;
            tokens = str.split("\\*", 2);
            if (tokens.length > 1) {
                return calc(tokens[0]) * calc(tokens[1]);
            }
            tokens = str.split("/", 2);
            if (tokens.length > 1) {
                return calc(tokens[0]) / calc(tokens[1]);
            }
            tokens = str.split("\\+", 2);
            if (tokens.length > 1) {
                return calc(tokens[0]) + calc(tokens[1]);
            }
            tokens = str.split("-", 2);
            if (tokens.length > 1) {
                return calc(tokens[0]) - calc(tokens[1]);
            }
            return 0;
        }
    }
    public static boolean formula(String str) {

        String[] equations = str.split("=");
        for (int i = 0; i < equations.length-1; i++)
        {
            if(calc(equations[i]) != calc(equations[i+1])) {
                return false;
            }
        }
        return true;

    }

    // Задание №10. Палиндром
    public static boolean palindromeDescendant(int num) {
        boolean isSym = false;
        while(num > 9) {
            if(isSymmetrical(num)) {
                isSym = true;
                break;
            }
            num = getSumofDigits(num);
        }
        return isSym;
    }
    public static boolean isSymmetrical(int num) {
        int reversenum = 0, n = num;
        if(n < 0)
            n = n * -1;
        while(n != 0) {
            reversenum = reversenum * 10;
            reversenum = reversenum + n % 10;
            n = n / 10;
        }
        return(reversenum == num);
    }
    public static int getSumofDigits(int n) {
        String iString = Integer.toString(n);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < iString.length() - 1; i += 2) {
            int i1 = Integer.parseInt(Character.toString(iString.charAt(i)));
            int i2 = Integer.parseInt(Character.toString(iString.charAt(i+1)));
            int num = i1 + i2;
            sb.append(Integer.toString(num));
        }

        return Integer.parseInt(sb.toString());
    }
}
