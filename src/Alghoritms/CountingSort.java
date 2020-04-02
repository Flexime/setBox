package Alghoritms;

        import java.util.Arrays;
        import java.util.Collections;

public class CountingSort {

    public static int[] countingSort(Integer[] theArray, int maxValue) {

        // counters array from 0 to max
        int numCounts[] = new int[maxValue + 1];


        // index = value
        for (int num : theArray) numCounts[num]++;

        // sorted array
        int[] sortedArray = new int[theArray.length];
        int currentSortedIndex = 0;
        // counters
        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];
            // values
            for (int k = 0; k < count; k++) {
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }
        return sortedArray;
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }



    public static void main(String args[])
    {

        Integer arr[] = {1,1,412,412,412,4,124,1645,6,4,62,512,54,7468,45,734};

        int max = Collections.max(Arrays.asList(arr));

        System.out.println("Sorted array is: ");
        printArray(countingSort(arr,max));


    }
}

