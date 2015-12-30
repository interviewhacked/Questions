/**
 * Output top N positive integer in string comparison order. For example, let's
 * say N=1000, then you need to output in string comparison order as below: 1,
 * 10, 100, 1000, 101, 102, ... 109, 11, 110, ...
 * 
 * @author joshi18
 *
 */
public class IntegerInStringOrder {
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++)
			printRec("" + i, 1000);
	}

	static void printRec(String str, int n) {
		if (Integer.parseInt(str) > n)
			return;
		System.out.println(str);
		for (int i = 0; i < 10; i++)
			printRec(str + i, n);
	}
}
