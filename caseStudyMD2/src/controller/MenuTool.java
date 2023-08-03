package controller;

import Model.Category;
import Model.Product;
import service.imp.ProductManage;

import java.util.Scanner;

public class MenuTool {
    public void menuTool(ProductManage productManage) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu chức năng \n" +
                    "1. Hiển thị sản phẩm theo danh mục. \n" +
                    "2. Tìm kiếm theo tên sản phẩm. \n" +
                    "0. Thoát. \n" +
                    "Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManage.displayByCategory(new Category());
                    break;
                case 2:
                    productManage.searchByName();
                    break;
//                case 3:
//
//                    break;
//                case 4:
//
//                    break;
//                case 5:
//                    break;
//                case 6:
            }
        } while (choice != 0);
    }

}
