import controller.MenuAdmin;
import controller.MenuCategory;
import controller.MenuProduct;
import controller.MenuTool;
import service.imp.AccountManage;
import service.imp.CategoryManage;
import service.imp.ProductManage;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountManage accountManage = new AccountManage();
        CategoryManage categoryManage = CategoryManage.getInstance(scanner);
        ProductManage productManage = new ProductManage(scanner,categoryManage);
        MenuCategory menuCategory = new MenuCategory();
        MenuProduct menuProduct = new MenuProduct();
        MenuTool menuTool = new MenuTool(productManage);
        MenuAdmin menuAdmin;
        menuAdmin = new MenuAdmin(productManage,menuProduct,menuTool,menuCategory);
        int choice = 0;
        do {
            System.out.println(" \t\t----------------------- \n" +
                    "\t\t\t Ứng dụng quản lý sản phẩm Thành điện máy \n" +
                    "\t\t\t1. Đăng nhập quản trị viên\n" +
                    "\t\t\t2. Xem mà không cần đăng nhập \n" +
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
                        int count = 0;
                        do {
                            if (accountManage.Login()){
                                menuAdmin.menuAdmin();
                            } else {
                                count+=1;
                                if (count <3){
                                    System.out.println("Tên đăng nhập hoặc mật khẩu không chính xác! \n " +
                                            "Bạn đã nhập không chính xác " + count +" lần.\n" +
                                            "Bạn còn " + (3-count) + " lần nhập!");

                                } else  {
                                    System.out.println("Bạn đã nhập đủ 3 lần!");
                                }

                            }
                        } while (count < 3);

                        break;
                    case 2:
                        menuTool.menuNotLogin();
                        break;
                    case 0:
                        System.exit(0);
                }
            }
        } while (true);
    }
}
