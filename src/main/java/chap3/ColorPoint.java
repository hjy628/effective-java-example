package chap3;


import java.awt.*;

public class ColorPoint extends Point{

    private final Color color;

    public ColorPoint(int x, int y,Color color) {
        super(x, y);
        this.color = color;
    }

    //Broken - violates symmetry!
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorPoint))
            return false;
        return super.equals(obj) && ((ColorPoint)obj).color == color;
    }



    private boolean test(){
        Point p = new Point(1,2);
        ColorPoint cp = new ColorPoint(1,2,Color.RED);
        return p.equals(cp);
    }
}
