import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class jQueryJSON extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String privilege = req.getParameter("type");

        System.out.println(name+":"+privilege);
        System.out.println(name+":已收到jQuery请求");

        Person person = new Person(name,privilege);
        Gson gson = new Gson();

        String jsonInfo = gson.toJson(person);
        resp.getWriter().write(jsonInfo);

    }
}
