import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: lastVisitTime
 * @description: 使用Cookie实现上次访问时间
 * @author: Cube
 * @create: 2019-05-05 09:23
 **/
public class lastVisitTime extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        Long time = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        int index = 0;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if ("lastVisitTime".equals(cookies[i].getName())) {
                    time = Long.parseLong(cookies[i].getValue());
                }
                if ("index".equals(cookies[i].getName())) {
                    index = Integer.parseInt(cookies[i].getValue());
                    index++;
                }
            }
            if (time != null){
                out.println("你是第"+index+"访问，上次访问时间是："+simpleDateFormat.format(new Date(time)));
            }
        }else {
            out.println("你是第1次访问，当前时间是："+simpleDateFormat.format(new Date(System.currentTimeMillis())));
        }

        Cookie cookie = new Cookie("lastVisitTime", System.currentTimeMillis() + "");
        Cookie VisitIndex = new Cookie("index", index+"");
        cookie.setMaxAge(60);
        VisitIndex.setMaxAge(60);
        resp.addCookie(cookie);
        resp.addCookie(VisitIndex);
    }
}
