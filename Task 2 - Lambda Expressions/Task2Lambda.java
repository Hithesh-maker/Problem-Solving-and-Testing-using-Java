import java.util.Scanner;

interface PerformOperation {
    boolean check(int n);
}

public class Task2Lambda {

    // Lambda for checking odd number
    public static PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    // Lambda for checking prime number
    public static PerformOperation isPrime() {
        return n -> {
            if (n < 2) {
                return false;
            }

            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        };
    }

    // Lambda for checking palindrome
    public static PerformOperation isPalindrome() {
        return n -> {
            int original = n;
            int reverse = 0;

            while (n > 0) {
                int digit = n % 10;
                reverse = reverse * 10 + digit;
                n = n / 10;
            }

            return original == reverse;
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            int condition = sc.nextInt();
            int number = sc.nextInt();

            if (condition == 1) {

                if (isOdd().check(number)) {
                    System.out.println("ODD");
                } else {
                    System.out.println("EVEN");
                }

            } else if (condition == 2) {

                if (isPrime().check(number)) {
                    System.out.println("PRIME");
                } else {
                    System.out.println("COMPOSITE");
                }

            } else if (condition == 3) {

                if (isPalindrome().check(number)) {
                    System.out.println("PALINDROME");
                } else {
                    System.out.println("NOT PALINDROME");
                }
            }
        }

        sc.close();
    }
}