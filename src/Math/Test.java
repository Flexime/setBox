package Math;

public class Test {

    static double[][] determinantOfMatrix(double jacob[][]) {

        double ans =  ( jacob[0][0]*jacob[1][1] -jacob[0][1]*jacob[1][0]);

        double inverse[][] = {
                {jacob[1][1]/(1/ans),-jacob[0][1]/(1/ans)},
                {-jacob[1][0]/(1/ans),jacob[0][0]/(1/ans)}
        };
        return inverse;
        // inverse [J]^-1
    }

    public static void main(String[] args) {
        double x1 = 1; //
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
//y = Math.sin(funcx(x));



    }
    static void findSolution(double inverse [][], double b[][],double x1,double x2) {

        //-J[]^-1  (f1 f2) vector by matrix
        double VbM[][] = {
                {func1(x1, x2) * inverse[0][0] , func1(x1, x2) * inverse[1][0]},
                {func3(x1, x2) * inverse[0][1] , func2(x1, x2) * inverse[1][1]}
        };


        double answer[][] = {
                { (b[0][0] - (VbM[0][0])+ VbM[0][1]) },
                { (b[1][0] - (VbM[1][0]) +VbM[1][1]) }

        };
        System.out.println("(x1,x2): " + answer[0][0] + ","+ answer[1][0]);
    }


        static double b;
    static double func1(double x, double a) //f1
    {

        return x * Math.log(Math.pow(x, 2)) + Math.pow(Math.E, x - 1) * Math.sqrt(a + b);
    }
    static   double func2(double x,double z) //f2
    {
        return   2 * x * z;
    }
    static  double func3(double x,double z){
     return  Math.pow(Math.cos(x), 2) + (Math.pow(x, 3) / 5 * z) ;
    }
}