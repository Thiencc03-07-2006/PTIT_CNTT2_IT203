package struc.run;

import struc.business.IProductService;
import struc.business.ProductServiceImpl;
import struc.model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private static final IProductService productService = new ProductServiceImpl();

    public static void showProductMenu(Scanner sc) {
        while (true) {
            System.out.println("""
                    +--------------------MENU-------------------+
                    |1. Hiển thị danh sách sản phẩm             |
                    |2. Thêm mới sản phẩm                       |
                    |3. Cập nhật thông tin sản phẩm             |
                    |4. Xóa sản phẩm                            |
                    |5. Lọc sản phẩm                            |
                    |6. Sắp xếp sản phẩm                        |
                    |7. Thoát                                   |
                    +-------------------------------------------+
                    """);
            System.out.println("Nhap lua chọn");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    showListProduct();
                    break;

            }

        }
    }

    private static void showListProduct() {
        List<Product> list = productService.findAll();

        if (list.isEmpty()) {
            System.err.println("Khong có san pham nao !!!");
            return;
        }
        // in tieieu đề
        System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                "-".repeat(6),
                "-".repeat(27),
                "-".repeat(12),
                "-".repeat(7),
                "-".repeat(12),
                "-".repeat(22)
        );
        System.out.printf("| %-4s | %-25s | %-10s | %-5s | %-10s | %-20s |\n",
                "ID", "Name", "Price", "Stock", "Desc", "Created At"
        );
        System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                "-".repeat(6),
                "-".repeat(27),
                "-".repeat(12),
                "-".repeat(7),
                "-".repeat(12),
                "-".repeat(22)
        );


        for (Product p : list){
            System.out.print(p);
        }

        System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                "-".repeat(6),
                "-".repeat(27),
                "-".repeat(12),
                "-".repeat(7),
                "-".repeat(12),
                "-".repeat(22)
        );
    }
}