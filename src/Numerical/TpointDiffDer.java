package Numerical;

public class TpointDiffDer {

    static double x_i(int i ,double deltax, int a){

        return  a+i*deltax;
    }
    static  double funcx(double x){

        return 3*Math.sin(6*x);
    }

    static  double yi(int i , double deltax, int a) {

        return    funcx(    x_i(i,deltax,a)   )  ;
    }

    static  double dyi(double x){

        return  18* Math.cos(6*x);
    }

    static double three1(int i ,double deltax,int a ){
        return (1/deltax* Math.abs( 1/2 *funcx(yi(i,deltax,a) +deltax)  - 1/2* funcx ( yi(i,deltax,a)-deltax) ) );
}

    static  double three2(int i , double deltax, int a){

        return  ( 1/deltax *  Math.abs (  (-3/2) * funcx(i)  + 2 *funcx(i+deltax)  - 1/2 * funcx(i+2*deltax) )      );
    }
    static double five1(int i,double deltax,int a){

        return  ( 1/ deltax* /*[*/ (    Math.abs( 1/12 *  ( funcx(i - 2*deltax) )   - 8/12 * (funcx(i+deltax) )  - 1/12*funcx(i+2*deltax)) /*]*/  )  );
    }



    static  double deltai5_1   (double deltax,int a,double error, int N) {
        for ( ; (Math.abs(dyi(N) - five1(N, deltax, a)) > error); N++) {
            if ( Math.abs(dyi(N) - five1(N, deltax, a)) <= error) {
                return N;
            }
        }
        return N;

    }

    static  double deltai3_1 (double deltax , int a ,double error, int N){
        for (; (Math.abs(dyi(N) - three1(N,deltax,a)) > error); N++){
            if (Math.abs(dyi(N) - three1(N,deltax,a)) <= error){
                return N;
            }
        }

        return N;
    }

    static  double deltai3_2 (double deltax,int a,double error, int N) {
        for (; (Math.abs(dyi(N)   - three2(N,deltax,a)) > error ); N++){
             if((Math.abs(dyi(N)   - three2(N,deltax,a)) <= error )){
                return N;
            }
        }
        return N;
    }

    public static void main(String[] args) {
        int N = 10;
        int a =0;
        double  b =2;
        double deltax = (b-a)/N;
        double sum= 0;
        double arr[] = new double[N+1];
        double error =(Math.pow(10,-3));
        System.out.println("3-1: " + three1(N,deltax,a)  +
               "\n3-2: " + three2(N,deltax,a)  +
                "\n5-1: " + five1(N,deltax,a)   );
        System.out.println( " 3-1 took: " + deltai3_1(deltax,a,error,N) +
                "\n 3-2 took: " + deltai3_2(deltax,a,error,N) +
                "\n5-1 tooK: " + deltai5_1(deltax,a,error,N)  );
}}
