package ie.gmit.dip;

public class InsertionSort extends ArrayGenerator{
	
	/*
	 * Code Source - CTA Sorting Algorithms Part 1 lecture
	 */
	public void insertionSort(int[] arr) {
		//loop over all the elements in the input array
		for (int i = 1; i < arr.length; i++) {
			//sets a local variable - key
			int key = arr[i]; 
			int j = i - 1;
			//while loop over all elements before the curent loop index
			//if any element before curent is found greater than curent
			//the curent is swapped with the greater element
			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j - 1;
			}
			//swapping of curent with greater element takes place here
			arr[j+1] = key;
		}
	}
	
	//Function to measure running time of a sorting run
	public double testInsertionSort(int arraySize) {
		//randomArray function to generate an int[] of arraySize number of elements and range specified
		int[] arr = randomArray(arraySize, range);
		long startTime = System . nanoTime () ;
		insertionSort(arr);
		long endTime = System . nanoTime () ;
		long timeElapsed = endTime - startTime ;
		double elapsedMillis = timeElapsed /1000000;
		return elapsedMillis;
	}
	
	//Function to measure the average of 10 sorting runs 
	public double testInsertionSortBench(int arraySize) {
		double med = 0;
		for (int i = 0; i < 10; i++) {
			med = med + testInsertionSort(arraySize);
		}
		return med/10;
	}
}
