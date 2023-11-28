package warmUp;

import java.util.Scanner;

public class TaskC {
    static class Point {
        double r;
        double angle;

        Point(double x, double y) {
            r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            angle = Math.atan2(x, y);
        }

        double getRes(Point p) {
            double diff = Math.abs(this.angle - p.angle);
            double centralAngle = Math.min(Math.PI * 2 - diff, diff);
            double rMin = Math.min(r, p.r);
            double rMax = Math.max(r, p.r);

            return Math.min(centralAngle * rMin + rMax - rMin, rMin + rMax);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Point a = new Point(sc.nextDouble(), sc.nextDouble());
        Point b = new Point(sc.nextDouble(), sc.nextDouble());

        System.out.printf("%.8f", a.getRes(b));
    }
}
