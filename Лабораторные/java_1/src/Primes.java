public class Primes {
    public static void main(String[] args) {
        for (int n=1; n<=100; n++){
            if (isD(n)){
                System.out.println(n);
            }
        }
    }

    public static boolean isD(int n) {
        if (n%3==0){
            return true;
        } else {
            return false;
        }
    }

    //Проверка на простое число
    public static boolean isPrime(int n) {
        for (int i=2; i<n; i++ ){
            if (n%i==0){
                return false;
            }
        }
        return n>2;
    }
}
