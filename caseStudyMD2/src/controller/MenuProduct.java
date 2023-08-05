package controller;
import service.imp.ProductManage;

import java.util.Scanner;

public class MenuProduct {
    public void menuProduct(ProductManage productManage){
        Scanner scanner = new Scanner(System.in);
                int choice;
        do {
            System.out.println("\t\t\t\tMenu sản phẩm \n" +
                    "\t\t\t1. Thêm sản phẩm. \n" +
                    "\t\t\t2. Sửa sản phẩm. \n" +
                    "\t\t\t3. Hiển thị sản phẩm. \n" +
                    "\t\t\t4. Xóa sản phẩm. \n" +
                    "\t\t\t0. Thoát. \n" +
                    "Nhập lựa chọn của bạn:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    productManage.add();
                    break;
                case 2:
                    productManage.update();
                    break;
                case 3:
                    productManage.display();
                    break;
                case 4:
                    productManage.deleteById();
                    break;
            }
        } while (choice != 0);
    }
}
