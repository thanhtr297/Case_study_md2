import controller.MenuCategory;
import controller.MenuProduct;
import controller.MenuTool;
import service.imp.CategoryManage;
import service.imp.ProductManage;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuCategory menuCategory = new MenuCategory();
        MenuProduct menuProduct = new MenuProduct();
        CategoryManage categoryManage = CategoryManage.getInstance(scanner);
        ProductManage productManage = new ProductManage(scanner,categoryManage);
        MenuTool menuTool = new MenuTool();
        int choice = 0;
        do {
            System.out.println("Ứng dụng quản lý sản phẩm Thành điện máy \n" +
                    "1. Menu Danh mục\n" +
                    "2. Menu Sản phẩm \n" +
                    "3. Menu chức năng \n" +
                    "0. Thoát. \n" +
                    "Nhập lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception o) {
                System.out.println("Vui lòng nhập đúng số!");
            }
            if (choice < 0 || choice >3) {
                System.out.println("Vui lòng nhập đúng số!");
            } else {
                switch (choice) {
                    case 1:
                        menuCategory.menuCategory(productManage);
                        break;
                    case 2:
                        menuProduct.menuProduct(productManage);
                        break;
                    case 3:
                        menuTool.menuTool(productManage);
                        break;
                    case 0:
                        System.exit(0);
                }
            }
        } while (true);
    }
}
