/**
 * Given a huge N*N matrix, we need to query the GCD of numbers in any given
 * submatrix range（x1,y1,x2,y2）. Design a way to preprocess the matrix to
 * accelerate the query speed. extra space should be less than O(N^2) and the
 * preprocess time complexity should be as litte as possible.
 * 
 * @author joshi18
 *
 */

/**
 * I'll try to present a Segment Tree based approach, which takes O(n^2) time
 * and space to pre-process, and answers each query in O(r * log(c)) time. r and
 * c are the number of rows and columns in the query.
 * 
 * For each row A[i] in the matrix A, we build a segment tree, such that each
 * node remembers GCD(A[i][a..b]) for some range [a,b). The root node remembers
 * GCD(A[i][0..n]), its children remembers GCD(A[i][0..n/2]) and
 * GCD(A[i][n/2..n]), and so on. The tree allows us to query GCD(A[i][a..b]) in
 * O(log n) time for some row i and an arbitrary range [a,b). The memory
 * complexity of each segment tree is O(n), which gives us O(n^2) total memory
 * complexity.
 * 
 * To answer a query, we just query GCD(A[y1][x1..x2]), GCD(A[y1+1][x1..x2]),
 * ... GCD(A[y2][x1..x2]) and take a GCD on all these numbers.
 * 
 * We can further improve the query time to O(logn * logn) by building one 2-d
 * segment tree for the entire matrix, but I doubt whether it's feasible to
 * implement a 2-d segment tree within the timespan of an interview.
 * 
 * @author joshi18
 *
 */
public class GCDRangeQuery {

}
