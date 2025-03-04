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
                nhanVien.getRole(new NhanVienVP());
                break;
            case 3:
                nhanVien.getRole(new KeToan());
                break;
            default:
                System.out.println("Chức vụ không hợp lệ!");
                return;
        }

        nhanVien.showDuties();


    }
}