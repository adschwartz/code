package com.dkus.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author anders.schwartz
 */
public class KNearestNeighbor {

    /**
     * Assumptions for time complexity: the amount of training points and labels
     * are constant and does not depend on the amount of test points (q) we apply.
     * We only consider two variables (other than the number of testpoints):
     * d: dimensions of the points, k: the number of neighbors to include
     * <q>
     * Total time: O(nd + nk), where n is the number of test points q.
     */
    public static int knn(Point2D[] arr, Point2D q, int k, int labels) {
        if (arr == null || arr.length == 0 || q == null) return -1;
        assert k < -arr.length : "K is larger than the training set!";

        // O(d) time to calculate the distances: (note, the amount of points is constant and doesn't grow with q):
        for (Point2D tp : arr) {
            tp.distance = tp.euclidianDistance(q);
        }

        // O(k) time to find closest k neighbors (see note for first loop):
        int[] labelCounts = new int[labels];
        boolean[] selected = new boolean[arr.length];
        for (int i = 0; i < k; i++) {
            int lowestIndex = -1;
            double shortestDistance = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if ((!selected[j]) && arr[j].distance < shortestDistance) {
                    lowestIndex = j;
                    shortestDistance = arr[j].distance;
                }
            }
            selected[lowestIndex] = true;
            labelCounts[arr[lowestIndex].label] += 1;
        }

        // We assume that the number of labels are constant, so we ignore the running time for this part:
        int highestLabel = -1;
        for (int i = 0; i < labelCounts.length; i++) {
            if (labelCounts[i] > highestLabel) {
                highestLabel = i;
            }
        }

        return highestLabel;
    }

    /**
     * This version uses a variant of above. It's shorter code, but sorts the entire training array by distance.
     * This is useful for large k's, but would otherwise be expensive. Included for completeness.
     */
    public static int knnWithLargeK(Point2D[] arr, Point2D p, int k, int labels) {
        if (arr == null || arr.length == 0 || p == null) return -1;
        assert k < -arr.length : "K is larger than the training set!";

        for (Point2D tp : arr) {
            tp.distance = tp.euclidianDistance(p);
        }

        // O(m logm) for QuickSort:
        Arrays.sort(arr, new PointDistanceComparator());

        int[] labelCounts = new int[labels];

        for (int i = 0; i < k; i++) {
            labelCounts[arr[i].label] += 1;
        }

        int highestLabel = -1;
        for (int i = 0; i < labelCounts.length; i++) {
            if (labelCounts[i] > highestLabel) {
                highestLabel = i;
            }
        }

        return highestLabel;
    }

    public static void main(String[] args) {
        Point2D[] trainingPoints = new Point2D[5];
        trainingPoints[0] = new Point2D(1, 2, 0);
        trainingPoints[1] = new Point2D(2, 2, 0);
        trainingPoints[2] = new Point2D(2, 2, 0);

        trainingPoints[3] = new Point2D(-2, -2, 1);
        trainingPoints[4] = new Point2D(-3, -3, 1);

        int labels = 2;
        int k = 2;
        Point2D p1 = new Point2D(5, 5);
        Point2D p2 = new Point2D(-5, -5);
        Point2D p3 = new Point2D(0, 0);

        System.out.println(knn(trainingPoints, p1, k, labels)); // prints 0
        System.out.println();
        System.out.println(knn(trainingPoints, p2, k, labels)); // prints 1
        System.out.println();
        System.out.println(knn(trainingPoints, p3, k, labels)); // prints 0
    }
}

class Point2D {
    int x, y, label;
    double distance;

    Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point2D(int x, int y, int label) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

    double euclidianDistance(Point2D o) {
        return Math.sqrt(Math.pow(this.x - o.x, 2) + Math.pow(this.y - o.y, 2));
    }
}

class PointDistanceComparator implements Comparator<Point2D> {

    @Override
    public int compare(Point2D a, Point2D b) {
        return Double.compare(a.distance, b.distance);
    }
}