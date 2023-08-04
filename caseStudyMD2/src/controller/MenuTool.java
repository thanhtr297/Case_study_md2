package controller;

import Model.Category;
import Model.Product;
import service.imp.ProductManage;

import java.util.Scanner;

public class MenuTool {
    public ProductManage productManage;
    Scanner scanner = new Scanner(System.in);
    public MenuTool(ProductManage productManage) {
        this.productManage = productManage;
    }

    public void menuTool(ProductManage productManage) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\t\t\t\tMenu chức năng \n" +
                    "\t\t\t1. Hiển thị sản phẩm theo danh mục. \n" +
                    "\t\t\t2. Tìm kiếm theo tên sản phẩm. \n" +
                    "\t\t\t3. Hiển thị sản phẩm theo trạng thái. \n" +
                    "\t\t\t0. Thoát. \n" +
                    "Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManage.displayByCategory(new Category());
                    break;
                case 2:
                    productManage.searchByName();
                    break;
                case 3:
                    displayByStatus();
                    break;
                case 4:

                    break;
                case 5:
                    break;
                case 6:
            }
        } while (choice != 0);
    }
    public void displayByStatus(){
        boolean flag = false;
        int pick ;
        do {
            System.out.println("\t\t\t\tMenu hiển thị: \n" +
                    "\t\t\t1. Hiển thị ra sản phẩm trạng thái mới\n" +
                    "\t\t\t2. Hiển thị ra sản phẩm trạng thái cũ \n" +
                    "\t\t\t0. Thoát." +
                    "Nhập vào lựa chọn hiển thị: ");

            pick = Integer.parseInt(scanner.nextLine());
            switch (pick){
                case 1:
                    for (Product p : productManage.getListProduct()) {
                        if (p.getStatus().toLowerCase().equals("mới")){
                            System.out.println("\t\t\tDanh sách sản phẩm có trạng thái mới:");
                            System.out.println(p);
                            flag = true;
                        }
                    }
                    break;
                case 2:
                    for (Product p : productManage.getListProduct()) {
                        if (p.getStatus().toLowerCase().equals("cũ")){
                            System.out.println("\t\t\tDanh sách sản phẩm có trạng thái mới:");
                            System.out.println(p);
                            flag = true;
                        }
                    }
                    break;
            }
            if (!flag){
                System.out.println("Vui lòng nhập lại!");
            }
        } while (pick != 0);
    }


}
