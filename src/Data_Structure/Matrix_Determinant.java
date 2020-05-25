package Data_Structure;

public class Matrix_Determinant {
    static  double matrix [][];

    /** Dimension of input square matrix**/
    static final int N = 5;

    static void getCofactor(int mat[][],
                            int temp[][], int p, int q, int n)
    {
        int i = 0, j = 0;

        // Looping for each element of
        // the matrix
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {

                // Copying into temporary matrix
                if (row != p && col != q)
                {
                    temp[i][j++] = mat[row][col];

                    // Row is filled, so increaserow index and reset col index
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    /** Recursive function for finding determinant
     of matrix. n is current dimension of mat[][]. **/
    static int determinantOfMatrix(int mat[][], int n)
    {
        int D = 0;

        // Base case : if matrix contains single
        // element
        if (n == 1)
            return mat[0][0];

        // To store cofactors
        int temp[][] = new int[N][N];

        // To store sign multiplier
        int sign = 1;

        // Iterate for each element of first row
        for (int f = 0; f < n; f++)
        {
            // Getting Cofactor of mat[0][f]
            getCofactor(mat, temp, 0, f, n);
            D += sign * mat[0][f]
                    * determinantOfMatrix(temp, n - 1);


            // alternate sign
            sign = -sign;
        }

        return D;
    }


    static void display(int mat[][], int row, int col)
    {
        int number = 0;
        for (int i = 0; i < row; i++)
        {

            for (int j = 0; j < col; j++)
                System.out.print(mat[i][j] + " ");

            System.out.print("\n");

            number = i;

            if (number == i++ ){

                System.out.println("elems: " +number  );
            }

        }
    }

    // before running change matrix dimension N
    public static void main (String[] args)
    {

        int mat[][] = {{1, 0, 2, -1,5},
                {3, 0, 0, 5,0},
                {2, 1, 4, -3,0},
                {1, 0, 5, 0,7},
                {1, 0, 5, 0,7}};
        display(mat,N,N);

        System.out.print("Determinant of the matrix is : " + determinantOfMatrix(mat, N));

    }

}
