/**
 * 
 * Given a list of directed edges in a directed graph. You need to determine whether or not the directed graph forms a tree. 
The directed graph is considered to be a tree if there exists a root vertex, r, such that for every other vertex, v, 
there exists exactly one directed path from r to v. 
Input Format Each line of input specifies one directed edge in the form "s d", where 
s is the source vertex and d is the destination vertex. Each vertex name is a single alphabetic character. 
The vertexes are separated by a single space. There is one line for every edge. The end of input indicates
 the end of the edge list. 

 */

/**
 * There should be only one universal source.
 * And dfs from that source should visit every node only once.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Graph<T> {

	private Map<T, List<T>> adjList;
	private Set<T> nodes;

	Graph() {
		nodes = new HashSet<T>();
		adjList = new HashMap<T, List<T>>();
	}

	public boolean addEdge(T src, T dest) {
		nodes.add(src);
		nodes.add(dest);
		List<T> value = adjList.get(src);
		if (value != null) {
			if (value.contains(dest)) {
				return false;
			}
			value.add(dest);
			return true;
		}
		value = new ArrayList<T>();
		value.add(dest);
		adjList.put(src, value);
		return true;
	}

	public List<T> getUnivSource() {
		List<T> univSources = new ArrayList<T>();
		univSources.addAll(adjList.keySet());
		for (T key : adjList.keySet()) {
			univSources.removeAll(adjList.get(key));
		}
		return univSources;
	}

	public boolean isTree(T sourceNode) {
		Set<T> visitedNodes = new HashSet<T>();

		boolean result = doDfs(sourceNode, visitedNodes);

		return result ? visitedNodes.size() == this.nodes.size() : false;
	}

	private boolean doDfs(T sourceNode, Set<T> visitedNodes) {
		if (visitedNodes.contains(sourceNode)) {
			return false;
		}
		visitedNodes.add(sourceNode);
		boolean result = true;
		if (adjList.get(sourceNode) != null) {
			for (T child : adjList.get(sourceNode)) {
				result = result && doDfs(child, visitedNodes);
			}
		}
		return result;
	}
}

public class IsTree {

	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */

		Scanner scan = new Scanner(System.in);
		Graph<Character> graph = new Graph<>();
		while (scan.hasNextLine()) {
			String edge = scan.nextLine();
			String temp[] = edge.split(" ");
			char src = temp[0].trim().charAt(0);
			char dest = temp[1].trim().charAt(0);
			graph.addEdge(src, dest);
		}
		scan.close();
		List<Character> sources = graph.getUnivSource();
		if (sources.size() != 1) {
			System.out.println("false");
			return;
		}
		System.out.println(graph.isTree(sources.get(0)));
	}
}
