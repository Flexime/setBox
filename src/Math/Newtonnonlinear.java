package Math;

        import java.util.Scanner;

public class Newtonnonlinear {
    static double[][] determinantOfMatrix(double jacob[][]) {

        double ans =  ( jacob[0][0]*jacob[1][1] -jacob[0][1]*jacob[1][0]);

        double inverse[][] = {
                {jacob[1][1]/(1/ans),-jacob[0][1]/(1/ans)},
                {-jacob[1][0]/(1/ans),jacob[0][0]/(1/ans)}
        };
        return inverse;
        // inverse [J]^-1
    }



    static double funcx(double x1, double x2) //f1
    {
        return x1 - x2 + 1;
    }
    static   double funcy(double x1,double x2) //f2
    {

        return   (x1*x1) + (x2*x2)-4;
    }

    // (x1 x2 ) -J[]^-1  (f1 f2)
    static void findSolution(double inverse [][], double b[][],double x1,double x2) {


        //-J[]^-1  (f1 f2) vector by matrix

        double VbM[][] = {
                {funcx(x1, x2) * inverse[0][0] , funcx(x1, x2) * inverse[1][0]},
                {funcy(x1, x2) * inverse[0][1] , funcy(x1, x2) * inverse[1][1]}
        };


        double answer[][] = {
                { (b[0][0] - (VbM[0][0])+ VbM[0][1]) },
                { (b[1][0] - (VbM[1][0]) +VbM[1][1]) }

        };
        System.out.println("(x1,x2): " + answer[0][0] + ","+ answer[1][0]);
    }



    public static void main(String[] args) {


        double x1 = 1;
        double x2 = 1; //initial value


        double b[][] = {
                {x1},
                {x2},
        };
        double jacobian[][] = {
                {1, 1},
                {2 * x1, 2 * x1},
        };

        findSolution(determinantOfMatrix(jacobian), b, x1, x2);
    }}