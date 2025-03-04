package ThanhVienCongTu;

public class KeToan extends  ThanhVien {
    public KeToan(String ten) {
        super(ten,"Kế Toán");
    }
    @Override
    public String CongViec (){
        return "Tính lương";
    }
}
