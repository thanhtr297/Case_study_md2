package Model;

import java.io.Serializable;

public class Category implements Serializable {
    private int id;
    private static int ID = 0;
    private String name;

    public Category() {
    }



    public Category(String name) {
        this.id = ++ID;
        this.name = name;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
