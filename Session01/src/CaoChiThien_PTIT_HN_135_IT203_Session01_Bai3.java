public class CaoChiThien_PTIT_HN_135_IT203_Session01_Bai3 {
    public static void main(String[] args) {
        // Hai biến book1 và book2 là biến tham chiếu
        // -> Chúng được lưu trên STACK
        // -> Giá trị của chúng là địa chỉ trỏ tới đối tượng String trên HEAP
        String book1 = "Java Basic";
        String book2 = "Python Intro";
        System.out.println("Trước khi hoán đổi: Book1 = "+book1+", Book2 = " + book2);
        /*
        TẠI THỜI ĐIỂM BAN ĐẦU:
        STACK:
        book1 -----> (địa chỉ A)
        book2 -----> (địa chỉ B)
        HEAP:
        (A) "Java Basic"
        (B) "Python Intro"
        Lưu ý: String là immutable (bất biến),
        nội dung chuỗi không bị thay đổi sau khi tạo.
         */

        // Biến tạm temp cũng là biến tham chiếu, lưu trên STACK
        String temp = book1;

        /*
        SAU KHI: temp = book1;
        STACK:
        book1 -----> (A)
        book2 -----> (B)
        temp  -----> (A)
        HEAP:
        (A) "Java Basic"
        (B) "Python Intro"
        Không có đối tượng mới nào được tạo trên HEAP.
        temp chỉ trỏ tới cùng đối tượng với book1.
         */

        book1 = book2;

        /*
        SAU KHI: book1 = book2;
        STACK:
        book1 -----> (B)
        book2 -----> (B)
        temp  -----> (A)
        HEAP:
        (A) "Java Basic"
        (B) "Python Intro"
        book1 đổi địa chỉ tham chiếu từ A sang B.
        Đối tượng trên HEAP không hề thay đổi.
         */

        book2 = temp;
        /*
        SAU KHI: book2 = temp;
        STACK:
        book1 -----> (B)
        book2 -----> (A)
        temp  -----> (A)
        HEAP:
        (A) "Java Basic"
        (B) "Python Intro"
        => Hoán đổi hoàn tất.
        Chỉ có các biến tham chiếu trên STACK thay đổi.
        Không có chuỗi nào bị chỉnh sửa trên HEAP.
         */

        System.out.println("Sau khi hoán đổi: Book1 = "+book1+", Book2 = " + book2);
    }
}
