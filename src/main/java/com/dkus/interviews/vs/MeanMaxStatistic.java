package com.dkus.interviews.vs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author anders.schwartz
 */
public class MeanMaxStatistic implements Statistic {

    private final Deque<Double> window;
    private final Deque<Double> maxQueue;
    private final int windowSize;
    private int runningSum = 0;
    private double currentMean;
    private int samples = 0;

    public MeanMaxStatistic(int windowSize) {
        this.windowSize = windowSize;
        this.window = new ArrayDeque<>(windowSize);
        this.maxQueue = new ArrayDeque<>(windowSize);
    }

    public void slideWindow(Double next) {
        Double removedElement = window.size() == windowSize ? window.remove() : null;
        window.add(next);
        updateRunningMean(removedElement, next);
        updateMax(removedElement, next);
        samples++;
    }

    private void updateRunningMean(Double removedElement, Double nextElement) {
        if (removedElement != null) {
            runningSum -= removedElement;
        }
        runningSum += nextElement;
        currentMean = runningSum / (windowSize * 1.0);
    }

    private void updateMax(Double removedElement, Double nextElement) {
        // remove any elements that are smaller than nextElement (they will never become max)
        while (!maxQueue.isEmpty() && nextElement > maxQueue.getLast()) {
            maxQueue.removeLast();
        }

        // Remove removedElement from maxQueue if it is there:
        if (removedElement !=null && !maxQueue.isEmpty() && removedElement.equals(maxQueue.getFirst())) {
            maxQueue.remove();
        }

        maxQueue.addLast(nextElement);
    }

    public Double getCurrentMean() {
        return (samples >= windowSize) ? currentMean : null;
    }

    public Double getCurrentMax() {
        return (samples >= windowSize) ? maxQueue.getFirst() : null;
    }
}
