package Data_Structure;

        import java.util.Random;
        import java.util.Scanner;


public class matrix {

    Scanner scan;
    int matrix1[][], matrix2[][], sum[][],sub [][], multi[][];
    int row, column;

    void create() {

        scan = new Scanner(System.in);

        System.out.println("Matrix Addition");


        System.out.println("\nEnter number of rows & columns");
        row = Integer.parseInt(scan.nextLine());
        column = Integer.parseInt(scan.nextLine());

        matrix1 = new int[row][column];
        matrix2 = new int[row][column];
        sum = new int[row][column];
        sub = new int[row][column];
        Random rand = new Random();



        for(int i=0; i<row; i++) {

            for(int j=0; j<column; j++) {


                Integer r = rand.nextInt()%100;
                matrix1[i][j] = Math.abs(r);
            }
        }




        for(int i=0; i<row; i++) {

            for(int j=0; j<column; j++) {

                Integer r = rand.nextInt()%100;
                matrix2[i][j] = Math.abs(r);   //scan.nextInt();
            }
        }
    }

    void display() {

        System.out.println("\nThe First Matrix is :");

        for(int i=0; i<row; i++) {

            for(int j=0; j<column; j++) {

                System.out.print("\t" + matrix1[i][j]);
            }
            System.out.println();
        }

        System.out.println("\n\nThe Second Matrix is :");

        for(int i=0; i<row; i++) {

            for(int j=0; j<column; j++) {

                System.out.print("\t" + matrix2[i][j]);
            }
            System.out.println();
        }
    }

    void add() {

        for(int i=0; i<row; i++) {

            for(int j=0; j<column; j++) {

                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("\n\nThe Sum is :");

        for(int i=0; i<row; i++) {

            for(int j=0; j<column; j++) {

                System.out.print("\t" + sum[i][j]);
            }
            System.out.println();
        }
    }

    void sub() {

        for(int i=0; i<row; i++) {

            for(int j=0; j<column; j++) {

                sub[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        System.out.println("\n\nThe Subtraction is :");

        for(int i=0; i<row; i++) {

            for(int j=0; j<column; j++) {

                System.out.print("\t" + sub[i][j]);
            }
            System.out.println();
        }
    }

    void multi() {

        for(int i=0; i<row; i++) {

            for(int j=0; j<column; j++) {

                multi[i][j] = matrix1[i][j] * matrix2[i][j];
            }
        }

        System.out.println("\n\nThe Multiplication is :");

        for(int i=0; i<row; i++) {

            for(int j=0; j<column; j++) {

                System.out.print("\t" + multi[i][j]);
            }
            System.out.println();
        }
    }
    void  transposeMatrix(){
        int[][] temp = new int[matrix1[0].length][matrix1.length];
        for (int i = 0; i < matrix1.length; i++){
            for (int j = 0; j < matrix1[0].length; j++){
                temp[j][i] = matrix1[i][j];
                System.out.print("\t" + temp[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {

        matrix obj = new matrix();

        obj.create();
        obj.display();
        obj.add();
        obj.sub();
        obj.multi();
        obj.transposeMatrix();


    }
}