package Math;
// Newton Raphson Method for solving  equations

class Newton {

    static final double EPSILON = 0.001;

    /**1**/
    // The function is x^3 - x^2 + 2 
    static double func(double x)
    {
        return x * x * x - x * x + 2;
    }

    // Derivative of the above function  
    // which is 3*x^x - 2*x 
    static double derivFunc(double x)
    {
        return 3 * x * x - 2 * x;
    }

    // Function to find the root 
    static void newtonRaphson(double x)
    {
        double h = func(x) / derivFunc(x);
        /**3**/
        while (Math.abs(h) >= EPSILON )
        {

            h = func(x) / derivFunc(x);

            // formula to find next value
            // x(i+1) = x(i) - f(x) / f'(x)

            x = x - h;
        }

        System.out.print("The value of the"+ " root is : "
                + Math.round(x * 100.0) / 100.0);

    }


    public static void main (String[] args)
    {

        // Initial values assumed 
        double x0 = -10;
        newtonRaphson(x0);

        /**   Algorithm:
         *    Input: x0, f(x),f'(x)
         *    Output: root of func()
         *    1 Value of f(x) and f'(x)  for x
         *    2 Compute h:h = f(x)/f'(x)
         *    3 while h > e
         *       h= f(x)/f'(x)
         *       x = x-h
         * */


    }
}