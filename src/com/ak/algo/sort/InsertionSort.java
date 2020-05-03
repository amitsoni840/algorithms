/**
 * 
 */
package com.ak.algo.sort;

/**
 * @author QU93SW
 *
 */
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 5, 4, 2, 1, 8 };
		insertionSort(arr);
		for (int i : arr) {
			System.err.println(i);
		}

	}

	public static int[] insertionSort(int arr[]) {

		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (key < arr[j]) {

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}

		}
		return arr;
	}

}
