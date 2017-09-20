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
		
		int [][] matrixC = divideAndConquer(matrixA, matrixB, 0, 0, 0, 0, n);
		
		System.out.println("Divide and Conquer");
		System.out.println(matrixC[0][0] + " " + matrixC[0][1]);
		System.out.println(matrixC[1][0] + " " + matrixC[1][1] + "\n");
		
		int [][] matrixC1 = strassenMethod(matrixA, matrixB, n);
		System.out.println("StrassenMethod");
		System.out.println(matrixC1[0][0] + " " + matrixC1[0][1]);
		System.out.println(matrixC1[1][0] + " " + matrixC1[1][1]);
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
	
	// adding method for divide and conquer
	public static void adding(int[][] A, int[][] B, int[][] C, int row, int column){
		int n = B.length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				C[i+row][j+column] = A[i][j] + B[i][j];
			}
		}
	}
		
// Strassenmethod with run time of log7
	public static int[][] strassenMethod(int[][] A, int[][] B, int n){
		int [][]C = new int[n][n];
		if(n==1)
		{
			C[0][0] = A[0][0] * B[0][0];
		}
		else
		{
			int[][] A11 = matrix(A, 0, 0);
			int[][] A22 = matrix(A, 1, 1);
			int[][] A12 = matrix(A, 0, 1);
			int[][] A21 = matrix(A, 1, 0);
			
			int[][] B11 = matrix(B, 0, 0);
			int[][] B22 = matrix(B, 1, 1);
			int[][] B12 = matrix(B, 0, 1);
			int[][] B21 = matrix(B, 1, 0);
			
			int[][] S1 = subtract(B12,B22);
			int[][] S2 = add(A11,A12);
			int[][] S3 = add(A21,A22);
			int[][] S4 = subtract(B21,B11);
			int[][] S5 = add(A11,A22);
			int[][] S6 = add(B11,B22);
			int[][] S7 = subtract(A12,A22);
			int[][] S8 = add(B21,B22);
			int[][] S9 = subtract(A11,B21);
			int[][] S10 = add(B11,B12);
			
			int [][] P1 = strassenMethod(A11, S1, n/2);
			int [][] P2 = strassenMethod(S2, B22, n/2);
			int [][] P3 = strassenMethod(S3, B11, n/2);
			int [][] P4 = strassenMethod(A22, S4, n/2);
			int [][] P5 = strassenMethod(S5, S6, n/2);
			int [][] P6 = strassenMethod(S7, S8, n/2);
			int [][] P7 = strassenMethod(S9, S10, n/2);
			
			int [][] C11 = subtract(add(P5,P4),subtract(P2,P6));
			int [][] C12 = add(P1,P2);
			int [][] C21 = add(P3,P4);;
			int [][] C22 = subtract(add(P5,P1),add(P3,P7));
			
			// Putting C = c11, c12, c21 , c22
			for (int i = 0 ; i < 1 ; i++) {
				for (int j = 0 ; j < 1 ; j++) {
					C[i][j] = C11[i][j];
					C[i][j + 1] = C12[i][j];
					C[i + 1][j] = C21[i][j];
					C[i + 1][j + 1] = C22[i][j];
				}
			}
		}
		return C;
	}
	
	public static int[][] matrix(int[][] matrix, int row, int column) {
		int[][] C = new int[2][2];
		int row1 = row;
		int column1 = column;
		for (int i = 0; row1 < 2 ; i++, row1++) {
			for (int j = 0; column1 < 2 ; j++, column1++) {
				C[i][j] = matrix[row1][column1];
			}
		}
		return C;
	}
	
	public static int[][] add(int[][] A, int[][] B){
		int n = B.length;
		int[][] C = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		return C;
	}
	
	public static int[][] subtract(int[][] A, int[][] B){
		int n = B.length;
		int[][] C = new int[n][n];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				C[i][j] = A[i][j] - B[i][j];
			}
		}
		return C;
	}
	
	
}