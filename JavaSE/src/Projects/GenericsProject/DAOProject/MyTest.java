package Projects.GenericsProject.DAOProject;

import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void daoTest(){
        DAO<Integer> dao = new DAO<>();
        dao.save("老王",10);
        dao.save("老赵",20);
        dao.save("老钱",50);
        dao.save("老李",45);
        dao.save("老周",25);

        System.out.println("dao = " + dao);

        List<Integer> list = dao.list();

        System.out.println("list = " + list);

        dao.delete("老王");

        System.out.println("dao = " + dao);

        System.out.println("dao.get(\"老王\") = " + dao.get("老王"));

        System.out.println("dao.get(\"老李\") = " + dao.get("老李"));

        dao.save("老周",100);

        System.out.println("list = " + list);

        System.out.println("dao = " + dao);
    }

    @Test
    public void userTest(){
        DAO<User> dao = new DAO<>();

        User user1 = new User(001,"刘德华",34);
        User user2 = new User(002,"古天乐",32);
        User user3 = new User(003,"刘亦菲",23);
        User user4 = new User(004,"周杰伦",29);
        User user5 = new User(005,"明凯",26);

        dao.save("NO-001",user1);
        dao.save("NO-002",user2);
        dao.save("NO-003",user3);
        dao.save("NO-004",user4);
        dao.save("NO-005",user5);

        System.out.println("dao.list() = " + dao.list());

        System.out.println("dao = " + dao);

        System.out.println("dao.get(\"No-003\") = " + dao.get("No-003"));

        dao.delete("NO-005");

        System.out.println("dao = " + dao);
    }
}
