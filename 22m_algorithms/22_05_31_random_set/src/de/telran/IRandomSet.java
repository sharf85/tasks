package de.telran;

public interface IRandomSet<T> {
    /**
     * добаляет элемент, возвразает true, если элемент таки добавился (его не было в структуре данных ранее)
     * @param elt
     * @return
     */
    boolean add(T elt);

    /**
     * удаляет элемент и возвращает true, если элемент таки удалился (он был в структуре данных ранее)
     * @param elt
     * @return
     */
    boolean remove(T elt);

    /**
     * равновероятно возвращает один из имеющихся в структуре данных элементов.
     * @return
     */
    T getRandom();
}
