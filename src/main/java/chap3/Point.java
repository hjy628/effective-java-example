package chap3;

import java.util.HashSet;
import java.util.Set;

public class Point {
    private final int x;
    private final int y;

    //Initialize UnitCircle to contain all Points On the unit circle
    private static final Set<Point> unitCircle;

    static {
        unitCircle = new HashSet<Point>();
        unitCircle.add(new Point(1,0));
        unitCircle.add(new Point(0,1));
        unitCircle.add(new Point(-1,0));
        unitCircle.add(new Point(0,-1));
    }

    public static boolean onUnitCircle(Point p){
        return unitCircle.contains(p);
    }


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point))
            return false;
        Point p = (Point)obj;
        return p.x==x && p.y == y;
    }
    */



    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point))
            return false;
        Point p = (Point)obj;
        return p.x==x && p.y == y;
    }
}
