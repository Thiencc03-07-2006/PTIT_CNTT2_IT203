package btthextend;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IManager<Category> categoryManager = new CategoryManager();
        IManager<Book> bookManager = new BookManager();
        int choice;
        do {
            System.out.println("\n===== MENU CHÍNH =====");
            System.out.println("1. Quản lý Danh mục");
            System.out.println("2. Quản lý Sách");
            System.out.println("0. Thoát");
            System.out.print("Mời nhập lựa chọn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("\n--- QUẢN LÝ DANH MỤC ---");
                        System.out.println("1. Thêm");
                        System.out.println("2. Sửa");
                        System.out.println("3. Xóa");
                        System.out.println("4. Hiển thị");
                        System.out.println("0. Quay lại");
                        System.out.print("Mời nhập lựa chọn: ");
                        choice = sc.nextInt();
                        sc.nextLine();
                        switch (choice) {
                            case 1:
                                System.out.print("ID: ");
                                int id = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Name: ");
                                String name = sc.nextLine();
                                System.out.print("Description: ");
                                String desc = sc.nextLine();
                                categoryManager.add(new Category(id, name, desc));
                                break;
                            case 2:
                                System.out.print("Nhập ID cần sửa: ");
                                int updateId = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Name mới: ");
                                String newName = sc.nextLine();
                                System.out.print("Description mới: ");
                                String newDesc = sc.nextLine();
                                categoryManager.update(new Category(updateId, newName, newDesc));
                                break;
                            case 3:
                                System.out.print("Nhập ID cần xóa: ");
                                int deleteId = sc.nextInt();
                                categoryManager.delete(deleteId);
                                break;
                            case 4:
                                categoryManager.displayAll();
                                break;
                        }
                    } while (choice != 0);
                    choice=-1;
                    break;
                case 2:
                    do {
                        System.out.println("\n--- QUẢN LÝ SÁCH ---");
                        System.out.println("1. Thêm");
                        System.out.println("2. Sửa");
                        System.out.println("3. Xóa");
                        System.out.println("4. Hiển thị");
                        System.out.println("0. Quay lại");
                        System.out.print("Mời nhập lựa chọn: ");
                        choice = sc.nextInt();
                        sc.nextLine();
                        switch (choice) {
                            case 1:
                                System.out.println("Danh mục hiện có:");
                                categoryManager.displayAll();
                                System.out.print("ID: ");
                                int id = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Title: ");
                                String title = sc.nextLine();
                                System.out.print("Author: ");
                                String author = sc.nextLine();
                                System.out.print("Category ID: ");
                                int cateId = sc.nextInt();
                                bookManager.add(new Book(id, title, author, cateId));
                                break;
                            case 2:
                                System.out.print("Nhập ID sách cần sửa: ");
                                int updateId = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Title mới: ");
                                String newTitle = sc.nextLine();
                                System.out.print("Author mới: ");
                                String newAuthor = sc.nextLine();
                                System.out.print("Category ID mới: ");
                                int newCateId = sc.nextInt();
                                bookManager.update(new Book(updateId, newTitle, newAuthor, newCateId));
                                break;
                            case 3:
                                System.out.print("Nhập ID sách cần xóa: ");
                                int deleteId = sc.nextInt();
                                bookManager.delete(deleteId);
                                break;
                            case 4:
                                bookManager.displayAll();
                                break;
                        }
                    } while (choice != 0);
                    choice=-1;
                    break;
            }
        } while (choice != 0);
    }
}