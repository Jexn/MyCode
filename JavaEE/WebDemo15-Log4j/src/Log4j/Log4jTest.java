package Log4j;

import org.apache.log4j.Logger;

/**
 * @ClassName Log4jTest
 * @Description TODO
 * @Author Cube
 * @Date 2019-05-07 15:58
 */
public class Log4jTest {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Log4jTest.class);

        logger.debug("debug信息");
        logger.info("info信息");
        logger.warn("warn信息");
        logger.error("error信息");
    }
}
