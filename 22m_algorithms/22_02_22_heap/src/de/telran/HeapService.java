package de.telran;

public class HeapService {

    /**
     * Делает массив таким образом, что тот становится кучей
     *
     * @param array
     */
    // Если у узла в куче индекс в массиве равняется i, то индекс его детей в массиве равняется: 2*i + 1, 2*i + 2
    public void makeHeap(int[] array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            siftDown(i, array, array.length);
        }
    }

    /**
     * Сдвигает элемент с индексом i вниз по куче таким образом, что он встает на свое место (родитель больше него,
     * а оба дочерних элемента меньше)
     *
     * @param i
     * @param array
     */
    private void siftDown(int i, int[] array, int size) {
        int leftIndex = 2 * i + 1;
        int rightIndex = leftIndex + 1;

        int maxIndex = i;
        if (leftIndex < size && array[leftIndex] > array[maxIndex])
            maxIndex = leftIndex;

        if (rightIndex < size && array[rightIndex] > array[maxIndex])
            maxIndex = rightIndex;

        if (maxIndex != i) {
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
            siftDown(maxIndex, array, size);
        }
    }

    public void heapSort(int[] array) {
        makeHeap(array);

        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            siftDown(0, array, i);
        }
    }


}
