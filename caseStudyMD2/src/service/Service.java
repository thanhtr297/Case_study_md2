package service;

public interface Service<E> {
    void add();
    void update();
    void display();
    E findById();

}
