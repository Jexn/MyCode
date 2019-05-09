package Projects.TeamProject.Service;

import Projects.TeamProject.Domain.Architect;
import Projects.TeamProject.Domain.Designer;
import Projects.TeamProject.Domain.Employee;
import Projects.TeamProject.Domain.Programmer;

public class TeamService {
    private int count = 1;
    private static final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    public Programmer[] getTeam() {
        return team;
    }

    public void addMember(Employee employee) throws TeamException {
        if (total > MAX_MEMBER) {
            throw new TeamException("成员已满无法添加！");
        }
        if (!(employee instanceof Programmer)) {
            throw new TeamException("该员工不是开发人员，无法添加！");
        }

        Programmer programmer = (Programmer) employee;
        switch (programmer.getStatus()) {
            case BUSY:
                throw new TeamException("该员工已是其他团队成员!");
            case VOCATION:
                throw new TeamException("该员工正在休假！");
        }

        if (checkExist(programmer)) {
            throw new TeamException("该员工已经是该项目成员！");
        }

        int numberOfArchitect = 0, numberOfDesigner = 0, numberOfProgrammer = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numberOfArchitect++;
            } else if (team[i] instanceof Designer) {
                numberOfDesigner++;
            } else if (team[i] instanceof Programmer) {
                numberOfProgrammer++;
            }
        }

        if (programmer instanceof Architect) {
            if (numberOfArchitect >= 1) {
                throw new TeamException("团队中最多只有一名框架师");
            }
        } else if (programmer instanceof Designer) {
            if (numberOfDesigner >= 2) {
                throw new TeamException("团队中最多只有两名设计师");
            }
        } else if (programmer instanceof Programmer) {
            if (numberOfProgrammer >= 3) {
                throw new TeamException("团队中最多只有三名设计师");
            }
        }

        programmer.setStatus(Status.BUSY);
        programmer.setMemberId(count++);
        team[total++] = programmer;
    }

    // 检查成员是否已经存在
    public boolean checkExist(Programmer programmer) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == programmer.getId()) {
                return true;
            }
        }
        return false;
    }

    // 删除指定ID的团队成员
    public void removeMember(int memberId) throws TeamException {
        int n = 0;

        for (; n < total; n++) {
            if (team[n].getMemberId() == memberId) {
                team[n].setStatus(Status.FREE);
                break;
            }
        }

        if (n == total) {
            throw new TeamException("找不到该成员，无法删除");
        }

        // 后面成员覆盖前面成员ID
        for (int i = n + 1; i < total; i++) {
            team[i - 1] = team[i];
        }
        team[--total] = null;
    }
}
