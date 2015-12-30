/**
 * Given a undirected graph with corresponding edges. Find the number of
 * possible triangles? Example:
 */
/*-
 0 1 
 2 1 
 0 2 
 4 1 

 Answer: 
 1
 * @author joshi18
 *
 */

/*
 * For every vertex, we'll check for every pair of its neighbors whether there
 * is an edge between them and increment the triangle counter if so.
 * 
 * The total number of triangles will be the number of triangles we counted
 * divided by 6 (we count each triangle 6 times).
 */
public class TriangleCount {

}
