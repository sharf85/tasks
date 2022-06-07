package de.telran;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapsMedianElementCollection implements IMedianElementCollection {

    private final PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

    @Override
    public void add(int elt) {

        if (leftHeap.size() == 0 && rightHeap.size() == 0) {
            leftHeap.add(elt);
            return;
        }

        double median = getMedian();

        if (leftHeap.size() == rightHeap.size()) {
            if (elt >= median)
                rightHeap.add(elt);
            else
                leftHeap.add(elt);
        } else if (leftHeap.size() < rightHeap.size()) {
            if (elt <= median) {
                leftHeap.add(elt);
            } else {
                leftHeap.add(rightHeap.remove());
                rightHeap.add(elt);
            }
        } else {
            if (elt >= median) {
                rightHeap.add(elt);
            } else {
                rightHeap.add(leftHeap.remove());
                leftHeap.add(elt);
            }
        }

    }

    @Override
    public double getMedian() {
        if (leftHeap.size() == rightHeap.size())
            return ((double) leftHeap.element() + rightHeap.element()) / 2;

        return leftHeap.size() > rightHeap.size() ? leftHeap.element() : rightHeap.element();
    }
}
