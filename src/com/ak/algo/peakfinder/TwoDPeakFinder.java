package com.ak.algo.peakfinder;

public class TwoDPeakFinder {

	public static void main(String[] args) {
		int[][] arr = { { 10, 8, 10, 10 },
						{ 14, 13, 12, 11 }, 
						{ 15, 9, 11, 21 }, 
						{ 16, 17, 19, 20 } };
		//twoDPeakFinder(arr);

		System.out.println(twoDPeakFinderRecursion(0, arr.length-1, arr));

	}

	private static void twoDPeakFinder(int[][] arr) {

		int left = 0;
		int right = arr[0].length - 1;
		int globalMaxIndex = 0;
		int mid = 0;
		while (left <= right) {
			mid = left + (right - left) / 2;

			int max = arr[0][mid];
			for (int i = 0; i < arr.length; i++) {

				if (arr[i][mid] > max) {
					globalMaxIndex = i;
					max = arr[i][mid];
				}
			}
			if (left == right) {
				break;
			}
			if (arr[globalMaxIndex][mid] < arr[globalMaxIndex][mid - 1]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		System.out.println("peak is at  :" + arr[globalMaxIndex][mid]);
	}

	private static int twoDPeakFinderRecursion(int left, int right, int[][] arr) {

		int globalMaxIndex = 0;
		int mid = 0;

		mid = left + (right - left) / 2;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][mid] > max) {
				globalMaxIndex = i;
				max = arr[i][mid];
			}
		}

		if (left == right) {
			return arr[globalMaxIndex][mid];
		}

		if (arr[globalMaxIndex][mid] < arr[globalMaxIndex][mid - 1]) {
			right = mid;
			return twoDPeakFinderRecursion(left, right, arr);

		} else {
			left = mid + 1;
			return twoDPeakFinderRecursion(left, right, arr);
		}
	}

}
