/**
 * We will name a number "aggregated number" if this number has the following
 * attribute: just like the Fibonacci numbers 1,1,2,3,5,8,13.....
 * 
 * the digits in the number can divided into several parts, and the later part
 * is the sum of the former parts.
 * 
 * like 112358, because 1+1=2, 1+2=3, 2+3=5, 3+5=8 122436, because 12+24=36
 * 1299111210, because 12+99=111, 99+111=210 112112224, because 112+112=224 so
 * can you provide a function to check whether this number is aggregated number
 * or not?
 * 
 * @author joshi18
 *
 */
public class AggregateNumber {
	static boolean IsAggregatedNumber(String text) {
		for (int i = 1; i <= text.length() / 2; i++) {
			for (int j = 1; j <= text.length() / 2; j++) {
				if (Match(i, j, text)) {
					return true;
				}
			}
		}

		return false;
	}

	static boolean Match(int i, int j, String text) {
		String first = text.substring(0, i);
		String second = text.substring(i, j);
		StringBuilder buffer = new StringBuilder();
		buffer.append(first);
		buffer.append(second);
		while (buffer.length() < text.length()) {
			String third = (Integer.parseInt(first) + Integer.parseInt(second))
					+ "";
			buffer.append(third);
			first = second;
			second = third;
		}

		return buffer.length() == text.length() && buffer.toString() == text;
	}
}
