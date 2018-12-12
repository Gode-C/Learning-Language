/**
 * Created by chen3736 on 10/13/15.
 */
public class Square extends Shape{



    public Double leng;

    public Square(double ra){this.leng = ra;
    }

    @Override
    public double getArea() {
        return Math.pow(leng,2);
    }

    @Override
    public String getShapeName() {
        return "Square";
    }
}
