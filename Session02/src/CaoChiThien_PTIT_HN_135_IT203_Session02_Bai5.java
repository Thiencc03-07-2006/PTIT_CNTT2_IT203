import java.util.Scanner;

public class CaoChiThien_PTIT_HN_135_IT203_Session02_Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int point = 100;
        int day;
        System.out.println("(Nhập số ngày trễ. 999 để kết thúc)");
        while (true) {
            System.out.print("Số ngày trễ lần này: ");
            day = sc.nextInt();
            if (day == 999) {
                break;
            }
            if (day <= 0) {
                point += 5;
            } else {
                point -= day * 2;
            }
        }
        System.out.println("Tổng điểm uy tín: " + point);
        if (point > 120) {
            System.out.println("Xếp loại: Độc giả Thân thiết");
        } else if (point >= 80) {
            System.out.println("Xếp loại: Độc giả Tiêu chuẩn");
        } else {
            System.out.println("Xếp loại: Độc giả cần lưu ý");
        }
        sc.close();
    }
}
