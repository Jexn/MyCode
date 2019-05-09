package Log4j;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName ServletLog
 * @Description TODO
 * @Author Cube
 * @Date 2019-05-07 16:03
 */
@WebServlet(value = "/log4j")
public class ServletLog extends HttpServlet {
    private Logger logger = Logger.getLogger(ServletLog.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        logger.debug("debug信息");
        logger.info("info信息");
        logger.warn("warn信息");
        logger.error("error信息");

        PrintWriter out = resp.getWriter();
        out.write("Log4j测试");
    }
}
