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
		
		int [][] matrixC = divideAndConquer(matrixB, matrixB, n);
		
		System.out.println("Divide and Conquer");
		System.out.println(matrixC[0][0] + " " + matrixC[0][1]);
		System.out.println(matrixC[1][0] + " " + matrixC[1][1]);
	}
	
	public static void bruteForce(int[][] A, int[][] B, int n){
		System.out.println("brute force");
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
		
		System.out.println();
	}
	
	public static int[][] divideAndConquer(int[][]A, int[][]B, int n){
		// Make the final n x n matrix
		int [][]C = new int[n][n];
		
		if(n==1)
		{
			C[0][0] =A[0][0] * B[0][0];
			int[][] temp = {{C[0][0]}};
			return temp;
		}
		else{
			C[0][0]= A[0][0] * B[0][0] + A[0][1] * B[1][0];
			C[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1];
			C[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0];
			C[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1];
			
			return C;
		}
		
	}
	
//	public static int[][] divide(int[][]A, int[][]B, int[][]C, int n){
//		C[0][0]= A[0][0] * B[0][0] + A[0][1] * B[1][0];
//		C[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1];
//		C[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0];
//		C[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1];
//		return C;
//	}
}