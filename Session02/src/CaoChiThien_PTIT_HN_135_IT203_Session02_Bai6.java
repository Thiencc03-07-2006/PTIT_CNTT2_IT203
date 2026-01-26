import java.util.Scanner;

public class CaoChiThien_PTIT_HN_135_IT203_Session02_Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = -1;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int count = 0;
        for (int i = 2; i < 9; i++) {
            System.out.print("Nhập số lượt mượn của ngày " + (i == 8 ? "Chủ Nhật" : i) + ": ");
            int luotMuon = sc.nextInt();
            if (luotMuon == 0) {
                continue;
            }
            if (luotMuon > max) {
                max = luotMuon;
            }
            if (luotMuon < min) {
                min = luotMuon;
            }
            sum += luotMuon;
            count++;
        }
        double avg = (double) sum / count;
        System.out.println("Lượt mượn cao nhất: " + max);
        System.out.println("Lượt mượn thấp nhất: " + min);
        System.out.println("Lượt mượn trung bình: " + avg);
        sc.close();
    }
}
