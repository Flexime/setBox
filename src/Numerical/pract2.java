package Numerical;
public class pract2 {

    public static void main(String[] args) {


        int N = 50;// 30 40 50 100


        double deltax = 1;
        double forwsum = 0, exsum = 0;
        double backsum = 0, centsum = 0;
        double arr[] = new double[N + 1], arr2[] = new double[N + 1];
        double arr3[] = new double[N + 1], arrex[] = new double[N+1];


        //exact
        for (int i = 0; i< N; i ++ ){
          exsum = 6* (Math.cos(3*i));

            exsum +=  arrex[i];
        }


        //forward
        for (int i = 0; i < N; i++) {
            forwsum = ((2 * Math.sin(3 *  i+1)) - 2 * Math.sin(3*i))
                    //======================================================
                    / deltax;
            // System.out.println( "currenst sum: " + sum);

            arr[i] = forwsum;
        }

        //backward
        for (int i = 0; i < N; i++) {
            backsum = ((2 * Math.sin(3*i)) - 2 * Math.sin(3 * i-1))
                    //======================================================
                    / deltax;
           // System.out.println("current sum: " + sum2);

            arr2[i] = backsum;
        }
        //central
        for (int i = 1; i < N; i++){
            centsum = (2*Math.sin(3*i +1 )  - (2*Math.sin(3*i - 1))      )
                    //======================================================
                    / 2 * deltax;
            arr3[i] = centsum;
        }

        System.out.println("exact: " + Math.abs(exsum));
        System.out.println("cent: " + Math.abs(centsum));
        System.out.println("back: "  + Math.abs(backsum));
        System.out.println( "forward: " + Math.abs(forwsum));



    }
}
