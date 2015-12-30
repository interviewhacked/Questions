import java.util.Arrays;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix:
 */
/*-
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]

 * @author joshi18
 *
 */
public class SpiralMatrix {

	int nextNumber = 1;

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int width = n;
		int height = n;
		for (int i=0;width >= 1;++i) {
			visitPerimeterInSpiral(matrix, i, i, width, height);
			width -= 2;
			height -= 2;
		}
		return matrix;
	}

	void visitPerimeterInSpiral(int[][] matrix, int beginRow, int beginCol,
			int width, int height) {
		int endRow = beginRow + height - 1;
		int endCol = beginCol + width - 1;

		//Top row
		for (int i = beginCol; i <= endCol; ++i) {
			matrix[beginRow][i] = getNext();
		}

		//Rightmost column
		for (int i = beginRow + 1; i <= endRow; ++i) {
			matrix[i][endCol] = getNext();
		}

		//bottom row
		for (int i = endCol - 1; i >= beginCol; --i) {
			matrix[endRow][i] = getNext();
		}

		//leftmost column
		for (int i = endRow - 1; i >= beginRow + 1; --i) {
			matrix[i][beginCol] = getNext();
		}
	}

	int getNext() {
		return nextNumber++;
	}

	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		print(sm.generateMatrix(6));

	}

	private static void print(int[][] generateMatrix) {
		for(int []row:generateMatrix){
			System.out.println(Arrays.toString(row));
		}
		
	}
}
