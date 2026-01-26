/*
    Vòng lặp
    1. Viết thuật toán kiểm tra số nguyên nhập vào và in ra thông báo
    kết luận số nhập vào có phải số nguyên tố hay không
    2. Tìm và in ra 100 số nguyên tố đầu tiên
    3. Viết chương trình thực hiện menu chức năng sau :
    +------------------Menu---------------------+
    |1. Nhập vào 1 số nguyên dương n            |
    |2. Tính tổng của số chẵn và tổng số lẻ < n |
    |3. Tìm các số hoàn hảo < n                 |
    |4. Tính n!                                 |
    |5. Thoát chương trình                      |
    +-------------------------------------------+
*/

import java.util.Scanner;

public class BTLloop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 1
        System.out.print("Nhap vao so can kiem tra nguyen: ");
        int check = 1;
        int checkPrime = input.nextInt();
        if (checkPrime < 2) {
            System.out.printf("%d khong phai so nguyen to\n", checkPrime);
        } else {
            for (int i = (int) Math.sqrt(checkPrime); i > 1; i--) {
                if (checkPrime % i == 0) {
                    System.out.printf("%d khong phai so nguyen to\n", checkPrime);
                    check = 0;
                    break;
                }
            }
        }

        if (check == 1) {
            System.out.printf("%d la so nguyen to\n", checkPrime);
        }
        // 2
        int count = 0;
        int prime = 2;
        while (count <= 100) {
            check = 1;
            for (int i = (int) Math.sqrt(prime); i > 1; i--) {
                if (prime % i == 0) {
                    check = 0;
                    break;
                }
            }
            if (check == 1) {
                System.out.printf("%d\n", prime);
                count++;
            }
            prime++;
        }
        int choose;
        int n = 0;
        do {
            System.out.print("""
                    +------------------Menu---------------------+
                    |1. Nhập vào 1 số nguyên dương n            |
                    |2. Tính tổng của số chẵn và tổng số lẻ < n |
                    |3. Tìm các số hoàn hảo < n                 |
                    |4. Tính n!                                 |
                    |5. Thoát chương trình                      |
                    +-------------------------------------------+
                    Mời nhập lựa chọn:
                    """);
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    do {
                        System.out.print("Nhập vào 1 số nguyên dương n:");
                        n = input.nextInt();
                        if (n <= 0) {
                            System.out.println("Vui lòng nhập số nguyên dương");
                        }
                    } while (n <= 0);
                    break;
                case 2:
                    if (n == 0) {
                        System.out.println("Vui lòng nhập n trước (chọn 1)");
                        break;
                    }
                    int totalOdd = 0;
                    int totalEven = 0;
                    for (int i = 1; i < n; i++) {
                        if (i % 2 == 0) {
                            totalEven += i;
                        } else {
                            totalOdd += i;
                        }
                    }
                    System.out.printf("Tổng số chẵn: %d\n Tổng số lẻ: %d\n", totalEven, totalOdd);
                    break;
                case 3:
                    if (n == 0) {
                        System.out.println("Vui lòng nhập n trước (chọn 1)");
                        break;
                    }
                    System.out.println("Các số hoàn hảo < " + n + ":");
                    for (int i = 1; i < n; i++) {
                        int sum = 0;
                        for (int j = 1; j <= i / 2; j++) {
                            if (i % j == 0) sum += j;
                        }
                        if (sum == i) {
                            System.out.print(i + " ");
                        }
                    }
                    System.out.println();
                    break;
                case 4:
                    if (n == 0) {
                        System.out.println("Vui lòng nhập n trước (chọn 1)");
                        break;
                    }
                    long factorial = 1;
                    for (int i = 1; i <= n; i++) {
                        factorial *= i;
                    }
                    System.out.printf("Giai thừa: %d\n", factorial);
                    break;
                case 5:
                    if (n == 0) {
                        System.out.println("Vui lòng nhập n trước (chọn 1)");
                        break;
                    }
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Vui lòng nhập từ  1-5");
            }
        } while (choose != 5);
        input.close();
    }
}
