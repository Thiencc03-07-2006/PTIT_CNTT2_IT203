package bai5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Patient> patientList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    updateDiagnosis();
                    break;
                case 3:
                    dischargePatient();
                    break;
                case 4:
                    sortPatients();
                    break;
                case 5:
                    displayPatients();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1. Tiếp nhận bệnh nhân");
        System.out.println("2. Cập nhật chẩn đoán");
        System.out.println("3. Xuất viện");
        System.out.println("4. Sắp xếp danh sách bệnh nhân");
        System.out.println("5. Hiển thị danh sách bệnh nhân");
        System.out.println("6. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    private static void addPatient() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        if (findPatientById(id) != null) {
            System.out.println("ID đã tồn tại. Không thể thêm.");
            return;
        }
        System.out.print("Nhập họ tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập chẩn đoán: ");
        String diagnosis = sc.nextLine();
        patientList.add(new Patient(id, name, age, diagnosis));
        System.out.println("Thêm bệnh nhân thành công.");
    }

    private static void updateDiagnosis() {
        System.out.print("Nhập ID bệnh nhân: ");
        String id = sc.nextLine();
        Patient p = findPatientById(id);
        if (p == null) {
            System.out.println("Không tìm thấy bệnh nhân.");
            return;
        }
        System.out.print("Nhập chẩn đoán mới: ");
        String newDiagnosis = sc.nextLine();
        p.setDiagnosis(newDiagnosis);
        System.out.println("Cập nhật thành công.");
    }

    private static void dischargePatient() {
        System.out.print("Nhập ID bệnh nhân: ");
        String id = sc.nextLine();

        Patient p = findPatientById(id);
        if (p == null) {
            System.out.println("Không tìm thấy bệnh nhân.");
            return;
        }

        patientList.remove(p);
        System.out.println("Đã xuất viện bệnh nhân.");
    }

    private static void sortPatients() {

        Collections.sort(patientList, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                if (p1.getAge() != p2.getAge()) {
                    return p2.getAge() - p1.getAge();
                }
                return p1.getFullName().compareToIgnoreCase(p2.getFullName());
            }
        });

        System.out.println("Đã sắp xếp danh sách.");
    }

    private static void displayPatients() {
        if (patientList.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        System.out.println("\n===== Danh sách bệnh nhân =====");
        for (Patient p : patientList) {
            System.out.println(p);
        }
    }

    private static Patient findPatientById(String id) {
        for (Patient p : patientList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}