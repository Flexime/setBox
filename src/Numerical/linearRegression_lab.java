package Numerical;
import java.util.Arrays;
//@Askarbek_Asubaev  CS1803
/**
 Function f(x) = 10x + 5 – c*sin(6*x) in func

 k angular coef ( equation of straight line)
 b real number

 the lower the value of constant C the closer is approach to original  function


division by square:  used in minimization to find minimized values to minimize function


 **/

class linearRegression_lab {
    public static void main(String[] args) {
        double C=0.01;// 0.01 0.1 10 100
        int N = 40;
        int a = 0;
        int b = 3;

        double deltaX = (b-a) / (double)N;
        double[] xi = xi(N, a, deltaX);
        //0.01
        double k = k_func(N, xi,C);
        System.out.println("k: " + k );

        double B = b_func(N, xi, k,C);
        System.out.println("b: " + B );
        System.out.println("C: " + C);
        System.out.println("-------------------------------------------------");


        //======2==========================
        double k2 = k_func(N, xi,0.1);
        System.out.println("k2: " + k2 );

        double B2 = b_func(N, xi, k,0.1);
        System.out.println("b2: " + B2);
        System.out.println("C: "  + 0.1);
        System.out.println("-------------------------------------------------");

        //======3=========================
        double k3 = k_func(N, xi,10);
        System.out.println("k3: " + k3 );

        double B3 = b_func(N, xi, k,10);
        System.out.println("b3: " + B3 );
        System.out.println("C: " + 10);
        System.out.println("-------------------------------------------------");

        //======4=========================
        double k4 = k_func(N, xi,100);
        System.out.println("k4: " + k4 );

        double B4 = b_func(N, xi, k,100);
        System.out.println("b4: " + B4 );
        System.out.println("C: " + 100);
        System.out.println("-------------------------------------------------");

    }
    public static double func(double x,double C) {
        return 10 * x + 5 - C * Math.sin(6 * x);
    }
    private static double b_func(int N, double[] xi, double k, double C) {
        double numerator = 0;
        for (int i = 0; i < N; i++) {
            numerator += func(xi[i],C) - k * xi[i];
        }
        return numerator / N;
    }
    private static double[] xi(int N, int a, double deltaX) {
        double[] xi = new double[N];
        for (int i = 0; i < N; i++) {
            xi[i] = a + (i * deltaX);
        }
        return xi;
    }

    private static double k_func(int N, double[] xi,double C) {
        double k = 0;
        double[] subNumerator = new double[N];
        double[] subDenominatorLeft = new double[N];
        double[] subDenominatorRight = new double[N];
        for (int i = 0; i < N; i++) {
            subNumerator[i] = func(xi[i],C) / N;
            subDenominatorLeft[i] = Math.pow(xi[i], 2);
            subDenominatorRight[i] = xi[i];
        }
        double algebraicSum_subNumerator = 0;
        //----------------------------------------
        double algebraicSum_subDenominatorLeft = 0;
        double algebraicSum_subDenominatorRight = 0;
        for (int i = 0; i < N; i++) {

            algebraicSum_subNumerator += subNumerator[i];
            //----------------------------------------
            algebraicSum_subDenominatorLeft += subDenominatorLeft[i];
            algebraicSum_subDenominatorRight += subDenominatorRight[i];
        }
        double[] numerator = new double[N];
        for (int i = 0; i < N; i++) {
            numerator[i] = (func(xi[i],C) * xi[i]) - (xi[i] * algebraicSum_subNumerator);
        }
        double algebraicSum_numerator = 0;
        for (int i = 0; i < N; i++) {
            algebraicSum_numerator += numerator[i];
        }
        k = algebraicSum_numerator / (algebraicSum_subDenominatorLeft - 1/(double)N * Math.pow(algebraicSum_subDenominatorRight, 2));
        return k;
    }
}