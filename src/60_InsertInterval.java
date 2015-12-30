import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author joshi18
 *
 */

/**
 * Just insert the interval in the right position by start time and then do a
 * merge using stack.
 * 
 * @author joshi18
 *
 */
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	public String toString() {
		return "[ " + start + ", " + end + " ] ";
	}
}

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> mergedList = new ArrayList<Interval>();
		Stack<Interval> aStack = new Stack<Interval>();

		boolean isInserted = false;
		if (intervals.isEmpty()) {
			isInserted = true;
			mergedList.add(newInterval);
		}
		for (int i = 0; i < intervals.size(); ++i) {
			if (intervals.get(i).start >= newInterval.start && !isInserted) {
				isInserted = true;
				mergedList.add(newInterval);
			}
			mergedList.add(intervals.get(i));
		}
		if (!isInserted) {
			isInserted = true;
			mergedList.add(newInterval);
		}
		for (Interval aInterval : mergedList) {
			if (aStack.isEmpty()) {
				aStack.add(aInterval);
			} else {
				Interval lastInterval = aStack.pop();
				if (aInterval.start <= lastInterval.end) {
					aStack.push(new Interval(Math.min(aInterval.start,
							lastInterval.start), Math.max(lastInterval.end,
							aInterval.end)));
				} else {
					aStack.push(lastInterval);
					aStack.push(aInterval);
				}
			}
		}
		List<Interval> result = new ArrayList<>();
		result.addAll(aStack);
		return result;
	}

}
