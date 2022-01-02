package com.nagyadam;

import java.util.Scanner;
import java.lang.Math;

public class Gyak {

    /*public static void main(String[] args){
        /*System.out.println(getDurationString(125,30));

        System.out.println(getDurationString(5000));


        if(!isLeapYear(2017)){
            System.out.println("Nem szokoev");
        }
        System.out.println(getDaysInMonth(2,2020));
        printYearsAndDays(561600);

        isPalindrome(11);

        printFactors(6);
        if(isPerfectNumber(33)){
            System.out.println("Perfect number");
        }

        numberToWords(1000);

        System.out.println(getDigitCount(11));
        System.out.println(getDigitCount(reverse(11)));
        System.out.println(reverse(-121));
        System.out.println(getLargestPrime(21));
        System.out.println(calculator());
        System.out.println(tenSum());
        findMinMax();
        inputThenPrintSumAndAverage();
        System.out.println(getBucketCount(3.4,2.1,1.5,2));

    }*/

    public static String getDurationString(int minutes, int seconds){
        if(minutes<0 || (seconds<0 || seconds>60)){
            return "Invalid value";
        }
        int hours=minutes/60;
        int leftMinutes=minutes%60;

        return hours+"h "+leftMinutes+"m "+seconds+"s";
    }

    public static String getDurationString(int seconds){
        if(seconds<0){
            return "Invalid value";
        }
        int minutes=seconds/60;
        seconds=seconds%60;

        return getDurationString(minutes, seconds);
    }
    public static void printYearsAndDays(long minutes){
        if(minutes<0){
            System.out.println("Invalid value");
        }else{
            long hour=minutes/60;
            long day=hour/24;
            long year=day/365;
            day=day%365;
            System.out.println(minutes +" min = "+year+" y and "+day+" d");
        }

    }

    public static void printEqual(int a, int b, int c){
        if(a<0||b<0||c<0){
            System.out.println("Invalid Value");
        }else if(a==b && b==c){
            System.out.println("All numbers are equal");
        }else if(a!=b && c!=a && b!=c){
            System.out.println("All numbers are different");
        }else{
            System.out.println("Neither all are equal or different");
        }
    }

    public static boolean isCatPlaying(boolean summer, int temperature){
        if(temperature<25 || temperature>45){
            return false;
        }else if(!summer && temperature>35){
            return false;
        }else{
            return true;
        }

    }

    public static void printDayOfTheWekk(int day){
        switch(day){
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

    public static boolean isLeapYear(int year){
        if(year<1 || year>9999){
            return false;
        }else{
            if((year%4==0 && year%100!=0) || year%400==0){
                return true;
            }else{
                return false;
            }
        }
    }

    public static int getDaysInMonth(int month, int year){

        if((month<1 || month>12) || (year<1 || year>9999)){
            return -1;
        }

        switch(month){
            case 1:
                return 31;
            case 2:
                if(isLeapYear(year)){
                    return 29;
                }
                return 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
        }
        return -1;
    }

    public static int sumDigits(int number){
        if(number<10){
            return -1;
        }
        int sum=0;
        while(number>0){
            int digit=number%10;
            sum+=digit;
            number/=10;
        }

        return sum;
    }
    public static boolean isPalindrome(int number){
        int original=number;
        int lastDigit=0;
        int reverse=0;
        while(number>0){
            lastDigit=number%10;
            reverse=reverse*10;
            reverse+=lastDigit;
            number/=10;
        }
        System.out.println(reverse);
        System.out.println(number);
        if(reverse==original){
            return true;
        }else{
            return false;
        }

    }

    public static int sumFirstAndLastDigit(int number){
        if(number<0){
            return -1;
        }
        int lastDigit;
        int firstDigit;
        lastDigit = number % 10;

        firstDigit = number;

        while(number >= 10)
        {
            number = number / 10;
        }
        firstDigit = number;
        return firstDigit+lastDigit;
    }

    public static int getEvenDigitSum(int number){
        if(number<0){
            return -1;
        }
        int lastDigit = 0;
        int evenDigitSum = 0;

        while(number>0) {
            lastDigit = number%10;
            if(lastDigit % 2 == 0){
                evenDigitSum += lastDigit;
            }
            number = number / 10;
        }

        return evenDigitSum;
    }

    public static int getGreatestCommonDivisor(int first, int second){
        if(first<10 || second<10){
            return -1;
        }
        int gcd = 1;
        for (int i = 1; i <= first && i <= second; i++) {
            if (first % i == 0 && second % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
    public static void printFactors(int number){
        if(number<1){
            System.out.println("Invalid Value");
        }

        for(int i=1;i<=number;i++){
            if(number%i==0){
                System.out.println(i);
            }

        }

    }
    public static boolean isPerfectNumber(int number){
        if(number<1){
            return false;
        }
        int sum=0;
        for(int i=1;i<number;i++){
            if(number%i==0){
                sum+=i;
            }
        }
        if(sum==number){
            return true;
        }else{
            return false;
        }
    }

    public static void numberToWords(int number){
        if(number==0){
            System.out.println("Zero");
        }

        int newNum=reverse(number);
        int a=getDigitCount(newNum);

        int lastDigit;
        while(newNum>0){
            lastDigit=newNum%10;
            switch(lastDigit){
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
            }
            newNum/=10;
        }
        if(a!=getDigitCount(number)){
            int dif=getDigitCount(number)-a;
            for(int i=0;i<dif;i++){
                System.out.println("Zero");
            }
        }

    }



    public static int reverse(int num){
        if(num<0){
            num*=-1;
        }
        int lastDigit=0;
        int reverse=0;
        while(num>0){
            lastDigit=num%10;
            reverse=reverse*10;
            reverse+=lastDigit;
            num/=10;
        }
        if(num<0){
            reverse*=-1;
        }
        return reverse;
    }



    public static void typeNum(int num){
        switch(num){
            case 0:
                System.out.println("Zero");
                break;
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
        }
    }
    
    public static int getDigitCount(int number){

        int count = 0;
        if(number==0){
            count=1;
        }else{
            while(number>0){
                count+=1;
                number/=10;
            }
        }
        return count;
    }

    public static int getLargestPrime(int number){
        int temp=0;
        for(int i=1;i<number;i++){
            if(number%i==0 && isPrime(i)){
                temp=i;
            }
        }
        return temp;
    }

    public static boolean isPrime(int num){
        int count=0;
        for(int i=1;i<=num;i++){
            if(num%i==0){
                count++;
            }
        }
        if(count==2){
            return true;
        }else{
            return false;
        }
    }

    public static int calculator(){
        Scanner scanner = new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        scanner.nextLine();
        String app = scanner.nextLine();
        switch(app){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;

        }
        return -1;
    }

    public static int tenSum(){
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        int sum = 0;

        while(counter<10){
            int order=counter + 1;
            System.out.println("Enter number #" + order + ":");
            boolean isAnInt =scanner.hasNextInt();

            if(isAnInt){
                int number = scanner.nextInt();
                counter++;
                sum+=number;

            }else{
                System.out.println("Invalid Number");
            }
            scanner.nextLine();

        }
        scanner.close();
        return sum;
    }

    public static void findMinMax(){
        Scanner scanner = new Scanner(System.in);

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        while(true) {
            System.out.println("Enter number:");
            boolean isAnInt = scanner.hasNextInt();

            if(isAnInt){
                int number = scanner.nextInt();

                if(number>max){
                    max=number;
                }
                if(number<min){
                    min=number;
                }
            }else{
                break;
            }
            scanner.nextLine();
        }
        System.out.println("Min number: "+ min + " and max number: " + max);
        scanner.close();

    }

    public static void inputThenPrintSumAndAverage(){
        Scanner scanner = new Scanner(System.in);
        int counter=0;
        int sum=0;
        double avg=0;
        while(true){
            boolean isAnInt=scanner.hasNextInt();
            if(isAnInt){
                int number = scanner.nextInt();
                sum+=number;
                counter++;
                avg=(double)sum/counter;
            }else{
                break;
            }
        }
        System.out.println("SUM = " + sum + " AVG = " + Math.round(avg));
    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets){
        if(width<=0 || height<=0 || areaPerBucket<=0 || extraBuckets<0){
            return -1;
        }
        double area=width*height;
        System.out.println("area: " + area);
        double coveredArea=areaPerBucket*extraBuckets;
        System.out.println("covered area: " + coveredArea);
        double notYetCoveredArea=area-coveredArea;
        System.out.println("not yet covered area: " + notYetCoveredArea);
        int neededBuckets= (int) Math.ceil( (notYetCoveredArea/areaPerBucket));
        return neededBuckets;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket){
        if(width<=0 || height<=0 || areaPerBucket<=0){
            return -1;
        }
        double area=width*height;
        int neededBuckets= (int) Math.ceil( (area/areaPerBucket));
        return neededBuckets;
    }
    public static int getBucketCount(double area, double areaPerBucket){
        if(area<=0 || areaPerBucket<=0){
            return -1;
        }
        int neededBuckets= (int) Math.ceil( (area/areaPerBucket));
        return neededBuckets;
    }


}
