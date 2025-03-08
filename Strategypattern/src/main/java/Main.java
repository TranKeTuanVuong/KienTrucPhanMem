import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập tên nhân viên
        System.out.print("Nhập tên nhân viên: ");
        String ten = sc.nextLine();
        NhanVien nhanVien = new NhanVien(ten);
        // Hiển thị menu chức vụ
        System.out.println("Chọn chức vụ:");
        System.out.println("1. Đội Trưởng");
        System.out.println("2. Giám đốc");
        System.out.println("3. Nhân viên VP");
        System.out.println("4. Kế Toán");
        System.out.print("Nhập lựa chọn: ");
        int choice = sc.nextInt();

        // Gán chức vụ tương ứng
        switch (choice) {
            case 1 -> nhanVien.setRole(new DoiTruong());
            case 2 -> nhanVien.setRole(new GiamDoc());
            case 3 -> nhanVien.setRole(new NhanVienVP());
            case 4 -> nhanVien.setRole(new KeToan());
            default -> {
                System.out.println("Lựa chọn không hợp lệ!");
                return;
            }
        }

        // Hiển thị công việc của nhân viên
        nhanVien.show();
        sc.close();
    }
}
