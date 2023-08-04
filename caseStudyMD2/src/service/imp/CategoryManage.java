package service.imp;
import io.IO;
import Model.Category;
import service.CategoryService;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryManage implements CategoryService, IO<Category> {
    private final List<Category> categoryList;
    private final Scanner scanner;
    private static CategoryManage categoryManage;
    private final String PATH = "C:\\Users\\bong\\Desktop\\MD2_btap\\CaseStudy\\caseStudyMD2\\src\\io\\Category";


    private CategoryManage(Scanner scanner) {
        this.scanner = scanner;
        categoryList = read(PATH);
        setIndex();
    }

    public static CategoryManage getInstance(Scanner scanner) {
        if (categoryManage == null) {
            categoryManage = new CategoryManage(scanner);
        }
        return categoryManage;
    }

    public List<Category> getCategories() {
        return categoryList;
    }

    private void setIndex() {
        if (!categoryList.isEmpty()) {
            int index = categoryList.get(0).getId();
            for (Category category : categoryList) {
                if (category.getId() > index) {
                    index = category.getId();
                }
            }
            Category.ID = index;
        } else {
            Category.ID = 0;
        }
    }

    private Category getCategory() {
        System.out.println("Nhập tên danh mục: ");
        String name = scanner.nextLine();
        return new Category(name);
    }

    @Override
    public void add() {
        categoryList.add(getCategory());
        write(categoryList, PATH);
        System.out.println("Thêm thành công rồi nè!");
    }

    @Override
    public void update() {

    }


    public void updateCategory(ProductManage productManage) {
        Category category = findById();
        if (category != null) {
            System.out.println("Nhập tên danh mục cần đổi: ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                category.setName(name);
                for (int i = 0; i < productManage.getListProduct().size() ; i++) {
                    if (productManage.getListProduct().get(i).getCategory().getName().equals(category.getName())){
                        productManage.getListProduct().get(i).getCategory().setName(name);
                    }
                }
            }
            System.out.println("Cập nhật thành công rồi nè");
        }else {
            System.out.println("Không có danh mục phù hợp với ID!");
        }
        write(categoryList, PATH);
        productManage.write(productManage.getListProduct(), productManage.getPATH());
    }

    public void deleteCategory(ProductManage productManage){
        Category category = findById();
        if (category!=null){
            for (int i = 0; i < productManage.getListProduct().size(); i++) {
                if (productManage.getListProduct().get(i).getCategory().getName().equals(category.getName())){
                    productManage.getListProduct().remove(i);
                }
            }
            categoryList.remove(category);
            write(categoryList, PATH);
            productManage.write(productManage.getListProduct(),productManage.getPATH());
        }else {
            System.out.println("Không có danh mục phù hợp với ID!");
        }
    }

    @Override
    public Category findById() {
        System.out.println("Nhập mã danh mục: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Category category : categoryList) {
            if(category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    @Override
    public void display() {
        if (!categoryList.isEmpty()) {
            System.out.println("Danh sách danh mục: ");
            for (Category category : categoryList) {
                System.out.println(category);
                System.out.println("----------");
            }
        } else {
            System.out.println("Không có danh mục phù hợp trong danh sách!");
        }
    }

    @Override
    public void write(List<Category> categories, String path) {
        try (ObjectOutputStream obj = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)))) {
            obj.writeObject(categories);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> read(String path) {
        List<Category> categoryList = new ArrayList<>();
        File file = new File(path);
        try  {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream obj = new ObjectInputStream(fileInputStream);
            if (obj.available() != -1) {
                categoryList =(List<Category>) obj.readObject();
            }
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
}


