package com.artem.sorter;

public final class Sorter {
    private Sorter() {
    }

    public static int[] sort(int[] array) {
        if (array.length > 0)
            return divideAndMerge(array, 0, array.length - 1);
        return new int[0];
    }

    private static int[] divideAndMerge(int[] array, int firstIndex, int lastIndex) {
        int length = lastIndex - firstIndex + 1;
        if (length == 1)
            return new int[]{array[firstIndex]};
        int middleIndex = firstIndex + length / 2 - 1;
        return merge(divideAndMerge(array, firstIndex, middleIndex), divideAndMerge(array, middleIndex + 1, lastIndex));
    }

    private static int[] merge(int[] firstArray, int[] secondArray) {
        int[] result = new int[firstArray.length + secondArray.length];
        for (int resultCounter = 0, firstArrayCounter = 0, secondArrayCounter = 0; resultCounter < result.length; resultCounter++) {
            if (firstArrayCounter == firstArray.length)
                result[resultCounter] = secondArray[secondArrayCounter++];
            else if (secondArrayCounter == secondArray.length)
                result[resultCounter] = firstArray[firstArrayCounter++];
            else if (firstArray[firstArrayCounter] <= secondArray[secondArrayCounter])
                result[resultCounter] = firstArray[firstArrayCounter++];
            else
                result[resultCounter] = secondArray[secondArrayCounter++];
        }
        return result;
    }
}
