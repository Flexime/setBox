package Numerical;
import jdk.jshell.EvalException;

import java.io.IOException;

public class Euler_Method {

    /**===================euler==================================================================================*/
        float func(float x, float y)
        {
            return (x*x -2*y);
        }
        static float funcex(float x){

            return (float) ( 0.75 * Math.pow( Math.E,-2 *x) + 0.5*x*x - 0.5 *x + 0.25);

        }

        // Function for Euler formula
        void euler(float x0, float y, float h, float x, int i)
        {
            float temp = -0;
            float arrEU[] =new float[10];
            // Iterating

            while (x0 < x) {
                temp = y;
                y = y + h * func(x0, y);
                x0 = x0 + h;
            }

            System.out.println("Approximate solution at x = "
                    + x + " is " + y);

            arrEU[i]= y;
        }


/**========================================RungeKutta===============================================================================================================*/

static double dydx(double x, double y)
{
    return (x*x -2*y);
}
    static double rungeKutta(double x0, double y0,
                             double x, double h)
    {
        //number of iterations using step and step height

        int n = (int)((x - x0) / h);
        double k1, k2;

        double y = y0;
        for (int i = 1; i <= n; i++) {
            // Apply Runge Kutta Formulas
            // to find next value of y
            k1 = h * dydx(x0, y);
            k2 = h * dydx(x0 + 0.5 * h,
                    y + 0.5 * k1);

            // Update next value of y
            y = y + (1.0 / 6.0) * (k1 + 2 * k2);
            // Update next value of x
            x0 = x0 + h;
        }

        return y;
    }

    public  static  float sumarr(float[] arr) {
        int sum =0;
        for(float value: arr ) {
            sum+=value;
        }
        return sum;
    }

    public static void main(String args[]) throws IOException {
           Euler_Method funcEU = new Euler_Method();

            // initial value and segment[0,1]
            float x0 = 0;
            float y0 = 1;
            // step
            float h = 0.1f;

            // Value of x at which we need approximation
            float x = 0.1f;
        System.out.println("=========================EXACT====VALUE=======================================");
        System.out.println(
                              " exact "+  "at 0.1 " + "is " + funcex(x) +"\n " +
                              " exact "+ "at 0.2: "  +"is " + funcex(0.2f)+"\n " +
                              " exact "+ "at 0.3: " + "is " + funcex(0.3f)+"\n " +
                              " exact "+ "at 0.4: " + "is " + funcex(0.4f)+"\n " +
                              " exact "+ "at 0.5: " + "is " + funcex(0.5f)+"\n " +
                              " exact "+ "at 0.6: " + "is " + funcex(0.6f)+"\n " +
                              " exact "+ "at 0.7: " + "is " + funcex(0.7f)+"\n " +
                              " exact "+ "at 0.8: " + "is " + funcex(0.8f)+"\n " +
                              " exact "+ "at 0.9: " + "is " + funcex(0.9f)+"\n " +
                              " exact "+ "at 1.0: "+  "is " + funcex(1f)  );
        System.out.println("=========================EULER====VALUE=======================================");
            float arrEU[] =new float[10];
            funcEU.euler(x0, y0, h, x,0);
            funcEU.euler(x0, y0, h, 0.2f,1);
            funcEU.euler(x0, y0, h, 0.3f,2);
            funcEU.euler(x0, y0, h, 0.4f,3);
            funcEU.euler(x0, y0, h, 0.5f,4);
            funcEU.euler(x0, y0, h, 0.6f,5);
            funcEU.euler(x0, y0, h, 0.7f,6);
            funcEU.euler(x0, y0, h, 0.8f,7);
            funcEU.euler(x0, y0, h, 0.9f,8);
            funcEU.euler(x0, y0, h, 1f,9);

        System.out.println("=========================RUNGE====KUTTA====VALUE=======================================");
        System.out.println(
                "at 0.1 "        + rungeKutta(x0, y0, x, h) +"\n " +
                "at 0.2 "+ "is " + rungeKutta(x0, y0, 0.2f, h)+"\n " +
                "at 0.3 "+ "is " + rungeKutta(x0, y0, 0.3f, h)+"\n " +
                "at 0.4 "+ "is "+  rungeKutta(x0, y0, 0.4f, h)+"\n " +
                "at 0.5 "+ "is " + rungeKutta(x0, y0, 0.5f, h)+"\n " +
                "at 0.6 "+ "is " + rungeKutta(x0, y0, 0.6f, h)+"\n " +
                "at 0.7 "+ "is " + rungeKutta(x0, y0, 0.7f, h)+"\n " +
                "at 0.8 "+ "is " + rungeKutta(x0, y0, 0.8f, h)+"\n " +
                "at 0.9 "+ "is " + rungeKutta(x0, y0, 0.9f, h)+"\n " +
                "at 1.0 "+ "is " + rungeKutta(x0, y0, 1.0f, h) );

        System.out.println("=========================MATH====EXPECTATION=======================================");
        float arr[] = new float[10];
        float arr2[] = new float[10];
        float delta1[]  ={0.1f,0.2f,0.3f,0.4f,0.5f,0.6f,0.7f,0.8f,0.9f,1.0f};
        float sum =0;
        float sum2 =0;
        for (int i = 0; i<10; i++){

            sum+=    Math.abs(     funcex(delta1[i]) - arrEU[i]    ) ;// funcEU.euler(x0,y0,h,i) )) ;  delta 1

            arr[i]=sum;
        }
        System.out.println("Delta1 " +  sum);
        for (int i = 0; i<10; i++){

            sum2+=    Math.abs(     funcex(delta1[i]) - rungeKutta(x0,y0,i,h)    ) ;//  delta 2

            arr2[i]=sum2;
        }
        System.out.println("Delta 2 " + sum2 );

        sumarr(arr);
        System.out.println("Math exp Euler: "  +  (sum)/10);
        sumarr(arr2);
        System.out.println("Math exp RungeKutta: " + (sum2)/10);
        }
    }

