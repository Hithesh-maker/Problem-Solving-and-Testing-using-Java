import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] prefixSum = new int[n];

        // Read array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Calculate prefix sum
        prefixSum[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // Print prefix sum
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }

            System.out.print(prefixSum[i]);
        }

        System.out.println();

        sc.close();
    }
}