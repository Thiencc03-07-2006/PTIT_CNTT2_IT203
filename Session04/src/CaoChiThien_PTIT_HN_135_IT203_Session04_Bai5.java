import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaoChiThien_PTIT_HN_135_IT203_Session04_Bai5 {
    public static void main(String[] args) {
        String[] logs = {
                "2024-05-20 | User: NguyenVanA | Action: BORROW | BookID: BK12345",
                "2024-05-21 | User: TranVanB | Action: RETURN | BookID: BK12345",
                "2024-05-22 | User: NguyenVanA | Action: BORROW | BookID: BK67890"
        };
        Pattern pattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2}) \\| User: (\\w+) \\| Action: (BORROW|RETURN) \\| BookID: (BK\\d+)");
        int borrowCount = 0;
        int returnCount = 0;
        for (String log : logs) {
            Matcher matcher = pattern.matcher(log);
            if (matcher.find()) {
                String date = matcher.group(1);
                String user = matcher.group(2);
                String action = matcher.group(3);
                String bookId = matcher.group(4);
                System.out.println("Ngày: " + date);
                System.out.println("Người dùng: " + user);
                System.out.println("Hành động: " + action);
                System.out.println("Mã sách: " + bookId);
                System.out.println("--------------------");
                if (action.equals("BORROW")) {
                    borrowCount++;
                } else if (action.equals("RETURN")) {
                    returnCount++;
                }
            }
        }
        System.out.println("Tổng số lượt mượn (BORROW): " + borrowCount);
        System.out.println("Tổng số lượt trả (RETURN): " + returnCount);
    }
}
