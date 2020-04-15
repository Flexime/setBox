package Math;

public class spline2 {


    static  double funcx(double x){

        return Math.sin(x);
    }


    static double x_i(int i ,double deltax, int a){

        return  a+i*deltax;
    }


    static  double spline(int i,double deltax,int a) {

        return  ((funcx(x_i(i,deltax,a))) + ( (funcx(x_i(i++,deltax,a))) - (funcx(x_i(i,deltax,a)))
                /x_i(i++,deltax,a) - x_i(i,deltax,a) ) * ((x_i(i,deltax,a)) +deltax/2- x_i(i,deltax,a)));
    }

    static double funcx_i(int i,double deltax ,int a){

        return (x_i(i,deltax,a))  + deltax/2;
    }


    public  static  double sumarr(double[] arr) {
        int sum =0;
        for(double value: arr ) {
            sum+=value;
        }
        return sum;
    }

    public static void main(String[] args) {

        int N = 150;// 10 30 50 70 100 150
        int a =0;
        double  b =Math.PI ;
        double deltax = b-a/N;
        double sum= 0;
        double arr[] = new double[N+1];

        for (int i=0;i<=N;++i ){
            System.out.println("iteration: "+i);

            System.out.println((funcx_i(i, deltax, a) - spline(i, deltax, a)));


            sum = funcx_i(i, deltax, a) - spline(i, deltax, a);
            arr[i]= sum;

        }
        System.out.println( sumarr(arr));

        double A =  (sum*1)/N;

        System.out.println("A: " + A) ;
    }
}
