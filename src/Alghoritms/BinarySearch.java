package Alghoritms;

public class BinarySearch {
    // returns index of x
    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // if the element is present at the  middle

            if (arr[mid] == x)
                return mid;

            // if element is smaller than mid,
            // element is  in left subarray

            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // element is in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        //  element is not present  in array
        return -1;
    }

    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}
