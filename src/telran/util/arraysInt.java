package telran.util;

import java.util.Arrays;

public class arraysInt {
	public static int[] addNumber(int[] array, int number) {
		int[] arrayNew = Arrays.copyOf(array, array.length + 1);
		arrayNew[arrayNew.length - 1] = number;
		return arrayNew;
	}

//First version of implementation:
//	public static int[] insertNumber(int[] array, int index, int number) {
//		int[] arraySource = { number };
//		int[] arrayNew = Arrays.copyOf(array, array.length + 1);
//		System.arraycopy(arraySource, 0, arrayNew, index, 1);
//		System.arraycopy(array, index, arrayNew, index + 1, array.length - index);
//		return arrayNew;
//	}

//Second version of implementation:

	public static void exception(int[] array, int index) throws Exception {
		if (index < 0) {
			throw new Exception("Index is less than 0");
		} else if (index > array.length) {
			throw new Exception("Index exceeds arrays length");
		}
	}

	public static int[] insertNumber(int[] array, int index, int number) throws Exception {
		exception(array, index);

		int[] arrayNew = new int[array.length + 1];
		arrayNew[index] = number;
		System.arraycopy(array, 0, arrayNew, 0, index);
		System.arraycopy(array, index, arrayNew, index + 1, array.length - index);

		return arrayNew;
	}

	public static int[] removeNumber(int[] array, int index) throws Exception {
		exception(array, index);

		int[] arrayNew = new int[array.length - 1];
		System.arraycopy(array, 0, arrayNew, 0, index);
		System.arraycopy(array, index + 1, arrayNew, index, array.length - index - 1);

		return arrayNew;
	}

	public static int[] insertSorted(int[] sortedArray, int number) throws Exception {
		int index = Arrays.binarySearch(sortedArray, number);
		int insertIndex = index < 0 ? -index - 1 : index;
		return insertNumber(sortedArray, insertIndex, number);

	}

}
