package Lists;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        /*System.out.println("Enter how many Integers you want to store: ");
        int number=scanner.nextInt();
        int[] myIntegers = setIntegers(number);
        getIntegers(myIntegers);
        System.out.println("The average of the entered numbers: " + getAverage(myIntegers));

        getIntegers(sortArray(myIntegers));

        System.out.println(findMin(myIntegers));

        System.out.println(Arrays.toString(resizeArray(myIntegers)));
        */

        GroceryList groceryList = new GroceryList();
        groceryList.addGroceryItem("milk");
        groceryList.addGroceryItem("bread");
        groceryList.printGroceryList();
    }
    public static int[] setIntegers(int number){
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        for(int i=0;i<values.length;i++){
            values[i]=scanner.nextInt();
        }
        return values;
    }

    public static void getIntegers(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.println("Stored value on the "+ (i+1)+ ". element is: "+array[i]);
        }
    }

    public static double getAverage(int[] array){
        double sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        return sum/array.length;
    }

    public static int[] sortArray(int[] array){
        int[] sortedArray = new int[array.length];
        for(int i=0;i<array.length;i++){
            sortedArray[i]=array[i];
        }
        boolean flag=true;
        int temp;
        while(flag){
            flag=false;
            for(int i=0;i<sortedArray.length-1;i++){
                if(sortedArray[i]>sortedArray[i+1]){
                    temp=sortedArray[i];
                    sortedArray[i]=sortedArray[i+1];
                    sortedArray[i+1]=temp;
                    flag=true;
                }
            }
        }
        return sortedArray;
    }

    public static int findMin(int[] array){
        int[] sortedArray = new int[array.length];
        for(int i=0;i<array.length;i++){
            sortedArray[i]=array[i];
        }
        boolean flag=true;
        int temp;
        while(flag){
            flag=false;
            for(int i=0;i<sortedArray.length-1;i++){
                if(sortedArray[i]>sortedArray[i+1]){
                    temp=sortedArray[i];
                    sortedArray[i]=sortedArray[i+1];
                    sortedArray[i+1]=temp;
                    flag=true;
                }
            }
        }
        return sortedArray[0];
    }

    public static int[] resizeArray(int[] array){
        int[] newArray =array;
        array=new int[array.length+2];
        for(int i=0;i<newArray.length;i++){
            array[i]=newArray[i];
        }
        return array;
    }
}
