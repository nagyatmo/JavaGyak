package Lists.Autoboxing;

import java.lang.reflect.Array;
import java.util.ArrayList;

class IntValue{
    private int myValue;

    public IntValue(int myValue){
        this.myValue=myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}
//AUTOBOXING
public class Main {
    public static void main(String[] args) {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("Adam");

        //ArrayList<int> intArrayList = new ArrayList<int>();
        ArrayList<IntValue> intValueArrayList = new ArrayList<IntValue>();
        intValueArrayList.add(new IntValue(54));

        ArrayList<Integer> integerValue = new ArrayList<Integer>();
        integerValue.add(54);

        for(int i=0;i<=10;i++){
            integerValue.add(Integer.valueOf(i));
        }

        Integer myIntValue = 56; // Integer.valueOf(56);
        int myInt = myIntValue.intValue();

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for(double dbl=0.0;dbl<=10.0;dbl+=0.5){
            myDoubleValues.add(Double.valueOf(dbl));
        }

        for(int i=0;i<myDoubleValues.size();i++){
            double value=myDoubleValues.get(i).doubleValue();
            System.out.println(value);
        }

    }
}
