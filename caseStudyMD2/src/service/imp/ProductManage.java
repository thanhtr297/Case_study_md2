package service.imp;

import IO.IO;
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
    private final String PATH = "\\src\\IO\\Product";

    public ProductManage(Scanner scanner, CategoryManage categoryManage) {
        products = read(PATH);
        this.scanner = scanner;
        this.categoryManage = categoryManage;
        setIndex();
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
        System.out.println("Input name");
        String name = scanner.nextLine();
        System.out.println("Input price");
        double price = Double.parseDouble(scanner.nextLine());
        categoryManage.display();
        System.out.println("Input category: ");
        Category category = categoryManage.findById();
        return new Product(name, price, category);
    }

    @Override
    public void add() {
        products.add(getProduct());
        write(products, PATH);
    }

    @Override
    public void update() {
        Product product = findById();
        if (product != null) {
            System.out.println("Input new name: ");
            String name = scanner.nextLine();
            product.setName(name);
            System.out.println("Input new price: ");
            double price = Double.parseDouble(scanner.nextLine());
            product.setPrice(price);
            categoryManage.display();
            System.out.println("Input new category: ");
            Category category = categoryManage.findById();
            product.setCategory(category);
        } else {
            System.out.println("Not exist category have this id!");
        }
        write(products, PATH);
    }

    @Override
    public void delete() {

    }

    @Override
    public void deleteById() {
        Product product = findById();
        if (product != null) {
            products.remove(product);
        } else {
            System.out.println("Not exist category have this id!");
        }
        write(products, PATH);
    }

    @Override
    public Product findById() {
        System.out.println("Input id you want: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void display() {
        if (!products.isEmpty()) {
            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("Not exist product in list!");
        }
    }




    @Override
    public void searchByName() {
        boolean check = false;
        System.out.println("Input name you want search: ");
        String search = scanner.nextLine();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(search.toLowerCase())) {
                System.out.println(product);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Not exist product have name contains this word!");
        }
    }

    @Override
    public void searchByPrice() {
        boolean check = false;
        System.out.println("Input min price you want search: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.println("Input max price you want search: ");
        double max = Double.parseDouble(scanner.nextLine());
        if (min > max) {
            System.out.println("Please input again!");
        } else {
            for (Product product : products) {
                if (product.getPrice() < max && product.getPrice() > min) {
                    System.out.println(product);
                    check = true;
                }
            }
            if (!check) {
                System.out.println("Not exist product have price between your input!");
            }
        }
    }

//    @Override
//    public void displayByCategory(Category category) {
//        boolean check = false;
//        categoryManage.display();
//        System.out.println("Input id category you want display: ");
//        int categoryId = Integer.parseInt(scanner.nextLine());
//        for (Product product : products) {
//            if (product.getCategory().getId() == categoryId) {
//                System.out.println(product);
//                check = true;
//            }
//        }
//        if (!check) {
//            System.out.println("Not exist product of your category choice!");
//        }
//    }

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
