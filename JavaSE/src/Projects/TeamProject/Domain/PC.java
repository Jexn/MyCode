package Projects.TeamProject.Domain;

public class PC implements Equipment {

    // model 表示机器的型号
    // display 表示显示器名称
    // type 表示机器的类型
    private String model;
    private String display;

    public PC(String model, String display) {
        super();
        this.model = model;
        this.display = display;
    }

    public PC() {
        super();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return "PC{" +
                "model='" + model + '\'' +
                ", display='" + display + '\'' +
                '}';
    }
}
