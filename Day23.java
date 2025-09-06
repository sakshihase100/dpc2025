import java.util.*;
import java.util.Arrays;
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || k <= 0) return new int[0];
        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // 1. Remove indices out of window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 2. Remove smaller values from back
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // 3. Add current element index
            deque.offerLast(i);

            // 4. Store result for full windows
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr1, k1))); 
        // [3, 3, 5, 5, 6, 7]

        int[] arr2 = {1, 5, 3, 2, 4, 6};
        int k2 = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr2, k2))); 
        // [5, 5, 4, 6]

        int[] arr3 = {1, 2, 3, 4};
        int k3 = 2;
        System.out.println(Arrays.toString(maxSlidingWindow(arr3, k3))); 
        // [2, 3, 4]

        int[] arr4 = {7, 7, 7, 7};
        int k4 = 1;
        System.out.println(Arrays.toString(maxSlidingWindow(arr4, k4))); 
        // [7, 7, 7, 7]
    }
}
