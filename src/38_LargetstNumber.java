import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 * 
 * @author joshi18
 *
 */

/**
 * Just sort the array with following compare function Given two numbers 'a' and
 * 'b' in string format: 'a' >'b' if 'a'+'b' > 'b'+'a' 'b' >'a' if 'a'+'b' <
 * 'b'+'a'
 * 
 * @author joshi18
 *
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
		List<String> strNums = new ArrayList<>();
		for (int el : nums) {
			strNums.add(el + "");
		}
		Collections.sort(strNums, new Comparator<String>() {
			public int compare(String one, String two) {
				String op1 = one + two;
				String op2 = two + one;
				for (int i = 0; i < op1.length(); ++i) {
					if (op1.charAt(i) > op2.charAt(i)) {
						return 1;
					}
					if (op1.charAt(i) < op2.charAt(i)) {
						return -1;
					}
				}
				return 0;
			}
		});
		String result = "";
		for (int i = strNums.size() - 1; i >= 0; --i) {
			result += strNums.get(i);
		}
		if (result.charAt(0) == '0') {
			return 0 + "";
		}
		return result;
	}
}
