package service.imp;

import java.util.Scanner;

public class AccountManage {
    Scanner scanner = new Scanner(System.in);
    public boolean Login() {
        System.out.println("Nhập vào user: ");
        String user= scanner.nextLine();
        System.out.println("Nhập vào password: ");
        String pass = scanner.nextLine();
        return user.equals("Thanh") && pass.equals("123456");

    }
}
