/**
 * Given an equation in the form 2^i * 3^j * 5^k * 7^l where i,j,k,l >=0 are
 * integers.write a program to generate numbers from that equation in sorted
 * order efficiently.
 * 
 * for example numbers from that equation will be in the order
 * 2,3,5,6,7,8,9.....and so on..
 * 
 * @author joshi18
 *
 */





/**
 * The key here is to use a heap (aka priority queue). Start with number 1 and
 * add it to the heap. Then, do a loop a) Pop the minimum value from the heap b)
 * Print this minimum c) Add minimum*2, *3, *5 and *7 to the heap
 * 
 * If we want N numbers, the complexity will be O(N log N).
 * 
 * @author joshi18
 *
 */
public class NextNumber {

}
