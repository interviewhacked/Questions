public class Solution2 {
/**
 * Given two integers A and B return count of all integers whose square lie in
 * the range defined by A and B.
 * e.g. give (-17,17) return 8.
 * A<B
 * and they have range in [Integer.MIN_VALUE, Integer.MAX_VALUE]
 * 
 * @param A 
 * @param B
 * @return
 */
	public int solution(int A, int B) {
		/**
		 * If B is negative or zero then we return zero as we are not supporting
		 * imaginary numbers.
		 * 
		 * 0 is considered square of 0.
		 */
		if (B <= 0) {
			return 0;
		}
		int count = 0;
		int highestNumber = (int) Math.sqrt((Math.abs(B)));
		boolean isANegative = false;
		int lowerLimit;
		if (A < 0) {
			isANegative = true;
			lowerLimit = 1;
		} else {
			lowerLimit = A;
		}
		if (A == 0) {
			lowerLimit = 1;
			++count;
		}
		int countWihtInA = 0;
		int currentSquare = highestNumber * highestNumber;
		while (currentSquare >= lowerLimit) {
			if (isANegative) {
				if (currentSquare <= -A) {
					++countWihtInA;
				}
			}
			++count;
			highestNumber--;
			currentSquare = highestNumber * highestNumber;
		}

		return count + countWihtInA;
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		s.solution(0, 5);
	}
}
