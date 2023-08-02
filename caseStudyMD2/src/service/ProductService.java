package service;

import Model.Product;

public interface ProductService extends Service<Product>{
    void deleteById();

    void searchByName();

    void searchByPrice();

//    void displayByCategory(Category category);
}
