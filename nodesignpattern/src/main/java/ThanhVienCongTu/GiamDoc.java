package ThanhVienCongTu;

public class GiamDoc extends ThanhVien {
    public GiamDoc(String ten) {
        super(ten,"Giám Đốc");
    }
    @Override
    public String CongViec  (){
        return "Đi trả lương";
    }

}
