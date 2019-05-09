package Projects.TeamProject.Domain;

// 架构师
public class Architect extends Designer {
    // 股票数量
    private int stock;

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Architect{" +
                "stock=" + stock +
                '}';
    }
}
