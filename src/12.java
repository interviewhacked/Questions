/**
	 * Coin Change is the problem of finding the number of ways of making
	 * changes for a particular amount of cents, n, using a given set of
	 * denominations . It is a general case of Integer Partition, and can be
	 * solved with dynamic programming.
	 * 
	 * 
	 * 
	 * 
	 * We are trying to count the number of distinct sets. Since order does not
	 * matter, we will impose that our solutions (sets) are all sorted in
	 * non-decreasing order (Thus, we are looking at sorted-set solutions:
	 * collections). For a particular N and (now with the restriction that , our
	 * solutions can be constructed in non-decreasing order), the set of
	 * solutions for this problem, C(n,m), can be partitioned into two sets:
	 * There are those sets that does not contain any Sm, Those sets that
	 * contain at least 1 Sm, If a solution does not contain Sm, then we can
	 * solve the subproblem of N with , or the solutions of C(n,m - 1). If a
	 * solution does contain Sm, then we are using at least one Sm, thus we are
	 * now solving the subproblem of N - Sm, . This is C(n - Sm,m). Thus, we can
	 * formulate the following: C(n,m) = C(n,m - 1) + C(n - Sm,m) with the base
	 * cases: C(n,m) = 1,n = 0 C(n,m) = 0,n < 0
	 */

	int countRecursive(int n, int m) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (m <= 0 && n >= 1)
			return 0;
		return countRecursive(n - m, m) + countRecursive(n, m - 1);
	}

	// Dynamic Programming in O(nm) time
	int count(int n, int m) {
		int result[][] = new int[n + 1][m + 1];
		for (int i = 0; i <= n; ++i) {
			for (int j = 0; j <= m && j <= n; ++j) {
				if (i == 0) {
					result[0][j] = 1;
					continue;
				}
				if (j == 0) {
					result[i][0] = 0;
					continue;
				}
				result[i][j] = result[i - j][j] + result[i][j - 1];
			}
		}
		return result[n][m];
		/**
		 * There are cases where the greedy algorithm is optimal - for example,
		 * the US coin system.
		 */
	}
