package service;

public interface Service<E> {
    void add();
    void update();
    void delete();
    void display();
    E findById();

}
