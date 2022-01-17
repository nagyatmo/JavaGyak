package udemy.learn.config;


import org.springframework.context.annotation.*;
import udemy.learn.GuessCount;
import udemy.learn.MaxNumber;
import org.springframework.beans.factory.annotation.Value;
import udemy.learn.MinNumber;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages = "udemy.learn")
public class GameConfig {

    // == fields ==
    @Value("${game.maxNumber}")
    private int maxNumber;

    @Value("${game.guessCount}")
    private int guessCount;

    @Value("${game.minNumber}")
    private int minNumber;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }
}