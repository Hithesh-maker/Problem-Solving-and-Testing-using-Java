import java.util.*;

public class Main {

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int k = 1;

        for (int i = 1; i < nums.length; i++) {

            // Found a new unique element
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = removeDuplicates(nums);

        // Print number of unique elements
        System.out.println(k);

        // Print first k unique elements
        System.out.print("[");

        for (int i = 0; i < k; i++) {

            if (i > 0) {
                System.out.print(",");
            }

            System.out.print(nums[i]);
        }

        System.out.println("]");

        sc.close();
    }
}