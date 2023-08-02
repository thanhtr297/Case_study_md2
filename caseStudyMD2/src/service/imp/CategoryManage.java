package service.imp;

import IO.IO;
import Model.Category;
import service.CategoryService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryManage implements CategoryService, IO<Category> {
    private final List<Category> categoryList;
    private final Scanner scanner;
    private static CategoryManage categoryManage;
    private final String PATH = "\\src\\IO\\Category";

    public CategoryManage(List<Category> categoryList, Scanner scanner) {
        this.categoryList = categoryList;
        this.scanner = scanner;
    }




    private CategoryManage(Scanner scanner) {
        this.scanner = scanner;
        categoryList = read(PATH);
        setIndex();
    }

    public static CategoryManage getInstance(Scanner scanner) {
        if (categoryManage == null) {
            categoryManage = new CategoryManage(scanner);
        }
        return categoryManage;
    }

    public List<Category> getCategories() {
        return categoryList;
    }

    private void setIndex() {
        if (!categoryList.isEmpty()) {
            int index = categoryList.get(0).getId();
            for (Category category : categoryList) {
                if (category.getId() > index) {
                    index = category.getId();
                }
            }
            Category.ID = index;
        } else {
            Category.ID = 0;
        }
    }

    private Category getCategory() {
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        return new Category(name);
    }

    @Override
    public void add() {
        categoryList.add(getCategory());
        write(categoryList, PATH);
    }

    @Override
    public void update() {
        Category category = findById();
        if (category != null) {
            System.out.println("Input new name: ");
            String name = scanner.nextLine();
            category.setName(name);
        }else {
            System.out.println("Not exist category have this id!");
        }
        write(categoryList, PATH);
    }

    @Override
    public void delete() {

    }

    @Override
    public Category findById() {
        System.out.println("Input id you want: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Category category : categoryList) {
            if(category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    @Override
    public void display() {
        if (!categoryList.isEmpty()) {
            for (Category category : categoryList) {
                System.out.println(category);
            }
        } else {
            System.out.println("Not exist category in list!");
        }
    }

    @Override
    public void write(List<Category> categories, String path) {
        try (ObjectOutputStream obj = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)))) {
            obj.writeObject(categories);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> read(String path) {
        List<Category> categoryList = new ArrayList<>();
        File file = new File(path);
        try  {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream obj = new ObjectInputStream(fileInputStream);
            if (obj.available() != -1) {
                categoryList =(List<Category>) obj.readObject();
            }
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
}


