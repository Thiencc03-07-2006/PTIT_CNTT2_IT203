import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1.1 Nhap xuat
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi nhap vao so luong phan tu: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Mang rong!");
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Moi nhap vao phan tu arr[%d]: ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        //1.2
        //So nguyen to
        System.out.println("So nguyen to:");
        for (int i = 0; i < n; i++) {
            if (arr[i] < 2) continue;
            boolean check = true;
            for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                if (arr[i] % j == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.printf(" %d", arr[i]);
            }
        }
        System.out.println();
        //Fibonacci
        int totalFibonacci = 0;
        System.out.println("So Fibonacci:");
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                System.out.print(" 1");
                totalFibonacci += 1;
                continue;
            }
            int temp;
            int left = 1;
            int right = 1;
            while (right < arr[i]) {
                temp = right;
                right += left;
                left = temp;
            }
            if (right == arr[i]) {
                System.out.printf(" %d", arr[i]);
                totalFibonacci += 1;
            }
        }
        System.out.printf("\nTong fibonacci: %d\n", totalFibonacci);
        // max&&min
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        //Tong giai thua
        long totalFactorial = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) continue;
            long factorial = 1;
            for (int j = 1; j <= arr[i]; j++) {
                factorial *= j;
            }
            totalFactorial += factorial;
        }
        System.out.printf("Tong giai thua: %d\n", totalFactorial);
    }
}