package com.rikkeiedu.management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[20];
        int currIndex = 0;
        int choice;
        do {
            System.out.println("""
                    1.Thêm mới học sinh
                    2.Hiển thị danh sách
                    3.Tính điểm trung bình
                    0.Thoát
                    """);
            System.out.print("Mời nhập: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập họ tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập điểm: ");
                    double score = Double.parseDouble(sc.nextLine());
                    System.out.print("Nhập tên lớp: ");
                    String className = sc.nextLine();
                    students[currIndex] = new Student(name, score, className);
                    currIndex++;
                    break;
                case 2:
                    if (currIndex == 0) {
                        System.out.println("Danh sách học sinh trống!");
                        break;
                    }
                    System.out.println("\n--- DANH SÁCH HỌC SINH ---");
                    for (int i = 0; i < currIndex; i++) {
                        students[i].display();
                    }
                    break;
                case 3:
                    if (currIndex == 0) {
                        System.out.println("Danh sách học sinh trống!");
                        break;
                    }
                    double total = 0;
                    for (int i = 0; i < currIndex; i++) {
                        total += students[i].getScore();
                    }
                    System.out.println("Điểm trung bình của lớp: " + total / currIndex);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
        sc.close();
    }
}
