package academy.learnprogramming;

import java.net.StandardSocketOptions;

public class Main {

    public static void main(String[] args) {

        int myValue =10000;
        int myMinIntValue =Integer.MIN_VALUE;
        int myMaxIntValue =Integer.MAX_VALUE;
        System.out.println("Integer minimum value = " + myMinIntValue);
        System.out.println("Integer minimum value = " + myMaxIntValue);
        System.out.println("Busted Max value = " + (myMaxIntValue+1));
        //overflow

        int myTotal = (myMinIntValue/2);
        byte myMinByteValue = Byte.MIN_VALUE;
        byte myNewByteValue = (byte) (myMinByteValue/2);

        byte byteValue=10;
        short shortValue=20;
        int intValue=50;
        long longTotal = 50000L + 10L *(byteValue+shortValue+intValue);
        System.out.println(longTotal);

        short shortTotal = (short )(1000+10*(byteValue+shortValue+intValue));
        String name = "Nagy Adam";
        System.out.println(name);
    }
}
