package Math;

import java.util.ArrayList;

//spline of 1st order
public class spline {
    static double funcx(double x) //f1
    {
        return x * x + 12 * Math.sin(x) * 4 * x;
    }

    static double spline_1st_order(double xi, double yi, double xi1, double yi1, double h) {


        return yi + ((yi1 - yi) / (xi1 - xi)) * (f(xi, h) - xi);
    }

    static double f(double xi, double h) {
        return xi + h / 2;
    }

    public static void main(String[] args) {

            double N = 10;
            int i = 0;
            double xi;


            double a = 0;
            double b = 1;
            double h = (b - a) / N; // h is delta


            xi = a + i * h;
            double yi = funcx(xi);

            i++;

            double xi1 = a + i * h;
            double yi1 = funcx(xi);

            double f = f(xi, h);

            double S = spline_1st_order(xi, yi, xi1, yi1, h);
            double deltai = f - S;
            System.out.println(deltai);
            double A = 1 / N * (f - S);
            System.out.println(A);
            double sig = Math.sqrt(1 / N - 1 * Math.pow(deltai - A, 2));
            System.out.println(sig);
        }
    }
