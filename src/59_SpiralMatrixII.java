import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 */
/*-
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 * @author joshi18
 *
 */
/**
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * @author joshi18
 *
 */

public class SpiralMatrixII {

	List<Integer> result;

	public List<Integer> spiralOrder(int[][] matrix) {
		result = new ArrayList<>();
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
			return result;
		}
		int width = matrix[0].length;
		int height = matrix.length;
		for (int i = 0; width >= 1 && height >= 1; ++i) {
			visitPerimeterInSpiral(matrix, i, i, width, height);
			width -= 2;
			height -= 2;
		}
		return result;
	}

	void visitPerimeterInSpiral(int[][] matrix, int beginRow, int beginCol,
			int width, int height) {
		int endRow = beginRow + height - 1;
		int endCol = beginCol + width - 1;

		// Top row
		for (int i = beginCol; i <= endCol; ++i) {
			result.add(matrix[beginRow][i]);
		}

		// Rightmost column
		for (int i = beginRow + 1; i <= endRow; ++i) {
			result.add(matrix[i][endCol]);
		}

		// bottom row
		for (int i = endCol - 1; i >= beginCol && endRow!=beginRow; --i) {
			result.add(matrix[endRow][i]);
		}

		// leftmost column
		for (int i = endRow - 1; i >= beginRow + 1 && beginCol!=endCol; --i) {
			result.add(matrix[i][beginCol]);
		}
	}

	public static void main(String[] args) {
		SpiralMatrixII sm = new SpiralMatrixII();
//		System.out.println(sm.spiralOrder(new int[][] { { 1, 2, 3 },
//				{ 4, 5, 6 }, { 7, 8, 9 } }));
//		System.out.println(sm.spiralOrder(new int[][] { { 1, 2, 3 },
//				{ 4, 5, 6 } }));
		System.out.println(sm.spiralOrder(new int[][] {{2,3 }}));
		System.out.println(sm.spiralOrder(new int[][] {{2},{3 }}));

	}
}
