package Math;
    import java.io.*;
    import java.util.Arrays;

class diagonalMatrix {
        public static void main(String[] args) {
    int n = 5;
    double A[][] = new double[n][n];
            //{{1, 4},
            //{4,6}

            Arrays.toString(A);

       double  b[] = new double[n];

// здесь должна быть инициализация матрицы A и матрицы свободных коэффициентов b

            for (int k = 0; k < n; k++) {
                for (int i = k + 1; i < n; i++) {
                    double mu = A[i][k] / A[k][k];
                    for (int j = 0; j < n; j++)
                        A[i][j] -= A[k][j] * mu;
                    b[i] -= b[k] * mu;

                }

            }


            Arrays.toString(A);
        }
    }
