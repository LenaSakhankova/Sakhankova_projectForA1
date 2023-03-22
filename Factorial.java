public class Factorial{

    public static void main(String[] args) {
        int n = 65; // Indef if n > 66
        un(n);
    }

    public static void un(int n) throws ExceptionInInitializerError
    {
        try {
            if(n<1 || n>=66) throw new ExceptionInInitializerError();
            double un = (1 / factorial(n)) * sumFactorials(n);
            System.out.format("%.6f", un);
        }
        catch (ExceptionInInitializerError ex){
            System.out.println("n should be between 1 and 65");
        }
    }

    public static double factorial(int n) {
        long temp = 1;
        for (int i = 1; i <= n; i++) {
            temp *= i;
        }
        return temp;
    }

    public static double sumFactorials(int n) {
        long temp = 0;
        for (int i = 1; i <= n; i++) {
            temp += factorial(i);
        }
        return temp;
    }
}
