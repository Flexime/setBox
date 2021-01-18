package Math;

import java.util.Arrays;

public class GaussianElimination {
    private static final double EPSILON = 1e-10;

    // иссключение по Гауссу
    public static double[] lsolve(double[][] A, double[] b) {
        int n = b.length;

        for (int p = 0; p < n; p++) {

            // замена ряда с макс значением
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p]; A[p] = A[max]; A[max] = temp;
            double   t    = b[p]; b[p] = b[max]; b[max] = t;

            // матрица исключаема
            if (Math.abs(A[p][p]) <= EPSILON) {
                throw new ArithmeticException("Матрица исключаема");
            }

            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        // обратная замена
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }



    public static void main(String[] args) {
        int n = 3;
        double[][] A = {
                { 0, 1,  1 },
                { 2, 4, -2 },
                { 0, 3, 15 }
        };
        double[] b = { 4, 2, 36 };
        double[] x = lsolve(A, b);




        for (int i = 0; i < n; i++) {
            System.out.println(x[i]);
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <A[i].length; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }

    }

}
