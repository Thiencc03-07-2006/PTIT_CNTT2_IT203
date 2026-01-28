import java.util.Scanner;

public class CaoChiThien_PTIT_HN_135_IT203_Session04_Bai1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời nhập tên sách: ");
        String title = sc.nextLine();
        System.out.print("Mời nhập tên tác giả: ");
        String author = sc.nextLine();
        title = title.trim().replaceAll("\\s+", " ").toUpperCase();
        StringBuilder rs = formatAuthor(author);
        System.out.printf("[%s] - Tác giả: %s", title, rs);
        sc.close();
    }

    private static StringBuilder formatAuthor(String author) {
        author = author.trim().replaceAll("\\s+", " ").toLowerCase();
        String[] temp = author.split(" ");
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            rs.append(Character.toUpperCase(temp[i].charAt(0))).append(temp[i].substring(1)).append(i == temp.length - 1 ? "" : " ");
        }
        return rs;
    }
}
