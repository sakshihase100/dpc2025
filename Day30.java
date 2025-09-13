import java.util.*;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); 
        dp[0] = 0; 

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of coin types: ");
        int n = sc.nextInt();
        int[] coins = new int[n];
        System.out.print("Enter coin denominations: ");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.print("Enter amount: ");
        int amount = sc.nextInt();

        int result = coinChange(coins, amount);
        System.out.println("Minimum coins needed: " + result);
    }
}
