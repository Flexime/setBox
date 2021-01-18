package Numerical;

import java.util.Arrays;

public class waveEQ {
    /**initial **/
    static  double funcx(double x){
        return (float) ( Math.pow(Math.E,x) * Math.sin(3*x));
    }
    //exact 𝑢(𝑥,𝑡)=𝐹(𝑥−𝑐𝑡)


    public static void main(String[] args) {
       // 1//
    int Nx=30;//30
    int Nt=30;//30

    float a = 1; float b = 3;
    float tmax = 5;
    float c = 0.8f;


    float sum = 0;


    float sumarr[] = new  float[Nx];


    /**2 **/
    double deltax = (double) (b-a) / Nx;
    double deltat =(double) tmax/Nt;
        System.out.println();
        System.out.println("deltax: " +deltax +"  " + "deltat: "  + deltat);
    /**3**/
     double xi[] = new double[ Nx];
     double tj[] = new double[Nt];
     /**4**/
      double Uex[][] = new double[Nx][ Nt];
      double Uapp[][] = new double[Nx][ Nt];

      /**ex**/
        for (int i = 0; i<Nx; i++) {
            xi[i] = a + i * deltax;
        }
        for (int j =0; j<Nt;j++){
            tj[j] = j*deltat;
        }
        System.out.println();
        System.out.println("xi values:  " +  Arrays.toString(xi));
        System.out.println("");
        System.out.println("tj values:  " +  Arrays.toString(tj));

      for (int i  = 0; i< Nx; i++) {
          for (int j = 0; j < Nt; j++) {
              //𝑢(𝑥,𝑡)=𝐹(𝑥−𝑐𝑡)
              Uex[i][j] =  funcx( xi[i] - c* tj[j]  );
              //explicit soluton
            //  Uapp[i][j] =  Math.pow(Math.E, ( xi[i] - c *tj[j]  ) * Math.sin(xi[i] - c * tj[j])); //15.001162217550496

          }

      }
        System.out.println();
        System.out.println("exact(explicit): " + Arrays.deepToString((Uex)));

        // Finding Uapp[i][j+1]
        double[][] UappLeft = new double[Nx][Nt];
        double[][] UappRight = new double[Nx][Nt];
        double[][] UappMid = new double[Nx][Nt];
        double[][] UappLax = new double[Nx][Nt];

        for (int i = 0; i < Nx; i++) {
            UappLeft[i][0] = funcx(xi[i]);
            UappRight[i][0] = funcx(xi[i]);
            UappMid[i][0] = funcx(xi[i]);
            UappLax[i][0] = funcx(xi[i]);
        }


        /**=================5==app===========**/

       Lax4(Nx,Nt,Uapp,xi,c,deltat,deltax);
       approx1(Nx,Nt,Uapp,xi,c,deltat,deltax);
       approx2(Nx,Nt,Uapp,xi,c,deltat,deltax);
       aprrox3(Nx,Nt,Uapp,xi,c,deltat,deltax);



/**=======6==app====**/
//deltas
        double[] deltaLeft = new double[Nx];
        double[] deltaRight = new double[Nx];
        double[] deltaMid = new double[Nx];
        double[] deltaLax = new double[Nx];


        //Math expectation
        double MaLeft = 0;
        double MaRight = 0;
        double MaMid = 0;
        double MaLax = 0;

        for (int i  = 1; i< Nx; i++) {
                deltaLeft[i] = Math.abs(Uex[i][1] - UappLeft[i][1]);
                deltaRight[i] = Math.abs(Uex[i][1] - UappRight[i][1]);
                deltaMid[i] = Math.abs(Uex[i][1] - UappMid[i][1]);
                deltaLax[i] = Math.abs(Uex[i][1] - UappLax[i][1]);

        }

        for (int i =0; i<Nx;i++){
            MaLeft += deltaLeft[i];
            MaRight += deltaRight[i];
            MaMid += deltaMid[i];
            MaLax += deltaLax[i];
        }
        System.out.println();
        System.out.println("MaLeft = " + MaLeft/Nx); // worst accurate
        System.out.println("MaRight = " + MaRight/Nx);
        System.out.println("MaMid = " + MaMid/Nx);
        System.out.println("MaLax = " + MaLax/Nx); // most accurate

        /** test to see Arrays **/
        // arrsout(Uex); for 2D array
        // System.out.println(Arrays.deepToString((Uex))); faster 2D array
        // System.out.println(Arrays.toString(deltai)); 1D array

    }
    /**Formulas for approximate **/
    static  void Lax4 (double Nx,double Nt,double[][] UappLax, double xi[],double c
    ,double deltat,double deltax) {
        for (int i  = 1; i< Nx-1; i++) {
            for (int j = 0; j < Nt-1; j++) {

                    //𝑢_𝑖^0=𝐹(𝑥_𝑖)
                UappLax[i][0] = funcx(xi[i]);

                        // central

                UappLax[i][j+1] =( (       UappLax[i+1][j] + UappLax[i-1][j] ) /2 )
                        -
                        ( c *deltat/deltax  ) * (UappLax[i+1][j] - UappLax[i-1][j]);
            }

        }

    }
//right
    static  void approx1 (double Nx,double Nt,double[][] UappRight, double xi[],double c
            ,double deltat,double deltax) {
        for (int i  = 1; i< Nx-1; i++) {
            for (int j = 0; j < Nt-1; j++) {

                UappRight[i][0] = funcx(xi[i]);


                UappRight[i][j+1] =(UappRight[i][j] - ( c * ( deltat/deltax  ) * (UappRight[i+1][j] - UappRight[i][j]) ) );


            }

        }

    }
    //left
    static  void approx2 (double Nx,double Nt,double[][] UappLeft, double xi[],double c
            ,double deltat,double deltax) {
        for (int i  = 1; i< Nx-1; i++) {
            for (int j = 0; j < Nt-1; j++) {

                UappLeft[i][0] = funcx(xi[i]);


                UappLeft[i][j+1] =(UappLeft[i][j]  -( c *( deltat/deltax  ) * (UappLeft[i][j] - UappLeft[i-1][j])));


            }

        }

    }//mid
    static  void aprrox3 (double Nx,double Nt,double[][] UappMid, double xi[],double c
            ,double deltat,double deltax) {
        for (int i  = 1; i< Nx-1; i++) {
            for (int j = 0; j < Nt-1; j++) {

                //Uapp[i][j+1] = funcx(xi[i]);
                //𝑢_𝑖^0=𝐹(𝑥_𝑖)
                UappMid[i][0] = funcx(xi[i]);


                UappMid[i][j+1] =( (       UappMid[i][j])
                        -
                        ( c *deltat/ (2 * deltax)  ) * (UappMid[i+1][j] - UappMid[i-1][j]));
            }

        }

    }

/**helper**/

    static void arrsout(double[][] array){

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print( array[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
