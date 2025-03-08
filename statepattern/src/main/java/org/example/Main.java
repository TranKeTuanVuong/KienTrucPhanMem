package org.example;

import demo.DoiTruong;
import demo.KeToan;
import demo.NhanVien;
import demo.NhanVienVP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        NhanVien nhanVien = new NhanVien("vương");
        switch (choice) {
            case 1:
                nhanVien.setRole(new DoiTruong());
                break;
            case 2:
                nhanVien.setRole(new NhanVienVP()); // Sửa getRole() thành setRole()
                break;
            case 3:
                nhanVien.setRole(new KeToan()); // Sửa getRole() thành setRole()
                break;
            default:
                System.out.println("Chức vụ không hợp lệ!");
                return;
        }


        if (nhanVien.getRole() == null) {
            System.out.println("Chưa có chức vụ, không thể thực hiện nhiệm vụ!");
        } else {
            nhanVien.showDuties();
        }



    }
}