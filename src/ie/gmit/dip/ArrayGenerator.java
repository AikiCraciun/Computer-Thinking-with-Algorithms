package ie.gmit.dip;

//Abstract class to with main functuion to generate
//random array of specified lenght and range

public abstract class ArrayGenerator {
	public int range = 10000;

	public int[] randomArray(int n, int range) {
		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * range);
		}
		return array;
	}

}
