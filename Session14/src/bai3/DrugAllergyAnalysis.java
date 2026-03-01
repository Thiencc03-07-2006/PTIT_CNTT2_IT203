package bai3;

import java.util.HashSet;
import java.util.Set;

public class DrugAllergyAnalysis {
    public static void main(String[] args) {
        Set<String> drugIngredients = new HashSet<>();
        drugIngredients.add("Aspirin");
        drugIngredients.add("Caffeine");
        drugIngredients.add("Paracetamol");
        Set<String> allergyList = new HashSet<>();
        allergyList.add("Penicillin");
        allergyList.add("Aspirin");
        Set<String> allergyWarning = new HashSet<>(drugIngredients);
        allergyWarning.retainAll(allergyList);
        Set<String> safeIngredients = new HashSet<>(drugIngredients);
        safeIngredients.removeAll(allergyList);
        System.out.println("Cảnh báo dị ứng: " + allergyWarning);
        System.out.println("Thành phần an toàn: " + safeIngredients);
    }
}