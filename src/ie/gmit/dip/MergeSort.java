package ie.gmit.dip;

public class MergeSort extends ArrayGenerator {

	/*
	 * Code Source - https://www.baeldung.com/java-merge-sort
	 * Code has been taken from above website
	 */
	
	//recursive function to perform merge sort
	public void mergeSort(int[] a, int n) {
		//base case when input arrays size 1 are met
		if (n < 2) {
			return;
		}
		//spit input arrays into two subarrays
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		
		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		//recursive call to split subarrays to other subarrays 
		//until base case is met
		mergeSort(l, mid);
		mergeSort(r, n - mid);

		//merge step of two subarrays take place at the end
		merge(a, l, r, mid, n - mid);
	}

	//function to sort and merge two subarrays
	public static void merge(int[] a, int[] l, int[] r, int left, int right) {

		//the three index variables for subarray-1, subarray-2 
		//and sorted output array
		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}
		//while loops to assign remaining elements in any of 
		//the two suarray over sorted output array
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}
	}

	//Function to measure running time of a sorting run
	public double testMergeSort(int arraySize) {
		//randomArray function to generate an int[] of arraySize number of elements and range specified
		int[] arr = randomArray(arraySize, range);
		long startTime = System.nanoTime();
		mergeSort(arr, arr.length);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		double elapsedMillis = timeElapsed / 1000000;
		return elapsedMillis;
	}

	//Function to measure the average of 10 sorting runs  
	public double testMergeSortBench(int arraySize) {
		double med = 0;
		for (int i = 0; i < 10; i++) {
			med = med + testMergeSort(arraySize);
		}
		return med / 10;
	}

}
