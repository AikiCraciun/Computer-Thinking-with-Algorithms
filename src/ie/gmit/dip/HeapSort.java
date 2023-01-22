package ie.gmit.dip;

public class HeapSort extends ArrayGenerator {

	/*
	 * Code Source - https://www.geeksforgeeks.org/heap-sort/
	 * Code has been taken from above website
	 */
	
	public void heapSort(int arr[]) {
		int n = arr.length;

		//for llop to build the heap data structure
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		//move root of heap to the end of the array
		//this way the largest element is always moved at the end of the array
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			//call heapify at the root of array after reordering 
			//of the array (largest element sorted)
			heapify(arr, i, 0);
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	void heapify(int arr[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	//Function to measure running time of a sorting run
	public double testHeapSort(int arraySize) {
		//randomArray function to generate an int[] of arraySize number of elements and range specified
		int[] arr = randomArray(arraySize, range);
		long startTime = System . nanoTime () ;
		heapSort(arr);
		long endTime = System . nanoTime () ;
		long timeElapsed = endTime - startTime ;
		double elapsedMillis = timeElapsed /1000000;
		return elapsedMillis;
	}
	
	//Function to measure the average of 10 sorting runs
	public double testHeapSortBench(int arraySize) {
		double med = 0;
		for (int i = 0; i < 10; i++) {
			med = med + testHeapSort(arraySize);
		}
		return med/10;
	}

}
