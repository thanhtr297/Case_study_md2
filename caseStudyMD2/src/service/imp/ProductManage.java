package service.imp;

import io.IO;
import Model.Category;
import Model.Product;
import service.ProductService;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManage implements ProductService, IO<Product> {
    private final List<Product> products;
    private final Scanner scanner;
    private final CategoryManage categoryManage;
    private final String PATH = "C:\\Users\\bong\\Desktop\\MD2_btap\\CaseStudy\\caseStudyMD2\\src\\io\\Product";

    public ProductManage(Scanner scanner, CategoryManage categoryManage) {
        products = read(PATH);
        this.scanner = scanner;
        this.categoryManage = categoryManage;
        setIndex();
    }
    public List<Product> getListProduct(){
        return products;
    }
    public String getPATH(){
        return PATH;
    }
    private void setIndex() {
        if (!products.isEmpty()) {
            int index = products.get(0).getId();
            for (Product product : products) {
                if (product.getId() > index) {
                    index = product.getId();
                }
            }
            Product.ID = index;
        } else {
            Product.ID = 0;
        }
    }

    private Product getProduct() {
        System.out.println("Nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("Nhập giá:");
        double price = Double.parseDouble(scanner.nextLine());
        categoryManage.display();
        System.out.println("Nhập danh mụcc cho sản phẩm: ");
        Category category = categoryManage.findById();
        System.out.println("Nhập vào số lượng:");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào mô tả:");
        String detail = scanner.nextLine();
        return new Product(name, price, category,quantity,detail);
    }

    @Override
    public void add() {
        products.add(getProduct());
        write(products, PATH);
        System.out.println("Thêm thành công rồi nè");
    }

    @Override
    public void update() {
        Product product = findById();
        if (product != null) {
            System.out.println("Cập nhật tên: ");
            String name = scanner.nextLine();
            if (!name.isEmpty()){
                product.setName(name);
            }
            System.out.println("Cập nhật giá: ");
            String price = scanner.nextLine();
            if (!price.isEmpty()){
                product.setPrice(Double.parseDouble(price));
            }
            categoryManage.display();
            System.out.println("Cập nhật danh mục cho: " + name);
            Category category = categoryManage.findById();
                product.setCategory(category);
            System.out.println("Cập nhật số lượng: ");
            String quantity = scanner.nextLine();
            if (!quantity.isEmpty()) {
                product.setQuantity(Integer.parseInt(quantity));
            }
            System.out.println("Cập nhật mô tả: ");
            String detail = scanner.nextLine();
            if (!detail.isEmpty()) {
                product.setDetail(detail);            }

            System.out.println("Cập nhật thành  công rồi nè!!");

        } else {
            System.out.println("Không có danh mục phù hợp!");
        }
        write(products, PATH);
    }
    @Override
    public void deleteById() {
        Product product = findById();
        if (product != null) {
            products.remove(product);
            System.out.println("Xóa thành công rồi nè");
        } else {
            System.out.println("Không có danh mục phù hợp!");
        }
        write(products, PATH);
    }

    @Override
    public Product findById() {
        System.out.println("Nhập vào mã sp: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    public void displayByCategory(Category category){
        boolean flag = false;
        categoryManage.display();
        System.out.println("Nhập vào mã danh mục cần hiển thị: ");
        int checkID = Integer.parseInt(scanner.nextLine());
        for (Product p : products) {
            if (p.getCategory().getId() == checkID) {
                System.out.println(p);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Không có danh mục mà bạn chọn!");
        }
     }
     public  void sortByPrice(){

     }
     public void searchByName(){
         System.out.println("Nhập từ khóa tên muốn tìm:");
         String search = scanner.nextLine();
         for (Product p: products) {
             if (p.getName().toLowerCase().contains(search.toLowerCase())){
                 System.out.println(p);
             }
         }
     }

    @Override
    public void display() {
        if (!products.isEmpty()) {
            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("Không có danh mục trong danh sách!");
        }
    }

    @Override
    public void write(List<Product> products, String path) {
        try (ObjectOutputStream obj = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)))) {
            obj.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> read(String path) {
        List<Product> productList = new ArrayList<>();
        File file = new File(path);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream obj = new ObjectInputStream(fileInputStream);
            if (obj.available() != -1) {
                productList = (List<Product>) obj.readObject();
            }
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
