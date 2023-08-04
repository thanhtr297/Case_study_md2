package Model;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 12345265656565678L;
    private int id;
    public static int ID = 0;
    private String name;
    private double price;
    private Category category;
    private int quantity;
    private String status;


    public Product(String name, double price, Category category, int quantity, String status) {
        this.id = ++ID;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.status = status;
    }

    public Product(int id, String name, double price, Category category, int quantity, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Sản phẩm: " + "  " + name + "\n" +
                "Mã sản phẩm: " + id + "\n" +
                "Giá: " + price +" Nghìn VNĐ" + "\n" +
                category +"\n" +
                "Số lượng: " + quantity +"chiếc" +"\n" +
                "Trạng thái: " + status + "\n" +
                "-------------------------------------------";
    }
}
