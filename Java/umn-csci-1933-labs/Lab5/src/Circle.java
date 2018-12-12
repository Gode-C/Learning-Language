/**
 * Created by chen3736 on 10/13/15.
 */
public class Circle extends Shape {

    public Double rad;

    public Circle(double ra){this.rad = ra;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(rad,2);
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }
}
