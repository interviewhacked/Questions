import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DependencyOrdering {
	List<String> finalOrder;
	Map<String, Integer> fileToCount;
	List<String> findOrder(Map<String, List<String>> dependencies, String rootFile) {
		finalOrder = new ArrayList<String>();
		finalOrder.add(rootFile);
		// not sure if rootFile is the first file to be imported in that case
		// call
		// initFinalOrder first
		for (int i = 0; i < dependencies.size() - 1; ++i) {
			for (Entry<String, List<String>> anEntry : dependencies.entrySet()) {
				for (String aFile : finalOrder) {
					if (anEntry.getValue().contains(aFile)) {
						anEntry.getValue().remove(aFile);
					}
				}
				if (anEntry.getValue().isEmpty()) {
					finalOrder.add(anEntry.getKey());
				}
			}
		}
		if (finalOrder.size() != dependencies.size()) {
			throw new RuntimeException("No such order possible");
		}
		return finalOrder;
	}

	void initFinalOrder(Map<String, List<String>> dependencies) {
		for (Entry<String, List<String>> anEntry : dependencies.entrySet()) {
			if (anEntry.getValue().isEmpty()) {
				finalOrder.add(anEntry.getKey());
			}
		}
	}
	
	void fileToCount(Map<String, List<String>> dependencies){
		
	}
	

}
