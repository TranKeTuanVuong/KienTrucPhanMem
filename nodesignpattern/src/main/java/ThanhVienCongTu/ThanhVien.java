package ThanhVienCongTu;

public class ThanhVien {
    private String chucVu;
    private String ten;

    public ThanhVien() {
    }

    public ThanhVien(String chucVu,String ten) {
        this.chucVu = chucVu;
        this.ten = ten;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String CongViec () {
        return  "khong co cong viec cu the";
    }

}
