package Alghoritms;

        import java.util.Arrays;
        import java.util.Collections;

public class BucketSort {

    public static void bucketSort(Integer[] a, int maxValue) {
        int [] bucket=new int[maxValue+1];

        for (int i=0; i<bucket.length; i++) {
            bucket[i]=0;
        }

        for (int i=0; i<a.length; i++) {
            bucket[a[i]]++;
        }

        int outPos=0;
        for (int i=0; i<bucket.length; i++) {
            for (int j=0; j<bucket[i]; j++) {
                a[outPos++]=i;
            }
        }
    }

    public static void main(String[] args) {
        Integer arr[] = {1,124,12,45,1,7,567,9,134,247,679,35,215,469,6793,512,427,6};

        int max = Collections.max(Arrays.asList(arr));

        bucketSort(arr,max);
        System.out.println("Sorted array is: "+ Arrays.toString(arr));



    }




}
