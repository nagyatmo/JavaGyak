

public class LeapYear {

    public void main(String[] args){
            int[] tomb={1,3,1};
            LeapYear(tomb);
    }
    public int LeapYear(int[] array) {
        if (array == null) {
            return 0;
        }
        int result = -1;
        long sumfromright = 0L;
        long[] sumsfromleft = new long[array.length];
        for (int i = 1; i < sumsfromleft.length; i++) {
            if (i != array.length - 1) {
                sumsfromleft[i] = sumsfromleft[i - 1] + array[i - 1];
                sumfromright = sumfromright + array[i + 1];
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (sumsfromleft[i] == sumfromright) {
                result = i;
            }
        }
        return result;
    }
}