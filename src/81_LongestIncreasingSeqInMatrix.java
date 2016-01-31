import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */




/**
 * The given matrix can be thought of as a directed acyclic graph where there is
 * an edge between from cell a to cell b if a and b are adjacent and a<b. It's
 * acyclic as either of c < d or d > c. To find the diameter of a DAG either do
 * a topological sort or do this
 */
/*-
 * memo = {}
def get_longest(to_node):
    if to_node in memo:
        return memo[to_node]
    best = 0
    for from_node in from_nodes[to_node]:
        best = max(best, get_longest(from_node) + 1)
    memo[to_node] = best
    return best
length, node = max([(get_longest(to_node), to_node) for to_node in all_nodes]) 
 * @author pkjoshi
 *
 */
public class LongestIncreasingSeqInMatrix {

	int max = 0;
	boolean isVisited[][];
	int[][] arr;
	int distance[][];

	int longestIncreasingPath(int[][] arr) {
		if (arr == null || arr.length < 1 || arr[0].length < 1) {
			return 0;
		}
		this.arr = arr;
		isVisited = new boolean[arr.length][arr[0].length];
		distance = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				doDfs(i, j);
			}
		}

		return max + 1;
	}

	void doDfs(int row, int col) {
		if (distance[row][col] != 0) {
			return;
		}
		for (Pair p : getFromNodes(row, col)) {
			doDfs(p.x, p.y);
			distance[row][col] = Math.max(distance[row][col], distance[p.x][p.y] + 1);
			if (distance[row][col] > max) {
				max = distance[row][col];
			}
		}
	}

	List<Pair> getFromNodes(int row, int col) {
		List<Pair> list = new ArrayList<Pair>();
		addIfInBounds(list, row + 1, col, arr[row][col]);
		addIfInBounds(list, row, col + 1, arr[row][col]);
		addIfInBounds(list, row, col - 1, arr[row][col]);
		addIfInBounds(list, row - 1, col, arr[row][col]);
		return list;
	}

	void addIfInBounds(List<Pair> list, int row, int col, int el) {
		if (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length && arr[row][col] < el) {
			list.add(new Pair(row, col));
		}
	}
}

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		int hash = 23;
		hash = hash * 31 + x;
		hash = hash * 31 + y;
		return hash;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		Pair arg = (Pair) o;
		return arg.x == this.x && arg.y == this.y;
	}
}
