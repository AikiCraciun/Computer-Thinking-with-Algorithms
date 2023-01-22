package ie.gmit.dip;

public class SelectionSort extends ArrayGenerator{
	
	/*
	 * Code Source - CTA Sorting Algorithms Part 1 lecture
	 */
	public void selectionSort(int[] arr) {
		// Three local variables initialize to control the iteration process
		int outer = 0, inner = 0, min = 0;
		//First loop over all elements in the array
		for (outer = 0; outer < arr.length - 1; outer++) {
			//Define current index as min
			min = outer;
			for (inner = outer + 1; inner < arr.length; inner++) {
				//finds out f there is a small elements than min
				if (arr[inner] < arr[min]) {
					min = inner;
				}
			}
			//swaps the min with the outer
			//this step puts all the elements in order
			int temp = arr[outer];
			arr[outer] = arr[min];
			arr[min] = temp;
		}
	}
	
	//Function to measure running time of a sorting run
	public double testSelectionSort(int arraySize) {
		//randomArray function to generate an int[] of arraySize number of elements and range specified
		int[] arr = randomArray(arraySize, range);
		long startTime = System . nanoTime () ;
		selectionSort(arr);
		long endTime = System . nanoTime () ;
		long timeElapsed = endTime - startTime ;
		double elapsedMillis = timeElapsed /1000000;
		return elapsedMillis;
	}
	
	//Function to measure the average of 10 sorting runs  
	public double testSelectionSortBench(int arraySize) {
		double med = 0;
		for (int i = 0; i < 10; i++) {
			med = med + testSelectionSort(arraySize);
		}
		return med/10;
	}
}
