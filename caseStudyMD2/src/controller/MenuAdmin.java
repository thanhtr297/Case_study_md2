package controller;


import service.imp.ProductManage;

import java.util.Scanner;

public class MenuAdmin {
    private final ProductManage productManage;
    private final MenuProduct menuProduct;
    private final MenuTool menuTool;
    private final MenuCategory menuCategory;

    public MenuAdmin(ProductManage productManage, MenuProduct menuProduct
            , MenuTool menuTool, MenuCategory menuCategory) {
        this.menuCategory = menuCategory;
        this.productManage = productManage;
        this.menuProduct = menuProduct;
        this.menuTool = menuTool;
    }

    Scanner scanner = new Scanner(System.in);
    int choice;

    public void menuAdmin() {
        boolean flag;
        do {
            System.out.println("\t\t\t-------------" +
                    " \t\t\t\t\t CHÀO MỪNG BẠN ĐẾN VỚI \n" +
                    "\t\t\t Ứng dụng quản lý sản phẩm điện máy \n" +
                    "\t\t\t1. Menu Danh mục\n" +
                    "\t\t\t2. Menu Sản phẩm \n" +
                    "\t\t\t3. Menu chức năng \n" +
                    "\t\t\t0. Đăng xuất khỏi quản trị viên. \n" +
                    "Nhập lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                flag = true;
            } catch (Exception o) {
                System.out.println("Vui lòng nhập đúng số!");
                flag = false;
            }
            if (choice < 0 || choice > 3) {
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
                }
            }
        }
        while (choice != 0 || !flag);
    }

}
