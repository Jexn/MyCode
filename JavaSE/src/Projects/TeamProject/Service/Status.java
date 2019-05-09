package Projects.TeamProject.Service;

// 现在工作状况
public enum Status {
    FREE("空闲"),
    BUSY("已加入开发团队"),
    VOCATION("正在休假");

    private final String STATUS_INFO;

    Status(String STATUS_INFO) {
        this.STATUS_INFO = STATUS_INFO;
    }

    public String getSTATUS_INFO() {
        return STATUS_INFO;
    }

    @Override
    public String toString() {
        return "Status{" +
                "STATUS_INFO='" + STATUS_INFO + '\'' +
                '}';
    }
}
