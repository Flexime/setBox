package Numerical;

public class lab1 {

    static  double funcx(double x){

        return  2 *(Math.cos( 5* x));
    }


    static double x_i(int i ,double deltax, int a){//0...N

        return  a+i*deltax;
    }

    static  double y_i(double x){    //0...N

        return 2 *(Math.cos( 5* x));
    }

    static  double D_y(double x){    //0...N
        return  10 * ( Math.sin(5*x));
    }

    static  double D_yl(double x , int i ,double deltax){ // 1 ... N
        return D_y(x) - backward(i,deltax);
    }
    static  double D_yr(double x , int i ,double deltax){ //0...N -1
        return D_y(x) - forward(i,deltax);
    }

    static  double delta_L(double x , int i ,double deltax) {
        return  Math.abs(D_y(x) -  D_yl(x,i,deltax));
    }

    static  double delta_R(double x , int i ,double deltax) {
        return  Math.abs(D_y(x) -  D_yr(x,i,deltax));
    }
    //----------=================================----------------

    //right difference derivative
    static  double forward(int i ,double deltax ){
       return    (  funcx(i + deltax)   - funcx(i)) /
               deltax;
    }
    //left difference derivative
    static  double backward(int i ,double deltax ){
        return    (  funcx(i) -  funcx(i - deltax) ) /
                deltax;
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
        double sum= 0,sum2 = 0;
        double arr[] = new double[N+1],arr2[] = new double[N+1];
        for (int i=0;i<N;++i ) {
            sum = delta_L(x_i(i, deltax, a), i, deltax);
            arr[i] = sum;

            sum2 = delta_R(y_i(i), i, deltax);
            arr2[i] = sum2;
        }

        System.out.println("deltaR : " + sum2);//deltaR
        System.out.println("deltaL : " + sum);//deltal
    }
}
