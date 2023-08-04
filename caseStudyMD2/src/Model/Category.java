package Model;

import java.io.Serializable;

public class Category implements Serializable {
    private static final long serialVersionUID = 1234522551426788L;
    private int id;
    public static int ID = 0;
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.id = ++ID;
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Danh mục: " + "  " +
                  id + ":  " +
                 name + ".";
    }
}
