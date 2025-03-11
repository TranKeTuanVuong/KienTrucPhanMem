import java.util.ArrayList;
import java.util.List;

// Interface Subject - Đối tượng được quan sát (Observable)
interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(); // Đổi tên từ notify() thành notifyObservers()
}

// Interface Observer - Đối tượng quan sát
interface Observer {
    void update(String message);
}

// Concrete Subject - Lớp trưởng
class ClassMonitor implements Subject {
    private String className;
    private List<Observer> observers = new ArrayList<>();
    private String latestNews;

    public ClassMonitor(String className) {
        this.className = className;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() { // Đổi tên từ notify() thành notifyObservers()
        for (Observer observer : observers) {
            observer.update(latestNews);
        }
    }

    // Phương thức tạo thông báo mới
    public void createNews(String news) {
        this.latestNews = news;
        System.out.println("Lớp trưởng lớp " + className + " tạo thông báo: " + news);
        notifyObservers(); // Đổi tên từ notify() thành notifyObservers()
    }
}

// Concrete Observer - Sinh viên
class Student implements Observer {
    private String studentId;
    private String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Sinh viên " + name + " (MSSV: " + studentId + ") nhận được thông báo: " + message);
    }
}

// Lớp học quản lý nhiều sinh viên và có một lớp trưởng
class ClassRoom {
    private String className;
    private ClassMonitor classMonitor;
    private List<Student> students = new ArrayList<>();

    public ClassRoom(String className) {
        this.className = className;
        this.classMonitor = new ClassMonitor(className);
    }

    public void addStudent(Student student) {
        students.add(student);
        classMonitor.attach(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        classMonitor.detach(student);
    }

    public ClassMonitor getClassMonitor() {
        return classMonitor;
    }
}

// Faculty - Khoa quản lý nhiều lớp học
class Faculty {
    private String facultyName;
    private List<ClassRoom> classRooms = new ArrayList<>();

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    public void addClass(ClassRoom classRoom) {
        classRooms.add(classRoom);
    }

    public void removeClass(ClassRoom classRoom) {
        classRooms.remove(classRoom);
    }
}

// Demo chạy thử
public class Main {
    public static void main(String[] args) {
        // Tạo Khoa
        Faculty itFaculty = new Faculty("Khoa Công nghệ thông tin");

        // Tạo lớp học
        ClassRoom classIT01 = new ClassRoom("IT01");

        // Thêm lớp vào khoa
        itFaculty.addClass(classIT01);

        // Tạo sinh viên
        Student student1 = new Student("SV001", "Nguyễn Văn A");
        Student student2 = new Student("SV002", "Trần Thị B");
        Student student3 = new Student("SV003", "Lê Văn C");

        // Thêm sinh viên vào lớp
        classIT01.addStudent(student1);
        classIT01.addStudent(student2);
        classIT01.addStudent(student3);

        // Lớp trưởng gửi thông báo
        classIT01.getClassMonitor().createNews("Ngày mai lớp có buổi học PTTKHT lúc 7h30!");

        // Thêm sinh viên mới
        Student student4 = new Student("SV004", "Phạm Thị D");
        classIT01.addStudent(student4);

        // Lớp trưởng gửi thông báo mới
        classIT01.getClassMonitor().createNews("Buổi học PTTKHT ngày mai được dời sang 13h30!");

        // Xóa một sinh viên khỏi lớp
        classIT01.removeStudent(student2);

        // Lớp trưởng gửi thông báo mới
        classIT01.getClassMonitor().createNews("Nộp bài tập môn PTTKHT vào thứ 6!");
    }
}