/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package prac;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;

public class PointGenerator {

    private List<Point2D> pointList = new ArrayList<>();

    public PointGenerator(int trials) {
        for (int i = 0; i < trials; i++) {
            pointList.add(new Point2D(StdRandom.uniformDouble(), StdRandom.uniformDouble()));
        }
    }

    public double getClosestDistance() {
        double closestDistance = Double.MAX_VALUE;
        Point2D closestPoint1 = null;
        Point2D closestPoint2 = null;
        for (int i = 0; i < pointList.size() - 1; i++) {
            Point2D iPoint = pointList.get(i);
            for (int j = i + 1; j < pointList.size(); j++) {
                Point2D jPoint = pointList.get(j);
                double tempDistance = iPoint.distanceTo(jPoint);
                if (tempDistance < closestDistance) {
                    closestDistance = tempDistance;
                    closestPoint1 = iPoint;
                    closestPoint2 = jPoint;
                }
            }
        }

        if (closestPoint1 != null && closestPoint2 != null)
            StdOut.println("points! : " + closestPoint1 + ", " + closestPoint2);

        return closestDistance;
    }


    public String toString() {
        return "count of points : " + pointList.size();
    }
}
