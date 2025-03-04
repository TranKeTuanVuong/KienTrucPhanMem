package demo;

public class NhanVien {
    private  String name;
    private  Role role;

    public NhanVien(String name) {
        this.name = name;
    }

    public NhanVien(String name ,Role role) {
        this.name = name;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void showDuties() {
        System.out.print(name + " - ");
        role.performDuties();
    }
}
