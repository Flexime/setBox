package Alghoritms;

class QuickSort
{

    int partition(double[] arr, int low, int high)
    {
        double pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            //current
            if (arr[j] < pivot)
            {
                i++;
                //swap i j
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap i+1 high or pivot
        double temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* low  start index
       high end index  */
    void sort(double[] arr, int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index */

            int pi = partition(arr, low, high);

            /* Recursively sort elements*/

            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

  public static double[] randarr(double[] arr, double N){

      for (int i =0; i<arr.length;i++){
            arr[i] = (int) (Math.random()*N);
        }
        return arr;
  }


    static void printArray(double[] arr)
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }


    public static void main(String args[])
    {
        double N = Math.pow(10,6);
         double [] arr = new double[(int) N];
        randarr(arr,N);
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);

        System.out.println("sorted array: ");
        printArray(arr);
    }
}