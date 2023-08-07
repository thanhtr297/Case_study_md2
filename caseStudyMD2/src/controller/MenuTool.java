package controller;

import Model.Category;
import Model.Product;
import service.imp.ProductManage;

import java.util.Scanner;

public class MenuTool {
    int choice;
    public ProductManage productManage;
    Scanner scanner = new Scanner(System.in);
    public MenuTool(ProductManage productManage) {
        this.productManage = productManage;
    }

    public void menuNotLogin(){
        do {
            System.out.println("\t\t\t\tMenu không đăng nhập \n" +
                    "\t\t\t1. Hiện thị các sa phẩm hiện có\n" +
                    "\t\t\t2. Tìm kiếm theo tên sản phẩm.\n" +
                    "\t\t\t3. Hiển thị sản phậ̉m theo  danh mục \n" +
                    "\t\t\t4. Hiển thị sản phẩm theo trạng thái. \n" +
                    "\t\t\t0. Thoát. \n" +
                    "Nhập lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception o) {
                System.out.println("Vui lòng nhập đúng số!");
            }
            switch (choice) {
                case 1:
                    productManage.display();
                    break;
                case 2:
                    productManage.searchByName();

                    break;
                case 3:
                    productManage.displayByCategory(new Category());
                    break;
                case 4:
                    displayByStatus();
                    break;
            }

        } while (choice != 0);

    }
    public void menuTool(ProductManage productManage) {

        do {
            System.out.println("\t\t\t\tMenu chức năng \n" +
                    "\t\t\t1. Hiển thị sản phẩm theo danh mục. \n" +
                    "\t\t\t2. Tìm kiếm theo tên sản phẩm. \n" +
                    "\t\t\t3. Hiển thị sản phẩm theo trạng thái. \n" +
                    "\t\t\t4. Hiển thị tổng số lượng đang tồn kho. \n" +
                    "\t\t\t5. Hiển thị tồng tiền hàng đang tổn kho. \n" +
                    "\t\t\t0. Thoát. \n" +
                    "Nhập lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception o){
                System.out.println("Vui lòng nhập đúng số!");
            }
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
                    displayTotalQuantity();
                    break;
                case 5:
                    displayTotalCashInStock();
                    break;
            }
        } while (choice != 0);
    }
    public void displayTotalCashInStock(){
        double sum = 0;
        for (Product p : productManage.getListProduct()) {
            sum += p.getPrice();
        }
        System.out.println("Tồng tiền hàng tồn kho là: " + sum + " nghìn VNĐ");
    }
    public void displayTotalQuantity(){
        int quantity=0;
        for (Product p : productManage.getListProduct()) {
            quantity += p.getQuantity();
        }
        System.out.println("Tồng số lượng hàng tồn kho là: " + quantity + " chiếc.");
    }
    public void displayByStatus(){
        boolean flag = false;
        do {
            System.out.println("\t\t\t\tMenu hiển thị: \n" +
                    "\t\t\t1. Hiển thị ra sản phẩm trạng thái mới\n" +
                    "\t\t\t2. Hiển thị ra sản phẩm trạng thái cũ \n" +
                    "\t\t\t0. Thoát. \n" +
                    "Nhập vào lựa chọn hiển thị: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception o){
                System.out.println("Vui lòng nhập đúng số!");
            }
            switch (choice){
                case 1:
                    for (Product p : productManage.getListProduct()) {
                        if (p.getStatus().equalsIgnoreCase("mới")){
                            System.out.println("\t\t\tDanh sách sản phẩm có trạng thái mới:");
                            System.out.println(p);
                            flag = true;
                        }
                    }
                    break;
                case 2:
                    for (Product p : productManage.getListProduct()) {
                        if (p.getStatus().equalsIgnoreCase("cũ")){
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
        } while (choice != 0);
    }

}
