import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName Log4j2Test
 * @Description TODO
 * @Author Cube
 * @Date 2019-05-07 17:06
 */
@SuppressWarnings("ALL")
public class Log4j2Test {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Log4j2Test.class);

        logger.debug("debug信息");
        logger.info("info信息");
        logger.warn("warn信息");
        logger.error("error信息");
    }
}
