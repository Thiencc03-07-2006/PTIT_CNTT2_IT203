package bai6;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Medicine> cart = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addMedicine();
                    break;
                case 2:
                    updateQuantity();
                    break;
                case 3:
                    removeMedicine();
                    break;
                case 4:
                    printInvoice();
                    break;
                case 5:
                    findCheapMedicine();
                    break;
                case 6:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n===== MENU KÊ ĐƠN THUỐC =====");
        System.out.println("1. Thêm thuốc vào đơn");
        System.out.println("2. Điều chỉnh số lượng");
        System.out.println("3. Xóa thuốc");
        System.out.println("4. In hóa đơn");
        System.out.println("5. Tìm thuốc giá rẻ (< 50.000)");
        System.out.println("6. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    private static void addMedicine() {
        System.out.print("Nhập mã thuốc: ");
        String id = sc.nextLine();
        Medicine existing = findById(id);
        if (existing != null) {
            System.out.print("Thuốc đã tồn tại. Nhập số lượng thêm: ");
            int addQty = Integer.parseInt(sc.nextLine());
            existing.setQuantity(existing.getQuantity() + addQty);
            System.out.println("Đã cộng dồn số lượng.");
            return;
        }
        System.out.print("Nhập tên thuốc: ");
        String name = sc.nextLine();
        System.out.print("Nhập đơn giá: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(sc.nextLine());
        cart.add(new Medicine(id, name, price, quantity));
        System.out.println("Đã thêm thuốc vào đơn.");
    }

    private static void updateQuantity() {
        System.out.print("Nhập mã thuốc: ");
        String id = sc.nextLine();
        Medicine m = findById(id);
        if (m == null) {
            System.out.println("Không tìm thấy thuốc.");
            return;
        }
        System.out.print("Nhập số lượng mới: ");
        int newQty = Integer.parseInt(sc.nextLine());
        if (newQty == 0) {
            cart.remove(m);
            System.out.println("Đã xóa thuốc khỏi đơn.");
        } else {
            m.setQuantity(newQty);
            System.out.println("Đã cập nhật số lượng.");
        }
    }

    private static void removeMedicine() {
        System.out.print("Nhập mã thuốc cần xóa: ");
        String id = sc.nextLine();
        Medicine m = findById(id);
        if (m == null) {
            System.out.println("Không tìm thấy thuốc.");
            return;
        }
        cart.remove(m);
        System.out.println("Đã xóa thuốc.");
    }

    private static void printInvoice() {
        if (cart.isEmpty()) {
            System.out.println("Đơn thuốc trống.");
            return;
        }
        double total = 0;
        System.out.println("\n===== HÓA ĐƠN THUỐC =====");
        System.out.printf("%-10s %-20s %-10s %-10s %-15s\n",
                "ID", "Tên thuốc", "Giá", "SL", "Thành tiền");
        for (Medicine m : cart) {
            double itemTotal = m.getTotalPrice();
            total += itemTotal;
            System.out.printf("%-10s %-20s %-10.0f %-10d %-15.0f\n",
                    m.getDrugId(),
                    m.getDrugName(),
                    m.getUnitPrice(),
                    m.getQuantity(),
                    itemTotal);
        }
        System.out.println("----------------------------------------------");
        System.out.printf("TỔNG TIỀN: %.0f VNĐ\n", total);
        cart.clear();
        System.out.println("Đơn thuốc đã được thanh toán và làm mới.");
    }

    private static void findCheapMedicine() {
        boolean found = false;
        System.out.println("\nThuốc có giá dưới 50.000 VNĐ:");
        for (Medicine m : cart) {
            if (m.getUnitPrice() < 50000) {
                System.out.println(m.getDrugId() + " - " +
                        m.getDrugName() + " - " +
                        m.getUnitPrice() + " VNĐ");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có thuốc giá rẻ.");
        }
    }

    private static Medicine findById(String id) {
        for (Medicine m : cart) {
            if (m.getDrugId().equals(id)) {
                return m;
            }
        }
        return null;
    }
}
