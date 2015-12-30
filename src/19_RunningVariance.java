
public class RunningVariance {

	int[] result;
	MinMaxQueue<Integer> aMinMaxQueue = new MinMaxQueue<>();

	public void compute(int[] arr, int k) {
		result = new int[k];
		for (int i = 0; i < k; ++i) {
			aMinMaxQueue.enqueue(arr[i]);
		}
		arr[0] = aMinMaxQueue.getMax() - aMinMaxQueue.getMin();
		for (int i = k, j = 1; j < k && i < arr.length; ++i, ++j) {
			aMinMaxQueue.dequeue();
			aMinMaxQueue.enqueue(arr[k]);
			arr[j] = aMinMaxQueue.getMax() - aMinMaxQueue.getMin();
		}
	}

	public boolean difference(int[] arr, int k, int t) {
		for (int i = 0; i < k; ++i) {
			aMinMaxQueue.enqueue(arr[i]);
		}
		int diff =  aMinMaxQueue.getMax() - aMinMaxQueue.getMin();
		if(diff<=t){
			
		}
		for (int i = k, j = 1; j < k && i < arr.length; ++i, ++j) {
			aMinMaxQueue.dequeue();
			aMinMaxQueue.enqueue(arr[k]);
			arr[j] = aMinMaxQueue.getMax() - aMinMaxQueue.getMin();
		}
	}
}
