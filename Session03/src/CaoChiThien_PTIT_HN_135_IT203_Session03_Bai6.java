import java.util.Arrays;

public class CaoChiThien_PTIT_HN_135_IT203_Session03_Bai6 {
    public static int[] mergeBooks(int[] a, int[] b) {
        int n = a.length + b.length;
        int[] temp = new int[n];
        System.arraycopy(a, 0, temp, 0, a.length);
        System.arraycopy(b, 0, temp, a.length, b.length);
        Arrays.sort(temp);
        for (int i = 0; i < n - 1; i++) {
            if (temp[i] == temp[i + 1]) {
                for (int j = i + 1; j < n - 1; j++) {
                    temp[j] = temp[j + 1];
                }
                n--;
                i--;
            }
        }
        return Arrays.copyOf(temp, n);
    }

    public static void displayBooks(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        int[] arrayFirst = {1, 3, 5, 7, 9};
        int[] arraySecond = {2, 3, 5, 6, 8, 9, 10};
        System.out.print("Kho cũ: ");
        displayBooks(arrayFirst);
        System.out.print("Lô mới: ");
        displayBooks(arraySecond);
        int[] arrayMerge = mergeBooks(arrayFirst, arraySecond);
        System.out.print("Kho tổng (đã gộp & lọc trùng): ");
        displayBooks(arrayMerge);
    }
}
