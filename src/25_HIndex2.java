/**
 * Follow up for H-Index: What if the citations array is sorted in ascending
 * order? Could you optimize your algorithm?
 * 
 * Original Problem: Given an array of citations (each citation is a
 * non-negative integer) of a researcher, write a function to compute the
 * researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * 
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher
 * has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations
 * respectively. Since the researcher has 3 papers with at least 3 citations
 * each and the remaining two with no more than 3 citations each, his h-index is
 * 3.
 * 
 * Note: If there are several possible values for h, the maximum one is taken as
 * the h-index.
 * 
 * @author joshi18
 *
 */
public class HIndex2 {
	public int hIndex(int[] citations) {
		int n = citations.length;
		int low = 0, high = citations.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (citations[mid] >= n - mid
					&& (mid == 0 || (citations[mid - 1] < n - (mid - 1)))) {
				return n - mid ;
			}
			if (citations[mid] >= n - mid) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return 0;
	}
}
