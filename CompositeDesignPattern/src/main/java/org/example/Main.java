package org.example;

import java.util.ArrayList;
import java.util.List;

// Component: Interface chung cho các thành phần đơn lẻ và các thành phần tổng hợp
interface SaleComponent {
    double getPrice();
    String getName();
}

// Leaf: Sản phẩm là thành phần đơn lẻ
class Product implements SaleComponent {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Composite: Bàn là thành phần tổng hợp chứa nhiều sản phẩm
class Table implements SaleComponent {
    private String tableNumber;
    private List<SaleComponent> items = new ArrayList<>();

    public Table(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void addItem(SaleComponent item) {
        items.add(item);
    }

    public void removeItem(SaleComponent item) {
        items.remove(item);
    }

    @Override
    public double getPrice() {
        double totalPrice = 0;
        for (SaleComponent item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String getName() {
        return "Bàn " + tableNumber;
    }

    public List<SaleComponent> getItems() {
        return items;
    }
}

// Client: Quán cà phê
class CoffeeShop {
    private String name;
    private List<Table> tables = new ArrayList<>();

    public CoffeeShop(String name) {
        this.name = name;
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public void removeTable(Table table) {
        tables.remove(table);
    }

    public double getTotalRevenue() {
        double totalRevenue = 0;
        for (Table table : tables) {
            totalRevenue += table.getPrice();
        }
        return totalRevenue;
    }

    public String getName() {
        return name;
    }

    public List<Table> getTables() {
        return tables;
    }

    // In hóa đơn chi tiết
    public void printDetailedReport() {
        System.out.println("===== BÁO CÁO DOANH THU CỦA " + name.toUpperCase() + " =====");

        for (Table table : tables) {
            System.out.println("\n" + table.getName() + " - Tổng tiền: " + table.getPrice() + " VND");
            System.out.println("Chi tiết sản phẩm:");

            for (SaleComponent item : table.getItems()) {
                System.out.println("  - " + item.getName() + ": " + item.getPrice() + " VND");
            }
        }

        System.out.println("\n===== TỔNG DOANH THU: " + getTotalRevenue() + " VND =====");
    }
}

// Demo chạy thử
public class Main {
    public static void main(String[] args) {
        // Tạo quán cà phê
        CoffeeShop coffeeShop = new CoffeeShop("Coffee House");

        // Tạo các sản phẩm
        Product blackCoffee = new Product("Cà phê đen", 15000);
        Product milkCoffee = new Product("Cà phê sữa", 20000);
        Product tea = new Product("Trà", 18000);
        Product bubbleTea = new Product("Trà sữa", 30000);
        Product water = new Product("Nước suối", 10000);
        Product cake = new Product("Bánh ngọt", 25000);

        // Tạo các bàn và thêm sản phẩm
        // Bàn 1
        Table table1 = new Table("01");
        table1.addItem(blackCoffee);
        table1.addItem(milkCoffee);
        table1.addItem(cake);

        // Bàn 2
        Table table2 = new Table("02");
        table2.addItem(bubbleTea);
        table2.addItem(bubbleTea); // 2 ly trà sữa
        table2.addItem(water);

        // Bàn 3
        Table table3 = new Table("03");
        table3.addItem(tea);
        table3.addItem(water);

        // Thêm các bàn vào quán
        coffeeShop.addTable(table1);
        coffeeShop.addTable(table2);
        coffeeShop.addTable(table3);

        // In báo cáo chi tiết
        coffeeShop.printDetailedReport();

        // In tổng doanh thu
        System.out.println("\nTổng doanh thu: " + coffeeShop.getTotalRevenue() + " VND");
    }
}