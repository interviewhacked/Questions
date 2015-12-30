import java.util.Arrays;

/**
 *  The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

 The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

 Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

 In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


 Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

 For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 */

/*-
 -2 (K)	-3	3
 -5	-10	1
 10	30	-5 (P)
 */
/**
 * Notes:
 * 
 * The knight's health has no upper bound. Any room can contain threats or
 * power-ups, even the first room the knight enters and the bottom-right room
 * where the princess is imprisoned.
 * 
 * @author joshi18
 *
 */

/**
 * Let S be the 2-D array where S(i,j) stores the solution of the sub-problem
 * beginning at dungeon[i][j]. S(dungeon[i][j])) refers to the solution of
 * single cell referred by dungeon[i][j]
 * 
 * S(dungeon[i][j]) = (dungeon[i][j] <=0 ? -dungeon[i][j]+1? 1)
 * 
 * If we know S(i+1,j) and S(i,j+1) then we would choose minimum of these two.
 * 
 * Let energyLeft = S(d(i,j)) + dungeon[i][j] which refers to how much energy is
 * left after entering the current cell if we begin with S(d(i,j))
 * 
 * so S(i,j) = S(dungeon[i][j]) if engeryLeft > min(S(i+1,j), S(i,j+1))
 * 
 * otherwise,
 * 
 * S(i,j) = S(dungeon[i][j]) + (min(S(i+1,j), S(i,j+1)) - energyLeft)
 * 
 * @author joshi18
 *
 */

public class D3 {

	int[][] sol;
	int[][] dungeon;

	public int calculateMinimumHP(int[][] dungeon) {
		this.dungeon = dungeon;
		if (dungeon == null || dungeon.length < 1 || dungeon[0].length < 1) {
			return 0;
		}
		sol = new int[dungeon.length][dungeon[0].length];
		int nRow = dungeon.length;
		int nCol = dungeon[0].length;
		sol[nRow - 1][nCol - 1] = getSol(dungeon[nRow - 1][nCol - 1]);
		for (int row = dungeon.length - 2; row >= 0; --row) {
			int curSol = getSol(dungeon[row][nCol - 1]);
			int energyLeft = curSol + dungeon[row][nCol - 1];
			sol[row][nCol - 1] = curSol
					+ getSol(energyLeft, sol[row + 1][nCol - 1]);
		}

		for (int col = dungeon[0].length - 2; col >= 0; --col) {
			int curSol = getSol(dungeon[nRow - 1][col]);
			int energyLeft = curSol + dungeon[nRow - 1][col];
			sol[nRow - 1][col] = curSol
					+ getSol(energyLeft, sol[nRow - 1][col + 1]);
		}

		for (int row = dungeon.length - 2; row >= 0; --row) {
			for (int col = dungeon[0].length - 2; col >= 0; --col) {
				int min = Math.min(sol[row][col + 1], sol[row + 1][col]);
				int curSol = getSol(dungeon[row][col]);
				int energyLeft = curSol + dungeon[row][col];
				sol[row][col] = curSol + getSol(energyLeft, min);
			}
		}

		return sol[0][0];
	}

	private int getSol(int energyLeft, int nextSolution) {
		if (energyLeft >= nextSolution) {
			return 0;
		}
		return (nextSolution - energyLeft);
	}

	private int getSol(int i) {
		return i <= 0 ? -i + 1 : 1;
	}

	public static void main(String[] args) {
		D3 d = new D3();
		assert (4 == d.calculateMinimumHP(new int[][] { { -3, 5 } }));
		assert (1 == d.calculateMinimumHP(new int[][] { { 5, -3 } }));
		assert (1 == d.calculateMinimumHP(new int[][] { { 0, 5 }, { -2, -3 } }));

		assert (1 == d.calculateMinimumHP(new int[][] { { 3, -20, 30 },
				{ -3, 4, 0 } }));

		assert (3 == d.calculateMinimumHP(new int[][] { { 1, -3, 3 },
				{ 0, -2, 0 }, { -3, -3, -3 } }));
		assert (1 == d.calculateMinimumHP(new int[][] { { 1, 2, 1 },
				{ -2, -3, -3 }, { 3, 2, -2 } }));

		assert (2 == d.calculateMinimumHP(new int[][] { { 1, -2, 3 },
				{ 2, -2, -2 } }));
		assert (3 == d.calculateMinimumHP(new int[][] { { 1, -4, 5, -99 },
				{ 2, -2, -2, -1 } }));
	}
}
