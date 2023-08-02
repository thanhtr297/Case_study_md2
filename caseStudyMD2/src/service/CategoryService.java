package service;

import Model.Category;

public interface CategoryService extends Service<Category>{
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
    default Category findId() {
        return null;
    }
}
