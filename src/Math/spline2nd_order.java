package Math;

public class spline2nd_order {

    static  double funcx(double x){

        return x*x +  7* (Math.sin(x));
    }


    static double x_i(int i ,double deltax, int a){

        return  a+i*deltax;
    }


    static double funcx_i(int i,double deltax ,int a,int k){

        return (x_i(i,deltax,a))  + deltax/k;
    }


    public  static  double sumarr(double[] arr) {
        int sum =0;
        for(double value: arr ) {
            sum+=value;
        }
        return sum;
    }

    public static void main(String[] args) {

        int N= 10;// 10 30 50 70 100 150

        int a =0;
        int k =3;
        double  b =Math.PI ;
        double deltax = b-a/N;
        double sum= 0;
        double arr[] = new double[N+1];



        for (int i=0;i<=N;++i ){
            //sum as delta
            sum =
                    funcx_i(i,deltax,a,k) -


                            // spline
                            funcx_i(i,deltax,a,k) + //a

                            funcx_i(i+1 ,deltax,a,k)- funcx_i(i,deltax,a,k)/ deltax //b

                            +  Math.pow (4 *( ( funcx_i(i+1,deltax,a,k) +  funcx_i(i,deltax,a,k) -2 *funcx_i(i,deltax,a,k)  )  / deltax*deltax) ,2 ); //c


            arr[i]= sum;

        }
        System.out.println( sumarr(arr));

        double A =  (sum*1)/N;

        System.out.println("A: " + A) ;



    }


}
