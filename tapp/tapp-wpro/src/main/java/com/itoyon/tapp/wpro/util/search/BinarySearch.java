package com.itoyon.tapp.wpro.util.search;

import com.itoyon.tapp.wpro.util.sort.BubbleSort;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 6, 7, 8, 9, 1, 2, 3, 4, 5 };
		int des = 3;
		System.out.println("二分查找结果：\n" + BinarySearch.binarySearch(arr, des));
	}

	/**
	 * 折半查找
	 * 
	 * @param srcArr
	 * @param des
	 * @return
	 */
	public static int binarySearch(int[] srcArr, int des) {
		int low = 0;
		int high = srcArr.length - 1;
		int middle;
		
		// 冒泡排序
		BubbleSort.bubbleSort(srcArr, des);

		while (low <= high) {
			middle = (low + high) / 2;
			if (des == srcArr[middle]) {
				return middle;
			} else if (des < srcArr[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}

		return -1;
	}
}
