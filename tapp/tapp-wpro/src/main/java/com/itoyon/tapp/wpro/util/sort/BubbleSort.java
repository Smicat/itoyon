package com.itoyon.tapp.wpro.util.sort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 8, 1, 2, 0, 9, 3, 12, 7, 6, 3, 4, 65, 22 };
		StringBuffer sb = new StringBuffer();
		int j = 0;

		BubbleSort.bubbleSort(arr, arr.length);

		for (int i : arr) {
			if (j < arr.length - 1) {
				sb.append(i + ", ");
			} else {
				sb.append(i);
			}
			j++;
		}
		System.out.print("冒泡排序结果：\n" + sb.toString());
	}

	/**
	 * 冒泡排序
	 * 
	 * @param a
	 * @param n
	 */
	public static void bubbleSort(int[] a, int n) {
		int j, k;
		int flag = n;// flag记录最后交换的位置，也就是排序的尾边界

		while (flag > 0) {// 排序未结束标志
			k = flag; // k 来记录遍历的尾边界
			flag = 0;

			for (j = 1; j < k; j++) {
				if (a[j - 1] > a[j]) {// 前面的数字大于后面的数字就交换
					// 交换a[j-1]和a[j]
					int temp;
					temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;

					// 表示交换过数据;
					flag = j;// 记录最新的尾边界
				}
			}
		}
	}
}
