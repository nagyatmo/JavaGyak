package udemy.learn.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import udemy.learn.config.GameConfig;


public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);
    // public static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);


        // close context (container)
        context.close();

    }
}
