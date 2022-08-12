// https://nados.io/question/find-element-in-an-array

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int d = sc.nextInt();

        int result = Arrays.stream(arr).boxed().collect(Collectors.toList()).indexOf(d);
        System.out.println(result);
    }
}
