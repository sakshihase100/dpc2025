import java.util.*;
public class DivisorCount{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(countDivisor(n));
        sc.close();
    }

    public static int countDivisor(long n){
        int count = 0;
        for(long i = 1; i*i<=n;i++){
            if(n%i==0){
                if(i == n/i){
                    count++;
                }
                else{
                    count += 2;
                }
            }
        }
        return count;
    }
}
