public class CaoChiThien_PTIT_HN_135_IT203_Session03_Bai3 {
    public static void maxQuantityOfBooks(String[] names, int[] quantities) {
        int max = quantities[0];
        for (int i = 1; i < quantities.length; i++) {
            if (quantities[i] > max) {
                max = quantities[i];
            }
        }
        System.out.println("Sách có số lượng nhiều nhất (" + max + ")");
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == max) {
                System.out.println("- " + names[i]);
            }
        }
    }

    public static void minQuantityOfBooks(String[] names, int[] quantities) {
        int min = quantities[0];
        for (int i = 1; i < quantities.length; i++) {
            if (quantities[i] < min) {
                min = quantities[i];
            }
        }
        System.out.println("Sách có số lượng ít nhất (" + min + ")");
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == min) {
                System.out.println("- " + names[i]);
            }
        }
    }

    public static void main(String[] args) {
        String[] names = {
                "Lập trình Java",
                "Cấu trúc dữ liệu",
                "Giải thuật",
                "Cơ sở dữ liệu",
                "Mạng máy tính"
        };
        int[] quantities = {10, 5, 10, 3, 3};
        maxQuantityOfBooks(names, quantities);
        System.out.println("---------------");
        minQuantityOfBooks(names, quantities);
    }
}
