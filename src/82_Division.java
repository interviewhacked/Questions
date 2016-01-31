class DivisionResult {
	int remainder;
	int quotient;

	DivisionResult(int remainder, int quotient) {
		this.remainder = remainder;
		this.quotient = quotient;
	}
}

public class Division {

	DivisionResult div(int numerator, int denominator) {
		if (denominator == 0) {
			throw new RuntimeException("Divide by zero");
		}
		if (numerator == 0) {
			return new DivisionResult(0, 0);
		}
		int quotient = 1;
		while (denominator * quotient < numerator) {
			quotient <<= 1;
		}

		// while (denominator * quotient > numerator) {
		// --quotient;
		// }

		quotient = binarySearch(quotient >> 1, quotient, denominator, numerator);

		if (denominator * quotient == numerator) {
			return new DivisionResult(0, quotient);
		}
		return new DivisionResult(numerator - denominator * quotient, quotient);

	}

	int binarySearch(int low, int high, int d, int n) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (d * mid == n) {
				return mid;
			}
			if (d * mid < n && (mid == high || (mid + 1) * d > n)) {
				return mid;
			}
			if (d * mid > n) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		throw new RuntimeException("Invalid case");

	}
}
