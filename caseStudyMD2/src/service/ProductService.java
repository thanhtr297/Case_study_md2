package service;

import Model.Product;
import Model.Category;
public interface ProductService extends Service<Product>{
    void deleteById();

    void displayByCategory(Category category);
}
