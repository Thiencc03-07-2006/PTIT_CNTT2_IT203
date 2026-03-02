package struc.business;

import struc.model.Product;

import java.util.List;
import java.util.Scanner;

public interface IProductService {
    // định nghĩa các phương thức của menu chức năng
    List<Product> findAll();
    void newProduct(Scanner sc);
}