package udemy.learn.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import udemy.learn.config.AppConfig;
import udemy.learn.Game;
import udemy.learn.MessageGenerator;
import udemy.learn.NumberGenerator;


public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);
   // public static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // get number generator bean from context (container)
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // get message generator bean from context (container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        // call method next() to get a random number
        int number = numberGenerator.next();

        // log generated number
        log.info("number = {}", number);

        // get game bean from context (container)
        Game game = context.getBean(Game.class);

        // call messageGenerator methods
        log.info(messageGenerator.getMainMessage());
        log.info(messageGenerator.getResultMessage());

        // call reset method
        game.reset();

        // close context (container)
        context.close();

    }
}
