import java.util.Scanner;

public class CaoChiThien_PTIT_HN_135_IT203_Session02_Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sách trả muộn: ");
        int n = sc.nextInt();
        int total = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Nhập số ngày trễ của sách thứ " + i + ": ");
            int day = sc.nextInt();
            total += day * 5000;
        }
        System.out.println("Tổng tiền phạt: " + total + " VNĐ");
        sc.close();
    }
}
