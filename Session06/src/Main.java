import CaoChiThien_PTIT_HN_135_IT203_Session01_Bai1.Student;
import CaoChiThien_PTIT_HN_135_IT203_Session01_Bai2.Account;
import CaoChiThien_PTIT_HN_135_IT203_Session01_Bai3.Product;
import CaoChiThien_PTIT_HN_135_IT203_Session01_Bai4.Employee;
import CaoChiThien_PTIT_HN_135_IT203_Session01_Bai5.Book;
import CaoChiThien_PTIT_HN_135_IT203_Session01_Bai6.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Bai 1
        System.out.println("Bai 1");
        Student student1 = new Student("ST1", "Nguyen Van A", 2006, 8.5);
        Student student2 = new Student("ST2", "Nguyen Van B", 2007, 9.5);
        student1.showInfo();
        student2.showInfo();
        //Bai 2
        System.out.println("Bai 2");
        Account acc = new Account("thiencc", "123456", "thien@gmail.com");
        System.out.println("Thông tin ban đầu:");
        acc.showInfo();
        acc.changePassword("abc@2026");
        System.out.println("Sau khi đổi mật khẩu:");
        acc.showInfo();
        sc.close();
        //Bai 3
        System.out.println("Bai 3");
        Product p = new Product("P001", "Chuột không dây", 250000);
        p.showInfo();
        p.setPrice(300000);
        p.showInfo();
        p.setPrice(-50000);
        p.showInfo();
        //Bai 4
        System.out.println("Bai 4");
        Employee e1 = new Employee();
        Employee e2 = new Employee("E001", "Nguyễn Văn A");
        Employee e3 = new Employee("E002", "Trần Thị B", 15000000);
        e1.showInfo();
        e2.showInfo();
        e3.showInfo();
        //Bai 5
        System.out.println("Bai 5");
        Book b = new Book("B001", "Lập trình Java", "Nguyễn Văn A", 120000);
        b.showInfo();
        //Bai 6
        System.out.println("Bai 6");
        User u1 = new User(1, "thiencc", "123456", "thien@gmail.com");
        u1.showInfo();
        User u2 = new User(2, "user02", "abcdef", "email_sai");
        u2.showInfo();
        User u3 = new User(3, "user03", "", "user03@gmail.com");
        u3.showInfo();
        u3.setPassword("newpass123");
        u3.setEmail("user03@ptit.edu.vn");
        u3.showInfo();
    }
}