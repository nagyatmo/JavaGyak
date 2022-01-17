package udemy.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GameImpl implements Game{

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);




    // == fields ==

    private final NumberGenerator numberGenerator;
    private final int guessCount;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int RemainingGuesses;
    private boolean validNumberRange = true;

    // == constructor ==
    @Autowired
    public GameImpl(@GuessCount int guessCount, NumberGenerator numberGenerator) {
        this.guessCount = guessCount;
        this.numberGenerator = numberGenerator;
    }

    // == init ==
    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = 0;
        RemainingGuesses = guessCount;
        biggest=numberGenerator.getMaxNumber();
        number= numberGenerator.next();
        log.debug("the number is {}" , number);
    }

    @PreDestroy
    public void preDestroy(){
        log.info("in Game preDestroy");
    }

    // == public methods ==
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess=guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return RemainingGuesses;
    }

    @Override
    public int getGuessCount() {
        return guessCount;
    }


    @Override
    public void check() {
        checkValidNumberRange();
        if(validNumberRange){
            if(guess >number){
                biggest = guess - 1;
            }
            if(guess < number){
                smallest = guess + 1;
            }
        }
        RemainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && RemainingGuesses <= 0;
    }

// == private methods
    private void checkValidNumberRange(){
        validNumberRange = (guess >=smallest) && (guess <= biggest);
    }
}
