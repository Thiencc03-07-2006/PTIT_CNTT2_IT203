package struc.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    // cấu trúc dữ liệu 1 sản phẩm
    private String id;
    private String name;
    private double price;
    private int stock;
    private String description;
    private Date createdAt;

    public Product() {
    }

    public Product(String id, String name, double price, int stock, String description, Date createdAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return String.format("| %-4s | %-25s | %-10.2f | %-5d | %-10s | %-20s |\n",
                id,
                name,
                price,
                stock,
                description,
                sdf.format(createdAt)
        );
    }
}