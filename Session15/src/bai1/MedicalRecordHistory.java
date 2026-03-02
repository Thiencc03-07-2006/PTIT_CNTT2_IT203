package bai1;

import java.util.Stack;

public class MedicalRecordHistory {

    private Stack<EditAction> history = new Stack<>();

    public void addEdit(EditAction action) {
        history.push(action);
        System.out.println("Đã thêm chỉnh sửa: " + action);
        displayHistory();
    }

    public EditAction undoEdit() {
        if (history.isEmpty()) {
            System.out.println("Không có chỉnh sửa nào để Undo.");
            return null;
        }

        EditAction removed = history.pop();
        System.out.println("Đã Undo: " + removed);
        displayHistory();
        return removed;
    }

    public EditAction getLatestEdit() {
        if (history.isEmpty()) {
            System.out.println("Stack rỗng.");
            return null;
        }
        return history.peek();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public void displayHistory() {
        System.out.println("----- LỊCH SỬ CHỈNH SỬA -----");

        if (history.isEmpty()) {
            System.out.println("Chưa có chỉnh sửa nào.");
        } else {
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println(history.get(i));
            }
        }

        System.out.println("------------------------------");
    }
}