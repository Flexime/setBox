package Alghoritms;


        import org.w3c.dom.ls.LSOutput;

        import java.util.*;
class  Grays_code {
    static void generateGrayarr(int n,ArrayList<String>  arr) {
        if (n <= 0)
            return;
        // bit
        arr.add("0");
        arr.add("1");

        int i, j;
        for (i = 2; i < (1<<n); i = i<<1) //L1 list of n-1 bit
        {
            // reverse of L1  L2

            for (j = i-1 ; j >= 0 ; j--)
                arr.add(arr.get(j));

            // append 0 to the first half
            for (j = 0 ; j < i ; j++)
                arr.set(j, "0" + arr.get(j));

            // append 1 to the second half
            for (j = i ; j < 2*i ; j++)
                arr.set(j, "1" + arr.get(j));
        }
        //Concatenate
        for (i = 0 ; i < arr.size() ; i++ )
            System.out.println(arr.get(i));
    }



    static char flip(char c) {
        return (c == '0') ? '1': '0';
    }

    static String graytoBinary(ArrayList<String>  arr)
    {
        String listString =  String.join(", ",arr); //Array list to string

        String binary = "";

        binary += listString.charAt(0);

        // Compute remaining bits
        for (int i = 1; i < listString.length(); i++) {


            // If current bit is 0,concatenate previous bit
            if (listString.charAt(i) == '0')
                binary += binary.charAt(i - 1);

                // Else, concatenate invert of previous bit
            else
                binary += flip(binary.charAt(i - 1));
        }

        return binary;

    }

    public static void main(String[] args)
    {
        ArrayList<String> arr = new ArrayList<String> ();
        generateGrayarr(4,arr);
        System.out.println( graytoBinary(arr));

    }
}
