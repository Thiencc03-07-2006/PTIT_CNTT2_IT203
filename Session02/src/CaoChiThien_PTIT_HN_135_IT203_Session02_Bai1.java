import java.util.Scanner;

public class CaoChiThien_PTIT_HN_135_IT203_Session02_Bai1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap tuoi cua ban: ");
        int age = input.nextInt();
        System.out.print("Nhap so sach dang muon: ");
        int borrowBook = input.nextInt();
        if (age >= 18 && borrowBook < 3) {
            System.out.println("Ket qua: Ban DU DIEU KIEN muon sach quy hiem.");
        } else {
            System.out.println("Ket qua: Khong du dieu kien.");
            if (borrowBook >= 3) {
                System.out.println("-Ly do: Ban da muon toi da 3 cuon.");
            }
            if (age < 18) {
                System.out.println("-Ly do: Ban phai tu 18 tuoi tro len.");
            }
        }
        input.close();
    }
}
