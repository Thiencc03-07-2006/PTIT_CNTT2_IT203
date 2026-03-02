package bai1;

public class Main {
    public static void main(String[] args) {

        MedicalRecordHistory history = new MedicalRecordHistory();

        history.addEdit(new EditAction("Thêm chẩn đoán: Sốt xuất huyết", "09:00"));
        history.addEdit(new EditAction("Cập nhật đơn thuốc Paracetamol", "09:10"));
        history.addEdit(new EditAction("Thêm kết quả xét nghiệm máu", "09:20"));

        System.out.println("\nChỉnh sửa gần nhất:");
        System.out.println(history.getLatestEdit());

        System.out.println("\nThực hiện Undo:");
        history.undoEdit();

        System.out.println("\nUndo lần nữa:");
        history.undoEdit();
    }
}