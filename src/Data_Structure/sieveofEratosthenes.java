package Data_Structure;

//out all primes till inputed integer



public class sieveofEratosthenes {
    void sieveOfEratosthenes(int n ){
        boolean isprime[] = new boolean[n+1];
        for(int i =0; i<n; i++)
            isprime[i] =true;
        for(int p = 2; p*p <=n; p++){
            if(isprime[p] == true){
                for(int i = p*p; i<= n; i+=p)
                    isprime[i] = false;
            }
        }

        for(int i =2; i<=n; i++){
            if(isprime[i] == true)
                System.out.println(i+ " ");
        }

    }


    static int arr[] = new int[]{10, 12, 13, 16, 18, 19, 20, 21, 22, 23,23,
            24, 33, 35, 42, 47};

    static int interpolationSearch(int x)
    {
        // Find indexes of two corners
        int low = 0, hi = (arr.length - 1);

        // Since array is sorted, an element present
        // in array must be in range defined by corner
        while (low <= hi && x >= arr[low] && x <= arr[hi])
        {

            if (low == hi)
            {
                if (arr[low] == x) return low;
                return -1;
            }

            int pos = low + (((hi-low) /
                    (arr[hi]-arr[low]))*(x - arr[low]));

            // Condition of target found
            if (arr[pos] == x)
                return pos;

            // If x is larger, x is in upper part
            if (arr[pos] < x)
                low = pos + 1;

                // If x is smaller, x is in the lower part
            else
                hi = pos - 1;
        }
        return -1;
    }


    public static void main(String[] args)
    {
        int x = 23; // Element to be searched
        int index = interpolationSearch(x);

        // If element was found
        if (index != -1)
            System.out.println("Element found at index " + index);
        else
            System.out.println("Element not found.");
    }
}


