package Projects.TeamProject.Domain;

import Projects.TeamProject.Service.Status;

// 程序员
public class Programmer extends Employee {
    // memberId 用来记录成员加入开发团队后在团队中的ID
    // status是项目service包下自定义的枚举类型，表示成员的状态。
    //  - FREE-空闲
    //  - BUSY-已加入开发团队
    //  - VOCATION-正在休假
    //equipment 表示该成员领用的设备
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    protected String getMemberDetails() {
        return getMemberId() + "/" + getDetails();
    }

    public String getDetailsForTeam() {
        return getMemberDetails() + "\t程序员";
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "memberId=" + memberId +
                ", status=" + status +
                ", equipment=" + equipment +
                '}';
    }
}
