package bai2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DrugLookup {
    public static void main(String[] args) {
        Map<String, String> drugCatalog = new HashMap<>();
        drugCatalog.put("T01", "Paracetamol");
        drugCatalog.put("T02", "Ibuprofen");
        drugCatalog.put("T03", "Amoxicillin");
        drugCatalog.put("T04", "Vitamin C");
        drugCatalog.put("T05", "Metformin");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã thuốc: ");
        String drugCode = sc.nextLine();
        if (drugCatalog.containsKey(drugCode)) {
            System.out.println("Tên thuốc: " + drugCatalog.get(drugCode));
        } else {
            System.out.println("Thuốc không tồn tại.");
        }
        sc.close();
    }
}
