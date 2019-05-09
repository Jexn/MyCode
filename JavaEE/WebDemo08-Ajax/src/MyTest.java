import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyTest {
    @Test
    public void fastJSON(){
        System.out.println("-------------------FastJSON----------------------");
        User user = new User("老王","男",23);
        String UserJson = JSON.toJSONString(user);
        System.out.println(UserJson);

        User user1 = new User("老宋","男",22);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        String listJSON = JSON.toJSONString(list);
        System.out.println(listJSON);

        String dateJSON = JSON.toJSONStringWithDateFormat(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(dateJSON);
    }

    @Test
    public void GsonTest(){
        System.out.println("-------------------Gson----------------------");
        Gson gson = new Gson();
        User user = new User("老王","男",23);
        String UserJSON = gson.toJson(user);
        System.out.println(UserJSON);

        User user1 = new User("老宋","男",22);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        String listJSON = gson.toJson(list);
        System.out.println(listJSON);

        System.out.println("-------------------JsonToObject----------------------");
        String objectStr = "{\"age\":23,\"name\":\"老王\",\"sex\":\"男\"}";
        User formJSON = gson.fromJson(objectStr,User.class);
        System.out.println(formJSON);

        System.out.println("-------------JSON-TO-List-------------");
        String listStr = "[{\"age\":23,\"name\":\"老王\",\"sex\":\"男\"},{\"age\":22,\"name\":\"老宋\",\"sex\":\"男\"}]";
        ArrayList<User> list1 = gson.fromJson(listJSON, new TypeToken<ArrayList<User>>(){}.getType());
        System.out.println(list1);
        for (User user2 : list1) {
            System.out.println(user2.getName());
        }
    }
}
