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
            siftDown(i, array);
        }
    }

    /**
     * Сдвигает элемент с индексом i вниз по куче таким образом, что он встает на свое место (родитель больше него,
     * а оба дочерних элемента меньше)
     *
     * @param i
     * @param array
     */
    private void siftDown(int i, int[] array) {
        //TODO implement
    }

    public void heapSort(int[] array) {
        makeHeap(array);

        //TODO complete. После того, как у нас массив приобрел структуру кучи, необходимо вытаскивать из
        // нее самый верхний элемент, затем ставить на его место самый последний элемент и сдвинуть его вниз
        // на свое место (siftDown).
    }


}
