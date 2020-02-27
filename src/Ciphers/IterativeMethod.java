package Cyphers;

public class IterativeMethod {

  public static void main(String[] args) {
    double x1 = 0;
    double x2 = 0;
    double x3 = 0;

    double c1 = 0;
    double c2=0;
    double c3 = 0; // counter|x^n+1 -x^n|

    double e =0.001;

    double[][] m = {{10,2,-1},{-2,-6,-1},{1,-3,12}};  // 3x3 A
    double[][] b = {{5},{24.42},{36}};                // 3x1 b

    for (int i =0; i<3;i++ ) {
        for(int j=0;j<4;j++)
          System.out.print(" "+ m[i][j] + " ");
    }
    System.out.println();


    if( ( m[0][1] + m[0][2]) <= m[0][0]){   // if + break
      x1 = (b[0][0]- (m[0][1])*x1 - m[0][2]*x2)/m[0][0];// x1=
        if (Math.pow(x1,c1+1)-Math.pow(x1,c1)<=e){
          System.out.println("x= "+x1);
        }else
          while (( m[0][1] + m[0][2]) >= m[0][0]) {
            c1 = c1 + 1;
          }
    }
    if( ( m[1][1] + m[1][2]) <= m[1][1]){
      x2 = ((b[0][1])*x1 - m[1][2]*x2)/m[1][1];
      if (Math.pow(x2,c2+1)-Math.pow(x2,c2)<=e){
        System.out.println("x= "+x2);
      }else
        while (( m[1][1] + m[1][2]) >= m[1][1]) {
          c2 = c2 + 1;
        }
    }
    if( ( m[2][1] + m[2][2]) <= m[2][2]){
      x3 = ((b[0][2])*x1 - m[1][2]*x2)/m[2][2];
      if (Math.pow(x2,c2+1)-Math.pow(x2,c2)<=e){
        System.out.println("x= "+x3);
      }else
        while (( m[1][1] + m[1][2]) >= m[1][1]) {
          c3 = c3 + 1;
        }
    }
    if (Math.pow(x1,c1+1)-Math.pow(x1,c1)<=e ||Math.pow(x2,c2+1)-Math.pow(x2,c2)<=e ||Math.pow(x2,c2+1)-Math.pow(x2,c2)<=e ){
      System.out.println("X^n+1= "+ x1+x2+x3);
    }else {
      System.out.println("Cant be solved using Iteration method");
    }
  }
}
