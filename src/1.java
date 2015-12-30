/**
There are a set of 'n' integers. Describe an algorithm to find for each 
of all its subsets of n-1 integers the product of its integers.

For example, let consider (6, 3, 1, 2). We need to find these products:
    
           6 * 3 * 1 = 18
           6 * 3 * 2 = 36
           3 * 1 * 2 = 6
           6 * 1 * 2 = 12


Sol.

for i= 1 to N
	a[i] = mul/a[i];

The downside of this approach is if a[i]=0 you get an exception.
*/


//Dynamic Programming:

void solution(int[] input) {

		int n = input.length, i, j;
		int[] leftMul = new int[n];
		int[] rightMul = new int[n];
		int[] result = new int[n];

		for (i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
				leftMul[i] = i == 0 ? 1 : input[i - 1] * leftMul[i - 1];
				rightMul[j] = j == n - 1 ? 1 : rightMul[j + 1] * input[j + 1];
		}

		for (i = 0; i < n; i++) {
				result[i] = leftMul[i] * rightMul[i];
		}
}  

/**
 * Through the leftMul and rightMul we calculate the multiplication of terms to 
 * the left and right of i-th term then finally we multiply it to get the result.
 * /


