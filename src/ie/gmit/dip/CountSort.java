package ie.gmit.dip;

public class CountSort extends ArrayGenerator {

	/*
	 * Code Source - https://www.javatpoint.com/counting-sort 
	 * Code has been taken from above website
	 */
	
	//This function finds the greatest element in the input array of size n
	int getMax(int[] a, int n) {
		int max = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max; // maximum element from the array
	}
	
	
	// function to perform counting sort
	public void countSort(int[] a, int n) {
		//Initialize output array
		int[] output = new int[n + 1];
		//Finds greatest elements from the input array
		int max = getMax(a, n);
		//Initialize count array with max+1 size
		int[] count = new int[max + 1]; 

		// Initialize count array with all zeros
		for (int i = 0; i <= max; ++i) {
			count[i] = 0; 
		}

		//Store how many elements of value X are in the input array 
		//at their X index in the count array
		for (int i = 0; i < n; i++) 
		{
			count[a[i]]++;
		}

		// find cumulative sum of elements in the count array
		for (int i = 1; i <= max; i++)
			count[i] += count[i - 1]; 

		/*
		 * This loop will find the index of each element of the original array in
		 * 
		 * count array, and place the elements in output array
		 */
		for (int i = n - 1; i >= 0; i--) {
			output[count[a[i]] - 1] = a[i];
			// decrease count for same numbers to determine 
			//final sorted position of curent index element
			count[a[i]]--; 
		}

		for (int i = 0; i < n; i++) {
			// store the sorted elements into main array
			a[i] = output[i]; 
		}
	}

	//Function to measure running time of a sorting run
	public double testCountSort(int arraySize) {
		//randomArray function to generate an int[] of arraySize number of elements and range specified
		int[] arr = randomArray(arraySize, range);
		long startTime = System.nanoTime();
		countSort(arr, arr.length);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		double elapsedMillis = timeElapsed / 1000000;
		return elapsedMillis;
	}

	//Function to measure the average of 10 sorting runs
	public double testCountSortBench(int arraySize) {
		double med = 0;
		for (int i = 0; i < 10; i++) {
			med = med + testCountSort(arraySize);
		}
		return med / 10;
	}

}
