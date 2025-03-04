import ThanhVienCongTu.GiamDoc;
import ThanhVienCongTu.KeToan;
import ThanhVienCongTu.NhanVienVP;
import ThanhVienCongTu.ThanhVien;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            ThanhVien thanhvien ;
            String chucvu = scanner.nextLine();
            switch (chucvu) {
                case "Giám Đốc":
                    thanhvien = new GiamDoc("Vương");
                    break;
                case "Nhân Viên Văn Phòng":
                    thanhvien = new NhanVienVP("Vương");
                    break;
                case "Kế Toán":
                    thanhvien = new KeToan("Vương");
                    break;
                default:
                    System.out.println("Chức vụ không hợp lệ!");
                    return;
            }
        System.out.println(thanhvien.getTen() + " (" + thanhvien.getChucVu() + ") phải làm: " + thanhvien.CongViec());
    }
}
