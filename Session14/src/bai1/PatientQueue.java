package bai1;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class PatientQueue {
    public static void main(String[] args) {
        String[] input = {"Nguyễn Văn A – Yên Bái","Trần Thị B – Thái Bình","Lê Văn C – Hưng Yên"};
        Set<String> patientQueue = new LinkedHashSet<>(Arrays.asList(input));
        System.out.print("In ra danh sách gọi khám:");
        for(String e:patientQueue){
            System.out.printf(" %s,",e);
        }
    }
}
