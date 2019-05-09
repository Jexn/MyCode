package Services;

import Dao.BookUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @program: addShoppingCart
 * @description: 添加购物车
 * @author: Cube
 * @create: 2019-05-05 15:38
 **/
public class addShoppingCart extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("id");
        HttpSession session = req.getSession();
        Map<String,Integer> map = (Map<String, Integer>) session.getAttribute("shoppingCart");
        if (map.get(id) == null){
            map.put(id,1);
        }else {
            map.put(id,map.get(id)+1);
        }
        session.setAttribute("shoppingCart",map);
        PrintWriter out = resp.getWriter();
        out.println(BookUtil.findBookById(Integer.parseInt(id)).getName()+"成功添加到购物车");
    }
}
