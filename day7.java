import java.util.*;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;  // Less than 3 bars -> no water trapped

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take input from user
        System.out.println("Enter number of bars:");
        int n = sc.nextInt();
        int[] height = new int[n];

        System.out.println("Enter heights of bars:");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int result = trap(height);
        System.out.println("Trapped Water: " + result);
        sc.close();
    }
}
