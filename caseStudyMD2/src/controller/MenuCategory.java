package controller;
import service.imp.CategoryManage;
import service.imp.ProductManage;
import java.util.Scanner;

public class MenuCategory {
    Scanner scanner = new Scanner(System.in);
    int choice;
    public void menuCategory(ProductManage productManage){
        CategoryManage categoryManage = CategoryManage.getInstance(scanner);
        do {
            System.out.println("Menu danh mục \n" +
                    "1. Thêm danh mục. \n" +
                    "2. Sửa danh mục. \n" +
                    "3. Hiển thị danh mục. \n" +
                    "4. Xóa danh mục \n" +
                    "0. Thoát. \n" +
                    "Nhập lựa chọn của bạn:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    categoryManage.add();
                    break;
                case 2:
                    categoryManage.updateCategory(productManage);
                    break;
                case 3:
                    categoryManage.display();
                    break;
                case 4:
                    categoryManage.deleteCategory(productManage);
            }
        } while (choice != 0);

    }


}
