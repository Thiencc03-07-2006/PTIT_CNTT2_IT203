import java.util.Scanner;
public class CaoChiThien_PTIT_HN_135_IT203_Session01_Bai5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập mã sách 4 chữ số: ");
        int code = input.nextInt();
        int thousands = code / 1000;
        int hundreds = (code / 100) % 10;
        int dozens = (code / 10) % 10;
        int units = code % 10;
        int sumOfFirstThreeNumber = thousands + hundreds + dozens;
        int mod = sumOfFirstThreeNumber % 10;
        System.out.println("Chữ số kiểm tra kỳ vọng: " + mod);
        System.out.println("Mã sách hợp lệ: " + ((mod == units) ? "HỢP LỆ" : "SAI MÃ"));
        input.close();
    }
}
