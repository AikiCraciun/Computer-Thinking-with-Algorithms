package ie.gmit.dip;

public class Runner {

	public void printArray(int a[], int n) {
		int i;
		for (i = 0; i < n; i++)
			System.out.print(a[i] + " ");
	}

	public static void main(String[] args) {
		CountSort countSort = new CountSort();
		MergeSort mergeSort = new MergeSort();
		InsertionSort insertionSort = new InsertionSort();
		HeapSort heapSort = new HeapSort();
		SelectionSort selectionSort = new SelectionSort();

		int[] arraySizes = { 100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000, 20000 };

		System.out.print("Size \t\t ");
		for (int i = 0; i < arraySizes.length; i++) {
			System.out.print(arraySizes[i] + "\t ");
		}
		System.out.print("\n");

		System.out.print("Selection Sort \t ");
		for (int i = 0; i < arraySizes.length; i++) {
			String d = String.format("%.3f", selectionSort.testSelectionSortBench(arraySizes[i]));
			System.out.print(d + "\t ");
		}
		System.out.print("\n");

		System.out.print("Insertion Sort \t ");
		for (int i = 0; i < arraySizes.length; i++) {
			String d = String.format("%.3f", insertionSort.testInsertionSortBench(arraySizes[i]));
			System.out.print(d + "\t ");
		}
		System.out.print("\n");

		System.out.print("Counting Sort \t ");
		for (int i = 0; i < arraySizes.length; i++) {
			String d = String.format("%.3f", countSort.testCountSortBench(arraySizes[i]));
			System.out.print(d + "\t ");
		}
		System.out.print("\n");

		System.out.print("Merge Sort \t ");
		for (int i = 0; i < arraySizes.length; i++) {
			String d = String.format("%.3f", mergeSort.testMergeSortBench(arraySizes[i]));
			System.out.print(d + "\t ");
		}
		System.out.print("\n");

		System.out.print("Heap Sort \t ");
		for (int i = 0; i < arraySizes.length; i++) {
			String d = String.format("%.3f", heapSort.testHeapSortBench(arraySizes[i]));
			System.out.print(d + "\t ");
		}
		System.out.print("\n");
	}
}
