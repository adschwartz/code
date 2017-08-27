package com.dkus.interviews.ra;

import java.util.Scanner;

/**
 * @author anders.schwartz
 */

class Point2D {
    int x, y;
    String type;

    Point2D(int x, int y) {
        this.x = x;
        this.y = y;
        this.type = "2D";
    }

    double dist2D(Point2D p) {
        return Math.sqrt(Math.pow((p.x - x), 2) + Math.pow((p.y - y), 2));
    }

    void printDistance(double d) {
        System.out.println(this.type + " distance = " + (int) Math.ceil(d));
    }
}

class Point3D extends Point2D {

    private int z;

    Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
        this.type = "3D";
    }

    double dist3D(Point3D p) {
        return Math.sqrt(Math.pow((p.x - x), 2) + Math.pow((p.y - y), 2) + Math.pow((p.z - z), 2));
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int z1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int z2 = scanner.nextInt();
        scanner.close();

        Point3D p1 = new Point3D(x1, y1, z1);
        Point3D p2 = new Point3D(x2, y2, z2);
        double d2 = p1.dist2D(p2);
        double d3 = p1.dist3D(p2);
        // The code below uses runtime polymorphism to call the overridden printDistance method:
        Point2D p = new Point2D(0, 0);
        p.printDistance(d2);
        p = p1;
        p.printDistance(d3);
    }
}
