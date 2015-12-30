import java.util.Arrays;

/**
 * Given a 2D array with unique elements. Find an element a[i][j] which is
 * minimum in the ith row and maximum in the jth columns. How many such elements
 * can exist?
 * 
 * @author joshi18
 *
 */
public class MinMaxSearch {

	static int findMinMax(int[][] arr) {
		int[] minRow = new int[arr.length];
		int[] maxCol = new int[arr[0].length];
		for (int i = 0; i < minRow.length; ++i) {
			minRow[i] = -1;
		}
		for (int j = 0; j < maxCol.length; ++j) {
			maxCol[j] = -1;
		}
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[i].length; ++j) {
				if (minRow[i] == -1) {
					minRow[i] = j;
				} else {
					if (arr[i][j] < arr[i][minRow[i]]) {
						minRow[i] = j;
					}
				}
				if (maxCol[j] == -1) {
					maxCol[j] = i;
				} else {
					if (arr[maxCol[j]][j] < arr[i][j]) {
						maxCol[j] = i;
					}
				}
			}
		}
		for (int i = 0; i < minRow.length && i < maxCol.length; ++i) {
			if (i == maxCol[minRow[i]]) {
				return arr[i][minRow[i]];
			}
		}
		throw new RuntimeException("no such element");
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 10, 5, 15 }, { 1, 2, 6 } };
		assert (5 == findMinMax(arr));

		arr = new int[][] { { 10, 20, 15 }, { 1, 2, 6 } };
		assert (10 == findMinMax(arr));

		arr = new int[][] { { 50, 70, 100 }, { 20, 90, 80 }, { 10, 60, 50 } };
		assert (50 == findMinMax(arr));

		// arr = new int[][] { { 102, 70, 100 }, { 20, 90, 80 },{ 10, 60, 50 }
		// };
		// assert (50 == findMinMax(arr));
	}
}
