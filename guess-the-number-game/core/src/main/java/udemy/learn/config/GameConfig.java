package udemy.learn.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import udemy.learn.GuessCount;
import udemy.learn.MaxNumber;

@Configuration
public class GameConfig {

    // == fields ==
    private int maxNumber = 100;
    private int guessCount = 10;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }
    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }
}
