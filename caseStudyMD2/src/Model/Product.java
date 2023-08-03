package Model;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialUID = 12345678L;
    private int id;
    public static int ID = 0;
    private String name;
    private double price;
    private Category category;
    private int quantity;
    private String detail;


    public Product(String name, double price, Category category, int quantity, String detail) {
        this.id = ++ID;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.detail = detail;
    }

    public Product(int id, String name, double price, Category category, int quantity, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Sản phẩm: " + "\n" + name +
                "Mã sản phẩm: " + id + "\n" +
                "Giá: " + price +"VNĐ" + "\n" +
                category +"\n" +
                "Số lượng: " + quantity +"chiếc" +"\n" +
                "Mô tả: " + detail + "\n" +
                "-------------------------------------------";
    }
}
