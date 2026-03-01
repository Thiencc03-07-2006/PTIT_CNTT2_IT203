package bai4;

import java.util.*;

public class EpidemiologyReport {
    public static void main(String[] args) {
        List<String> cases = Arrays.asList(
                "Cúm A",
                "Sốt xuất huyết",
                "Cúm A",
                "Covid-19",
                "Cúm A",
                "Sốt xuất huyết"
        );
        Map<String, Integer> statistics = new TreeMap<>();
        for (String disease : cases) {
            if (statistics.containsKey(disease)) {
                statistics.put(disease, statistics.get(disease) + 1);
            } else {
                statistics.put(disease, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ca");
        }
    }
}