package chap4;

public class Circle extends FigureTrue{
    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI*(radius*radius);
    }
}
