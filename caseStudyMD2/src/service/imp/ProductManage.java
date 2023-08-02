package service.imp;

import Model.Category;
import Model.Product;
import service.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductManage implements ProductService<Product> {
    private final List<Category> categoryList;
    private Scanner scanner;

    public ProductManage(List<Category> categoryList) {
        this.categoryList = categoryList;
    }


    @Override
    public void add() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public Product findId() {
        return null;
    }
}
