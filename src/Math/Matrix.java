package Math;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Matrix {
    // матрица mxn
    private int m, n;
    double[][] matrix = null;
    double[][] inverse = null;

    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
    }
    public Matrix(int order) {
        this.n = this.m = order;
    }
    public Matrix() {
        this.m = this.n = 2;
    }

    public boolean createMatrix() {
        if(m != 0 && n != 0) {
            matrix = new double[m][n];
            return true;
        }
        return false;
    }
    private boolean isMatrixCreated() {
        return matrix != null;
    }
    private void fillMatrixRandom() {
        if(!isMatrixCreated()) createMatrix();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.random() * 1000;
            }
        }
    }
    public void fillMatrix() {
        try {
            // создание матрицы вручную
            if(!isMatrixCreated()) createMatrix();

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(isr);

            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = Double.parseDouble(in.readLine());
                }
            }
        } catch(IOException e) {
            System.out.println("IOException in function fillMatrix()");
        } catch(NullPointerException e) {
            System.out.println("NullPointerException in function fillMatrix()");
        } catch(NumberFormatException e) {
            System.out.println("Number parsing exception in function fillMatrix()");
        }
    }
    public void printMatrix() {
        for(double[] arr : matrix) {
            for(double d : arr) {
                System.out.print(String.format("%.5e", d) + "\t\t");
            }
            System.out.println();
        }
    }
    private boolean reduceRow(double[] r1, double[] r2, int pos) {
        try {
            if(r1.length != r2.length) return false;

            double factor = r2[pos] / r1[pos];
            for(int i = pos; i < r1.length; i++) {
                r2[i] -= factor * r1[i];
            }
            return true;
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of range in function reduceRow()");
        }
        return false;
    }
    public void process() {
        fillMatrixRandom();
        try {
            if(!isMatrixCreated()) createMatrix();
            //k индекс ряда с макс значением
            int k;
            //временная переменая для замены
            double[] swapTemp;

            for(int i = 0; i < matrix.length; i++) {
                k = i;
                for(int j = i + 1; j < matrix.length; j++) {
                    if(matrix[j][i] > matrix[k][i]) {
                        k = j;
                    }
                }

                if(matrix[k][i] == 0) {
                    // свободный ряд
                    System.out.println("System of equations contains free variables");
                    System.exit(0);
                }
                // обмен ряда i и k
                swapTemp = matrix[i];
                matrix[i] = matrix[k];
                matrix[k] = swapTemp;
                // Итерация всех подрядов
                for(int j = 0; j < matrix.length; j++) {
                    //уменьшение по рядам
                    if(i != j && !reduceRow(matrix[i], matrix[j], i)) {
                        System.out.println("System of equations cannot be solved by this program");
                        System.exit(0);
                    }
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        Matrix m = new Matrix(4);
        System.out.println( m.matrix );

        m.process();
        m.printMatrix();
    }
}