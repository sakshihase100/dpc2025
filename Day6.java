import java.util.*;

public class ZeroSumSubarrays {

    public static List<int[]> findZeroSumSubarrays(int[] arr, int n) {
        List<int[]> result = new ArrayList<>();
        Map<Long, List<Integer>> prefixMap = new HashMap<>();

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            // Case 1: Subarray from 0 to i has sum 0
            if (sum == 0) {
                result.add(new int[]{0, i});
            }

            // Case 2: Subarray from prevIndex+1 to i has sum 0
            if (prefixMap.containsKey(sum)) {
                for (int start : prefixMap.get(sum)) {
                    result.add(new int[]{start + 1, i});
                }
            }

            // Store this index for current prefix sum
            prefixMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<int[]> result = findZeroSumSubarrays(arr, n);

        if (result.isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < result.size(); i++) {
                int[] pair = result.get(i);
                System.out.print("(" + pair[0] + ", " + pair[1] + ")");
                if (i < result.size() - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        sc.close();
    }
                                 }
