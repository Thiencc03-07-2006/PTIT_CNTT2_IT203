package bai2;

import java.util.ArrayList;
import java.util.Collections;

public class Medicine {
    public static void main(String[] args) {
        ArrayList<String> medicine = new ArrayList<>();
        medicine.add("Paracetamol");
        medicine.add("Ibuprofen");
        medicine.add("Panadol");
        medicine.add("Paracetamol");
        medicine.add("Aspirin");
        medicine.add("Ibuprofen");
        System.out.println("Input: " + medicine);
        ArrayList<String> result = new ArrayList<>();
        for (String e : medicine) {
            if (!result.contains(e)) {
                result.add(e);
            }
        }
        Collections.sort(result);
        System.out.println("Output: " + result);
    }
}
