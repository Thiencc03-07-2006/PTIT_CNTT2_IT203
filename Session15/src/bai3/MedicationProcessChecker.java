package bai3;

import java.util.Stack;

public class MedicationProcessChecker {

    private Stack<String> stack;

    public MedicationProcessChecker() {
        stack = new Stack<>();
    }

    public boolean checkProcess(String[] actions) {
        reset();
        for (int i = 0; i < actions.length; i++) {
            String action = actions[i];
            if (action.equalsIgnoreCase("PUSH")) {
                stack.push("MEDICATION");
                System.out.println("Bước " + (i + 1) + ": PUSH -> Phát thuốc");
            } else if (action.equalsIgnoreCase("POP")) {
                if (stack.isEmpty()) {
                    System.out.println("LỖI tại bước " + (i + 1)
                            + ": POP khi chưa có thuốc được phát.");
                    return false;
                }
                stack.pop();
                System.out.println("Bước " + (i + 1) + ": POP -> Hoàn tất phát thuốc");
            } else {
                System.out.println("LỖI tại bước " + (i + 1)
                        + ": Thao tác không hợp lệ: " + action);
                return false;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("LỖI: Kết thúc ca trực nhưng vẫn còn "
                    + stack.size() + " thuốc chưa hoàn tất.");
            return false;
        }
        System.out.println("Quy trình hợp lệ.");
        return true;
    }

    public void reset() {
        stack.clear();
    }
}