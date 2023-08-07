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
    int choice=-1;

    public void menuAdmin() {

        do {
            System.out.println("\t\t\t-------------\n" +
                    " \t\t\t\t\t CHÀO MỪNG BẠN ĐẾN VỚI" +
                    " ỨNG DỤNG QUẢN LÝ ĐIỆN MÁY \n" +
                    "\t\t\t1. Menu Danh mục\n" +
                    "\t\t\t2. Menu Sản phẩm \n" +
                    "\t\t\t3. Menu chức năng \n" +
                    "\t\t\t0. Đăng xuất khỏi quản trị viên. \n" +
                    "Nhập lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
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
            } catch (Exception o) {
                System.err.println("Vui lòng nhập đúng số!");
            }
        } while (choice != 0);
    }

}
