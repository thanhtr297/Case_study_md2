package service;

import Model.Product;

public interface ProductService<P> extends Service<Product>{
    @Override
    default void add() {

    }

    @Override
    default void update() {

    }

    @Override
    default void delete() {

    }

    @Override
    default Product findId() {
        return null;
    }
}
