import java.util.*;

public class FirstElementToRepeatKTimes {
    public static int firstElementToRepeatKTimes(int[] arr, int k) {
        Map<Integer, Integer> freq = new LinkedHashMap<>(); // preserves insertion order

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Traverse again to find first element with freq == k
        for (int num : arr) {
            if (freq.get(num) == k) {
                return num;
            }
        }

        return -1; // if no element found
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 4, 4, 5, 2, 6, 1, 4};
        int k1 = 2;
        System.out.println(firstElementToRepeatKTimes(arr1, k1)); // Output: 1

        int[] arr2 = {2, 3, 4, 2, 2, 5, 5};
        int k2 = 2;
        System.out.println(firstElementToRepeatKTimes(arr2, k2)); // Output: 5

        int[] arr3 = {1, 1, 1, 1};
        int k3 = 1;
        System.out.println(firstElementToRepeatKTimes(arr3, k3)); // Output: -1

        int[] arr4 = {10};
        int k4 = 1;
        System.out.println(firstElementToRepeatKTimes(arr4, k4)); // Output: 10

        int[] arr5 = {6, 6, 6, 6, 7, 7, 8, 8, 8};
        int k5 = 3;
        System.out.println(firstElementToRepeatKTimes(arr5, k5)); // Output: 8
    }
}
