
public class Main{
   
   public static void main(String[] args){    
      double[][] problem1 = {
         {2, 1, 4},
         {3, 4, 1}};
      double[][] problem2 = {
         {5, 2, 2},
         {3, -5, 26}};      
      double[][] problem3 = {
         {5, 3, -6},
         {3, 5, -18}};
      double[][] problem4 = {
         {1, 2, 2, 4},
         {3, -1, 4, 25},
         {3, 2, -1, -4}};
      double[][] problem5 = {
         {2, -3, 5, 4},
         {3, 2, 2, 3},
         {4, 1, -4, -6}};
      double[][] problem6 = {
         {3, -2, -1, -4, 7},
         {1, 0, 3, 2, -10},
         {1, 4, 2, 1, 0},
         {2, 3, 0, 3, 1}};
      double[][] problem7 = {
         {1, 1, 0, 0, 0, 0},
         {1, 1, 1, 0, 0, 0},
         {0, 1, 1, 1, 0, 0},
         {0, 0, 1, 1, 1, 0},
         {0, 0, 0, 0, 1, 1}};   
      System.out.print("\n\nThe first problem is : \n");
      MatrixSolver.matrixPrinter(problem1);
      MatrixSolver.matrixSolver(problem1);
      System.out.print("\n\nThe second problem is : \n");
      MatrixSolver.matrixPrinter(problem2);
      MatrixSolver.matrixSolver(problem2);
      System.out.print("\n\nThe third problem is : \n");
      MatrixSolver.matrixPrinter(problem3);
      MatrixSolver.matrixSolver(problem3);
      System.out.print("\n\nThe fourth problem is : \n");
      MatrixSolver.matrixPrinter(problem4);
      MatrixSolver.matrixSolver(problem4);
      System.out.print("\n\nThe fifth problem is : \n");
      MatrixSolver.matrixPrinter(problem5);
      MatrixSolver.matrixSolver(problem5);
      System.out.print("\n\nThe sixth problem is : \n");
      MatrixSolver.matrixPrinter(problem6);
      MatrixSolver.matrixSolver(problem6);
      System.out.print("\n\nThe seventh problem is : \n");
      MatrixSolver.matrixPrinter(problem7);
      MatrixSolver.matrixSolver(problem7);
   }
}

