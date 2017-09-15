package lab04;
/*   
Author: Chan In Kou
Purpose: Using bruteforce to multiply 2x2 matrix.
*/

public class LAB04_ChanInKou {
	public static void main(String args[]) {
		// since we are only testing 2x2 matrix
		int n = 2;
		
		// Making the first matrix and the second matrix
		int [][] matrixA = { {1, 2}, { 3, 4 } };
		int [][] matrixB = { {1, 2}, { 3, 4 } };
		
		// calling bruteforce method for matrix multiplication
		bruteForce(matrixA, matrixB, n);
	}
	
	public static void bruteForce(int[][] A, int[][] B, int n){
		// Declaring the size of the final matrix answer
		int[][] c = new int[n][n];
		
		// Loop for the equation
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				for (int k = 0; k < n; k++)
				{
					c[i][j] = c[i][j] + A[i][k] * B[k][j];
					// testing if the calculation is correct
//					System.out.print(c[i][j] + " = c[" + i + "," + j + "] " + " + " + 
//					"matrixA [" + i + "," + k + "] * " + "matrixB [" + k + "," + j + "] " + "\n");
				}
			}
		}
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}
}