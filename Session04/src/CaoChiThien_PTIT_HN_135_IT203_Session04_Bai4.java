import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaoChiThien_PTIT_HN_135_IT203_Session04_Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã thẻ thư viện (VD:TV202312345): ");
        String cardCode = sc.nextLine();
        Pattern prefixPattern = Pattern.compile("^[A-Z]{2}");
        Pattern yearPattern = Pattern.compile("^[A-Z]{2}(\\d{4})");
        Pattern fullPattern = Pattern.compile("^[A-Z]{2}\\d{4}\\d{5}$");
        Matcher prefixMatcher = prefixPattern.matcher(cardCode);
        Matcher yearMatcher = yearPattern.matcher(cardCode);
        Matcher fullMatcher = fullPattern.matcher(cardCode);
        if (!prefixMatcher.find()) {
            System.out.println("Lỗi: Thiếu hoặc sai tiền tố");
        }
        if (!yearMatcher.find()) {
            System.out.println("Lỗi: Năm vào học không hợp lệ");
            return;
        } else {
            int year = Integer.parseInt(yearMatcher.group(1));
            if (year < 2000 || year > 2026) {
                System.out.println("Lỗi: Năm vào học không hợp lệ");
            }
        }
        if (!fullMatcher.matches()) {
            System.out.println("Lỗi: Định dạng mã thẻ không hợp lệ");
        } else {
            System.out.println("Mã thẻ hợp lệ");
        }
    }
}
