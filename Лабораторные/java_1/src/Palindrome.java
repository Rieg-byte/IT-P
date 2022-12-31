public class Palindrome {
    public static void main(String[] args) {
        String[] a = {"java", "Palindrome", "wow", "song", "Noon", "VOZ"};
        for (int i = 0; i<a.length; i++ ){
            System.out.println(a[i]);
            System.out.println(isPalindrome(a[i], reverseString(a[i])));
        }
    }

    public static boolean isPalindrome(String n1, String n2){
        if (n1.equals(n2)){
            return true;
        } else {
            return false;
        }

    }

    //Проверка на палиндром
    public static String reverseString(String s){
        String x = "";
        for (int i = s.length()-1; i>=0; i--){
            x += s.charAt(i);
        }
        return x;
    }

}