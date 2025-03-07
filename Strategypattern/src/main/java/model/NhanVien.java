package model;

public class NhanVien {
    private String name;
    private Role role;


    public NhanVien(String name, Role role) {
        this.name = name;
        this.role = role;
    }
    public NhanVien(String name) {
        this.name = name;
        this.role = null; // Chưa có chức vụ
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void show(){
        if (role!=null){
            System.out.println(name + " Công việc: ");
            role.performDuties();
        } else {
            System.out.println(name + " Chưa có chức vụ");
        }
    }
}
