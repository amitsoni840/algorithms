package com.ak.algo.peakfinder;

public class OneDPeakFinderN {

	public static void main(String args[]) {
		int[] arr = { 1, 2, 3, 1 };
		System.out.println(peakFinder1D(arr));
		System.out.println(peakFinder1DLogNForloop(arr));
		System.out.println(peakFinder1DLogNRecursion(0, arr.length - 1, arr));
	}

	private static int peakFinder1D(int[] arr) {

		if (arr.length == 1) {
			return 0;
		}
		if (arr[0] > arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] > arr[arr.length - 2]) {
			return arr.length - 1;
		}

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
				return i;
			}
		}
		return -1;
	}

	private static int peakFinder1DLogNForloop(int[] arr) {

		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int mid = left + ((right - left) / 2);

			if (arr[mid] < arr[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;

	}

	private static int peakFinder1DLogNRecursion(int startIndex, int endIndex, int[] arr) {

		if (startIndex == endIndex) {
			return startIndex;
		}
		int mid = startIndex + ((endIndex - startIndex) / 2);
		if (arr[mid] < arr[mid + 1]) {
			return peakFinder1DLogNRecursion(mid + 1, endIndex, arr);
		} else {
			return peakFinder1DLogNRecursion(startIndex, mid, arr);
		}

	}
}
