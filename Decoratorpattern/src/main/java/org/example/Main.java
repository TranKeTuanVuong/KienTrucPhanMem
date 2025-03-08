package org.example;
import java.util.Scanner;

// Interface Role
interface Role {
    void performDuties();
}

// Lớp cơ bản của nhân viên (không có nhiệm vụ gì)
class BasicRole implements Role {
    @Override
    public void performDuties() {
        System.out.println(" ");
    }
}

// Decorator để mở rộng chức năng của Role
abstract class RoleDecorator implements Role {
    protected Role decoratedRole;

    public RoleDecorator(Role decoratedRole) {
        this.decoratedRole = decoratedRole;
    }

    @Override
    public void performDuties() {
        decoratedRole.performDuties();
    }
}

// Decorator cho Đội Trưởng
class DoiTruongDecorator extends RoleDecorator {
    public DoiTruongDecorator(Role decoratedRole) {
        super(decoratedRole);
    }

    @Override
    public void performDuties() {
        decoratedRole.performDuties();
        System.out.println("Đi tuần, Gán việc cho nhân viên.");
    }
}

// Decorator cho Giám Đốc
class GiamDocDecorator extends RoleDecorator {
    public GiamDocDecorator(Role decoratedRole) {
        super(decoratedRole);
    }

    @Override
    public void performDuties() {
        decoratedRole.performDuties();
        System.out.println("Quản lý công ty, Ra quyết định quan trọng.");
    }
}

// Decorator cho Nhân Viên Văn Phòng
class NhanVienVPDecorator extends RoleDecorator {
    public NhanVienVPDecorator(Role decoratedRole) {
        super(decoratedRole);
    }

    @Override
    public void performDuties() {
        decoratedRole.performDuties();
        System.out.println("Pha trà, Phê duyệt tài liệu.");
    }
}

// Lớp NhanVien
class NhanVien {
    private String name;
    private Role role;

    public NhanVien(String name) {
        this.name = name;
        this.role = new BasicRole(); // Mặc định không có nhiệm vụ
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void showDuties() {
        System.out.print(name + " - Công việc: ");
        role.performDuties();
    }
}
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

        System.out.print("Nhập lựa chọn: ");
        int choice = sc.nextInt();

        // Gán chức vụ bằng Decorator
        switch (choice) {
            case 1 -> nhanVien.setRole(new DoiTruongDecorator(new BasicRole()));
            case 2 -> nhanVien.setRole(new GiamDocDecorator(new BasicRole()));
            case 3 -> nhanVien.setRole(new NhanVienVPDecorator(new BasicRole()));
            default -> {
                System.out.println("Lựa chọn không hợp lệ!");
                return;
            }
        }

        // Hiển thị công việc của nhân viên
        nhanVien.showDuties();
        sc.close();
    }
}