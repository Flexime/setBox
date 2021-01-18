package Numerical;

import java.util.Arrays;

public class heat {



    static double U(double x){
      return  5*x+5;
    }
    public static void main(String[] args) {
       
        double a=0;
        double b =3;
        int N=40;
        double xi[] = new double[N];
        double deltax = (b-a)/N;


        for (int i = 0; i<N; i++) {
            xi[i] = a + i * deltax;
        }
        double y[] = new double[ N+1];
        double A = 0;
        double B = 0;
        double C = 0;
        double F = 0;


        double k =0.61;
        A=k/ (deltax*deltax);
        B = 2*k/(deltax*deltax);
        C = k/(deltax*deltax);
        double alpa[] =  new double[ N];
        double beta[] = new double[N];

        alpa[N-1]=0;
        beta[N-1]=20;
        for (int i = N-1; i>=1; i--){
            alpa[i-1]=-( C/(A *alpa[i]-B)  );

            beta[i-1]=( F-A*beta[i] ) / (A*alpa[i]-B);
        }
        System.out.println(" ");
        System.out.println("Alpha array:  " +  Arrays.toString(alpa));
        System.out.println(" ");
        System.out.println("Beta array:  " +  Arrays.toString(beta));

        double u[] = new double[N];


        y[0]=5;
        for (int i = 0; i<=N-1;i++){
            //y[i]=alpa[i-1]*y[i-1] +beta[i];//Thomas i=1
           y[i+1] = alpa[i]*y[i] +beta[i];//(2)
        }
        for (int i = 0; i<=N-1;i++) {
           u[i]=  U(xi[i]);
        }
        System.out.println(" ");
        System.out.println("Y array:  " +  Arrays.toString(y));
        System.out.println(" ");
        System.out.println("u array: " + Arrays.toString(u));
        double[] delta = new double[N];

            for (int i = 0; i<N;i++) {
                delta[i] = Math.abs( U(xi[i]) - y[i]);
        }
        System.out.println(" ");
        System.out.println("delta array: "+Arrays.toString(delta));
        System.out.println(" ");
        System.out.println("Outliers: ");
        System.out.println(y[2] +":" +u[2]+ " " +"|" +delta[2] );
        System.out.println(y[3] +":" +u[3] + " " + "|" + delta[3]);
        for (int i =8;i<15;i++){
            System.out.println(y[i] +":" +u[i]  + " "+"|" + delta[i]);
        }




    }
//2 , 3 , 9-14

}
