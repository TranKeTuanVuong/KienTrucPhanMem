package ThanhVienCongTu;

public class NhanVienVP extends ThanhVien {
    public NhanVienVP(String ten) {
        super(ten,"Nhân Viên Văn Phòng");
    }
    @Override
    public String CongViec() {
        return "làm báo cáo";
    }
}
