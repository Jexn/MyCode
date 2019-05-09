import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class MyTest {
    @Test
    public void method1() {
        Locale locale = Locale.getDefault();
        System.out.println(locale);

        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        String username = bundle.getString("username");
        String password = bundle.getString("password");
        String login = bundle.getString("login");
        String reset = bundle.getString("reset");
        String quit = bundle.getString("quit");

        System.out.println(login + "-" + username);
    }
}
