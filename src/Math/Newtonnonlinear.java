package Math;

import java.util.Scanner;

public class Newtonnonlinear {
    static double determinantOfMatrix(float jacob[][]) {
        float ans;
        ans =  ( jacob[0][0]*jacob[1][1] -jacob[0][1]*jacob[0][1]);
        return 1/
                ans;// inverse
    }
    static double funcx(float x, float x2) //f1
    {
        return x - x2 + 1;
    }
    static double funcy(float x,float x2) //f2
    {
        return (x*x) + (x2*x2)-4;
    }

    static void findSolution(float jacob[][], float b[][],float x1,float x2) {  // (x1 x2 ) -J[]^-1(f1 f2) vector by matrix

        determinantOfMatrix(jacob);


       // for (int i =0; i<iteration; i++) {
            double VbM[][] = {
                    {funcx(x1, x2) * jacob[0][0] + funcx(x1, x2) * jacob[0][1]},
                    {funcy(x1, x2) * jacob[0][1] + funcy(x1, x2) * jacob[0][1]}
            };

            double answer[][] = {
                    { (b[0][0] - VbM[0][0])},
                    { (b[1][0] - VbM[1][0])}

            };
            System.out.println(answer);
        }
  //  }


    public static void main(String[] args) {


        float x1= 1;
        float x2= 1; //initial value


        float b[][] = {
                {1},
                {1},
        };
        float jacobian[][] = {
                 {1,1},
                 {2*x1 ,2*x1},
        };
      //  Scanner sc =new Scanner(System.in);
       // int iteration = sc.nextInt();
        findSolution(jacobian,b,x1,x2);

    }
}