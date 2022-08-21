// https://nados.io/question/remove-primes

import java.util.ArrayList;
import java.util.Scanner;

public class RemovePrimes {

    public static boolean isPrime(int n) {
        int count = 0;
        for(int i=2; i*i<=n; i++) {
            if(n%i == 0) {
                count++;
                break;
            }
        }
        if(count >= 1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<n; i++) {
            arr.add(sc.nextInt());
        }

        int i=0;
        while(i<arr.size()) {
            if(isPrime(arr.get(i)))
                arr.remove(i);
            else
                i++;
        }

        System.out.println(arr);
    }
}
