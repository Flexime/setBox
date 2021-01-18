package Numerical;

    public class  pract1  {

        static  double funcx(double x){

            return  2 *(Math.sin( 3* x));
        }


        static  double exact(double x) {
        return  6* (Math.cos(3*x));
        }

        static double x_i(int i ,double deltax, double a){//0...N

            return  a+i*deltax;
        }


        //----------=================================----------------

        //right difference derivative
        static  double forward(int i ,double deltax,int a ){
            return    (  (    ( funcx(x_i((i+1),deltax,a ))   - funcx(x_i(i,deltax,a) ) )  /
                    deltax));
        }
        //left difference derivative
        static  double backward(int i ,double deltax,int a ){
            return   ( (  funcx(x_i(i,deltax,a) ) -   ( funcx(x_i(i-1,deltax, a ))) ) /deltax   );

        }

        //  sumarr not used
        public  static  double sumarr(double[] arr) {
            int sum =0;
            for(double value: arr ) {
                sum+=value;
            }
            return sum;
        }

        public static void main(String[] args) {

            int N= 50;// 30 40 50 100

            int a =0;
            double  b =Math.PI ;
            double deltax = b-a/N;
            double sum= 0,sum3= 0;
            double sum2 =0;
            double arr[] = new double[N+1],arr2[] = new double[N+1];
            double arr3[] = new double[N+1];
            for (int i=0;i<N;i ++) {
                System.out.println(2 *(Math.sin( 3* x_i(i,deltax,a)) *180 / Math.PI ));

            }
            for (int i=0;i<N;i ++) {
                Math.abs ( sum3 =  (exact(i) -forward(i,deltax,a) ) );
                System.out.println (sum3);
               // arr[i] = sum3;
            }
            for (int i = 0; i<N; i++ ){
                Math.abs( sum = exact(i));
                System.out.println(sum);
               // arr3[i] = sum ;
            }
             for(int l = 0; l<N;l ++){
                 System.out.println( backward(l,deltax,a));

                 Math.abs( sum2 = (exact(l)- backward(l,deltax,a)));


                // System.out.println( "backward: " + sum2);
                // arr2[l] = sum2;
             }





            System.out.println("exact value: " +Math.abs(sum));
            System.out.println("difference forward : " + Math.abs(sum3));//forward
            System.out.println("difference backward : " + Math.abs(sum2));//bacward
        }
    }




