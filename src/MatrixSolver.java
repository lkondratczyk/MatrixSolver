/**
 * Uses Cramer's Rule to solve any square matrix
 * 
 * @author lkondratczyk
 * @version 6/24/15
 */
public class MatrixSolver {
	public double[][] MAIN_MATRIX = new double[2][2];
	public int index1 = 0;
	public int iMain = 0;
	public double accumulator = 0.0;

	/**
	 * Finds the determinant of a 2 x 2 matrix
	 * 
	 * @param matrixIn
	 *            The 2 x 2 matrix
	 * @return The determinant of the 2 x 2 matrix
	 */
	public static double determinantFinder(double[][] matrixIn) {
		return (matrixIn[0][0] * matrixIn[1][1] - matrixIn[1][0]
				* matrixIn[0][1]);
	}

	/**
	 * Takes a matrix with a pivot index, and returns a smaller matrix reduced
	 * about the index
	 * 
	 * @param matrixIn
	 *            The matrix to be trim
	 * @param pivotIndex
	 *            The index of the column to be deleted
	 * @return A new matrix with the first row and the column matching the
	 *         pivotIndex removed
	 */
	public static double[][] matrixTrimmer(double[][] matrixIn, int pivotIndex) {
		double[][] returnMatrix = new double[matrixIn.length - 1][matrixIn.length - 1];
		int iPrime = 0;
		int jPrime = 0;
		for (int i = 1; i < matrixIn.length; i++) {
			for (int j = (pivotIndex == 0) ? 1 : 0; jPrime < matrixIn.length - 1; j++) {
				if (j == pivotIndex) {
					j = j + 1;
				}
				returnMatrix[iPrime][jPrime] = matrixIn[i][j];
				jPrime += 1;
			}
			iPrime += 1;
			jPrime = 0;
		}
		return returnMatrix;
	}

	/**
	 * A recursive function that uses Cramer's Rule to continuously multiply a
	 * given index by successively smaller matrices, until reaching a 2x2, when
	 * it returns the determinant
	 * 
	 * @param matrixIn
	 *            The matrix to be solved
	 * @return The determinant of the base case
	 */
	public static double innerMatrix(double[][] matrixIn) {
		double accumulator = 0;
		if (matrixIn.length == 2) {
			return determinantFinder(matrixIn);
		} else { //recursion here
			for (int j = 0; j < matrixIn.length; j++) {
				accumulator += (double) Math.pow(-1.0, (double) j)
						* matrixIn[0][j]
						* innerMatrix(matrixTrimmer(matrixIn, j));
			}
		}
		return accumulator;
	}

	/**
	 * Takes a matrix and inserts the solution column into the specified matrix
	 * column
	 * 
	 * @param matrixIn
	 *            The matrix being manipulated
	 * @param index
	 *            The index of the row to be substituted
	 * @return The inputed matrix with the swapped row
	 */
	public static double[][] matrixInsertion(double[][] matrixIn, int index) {
		double[][] matrixOut = new double[matrixIn.length][matrixIn.length];
		for (int i = 0; i < matrixIn.length; i++) {
			for (int j = 0; j < matrixIn.length; j++) {
				if (j == index) {
					matrixOut[i][j] = matrixIn[i][matrixIn.length];
				} else {
					matrixOut[i][j] = matrixIn[i][j];
				}
			}
		}
		return matrixOut;
	}

	/**
	 * Facilitates feeding the matrix to be solved into the recursive
	 * innerMatrix function, and performs the last step of Cramer's rule, where
	 * each substituted matrix determinant is divided by the determinant of the
	 * regular matrix
	 * 
	 * @param matrixIn
	 *            The matrix to be solved
	 */
	public static void matrixSolver(double[][] matrixIn) {
		double denominator = innerMatrix(matrixIn);
		System.out.print("The solution is: [");
		for (int i = 0; i < matrixIn.length; i++) {
			System.out.print(innerMatrix(matrixInsertion(matrixIn, i))
					/ denominator);
			if (i != matrixIn.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
	}

	/**
	 * For printing any size matrix if needed
	 * 
	 * @param matrixIn
	 *            The matrix to be printed
	 */
	public static void matrixPrinter(double[][] matrixIn) {
		for (int i = 0; i < matrixIn.length; i++) {
			for (int j = 0; j < matrixIn.length + 1; j++) {
				System.out.print(matrixIn[i][j] + ", ");
			}
			System.out.println("");
		}
	}
}
