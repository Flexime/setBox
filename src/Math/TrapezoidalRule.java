package Math;

public class TrapezoidalRule {

    //first order
    static  double derivative(double x ){
        return Math.pow(Math.E,x)  * ( 3 * Math.sin(3*x ))   + Math.cos(3*x)/
                //----------------------------------------------------------
                             10     ;
    }

    static  double derivative2 (double x ) {
        return  Math.pow(Math.E,x) * (3* Math.sin(3 *x ) - 4 * Math.cos(3 *x))/
                //------------------------------------------------------------
                                     50             ;
    }

    static  double NewtLeb(double a ,double b ){
        return derivative(b) - derivative(a);
    }

    static double f(double x) {
        return Math.pow(Math.E, x) * Math.cos(3 * x);
    }


    static  double Theorval(double a,double b ,double n){

        return (  derivative2(a) *(b-a )/24)*Math.pow((b-a)/n,2);
    }

    //small n values
    public static double trapezoida(double a, double b, double n) {
        double h = (b - a) / n; // deltax

        double s = f(a) + f(b);

        for (int i = 1; i < n; i++) {
            s += 2 * f(a + i * h);
        }

        return (h / 2) * s;
    }

    //high n values
    public static double trapezoidah(double a, double b, double n) {
         double h = (b-a)/n; // deltax

         double s  = f(a)+ f(b);


        for (int i = 1; i < n; i++) {

            s += 2 * f(a + i*h); //x[i]

            s += (f(i) + f(i + h/2) / 2) * (f(i +h/2) - f(i));
        }

        return(h/2) * s;
    }


    public static void main(String[] args) {
        //range
        double a = 0;
        double b = 2 * Math.PI;

        int n = 40;
        System.out.println("Integral");
        System.out.println("Real value: " + (NewtLeb(a,b) - trapezoidah(a,b,n)) );
        System.out.println("Theoretical  value: " + Theorval(a,b,n));


    }
}