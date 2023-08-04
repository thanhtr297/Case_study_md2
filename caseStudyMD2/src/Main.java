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
        MenuTool menuTool = new MenuTool(productManage);
        int choice = 0;
        do {
            System.out.println(" \t\t\t\t\t CHÀO MỪNG BẠN ĐẾN VỚI \n" +
                    "\t\t\t Ứng dụng quản lý sản phẩm Thành điện máy \n" +
                    "\t\t\t1. Menu Danh mục\n" +
                    "\t\t\t2. Menu Sản phẩm \n" +
                    "\t\t\t3. Menu chức năng \n" +
                    "\t\t\t0. Thoát. \n" +
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
