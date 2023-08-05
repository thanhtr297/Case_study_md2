package controller;

import java.util.Scanner;

public class LoginAndLogOut {
    Scanner scanner = new Scanner(System.in);
    public void login(){

        int choice;
        do {
            System.out.println("Đăng nhập");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){

            }
        } while (choice != 0);
    }
}
