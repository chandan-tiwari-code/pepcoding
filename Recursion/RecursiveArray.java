package Recursion;

public class RecursiveArray {
    public static void main(String[] args) {
       int[] array= {10, 20, 30, 80, 40, 50, 60};
      // displayArray(array, array.length-1);
      // displayReverse(array, 0, array.length-1);
      // add for loop to view array element
      // System.out.println(max(array, array.length-1));
      System.out.println(firstOccurance(array,  array.length-1, 20));
    }

    private static void displayArray(int[] array, int idx) {
        if (idx<0) return;
        displayArray(array, idx-1);
        System.out.println(array[idx]);
    }

    private static void displayReverse(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        displayReverse(array, start+1, end-1);
        int temp = array[start];
        array[start]=array[end];
        array[end]=temp;
    }

    private static int max(int[] array, int idx) {
        if(idx<0) return array[0];
        int max = max(array, idx-1);
        return max > array[idx] ? max : array[idx];
    }

    private static int firstOccurance(int[] array, int idx, int val) {
        if(idx==array.length-1) {
            return -1;
        }
        if (array[idx] == val) {
            return idx;
        }
        else {
            int ans = firstOccurance(array, idx+1, val);
            return ans;
        }
    }

    
}
