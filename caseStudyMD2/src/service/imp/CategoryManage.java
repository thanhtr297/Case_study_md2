package service.imp;

import Model.Category;
import service.CategoryService;

import java.util.List;
import java.util.Scanner;

public class CategoryManage implements CategoryService {
    private List<Category> categoryList;
    private final Scanner scanner;
    private CategoryManage categoryManage;

    public CategoryManage(List<Category> categoryList, Scanner scanner) {
        this.categoryList = categoryList;
        this.scanner = scanner;
    }

    @Override
    public void add() {
        System.out.println("Input name categoty: ");
        String name = scanner.nextLine();

    }

    @Override
    public void update() {
        CategoryService.super.update();
    }

    @Override
    public void delete() {
        CategoryService.super.delete();
    }

    @Override
    public Category findId() {
        return CategoryService.super.findId();
    }
}
