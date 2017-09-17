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
		
		int [][] matrixC = divideAndConquer(matrixB, matrixB, 0, 0, 0, 0, n);
		
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
		
		// loop for printing out the solution for nxn which is C
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
	
	// method for divide and conquer
	public static int[][] divideAndConquer(int[][]A, int[][]B, int row1, int column1, int row2, int column2, int n){
		// Make the final n x n matrix
		int [][]C = new int[n][n];
		
		if(n==1)
		{
			C[0][0] =A[row1][column1] * B[row2][column2];
			return C;
		}
		else{
			// divide the problem by 2 everytime 
			int size = n / 2;
			//first
			adding(divideAndConquer(A, B, row1, column1, row2, column2, size),
					divideAndConquer(A, B, row1, column1 + size, row2 + size, column2, size), C,  0, 0);
			
			//second
			adding(divideAndConquer(A, B, row1, column1, row2, column2 + size, size),
					divideAndConquer(A, B, row1, column1 + size, row2 + size, column2+ size, size), C,  0, size);
			
			//third
			adding(divideAndConquer(A, B, row1 + size, column1, row2, column2, size),
					divideAndConquer(A, B, row1 + size, column1 + size, row2 + size, column2, size), C, size, 0);
			
			//fourth
			adding(divideAndConquer(A, B, row1 + size, column1, row2, column2 + size, size),
					divideAndConquer(A, B, row1 + size, column1 + size, row2 + size, column2 + size, size), C, size, size);
//			C[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0];
//			C[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1];
//			C[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0];
//			C[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1];
			return C;
		}
	}
	
	public static void adding(int[][] A, int[][] B, int[][] C, int row, int column){
		int n = B.length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				C[i+row][j+column] = A[i][j] + B[i][j];
			}
		}
	}
	
	public static int[][] strassen(int[][] A, int[][] B, int[][] C){
		int[][] S1;
		
		return C;
		
	}
}