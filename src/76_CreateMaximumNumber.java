import java.util.Arrays;

/**
 * Given two arrays of length m and n with digits 0-9 representing two numbers.
 * Create the maximum number of length k <= m + n from digits of the two. The
 * relative order of the digits from the same array must be preserved. Return an
 * array of the k digits. You should try to optimize your time and space
 * complexity.
 */
/*-Example 1:
 nums1 = [3, 4, 6, 5]
 nums2 = [9, 1, 2, 5, 8, 3]
 k = 5
 return [9, 8, 6, 5, 3]

 Example 2:
 nums1 = [6, 7]
 nums2 = [6, 0, 4]
 k = 5
 return [6, 7, 6, 0, 4]

 Example 3:
 nums1 = [3, 9]
 nums2 = [8, 9]
 k = 3
 return [9, 8, 9]
 * @author joshi18
 *
 */

/*-
 * DP 
 * S(i1,i2,k) = 
 * 				max of 
 * 					num1[i1] + S(i1+1,i2,k-1) //choose digit from num1
 * 					num2[i2]+ S(i1,i2+1,k-1) //choose digit from num2 
 * 					max of( S(i1+1,i2+1,k),
 * 					S(i1,i2+1,k), S(i1+1,i2,k), )// neither num1[i1] nor num2[i2] are chosen.
 * 
 * Complexity O(m*n*k*k)
 * 
 * @author joshi18
 */
public class CreateMaximumNumber {
	int[] nums1;
	int[] nums2;

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {

		int[][][][] table = new int[k + 1][nums1.length + 1][nums2.length + 1][];
		this.nums1 = nums1;
		this.nums2 = nums2;
		;

		for (int ki = 1; ki <= k; ++ki) {
			for (int numi1 = nums1.length; numi1 >= 0; --numi1) {
				for (int numi2 = nums2.length; numi2 >= 0; --numi2) {

					table[ki][numi1][numi2] = getSol(table, numi1, numi2, ki);
					System.out.println(ki + " " + numi1 + " " + numi2 + " "
							+ Arrays.toString(table[ki][numi1][numi2]));
				}
			}
		}
		return table[k][0][0];
	}

	int[] getSol(int[][][][] table, int numi1, int numi2, int k) {
		if (numi1 == nums1.length && numi2 == nums2.length) {
			return new int[0];
		}
		if (numi1 == nums1.length) {
			if (k == 1) {
				return new int[] { max(nums2[numi2], table[k][numi1][numi2 + 1]) };
			}
			int option1[] = new int[0];
			if (numi2 == nums2.length - 1) {
				return new int[] { nums2[numi2] };
			}
			option1 = table[k - 1][numi1][numi2 + 1];
			option1 = prepend(nums2[numi2], option1);
			return maxNum(option1, table[k][numi1][numi2 + 1]);
		}

		if (numi2 == nums2.length) {
			if (k == 1) {
				return new int[] { max(nums1[numi1], table[k][numi1 + 1][numi2]) };
			}
			int option1[] = new int[0];
			if (numi1 == nums1.length - 1) {
				return new int[] { nums1[numi1] };
			}
			option1 = table[k - 1][numi1 + 1][numi2];
			option1 = prepend(nums1[numi1], option1);
			return maxNum(option1, table[k][numi1 + 1][numi2]);
		}

		if (k == 1) {
			int option1 = nums1[numi1];
			int option2 = nums2[numi2];
			int option3 = 0;
			option1 = max(option1, table[k][numi1 + 1][numi2][0]);

			option2 = max(option2, table[k][numi1][numi2 + 1][0]);

			option3 = table[k][numi1 + 1][numi2 + 1].length > 0 ? table[k][numi1 + 1][numi2 + 1][0]
					: 0;
			return new int[] { max(option1, option2, option3) };
		}
		int option1[] = new int[0];
		int option2[] = new int[0];
		;
		int option3[] = new int[0];
		;

		option1 = table[k - 1][numi1 + 1][numi2];
		option2 = table[k - 1][numi1][numi2 + 1];

		option3 = maxNum(table[k][numi1 + 1][numi2 + 1],
				table[k][numi1 + 1][numi2], table[k][numi1][numi2 + 1]);
		option1 = prepend(nums1[numi1], option1);
		option2 = prepend(nums2[numi2], option2);
		return maxNum(option1, option2, option3);

	}

	private int max(int i, int[] js) {
		int max = i;
		if (js == null || js.length == 0) {
			return i;
		}
		for (int el : js) {
			if (el > max) {
				max = el;
			}
		}
		return max;
	}

	int[] prepend(int el, int... a) {
		int result[] = new int[a.length + 1];
		result[0] = el;
		for (int i = 0; i < a.length; ++i) {
			result[i + 1] = a[i];
		}
		return result;
	}

	int max(int... arg) {
		int maxEl = arg[0];
		for (int el : arg) {
			if (maxEl < el) {
				maxEl = el;
			}
		}
		return maxEl;
	}

	int[] maxNum(int[] a, int[] b, int[] c) {
		return maxNum(a, maxNum(b, c));
	}

	int[] maxNum(int[] a, int[] b) {
		if (a.length > b.length) {
			return a;
		}
		if (b.length > a.length) {
			return b;
		}
		for (int i = 0; i < a.length; ++i) {
			if (a[i] > b[i]) {
				return a;
			}
			if (b[i] > a[i]) {
				return b;
			}
		}
		return a;
	}

	public static void main(String[] args) {
		CreateMaximumNumber obj = new CreateMaximumNumber();
		assert (Arrays.equals(
				new int[] { 9, 8, 6, 5, 3 },
				obj.maxNumber(new int[] { 3, 4, 6, 5 }, new int[] { 9, 1, 2, 5,
						8, 3 }, 5)));
		assert (Arrays.equals(new int[] { 9, 4 },
				obj.maxNumber(new int[] { 3, 4 }, new int[] { 9 }, 2)));
		// assert(Arrays.equals(Arrays.toString(obj.maxNumber(new int[] { 3, 4
		// },
		// new int[] { 9, 5 }, 3)));
		// assert(Arrays.equals(Arrays.toString(obj.maxNumber(
		// new int[] { 7 }, new int[] { 6,0 }, 3)));
		assert (Arrays.equals(new int[] { 6, 7, 6, 0, 4 },
				obj.maxNumber(new int[] { 6, 7 }, new int[] { 6, 0, 4 }, 5)));
		assert (Arrays.equals(new int[] { 9, 8, 9 },
				obj.maxNumber(new int[] { 3, 9 }, new int[] { 8, 9 }, 3)));
	}
}
