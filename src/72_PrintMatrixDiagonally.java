/**
 * Give a N*N matrix, print it out diagonally. Follow up, if it is a M*N matrix,
 * how to print it out. Example:
 */
/*-
 1 2 3 
 4 5 6 
 7 8 9 
 print: 
 1 
 2 4 
 3 5 7 
 6 8 
 9 

 * @author joshi18
 *
 */

public class PrintMatrixDiagonally {

	void print(int[][] matrix) {
		for (int col = 0; col < matrix[0].length; ++col) {
			helper(matrix, 0, col);
			System.out.println();
		}
		for (int row = 1; row < matrix.length; ++row) {
			helper(matrix, row, matrix[0].length - 1);
			System.out.println();
		}
	}

	void helper(int[][] matrix, int row, int col) {
		while (row >= 0 && row < matrix.length && col >= 0
				&& col < matrix[0].length) {
			System.out.print(matrix[row][col] + " ");
			++row;
			--col;
		}
	}
	
	public static void main(String []args){
		PrintMatrixDiagonally obj = new PrintMatrixDiagonally();
		obj.print(new int[][]{{1,2,3},{4,5,6}});
		obj.print(new int[][]{{1,2},{4,5},{7,8}});
		obj.print(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
	}
}
